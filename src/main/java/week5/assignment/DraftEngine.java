import java.util.*;

class Player implements Comparable<Player> {
    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Rule 1: Experienced players (≥10 matches) qualify regardless of fitness
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Rule 2: Less experienced players need ≥5 matches and must not be injured
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(Player other) {
        // Sort by batting average in descending order
        return Double.compare(other.battingAverage, this.battingAverage);
    }
}

public class DraftEngine {
    static String draftAndRank(Player[] players) {
        ArrayList<Player> draftable = new ArrayList<>();
        for (Player p : players) {
            if (Player.isDraftable(p.matchesPlayed) || Player.isDraftable(p.matchesPlayed, p.injured)) {
                draftable.add(p);
            }
        }
        Player[] arr = draftable.toArray(new Player[0]);
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append((i + 1)).append(". ").append(arr[i].name);
            if (i < arr.length - 1) sb.append(" | ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}
