import java.util.Arrays;

public class BankAccount {

    protected String account_number;
    protected double balance;
    protected static int totalAccounts;

    public BankAccount(double balance) {
        this.account_number = getRandomSequence();
        this.balance = balance;
        totalAccounts++;
    }

    protected static String getRandomSequence() {
        int[] sequence = new int[10];
        String format = "";

        for (int i = 0; i < sequence.length; i++) {
            int randomNum = (int) (Math.random() * 9);
            sequence[i] = randomNum;
            format += Integer.toString(sequence[i]);
        }

        return format;
    }

    public void deposit(double amount) {
        if (Double.toString(amount).isEmpty() || amount <= 0) {
            System.out.println("Amount is invalid. ");
        } else {
            balance += amount;
            System.out.println(balance);
        }
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (Double.toString(amount).isEmpty() || amount > balance) {
            System.out.println("Amount is invalid. ");
        } else {
            balance -= amount;
            System.out.println(balance);
        }
    }

    public String getAccountNumber() {
        return account_number;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }


    public static void main(String[] args) {

        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(2000);

        account1.deposit(-6);
        account2.withdraw(2001);

        System.out.println("Account " + account1.getAccountNumber() + " balance: " + account1.getBalance());
        System.out.println("Account " + account2.getAccountNumber() + " balance: " + account2.getBalance());

        System.out.println("Total number of accounts: " + BankAccount.getTotalAccounts());

    }
}