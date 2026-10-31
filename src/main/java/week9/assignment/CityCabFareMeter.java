import java.util.Scanner;

abstract class CityCab {
    double km;

    CityCab(double km) {
        this.km = km;
    }

    abstract double getRate();

    double calculateFare() {
        double fare = km * getRate();

        if (fare < 100) {
            fare = 100;
        }

        return fare;
    }
}

interface NightCabService {
    double getNightFare(double fare);
}

class MiniCityCab extends CityCab {

    MiniCityCab(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }
}

class SedanCityCab extends CityCab
        implements NightCabService {

    SedanCityCab(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }

    public double getNightFare(double fare) {
        return fare + (fare * 0.20);
    }
}

class SUVCityCab extends CityCab
        implements NightCabService {

    SUVCityCab(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }

    public double getNightFare(double fare) {
        return fare + (fare * 0.20);
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            CityCab cab = null;

            switch (type) {
                case "MINI":
                    cab = new MiniCityCab(km);
                    break;

                case "SEDAN":
                    cab = new SedanCityCab(km);
                    break;

                case "SUV":
                    cab = new SUVCityCab(km);
                    break;
            }

            if (cab == null) {
                continue;
            }

            if (time.equals("NIGHT")
                    && !(cab instanceof NightCabService)) {

                System.out.println(
                        type + ": night service not available"
                );

                continue;
            }

            double fare = cab.calculateFare();

            if (time.equals("NIGHT")) {
                fare = ((NightCabService) cab)
                        .getNightFare(fare);
            }

            System.out.printf("%s: %.2f%n", type, fare);

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}