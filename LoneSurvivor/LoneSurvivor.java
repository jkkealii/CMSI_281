public class LoneSurvivor {
    public static int people, tosses;
    public static CircularList gang;

    public static void main (String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Invalid Input");
        } else {
            for (int i = 0; i < 2; i++) {
                if (!isInteger(args[i])) {
                    throw new IllegalArgumentException("Input must be integers.");
                }
            }
        }
        people = Integer.parseInt(args[0]);
        tosses = Integer.parseInt(args[1]); 
        
        gang = new CircularList();
        for (int i = 1; i < people; i++) {
            gang.add(i);
        }
        gang.flounder(); //reset the current node to the node called "0"

        while (gang.getMagnitude() > 1) {
            for (int i = 0; i < tosses; i++) {
                gang.flounder();
            }
            gang.remove();
        }
        System.out.println(gang.inoa());
    }

    public static boolean isInteger (String input) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}