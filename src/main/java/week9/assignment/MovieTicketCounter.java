import java.util.Scanner;

abstract class MovieTicket {
    static final double CONVENIENCE_FEE = 20.0;

    int count;

    MovieTicket(int count) {
        this.count = count;
    }

    abstract double getPrice();

    double calculateAmount() {
        return (getPrice() + CONVENIENCE_FEE) * count;
    }
}

class RegularMovieTicket extends MovieTicket {
    RegularMovieTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 150;
    }
}

class PremiumMovieTicket extends MovieTicket {
    PremiumMovieTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 250;
    }
}

class ReclinerMovieTicket extends MovieTicket {
    ReclinerMovieTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 400;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();

            MovieTicket ticket = null;

            switch (seat) {
                case "REGULAR":
                    ticket = new RegularMovieTicket(count);
                    break;

                case "PREMIUM":
                    ticket = new PremiumMovieTicket(count);
                    break;

                case "RECLINER":
                    ticket = new ReclinerMovieTicket(count);
                    break;
            }

            if (ticket != null) {
                double amount = ticket.calculateAmount();
                System.out.printf("%s: %.2f%n", seat, amount);
                total += amount;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}