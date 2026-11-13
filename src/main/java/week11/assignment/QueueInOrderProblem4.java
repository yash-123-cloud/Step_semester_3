public class QueueInOrderProblem4 {

    public static int firstBreak(int[] tokens) {

        for (int i = 1; i < tokens.length; i++) {

            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] tokens = {3, 5, 5, 8, 6, 9};

        int result = firstBreak(tokens);

        System.out.println("First break position: " + result);

        if (result != -1) {
            System.out.println(tokens[result] +
                    " comes after " + tokens[result - 1]);
        } else {
            System.out.println("Queue is already in order");
        }

        int[] tokens2 = {1, 2, 2, 7};

        System.out.println("First break position: "
                + firstBreak(tokens2));
    }
}