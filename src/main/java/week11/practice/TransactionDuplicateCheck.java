import java.util.HashSet;

public class TransactionDuplicateCheck {

    static boolean hasDuplicate(String[] transactionIds) {

        HashSet<String> set = new HashSet<>();

        for (String id : transactionIds) {

            if (set.contains(id)) {
                return true;
            }

            set.add(id);
        }

        return false;
    }

    public static void main(String[] args) {

        String[] a = {
                "TXN1001", "TXN1002", "TXN1003",
                "TXN1002", "TXN1004"
        };

        String[] b = {
                "TXN2001", "TXN2002", "TXN2003"
        };

        System.out.println(hasDuplicate(a));
        System.out.println(hasDuplicate(b));
    }
}