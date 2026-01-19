/*
Write a program that prompts the user to enter a binary number (composed of 0s and 1s)
and converts it to decimal. Display the decimal equivalent on the console.
Hint: use the charAt method of the String class to retrieve the individual bits in the input string.
 */

/* Notes: To convert a binary number to a decimal number, we start by looking at the binary nums
    from the right, multiply the binary num by the power of 2. The power of 2 index starts at 0 and
    for every binary num, (2^n + 1) < number of binary nums. After we multiply each num of binary
    by its corresponding power of 2, we sum it all up to get our base 10 value.
 */

import java.util.Scanner;

public class BinaryValues {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        int[] arr = null;

        while (!valid) { // while valid is False
            System.out.println("Enter a binary number: ");
            String temp = scanner.nextLine();

            valid = true;

            arr = new int[temp.length()];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = temp.charAt(i) - '0';
            }

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < 0 || arr[j] > 1) {
                    System.out.println("Not a binary number. ");
                    valid = false;
                    break;
                }
            }

            if (valid) {

                int nElems = arr.length;

                int counter = 0;
                int total = 0;

                for (int k = nElems - 1; k > -1; k--) {
                    int equation = (int) (arr[k] * Math.pow(2, counter));
                    counter += 1;
                    total += equation;
                }

                System.out.println(total);

            }


        }


    }

}
