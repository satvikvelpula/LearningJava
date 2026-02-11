import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Math.min;

class ArrayGenerator {

    final int MAX_SIZE;
    int[] the_array;

    public ArrayGenerator() {
        this.MAX_SIZE = 1_000_000;
        this.the_array = new int[0];
    } // now we have to create a singular object to generate an array

    public int[] generateArray(int num) {
        if (num <= 0 || num > MAX_SIZE) {
            System.out.println("Not valid. ");
        } else {
            the_array = new int[num];
            int i_count = 0;
            System.out.println("Generating and populating array...");
            for (int i = 0; i < the_array.length; i++) {
                i_count++;
                the_array[i] = i_count;
            }
        }

        return the_array;

    }

    public void token() {
        int availableProcessors = Runtime.getRuntime().availableProcessors(); // aka thread count
        int chunkSizeForThread = (the_array.length + (availableProcessors - 1)) / availableProcessors; // aka chunk size for singular thread
        System.out.println("Chunk size for thread: " + chunkSizeForThread);
        System.out.println("Thread count: " + availableProcessors);
        ArrayList<Thread> threads = new ArrayList<>();
        ArrayList<Array> total_array = new ArrayList<>();

        for (int i = 0; i < availableProcessors; i++) {
            String name;
            name = "Thread_" + (i + 1);
            Array t = new Array(the_array, i * chunkSizeForThread, min((i * chunkSizeForThread) + chunkSizeForThread, the_array.length));
            total_array.add(t);
            Thread thread = new Thread(t);
            thread.setName(name);
            thread.start();
            threads.add(thread);
        }

        try {
            for (Thread j : threads) {
                j.join();
            }
        } catch (IllegalThreadStateException | InterruptedException e) {
            System.out.println("Error. ");
        }
        

        long complete_sum = 0;

        for (Array i : total_array) {
            complete_sum += i.total_sum;
        }

        System.out.println("Total sum of all arrays: " +  complete_sum);

    }

}

class Array implements Runnable { // base thread template

    int start_index;
    int stop_index;
    int total_sum;
    int[] arr;

    public Array(int[] array, int start_index, int stop_index) {
        this.start_index = start_index;
        this.stop_index = stop_index;
        this.arr = array;
     }

    @Override
    public void run() {
        for (int start = start_index; start < stop_index; start++) {
            total_sum += arr[start];
        }

        System.out.println("Array's total sum: " + total_sum + " Start to finish: " + start_index + ":" + stop_index);
    }
}

class Main {

    public static void main(String[] args) {
        ArrayGenerator array = new ArrayGenerator();
        array.generateArray(452);
        array.token();

    }
}