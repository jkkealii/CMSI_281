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
        String single, word, lastWord;
        String previous = "";
        boolean delimiter;
        boolean needsMore = false;

        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.get(i).length(); j++) {

                single = array.get(i).substring(j, j+1);
                word = array.get(i).substring(lastChar, j);
                delimiter = single.equals(";") || single.equals(":") || single.equals(" ") || single.equals(",") || single.equals("-");

                if (!(single.matches("[a-zA-Z]"))) {
                    if (delimiter) {
                        if (word.length() != 0) {
                            if (needsMore) {
                                vernacular.add(previous + word);
                                needsMore = false;
                                previous = "";
                            } else {
                                vernacular.add(word);
                                previous = "";
                            }
                        } else {
                            if (needsMore) {
                                vernacular.add(previous);
                                needsMore = false;
                                previous = "";
                            }
                        }
                    } else {
                        if (word.length() != 0) {
                            previous += word;
                            needsMore = true;
                        }
                    }
                    lastChar = j+1;
                } else if (j == array.get(i).length() - 1) {
                    lastWord = array.get(i).substring(lastChar, j+1);
                    if (needsMore) {
                        lastWord = previous + lastWord;
                        needsMore = false;
                        vernacular.add(lastWord);
                    } else {
                        vernacular.add(lastWord);
                    }    
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
        for (int i = 0; i < sort.length; i++) {
            System.out.println(sort[i]);
        }

        int tally = 1;
        for (int i = 1; i < sort.length; i++) {
            if (sort[i].equals(sort[i-1])) {
                tally++;
            } else {        
                System.out.println(sort[i-1] + ": " + tally);
                tally = 1;
            }
            if (i == sort.length - 1) {
                System.out.println(sort[i] + ": " + tally);
                tally = 1;
            }
        }
    }
}