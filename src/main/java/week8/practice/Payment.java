import java.util.Scanner;

interface PaymentMethod {
    double calculateAmount(double amount);
}

class CardPayment implements PaymentMethod {
    public double calculateAmount(double amount) {
        return amount + (amount * 0.02);
    }
}

class WalletPayment implements PaymentMethod {
    public double calculateAmount(double amount) {
        return amount + (amount * 0.01);
    }
}

class BankTransferPayment implements PaymentMethod {
    public double calculateAmount(double amount) {
        return amount;
    }
}

public class Payment {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            PaymentMethod payment;

            if (type.equals("CARD")) {
                payment = new CardPayment();
            } else if (type.equals("WALLET")) {
                payment = new WalletPayment();
            } else {
                payment = new BankTransferPayment();
            }

            double finalAmount = payment.calculateAmount(amount);

            System.out.printf("%s: %.2f%n", type, finalAmount);

            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}