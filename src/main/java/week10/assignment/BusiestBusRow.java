import java.util.Scanner;

public class BusiestBusRow {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] grid = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int bestRow = 0;
        int maxTotal = -1;

        for (int i = 0; i < r; i++) {

            int total = 0;

            for (int j = 0; j < c; j++) {
                total += grid[i][j];
            }

            if (total > maxTotal) {
                maxTotal = total;
                bestRow = i;
            }
        }

        System.out.println("Row " + bestRow +
                ", Total " + maxTotal);

        sc.close();
    }
}