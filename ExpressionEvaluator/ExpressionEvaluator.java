public class ExpressionEvaluator {
    public static void main (String[] args) {
        CustomizedStack tower;
        CustomizedStack next;
        int[] popped = new int[2];

        if (args.length == 1 && isInteger(args[0])) { //if there is only one arg, and it is an int, then output that int
            System.out.println(args[0]);
        } else if (doesWork(args)) {
            tower = new CustomizedStack(args[0]); //assuming we have a valid input, create the beginning of the stack
            next = new CustomizedStack(args[0]);

            for (int i = 1; i < args.length; i++) {
                if (isInteger(args[i])) {
                    next = new CustomizedStack(args[i]);
                    tower.push(next);
                } else {
                    popped = tower.pop();
                }

                if (isPlus(args[i])) {
                    next = new CustomizedStack(add(popped));
                    tower.push(next);
                } else if (isMinus(args[i])) {
                    next = new CustomizedStack(subtract(popped));
                    tower.push(next);
                } else if (isTimes(args[i])) {
                    next = new CustomizedStack(multiply(popped));
                    tower.push(next);
                } else if (isSlash(args[i])) {
                    next = new CustomizedStack(divide(popped));
                    tower.push(next);
                } else if (isMod(args[i])) {
                    next = new CustomizedStack(modulo(popped));
                    tower.push(next);
                }
            }
            System.out.println(next.toString()); //This should be tower.toString(), but that seems to only return the first integer from the input
        }
    }

    public static String add (int[] popped) {
        int result = popped[0] + popped[1];
        return Integer.toString(result);
    }

    public static String subtract (int[] popped) {
        int result = popped[0] - popped[1];
        return Integer.toString(result);
    }

    public static String multiply (int[] popped) {
        int result = popped[0] * popped[1];
        return Integer.toString(result);
    }

    public static String divide (int[] popped) {
        int result = popped[0] / popped[1];
        return Integer.toString(result);
    }

    public static String modulo (int[] popped) {
        int result = popped[0] % popped[1];
        return Integer.toString(result);
    }

    public static boolean doesWork (String[] values) {
        boolean result = true;
        for (int i = 0; i < values.length; i++) { //check if all args are acceptable input
                if (!isInteger(values[i]) && !isOperator(values[i])){
                    result = false;
                    throw new IllegalArgumentException("Invalid arguments.");
                }
            } 
        if (!isInteger(values[0]) || !isInteger(values[1])) {
            result = false;
            throw new IllegalArgumentException("Must start input with two integers.");
        }
        if (operatorCount(values) != integerCount(values)-1) {
            result = false;
            throw new IllegalArgumentException("Not a valid expression.");
        }
        return result;
    }

    public static int operatorCount (String[] values) {
        int result = 0;
        for (int i = 0; i < values.length; i++) {
            if (isOperator(values[i])) {
                result++;
            }
        }
        return result;
    }

    public static int integerCount (String[] values) {
        int result = 0;
        for (int i = 0; i < values.length; i++) {
            if (isInteger(values[i])) {
                result++;
            }
        }
        return result;
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

    public static boolean isOperator (String input) {
        return (input.equals("+") || input.equals("-") || input.equals("x") || input.equals("/") || input.equals("%"));
    }

    public static boolean isPlus (String input) {
        return (input.equals("+"));
    }

    public static boolean isMinus (String input) {
        return (input.equals("-"));
    }

    public static boolean isTimes (String input) {
        return (input.equals("x"));
    }

    public static boolean isSlash (String input) {
        return (input.equals("/"));
    }

    public static boolean isMod (String input) {
        return (input.equals("%"));
    }
}