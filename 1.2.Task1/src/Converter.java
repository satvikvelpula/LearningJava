import java.util.Scanner;

public class Converter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the degrees in Fahrenheit: ");
        float fahrenheit = Integer.parseInt(scanner.nextLine());
        float celsius = ((fahrenheit - 32) * 5/9);
        float celsiusRounded = Math.round((celsius * 10) / 10);
        System.out.println(celsiusRounded);
    }
}
