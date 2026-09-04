import java.util.*;

class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of people: ");
        int n = sc.nextInt();

        double[] height = new double[n];
        double[] weight = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter height: ");
            height[i] = sc.nextDouble();

            System.out.print("Enter weight: ");
            weight[i] = sc.nextDouble();
        }

        for (int i = 0; i < n; i++) {

            double bmi = weight[i] / (height[i] * height[i]);

            String status;

            if (bmi < 18.5)
                status = "Underweight";
            else if (bmi < 25)
                status = "Normal";
            else if (bmi < 30)
                status = "Overweight";
            else
                status = "Obese";

            System.out.printf(
                    "Person %d: BMI = %.2f, %s%n",
                    i + 1, bmi, status
            );
        }
    }
}