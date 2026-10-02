import java.util.*;

abstract class Bonus {
    String name;
    double salary;

    Bonus(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateBonus();
}

class FullTime extends Bonus {

    FullTime(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTime extends Bonus {

    PartTime(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * 0.05;
    }
}

class Intern extends Bonus {

    Intern(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return 2000;
    }
}

public class Employee {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Bonus employee;

            if (type.equals("FULLTIME")) {
                employee = new FullTime(name, salary);
            }
            else if (type.equals("PARTTIME")) {
                employee = new PartTime(name, salary);
            }
            else {
                employee = new Intern(name, salary);
            }

            double bonus = employee.calculateBonus();

            System.out.printf("%s: %.2f%n", name, bonus);

            total = total + bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", total);
    }
}

