import java.time.LocalDate;
import java.util.Scanner;

interface LibraryItem {
    LocalDate getDueDate();
    String getTitle();
}

class Book implements LibraryItem {

    String title;

    Book(String title) {
        this.title = title;
    }

    public LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(14);
    }

    public String getTitle() {
        return title;
    }
}

class DVD implements LibraryItem {

    String title;

    DVD(String title) {
        this.title = title;
    }

    public LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(7);
    }

    public String getTitle() {
        return title;
    }
}

class Magazine implements LibraryItem {

    String title;

    Magazine(String title) {
        this.title = title;
    }

    public LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(3);
    }

    public String getTitle() {
        return title;
    }
}

public class Library {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String type = line.substring(0, line.indexOf(" "));
            String title = line.substring(line.indexOf(" ") + 1);

            title = title.replace("\"", "");

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book(title);
            } else if (type.equals("DVD")) {
                item = new DVD(title);
            } else {
                item = new Magazine(title);
            }

            System.out.println(
                    item.getTitle() + ": " + item.getDueDate()
            );
        }

        sc.close();
    }
}