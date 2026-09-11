public class MatchAnalyzer {
    static double rowAverage(int[] row) {
        int sum = 0;
        for (int val : row) sum += val;
        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            if (avg >= threshold) {
                result.append("Match ").append(i).append(": Power Surge");
            } else {
                result.append("Match ").append(i).append(": Normal");
            }
            if (i < runsPerOver.length - 1) result.append(" | ");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[][] runs = {
                {4, 6, 8},
                {10, 12, 14},
                {2, 3, 1}
        };
        int threshold = 8;
        System.out.println(classifyMatches(runs, threshold));
    }
}
