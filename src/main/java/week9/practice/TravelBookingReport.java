import java.util.Scanner;

abstract class TravelBooking {
    static final double BOOKING_FEE = 50.0;

    double distance;

    TravelBooking(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    double calculateTotal() {
        return calculateFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    BusBooking(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 2.0;
    }
}

class TrainBooking extends TravelBooking {
    TrainBooking(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 1.5;
    }
}

class FlightBooking extends TravelBooking {
    FlightBooking(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 2500 + (distance * 4.0);
    }
}

class TravelBookingReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        TravelBooking[] bookings = new TravelBooking[n];
        String[] modes = new String[n];

        for (int i = 0; i < n; i++) {
            modes[i] = sc.next();
            double distance = sc.nextDouble();

            switch (modes[i]) {
                case "BUS":
                    bookings[i] = new BusBooking(distance);
                    break;

                case "TRAIN":
                    bookings[i] = new TrainBooking(distance);
                    break;

                case "FLIGHT":
                    bookings[i] = new FlightBooking(distance);
                    break;
            }
        }

        for (int i = 0; i < n; i++) {
            double total = bookings[i].calculateTotal();

            System.out.printf("%s: %.2f%n", modes[i], total);
        }

        sc.close();
    }
}