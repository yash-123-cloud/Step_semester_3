import java.util.*;
import java.time.LocalDate;

abstract class Subscription {
    LocalDate startDate;

    Subscription(LocalDate startDate) {
        this.startDate = startDate;
    }

    abstract LocalDate getRenewalDate();
}

class Basic extends Subscription {

    Basic(LocalDate startDate) {
        super(startDate);
    }

    LocalDate getRenewalDate() {
        return startDate.plusDays(30);
    }
}

class Standard extends Subscription {

    Standard(LocalDate startDate) {
        super(startDate);
    }

    LocalDate getRenewalDate() {
        return startDate.plusDays(90);
    }
}

class Premium extends Subscription {

    Premium(LocalDate startDate) {
        super(startDate);
    }

    LocalDate getRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class Plan {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            Subscription plan;

            if (type.equals("BASIC")) {
                plan = new Basic(startDate);
            }
            else if (type.equals("STANDARD")) {
                plan = new Standard(startDate);
            }
            else {
                plan = new Premium(startDate);
            }

            System.out.println(name + ": " + plan.getRenewalDate());
        }
    }
}
