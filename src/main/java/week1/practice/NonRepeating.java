import java.util.*;

class NonRepeating {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            int count = 0;

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == ch)
                    count++;
            }

            if (count == 1) {
                System.out.println("First Non-Repeating Character: " + ch);
                return;
            }
        }

        System.out.println("No Non-Repeating Character Found");
    }
}