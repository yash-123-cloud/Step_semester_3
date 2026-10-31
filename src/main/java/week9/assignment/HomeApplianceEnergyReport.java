import java.util.Scanner;

abstract class HomeAppliance {
    double hours;
    double power;

    HomeAppliance(double hours, double power) {
        this.hours = hours;
        this.power = power;
    }

    double calculateUnits() {
        return (power * hours) / 1000;
    }

    double calculateCost(double units) {
        return units * 8;
    }
}

interface ApplianceSaver {
    double calculateSaverUnits();
}

class FridgeAppliance extends HomeAppliance {

    FridgeAppliance(double hours) {
        super(hours, 150);
    }
}

class ACAppliance extends HomeAppliance
        implements ApplianceSaver {

    ACAppliance(double hours) {
        super(hours, 1500);
    }

    public double calculateSaverUnits() {
        return calculateUnits() * 0.75;
    }
}

class TVAppliance extends HomeAppliance {

    TVAppliance(double hours) {
        super(hours, 100);
    }
}

class WasherAppliance extends HomeAppliance
        implements ApplianceSaver {

    WasherAppliance(double hours) {
        super(hours, 500);
    }

    public double calculateSaverUnits() {
        return calculateUnits() * 0.75;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] data = line.split("\\s+");

            String type = data[0];
            double hours = Double.parseDouble(data[1]);

            boolean saver = data.length == 3
                    && data[2].equals("SAVER");

            HomeAppliance appliance = null;

            switch (type) {
                case "FRIDGE":
                    appliance = new FridgeAppliance(hours);
                    break;

                case "AC":
                    appliance = new ACAppliance(hours);
                    break;

                case "TV":
                    appliance = new TVAppliance(hours);
                    break;

                case "WASHER":
                    appliance = new WasherAppliance(hours);
                    break;
            }

            if (appliance == null) {
                continue;
            }

            if (saver && !(appliance instanceof ApplianceSaver)) {
                System.out.println(
                        type + ": saver mode not supported"
                );
                continue;
            }

            double units;

            if (saver) {
                units = ((ApplianceSaver) appliance)
                        .calculateSaverUnits();
            } else {
                units = appliance.calculateUnits();
            }

            double cost = appliance.calculateCost(units);

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);

        sc.close();
    }
}