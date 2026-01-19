import java.util.Scanner;

public class QuadraticEquation {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Coefficient 1: ");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.println("Coefficient 2: ");
        int b = Integer.parseInt(scanner.nextLine());
        System.out.println("Coefficient 3: ");
        int c = Integer.parseInt(scanner.nextLine());


        double sqroot = Math.sqrt(b*b - 4*a*c);

        if (Double.isNaN(sqroot)) {
            System.out.println("No real roots. ");
        } else {
            double root_positive = (-b + sqroot) / 2 * a;
            double root_negative = (-b - sqroot) / 2* a;

            System.out.print(root_positive + ", ");
            System.out.print(root_negative);
        }



    }

}
