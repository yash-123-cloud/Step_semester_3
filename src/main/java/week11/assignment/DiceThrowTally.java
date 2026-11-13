public class DiceThrowTally {

    public static void diceSort(int[] rolls) {

        int[] count = new int[7];

        // Count occurrences of each dice number
        for (int i = 0; i < rolls.length; i++) {
            count[rolls[i]]++;
        }

        // Print counts
        System.out.print("Counts: ");

        for (int i = 1; i <= 6; i++) {
            System.out.print(i + ":" + count[i]);

            if (i < 6) {
                System.out.print(" ");
            }
        }

        System.out.println();

        // Print sorted result
        System.out.print("Sorted: [");

        boolean first = true;

        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < count[i]; j++) {

                if (!first) {
                    System.out.print(", ");
                }

                System.out.print(i);
                first = false;
            }
        }

        System.out.println("]");
    }

    public static void main(String[] args) {

        int[] rolls = {4, 1, 2, 4, 1, 4, 2, 1, 4};

        diceSort(rolls);
    }
}