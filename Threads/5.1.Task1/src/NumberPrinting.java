class EvenNumPrinting implements Runnable {

    int even_num;
    int range;

    public EvenNumPrinting(int range) {
        this.range = range;
    }

    @Override
    public void run() {
        int count = 0;
        for (int i = 1; i <= range; i++) {
            if (i % 2 == 0) {
                count++;
                System.out.println("Printing even number (" + count + ") " + i);
            }
        }
    }
}

class OddNumPrinting implements Runnable {

    int odd_num;
    int range;

    public OddNumPrinting(int range) {
        this.range = range;
    }

    @Override
    public void run() {
        int count = 0;
        for (int i = 1; i <= range; i++) {
            if (i % 2 != 0) {
                count++;
                System.out.println("Printing odd number (" + count + ") " + i);
            }
        }
    }
}

public class NumberPrinting {

    public static void main(String[] args) {
        EvenNumPrinting even_nums = new EvenNumPrinting(20);
        Thread t = new Thread(even_nums);
        t.start();
        OddNumPrinting odd_nums = new OddNumPrinting(20);
        Thread t_2 = new Thread(odd_nums);
        t_2.start();

    }

}