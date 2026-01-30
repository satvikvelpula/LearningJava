/*

Task 2: Generate number sequence and store it to a CSV file for spreadsheet application

Generate a Fibonacci sequence of 60 numbers and write them to a CSV file.
Then read the content of the file with a spreadsheet application.

Note that the Fibonacci number of 60 is 1548008755920 that is too large
to be stored in a 32-bit integer. Therefore, you need to use long data type instead of int.
Please note also that the sequence starts with 0 and 1 and depending on your algorithm,
it may take time to calculate the sequence.


Fibonacci sequence = Fn = Fn-1 + Fn-2
Assume n = 9, this would mean that 8 + 7 = 15, 15 is now our curr number, again: Fn-1 + Fn - 2 ->
14 + 13 = 27
 */

import java.io.*;
import java.util.ArrayList;

public class Fibonacci {

    public final static String FILE_NAME = "fibonacci.csv";

    public static void main(String[] args) throws IOException {
        File f = new File(FILE_NAME);

        try (
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f));
        ) {
            long a = 0;
            long b = 1;
            long next = 0;
            int count = 60;

            bufferedWriter.write(a + ", ");
            bufferedWriter.write(b + ", ");

            for (int i = 2; i <= count; i++) {
                next = a + b;
                a = b;
                b = next;
                bufferedWriter.write(String.valueOf(next) + ", ");
            }

            System.out.println(next);


        } catch (IOException e) {
            System.out.println("Error. ");
        }

    }
}
