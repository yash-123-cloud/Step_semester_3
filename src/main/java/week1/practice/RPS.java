import java.util.*;

class RPS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        int win = 0, loss = 0, draw = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter Rock/Paper/Scissors: ");
            String player = sc.next();

            String computer = moves[r.nextInt(3)];

            System.out.println("Computer: " + computer);

            if (player.equals(computer)) {
                System.out.println("Draw");
                draw++;
            }
            else if ((player.equals("Rock") && computer.equals("Scissors")) ||
                    (player.equals("Paper") && computer.equals("Rock")) ||
                    (player.equals("Scissors") && computer.equals("Paper"))) {
                System.out.println("Player Wins");
                win++;
            }
            else {
                System.out.println("Computer Wins");
                loss++;
            }
        }

        System.out.println("Wins: " + win);
        System.out.println("Losses: " + loss);
        System.out.println("Draws: " + draw);
        System.out.println("Win %: " + (win * 100.0 / 5));
    }
}