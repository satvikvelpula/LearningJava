class Theater {
    int seat_limit;
    int customer_num;

    public Theater() {
        seat_limit = 100;
    }

    public boolean reserveSeats(int num) {
        synchronized(this) {
            if (num <= seat_limit) {
                seat_limit -= num;
                customer_num++;
                return true;
            } else {
                return false;
            }
        }

    }
}


public class Customer implements Runnable {
    int seats_request;
    Theater theater;

    public Customer() {
        this.seats_request = (int) (Math.random() * 3 + 1);
    }

    public void requestSeats(Theater theater, int seats_request) {
        boolean success = theater.reserveSeats(seats_request);

        if (success) {
            System.out.println("Customer " + theater.customer_num + " reserved " + seats_request + " tickets. " + "Seats left: " + theater.seat_limit);
        } else {
            System.out.println("Customer " + theater.customer_num + " couldn't reserve " + seats_request + " tickets. " + "Seats left: " + theater.seat_limit);
        }
    }

    public void run() {
        requestSeats(theater, (int) (Math.random() * 3 + 1));
    }
}


class Main {
    public static void main(String[] args) throws InterruptedException, IllegalThreadStateException {

        Theater finnkino_theater = new Theater();

        int randint = (int) (Math.random() * 100 + 1);

        for (int i = 0; i < randint; i++) {
            Customer customer = new Customer();
            customer.theater = finnkino_theater;
            Thread t = new Thread(customer);
            t.start();
        }

    }
}
