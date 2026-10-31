import java.util.Scanner;

abstract class GardenPlot {
    String owner;

    GardenPlot(String owner) {
        this.owner = owner;
    }

    abstract double calculateArea();
}

class CirclePlot extends GardenPlot {
    double radius;

    CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends GardenPlot {
    double length, width;

    RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }
}

class TrianglePlot extends GardenPlot {
    double base, height;

    TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }
}

class GardenPlotReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        GardenPlot[] plots = new GardenPlot[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();

            switch (shape) {
                case "CIRCLE":
                    plots[i] = new CirclePlot(owner, sc.nextDouble());
                    break;

                case "RECTANGLE":
                    plots[i] = new RectanglePlot(
                            owner, sc.nextDouble(), sc.nextDouble());
                    break;

                case "TRIANGLE":
                    plots[i] = new TrianglePlot(
                            owner, sc.nextDouble(), sc.nextDouble());
                    break;
            }
        }

        for (GardenPlot p : plots) {
            double area = p.calculateArea();
            System.out.printf("%s (%s): %.2f%n",
                    p.owner,
                    p instanceof CirclePlot ? "CIRCLE" :
                            p instanceof RectanglePlot ? "RECTANGLE" : "TRIANGLE",
                    area);
            total += area;
        }

        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}