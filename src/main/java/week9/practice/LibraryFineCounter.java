import java.util.Scanner;

abstract class C3LibraryItem {
    String title;
    int daysLate;

    C3LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double calculateFine();
}

class C3BookFine extends C3LibraryItem {
    C3BookFine(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return daysLate * 2.0;
    }
}

class C3DVDFine extends C3LibraryItem {
    C3DVDFine(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}

class C3MagazineFine extends C3LibraryItem {
    C3MagazineFine(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return daysLate * 1.0;
    }
}

public class LibraryFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        C3LibraryItem[] items = new C3LibraryItem[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();

            switch (type) {
                case "BOOK":
                    items[i] = new C3BookFine(title, days);
                    break;

                case "DVD":
                    items[i] = new C3DVDFine(title, days);
                    break;

                case "MAGAZINE":
                    items[i] = new C3MagazineFine(title, days);
                    break;
            }
        }

        for (C3LibraryItem item : items) {
            double fine = item.calculateFine();

            System.out.printf("%s: %.2f%n",
                    item.title, fine);

            total += fine;
        }

        System.out.printf("Total Fines: %.2f%n", total);

        sc.close();
    }
}