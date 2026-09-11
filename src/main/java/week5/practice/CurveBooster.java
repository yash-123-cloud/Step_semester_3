import java.util.Arrays;

public class CurveBooster {
    static void curveScores(int[] scores, int bonus) {
        // Add bonus to each score directly in the array
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        int[] scores = {70, 85, 60};
        curveScores(scores, 10);
        // Print using Arrays.toString()
        System.out.println(Arrays.toString(scores));
    }
}
