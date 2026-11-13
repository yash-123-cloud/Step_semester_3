public class LibraryBookShelfProblem {

    public static void shelf(int[] books) {

        for (int i = 1; i < books.length; i++) {

            int key = books[i];
            int j = i - 1;

            while (j >= 0 && books[j] > key) {
                books[j + 1] = books[j];
                j--;
            }

            books[j + 1] = key;

            System.out.print("After placing " + key + ": ");
            System.out.print("[");

            for (int k = 0; k < books.length; k++) {
                System.out.print(books[k]);

                if (k < books.length - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println("]");
        }
    }

    public static void main(String[] args) {

        int[] books = {30, 2, 40, 20};

        shelf(books);
    }
}