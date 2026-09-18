class CompanyEmployee {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;

        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class CompanyInformation {
    public static void main(String[] args) {

        CompanyEmployee emp1 = new CompanyEmployee("Divya", 65000);
        CompanyEmployee emp2 = new CompanyEmployee("Arjun", 30000);
        CompanyEmployee emp3 = new CompanyEmployee("Priya", 45000);

        System.out.println("3 Employee objects created");

        CompanyEmployee.printCompanyInfo();
    }
}