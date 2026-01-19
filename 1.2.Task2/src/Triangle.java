import java.util.Scanner;

public class Triangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("One leg of right triangle: ");
        long first_leg = Integer.parseInt(scanner.nextLine());
        System.out.println("Second leg of right triangle: ");
        long second_leg = Integer.parseInt(scanner.nextLine());
        long formula = (long) Math.sqrt((first_leg * first_leg) + (second_leg * second_leg));
        System.out.println( (float) formula);
    }

}
