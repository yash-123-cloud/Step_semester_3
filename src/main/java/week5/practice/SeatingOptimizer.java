public class SeatingOptimizer {
    static double rowAverage(int[] row) {
        int sum = 0;
        for (int val : row) sum += val;
        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            if (avg >= threshold) {
                result.append("Row ").append(i).append(": Buzzing Zone");
            } else {
                result.append("Row ").append(i).append(": Quiet Zone");
            }
            if (i < seatingScores.length - 1) result.append(" | ");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[][] seatingScores = {
                {40, 50, 45},
                {85, 90, 95},
                {30, 20, 25}
        };
        int threshold = 60;
        System.out.println(classifyRows(seatingScores, threshold));
    }
}
