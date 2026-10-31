import java.util.Scanner;

abstract class ShippingParcel {
    double weight;
    double declaredValue;

    ShippingParcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();
}

interface ParcelInsurance {
    double calculateInsurance();
}

class StandardShippingParcel extends ShippingParcel {

    StandardShippingParcel(double weight, double value) {
        super(weight, value);
    }

    double calculateCharge() {
        return 40 + (10 * weight);
    }
}

class ExpressShippingParcel extends ShippingParcel
        implements ParcelInsurance {

    ExpressShippingParcel(double weight, double value) {
        super(weight, value);
    }

    double calculateCharge() {
        return 80 + (15 * weight);
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

class FragileShippingParcel extends ShippingParcel
        implements ParcelInsurance {

    FragileShippingParcel(double weight, double value) {
        super(weight, value);
    }

    double calculateCharge() {
        return 40 + (10 * weight) + 50;
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            ShippingParcel parcel = null;
            double insurance = 0;

            switch (type) {
                case "STANDARD":
                    parcel = new StandardShippingParcel(weight, value);
                    break;

                case "EXPRESS":
                    parcel = new ExpressShippingParcel(weight, value);
                    insurance = ((ParcelInsurance) parcel)
                            .calculateInsurance();
                    break;

                case "FRAGILE":
                    parcel = new FragileShippingParcel(weight, value);
                    insurance = ((ParcelInsurance) parcel)
                            .calculateInsurance();
                    break;
            }

            if (parcel != null) {
                double charge = parcel.calculateCharge();
                double total = charge + insurance;

                System.out.printf(
                        "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                        type, charge, insurance, total
                );

                grandTotal += total;
            }
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
