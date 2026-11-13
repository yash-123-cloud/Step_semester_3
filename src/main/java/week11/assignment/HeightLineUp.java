import java.util.Arrays;

public class HeightLineUp {

    public static void lineUp(int[] heights) {

        int n = heights.length;
        int pass = 1;

        while (true) {

            boolean swapped = false;

            for (int j = 0; j < n - 1; j++) {

                if (heights[j] > heights[j + 1]) {

                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;

                    swapped = true;
                }
            }

            System.out.println("Pass " + pass + ": "
                    + Arrays.toString(heights));

            pass++;

            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        int[] heights = {4, 2, 5, 1};

        lineUp(heights);
    }
}