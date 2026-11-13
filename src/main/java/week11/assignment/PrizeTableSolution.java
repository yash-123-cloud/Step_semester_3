public class PrizeTableSolution {

    public static int prizeTable(int[] marks) {

        int swaps = 0;

        for (int i = 0; i < marks.length - 1; i++) {

            int maxIndex = i;

            // Find the highest mark
            for (int j = i + 1; j < marks.length; j++) {

                if (marks[j] > marks[maxIndex]) {
                    maxIndex = j;
                }
            }

            // Swap only if required
            if (maxIndex != i) {

                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;

                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {

        int[] marks = {45, 90, 60, 75};

        int swaps = prizeTable(marks);

        System.out.print("Sorted marks: ");

        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }

        System.out.println("\nSwaps = " + swaps);


        int[] marks2 = {80, 70, 60};

        int swaps2 = prizeTable(marks2);

        System.out.print("Sorted marks: ");

        for (int i = 0; i < marks2.length; i++) {
            System.out.print(marks2[i] + " ");
        }

        System.out.println("\nSwaps = " + swaps2);
    }
}