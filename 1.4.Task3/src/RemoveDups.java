
import java.util.Scanner;
import java.util.Arrays;

public class RemoveDups {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[size];


        for (int i = 0; i < size; i++) {
            System.out.println("Enter integer " + (i + 1) + ": ");
            int num = Integer.parseInt(scanner.nextLine());
            arr[i] = num;
        }

        int k = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean duplicate = false;

            for (int j = 0; j < k; j++) {
                if (arr[i] == arr[j]) {
                    duplicate = true;
                    break;
                }
            }

            if (!duplicate) {
                arr[k] = arr[i];
                k++;
            }
        }

        System.out.println("The array without duplicates: " + Arrays.toString(Arrays.copyOfRange(arr, 0, k)));

    }

}
