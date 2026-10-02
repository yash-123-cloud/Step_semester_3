import java.util.*;

abstract class Parking {
    int hours;

    Parking(int hours) {
        this.hours = hours;
    }

    abstract double calculateCharge();
}

class Bike extends Parking {

    Bike(int hours) {
        super(hours);
    }

    double calculateCharge() {
        return hours * 10;
    }
}

class Car extends Parking {

    Car(int hours) {
        super(hours);
    }

    double calculateCharge() {
        return 30 + (hours - 1) * 20;
    }
}

class Truck extends Parking {

    Truck(int hours) {
        super(hours);
    }

    double calculateCharge() {
        return Math.max(100, hours * 50);
    }
}

public class Vehicle {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int hours = sc.nextInt();

            Parking parking;

            if (type.equals("BIKE")) {
                parking = new Bike(hours);
            }
            else if (type.equals("CAR")) {
                parking = new Car(hours);
            }
            else {
                parking = new Truck(hours);
            }

            double charge = parking.calculateCharge();

            System.out.printf("%s: %.2f%n", type, charge);

            total = total + charge;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}

