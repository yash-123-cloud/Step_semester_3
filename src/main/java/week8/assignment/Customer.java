import java.util.*;

abstract class Bill {
    double amount;

    Bill(double amount) {
        this.amount = amount;
    }

    abstract double calculateAmount();
}

class Student extends Bill {

    Student(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount * 0.90;
    }
}

class Staff extends Bill {

    Staff(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount * 0.95;
    }
}

class Guest extends Bill {

    Guest(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount + 10;
    }
}

public class Customer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            Bill bill;

            if (type.equals("STUDENT")) {
                bill = new Student(amount);
            }
            else if (type.equals("STAFF")) {
                bill = new Staff(amount);
            }
            else {
                bill = new Guest(amount);
            }

            double finalAmount = bill.calculateAmount();

            System.out.printf("%s: %.2f%n", type, finalAmount);

            total = total + finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}

