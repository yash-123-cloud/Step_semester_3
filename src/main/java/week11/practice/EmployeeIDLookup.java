import java.util.HashMap;

public class EmployeeIDLookup {

    static HashMap<String, String> buildLookup(String[][] records) {

        HashMap<String, String> lookup = new HashMap<>();

        for (String[] record : records) {
            lookup.put(record[0], record[1]);
        }

        return lookup;
    }

    static String getDepartment(
            HashMap<String, String> lookup, String employeeId) {

        return lookup.getOrDefault(employeeId, "Unknown");
    }

    public static void main(String[] args) {

        String[][] records = {
                {"E245", "Finance"},
                {"E110", "Engineering"},
                {"E390", "Marketing"},
                {"E101", "Engineering"}
        };

        HashMap<String, String> lookup = buildLookup(records);

        System.out.println(getDepartment(lookup, "E390"));
        System.out.println(getDepartment(lookup, "E999"));
    }
}