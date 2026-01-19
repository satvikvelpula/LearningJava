import java.util.Scanner;

public class ObsoleteMeasures {

    public static void main(String[] args) {
        // Weight in grams

        Scanner scanner = new Scanner(System.in);

        double leivaska = 8499.2; // one leiväskä is this many grams
        double naula = 424.96; // one naula is this many grams
        double luoti = 13.28; // one luoti is this many grams

        System.out.println("Enter the amount of grams: ");
        double grams = Double.parseDouble(scanner.nextLine());

        int l = (int) (grams / leivaska);
        int remaining_1 = (int) (grams - (l * leivaska));
        int n = (int) (remaining_1 / naula);
        int remaining_2 = (int) (remaining_1 - (n * naula));
        float lu = (float) (remaining_2 / luoti);
        int remaining_3 = (int) (remaining_2 - (lu * luoti)); // debug purposes

        System.out.printf("Leiväskä: %d, Naula: %d, Luoti: %.2f, (Debug Purpose) Remaining: %d", l, n, lu, remaining_3);

    }

}
