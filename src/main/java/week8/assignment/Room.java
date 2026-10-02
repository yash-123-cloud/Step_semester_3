import java.util.*;

abstract class Electricity {
    int units;

    Electricity(int units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class Single extends Electricity {

    Single(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 8;
    }
}

class Shared extends Electricity {

    int occupants;

    Shared(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    double calculateBill() {
        return (units * 6) / (double) occupants;
    }
}

class AC extends Electricity {

    AC(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 10 + 200;
    }
}

public class Room {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int units = sc.nextInt();

            Electricity room;

            if (type.equals("SINGLE")) {
                room = new Single(units);
            }
            else if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                room = new Shared(units, occupants);
            }
            else {
                room = new AC(units);
            }

            double bill = room.calculateBill();

            System.out.printf("%s: %.2f%n", type, bill);

            total = total + bill;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}

