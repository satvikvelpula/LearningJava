/*
Write a program that prompts the user to enter two positive integers,
start and end (where start < end). The program should generate and display all the prime numbers
 between start and end, inclusive.

 We get the two positive integers, e.g. Mind you, start has to be smaller than end,
 Starting 1: Ending 6, ending - starting to get all numbers between, convert this to an array
 and remove the prime numbers! Simple as that.
 */

import java.util.Scanner;

public class PrimeNumberGenerator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean valid = false;

        while (!valid) {

            System.out.println("Enter the first integer: ");
            int pos_1 = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the second integer: ");
            int pos_2 = Integer.parseInt(scanner.nextLine());

            if (pos_1 < pos_2) {
                valid = true;
            }


            // We need to make an array out of the difference of pos_2 and pos_1

            for (int i = pos_1; i <= pos_2; i++) {

                if (i <= 1) {
                    continue;
                }

                boolean isPrime = true;

                for (int divisor = 2; divisor <= Math.sqrt(i); divisor++) {

                    if (i % divisor == 0) {
                        isPrime = false;
                        break;
                    }

                }

                if (isPrime) {
                    System.out.println(i);
                }

            }

        }
    }
}
