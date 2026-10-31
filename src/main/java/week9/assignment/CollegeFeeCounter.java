import java.util.Scanner;

abstract class CollegeStudent {
    String name;

    CollegeStudent(String name) {
        this.name = name;
    }

    abstract double calculateFee();
}

interface CollegeBusUser {
    double getTransportFee();
}

class DayScholarStudent extends CollegeStudent
        implements CollegeBusUser {

    DayScholarStudent(String name) {
        super(name);
    }

    public double getTransportFee() {
        return 12000;
    }

    double calculateFee() {
        return 40000 + getTransportFee();
    }
}

class HostellerStudent extends CollegeStudent {

    HostellerStudent(String name) {
        super(name);
    }

    double calculateFee() {
        return 40000 + 60000;
    }
}

class ScholarshipStudent extends CollegeStudent
        implements CollegeBusUser {

    ScholarshipStudent(String name) {
        super(name);
    }

    public double getTransportFee() {
        return 12000;
    }

    double calculateFee() {
        return 20000 + getTransportFee();
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            CollegeStudent student = null;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholarStudent(name);
                    break;

                case "HOSTELLER":
                    student = new HostellerStudent(name);
                    break;

                case "SCHOLAR":
                    student = new ScholarshipStudent(name);
                    break;
            }

            if (student != null) {
                double fee = student.calculateFee();

                System.out.printf("%s: %.2f%n", name, fee);

                total += fee;
            }
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}