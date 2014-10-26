import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;


public class WordSort {
    private static ArrayList <String> array;
    private static ArrayList <String> vernacular;

    public static void main (String[] args) throws Exception {
        java.io.BufferedReader stdIn = new java.io.BufferedReader (new java.io.InputStreamReader(System.in));
        array = new ArrayList<String>();
        vernacular = new ArrayList<String>();
        String s = stdIn.readLine();// grab the first line (or null, if end-of-file)
        while (s != null) { // while not end-of-file
            array.add(s); // process this line
            s = stdIn.readLine(); // grab the next line (or null)
        }

        int lastChar = 0;
        String single;
        String word;
        String lastWord;

        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.get(i).length(); j++) {

                single = array.get(i).substring(j, j+1);
                word = array.get(i).substring(lastChar, j);

                if (!(single.matches("[a-zA-Z]"))) { //("^.*[^a-zA-Z].*$")
                    if (word.length() != 0) {
                        vernacular.add(word);
                    }
                    lastChar = j+1;
                } else if (j == array.get(i).length() - 1) {
                    lastWord = array.get(i).substring(lastChar, j+1);
                    vernacular.add(lastWord);
                }
            }
            lastChar = 0;
        }

        if (!(args.length > 0 && args[0].equals("-sensitive"))) {
            for (int i = 0; i < vernacular.size(); i++) {
                vernacular.set(i, vernacular.get(i).toUpperCase());
            }
        }

        Object[] sort = vernacular.toArray();
        Arrays.sort(sort);

        int tally = 1;
        for (int i = 1; i < sort.length; i++) {
            if (sort[i].equals(sort[i-1])) {
                tally++;
            } else {
                System.out.println(sort[i-1] + ": " + tally);
                tally = 1;
            }   
        }
    }
}