import java.util.Arrays;

public class DutyRosterRotation {

    public static String[] rotateRoster(String[] names, int k) {

        int n = names.length;
        k = k % n;

        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = names[i];
        }

        return result;
    }

    public static void main(String[] args) {

        String[] names1 = {"A", "B", "C", "D", "E"};
        int k1 = 2;

        System.out.println("Sample 1:");
        System.out.println(Arrays.toString(rotateRoster(names1, k1)));

        String[] names2 = {"A", "B", "C", "D", "E"};
        int k2 = 7;

        System.out.println("Sample 2:");
        System.out.println(Arrays.toString(rotateRoster(names2, k2)));
    }
}