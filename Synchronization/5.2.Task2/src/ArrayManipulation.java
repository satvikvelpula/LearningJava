import java.util.ArrayList;

public class ArrayManipulation {

    private ArrayList<Integer> array;

    public ArrayManipulation() {
        array = new ArrayList<>();
    }

    public ArrayList<Integer> getArray() {
        return array;
    }

    public boolean addItem(int num) {
        synchronized(this) {
            try {
                array.add(num);
                return true;
            } catch (IllegalArgumentException e) {
                System.out.println("Illegal argument passed. ");
                return false;
            }

        }
    }

    public boolean removeItem(int num) {
        synchronized(this) {
            try {
                if (!array.contains(num)) {
                    return false;
                } else {
                    array.remove(Integer.valueOf(num));
                    return true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Illegal argument passed. ");
                return false;
            }
        }
    }

    public String getSize() {
        synchronized(this) {
            return "The array's size is: " + array.size();
        }
    }

    public static void /* ArrayList<Thread> */ generateThreads(ArrayManipulation array_reference) {
        // ArrayList<Thread> threads = new ArrayList<>();
        int count = 20;
        for (int i = 0; i < 20; i++) {
            IntegerRequest integerRequest = new IntegerRequest(array_reference);
            Thread t = new Thread(integerRequest);
            try {
                t.start();
                t.join();
            } catch(InterruptedException e) {
                System.out.println("Error. ");
            }
            // threads.add(t);
        }
        // return threads;
    }

}

class IntegerRequest implements Runnable {
    int num;
    ArrayManipulation array;

    public IntegerRequest(ArrayManipulation array_reference) {
        this.array = array_reference;
        this.num = (int) (Math.random() * 10 + 1);
    }

    public void IntegerRequestToAdd(int num) {
        boolean success = array.addItem(num);
        if (success) {
            System.out.println("Added Integer " + num + " to array, array is now sized: " + array.getSize());
        } else {
            System.out.println("Couldn't add integer. ");
        }
    }

    public void IntegerRequestToRemove(int num) {
        boolean success = array.removeItem(num);
        if (success) {
            System.out.println("Removed Integer " + num + " from array, array is now sized: " + array.getSize());
        } else {
            System.out.println("Couldn't remove integer. ");
        }
    }
    public void run() {
        IntegerRequestToAdd(num);
        IntegerRequestToRemove(num);
    }

}



class Main {
    public static void main(String[] args) {
        ArrayManipulation array = new ArrayManipulation();

        ArrayManipulation.generateThreads(array);

        // for (Thread i : ArrayManipulation.generateThreads()) {}

    }
}

