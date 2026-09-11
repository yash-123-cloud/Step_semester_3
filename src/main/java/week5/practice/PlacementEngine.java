import java.util.*;

class Candidate implements Comparable<Candidate> {
    String name;
    double cgpa;
    int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // Rule 1: CGPA-only eligibility
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5; // threshold chosen
    }

    // Rule 2: Combined CGPA + coding score eligibility
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60; // threshold chosen
    }

    // Composite score = CGPA*10 + codingScore
    double compositeScore() {
        return cgpa * 10 + codingScore;
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.compositeScore(), this.compositeScore());
    }
}

public class PlacementEngine {
    static String shortlistAndRank(Candidate[] candidates) {
        ArrayList<Candidate> shortlisted = new ArrayList<>();
        for (Candidate c : candidates) {
            if (Candidate.isEligible(c.cgpa) || Candidate.isEligible(c.cgpa, c.codingScore)) {
                shortlisted.add(c);
            }
        }

        Candidate[] arr = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append((i + 1)).append(". ").append(arr[i].name)
                    .append(" (").append(arr[i].compositeScore()).append(")");
            if (i < arr.length - 1) sb.append(" | ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}
