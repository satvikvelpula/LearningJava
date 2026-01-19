import java.util.Scanner;
public class MultiplicationTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = 3;
        int score = 0;
        boolean valid = false;

        for (int i = 1; i <= counter; i++) {

            while (!valid) {

                int rand1 = (int) ((Math.random() * 10 + 1));
                int rand2 = (int) ((Math.random() * 10 + 1));
                int equation = rand1 * rand2;
                System.out.println(rand1 + " * " + rand2 + " = " + "?");
                System.out.println("Enter the answer: ");
                int answer = scanner.nextInt();

                if (answer == equation) {
                    score++;
                }

                if (score == counter) {
                    System.out.println("Congratulations!");
                    valid = true;
                    break;
                }
            }

        }

        System.out.println("Your score: " + score); 

    }
}
