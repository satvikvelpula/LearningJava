import java.util.Scanner;

public class SubArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int size = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[size];
        int max_sum = Integer.MIN_VALUE;
        int max_start = 0;
        int max_end = 0;


        for (int j = 0; j < size; j++) {
            System.out.println("Enter integer " + (j + 1) + ": ");
            int num = Integer.parseInt(scanner.nextLine());
            arr[j] = num;
        }


        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {

                int currentSum = 0;

                for (int i = start; i <= end; i++) {
                    currentSum = currentSum + arr[i];
                }

                if (currentSum > max_sum) {
                    max_sum = currentSum;
                    max_start = start;
                    max_end = end;
                }

            }
        }

        System.out.println("Maximum sum: " + max_sum + ", Integers: " + (max_start + 1) + " - " + (max_end + 1));




    }


}
