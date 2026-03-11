import java.util.Arrays;

public class PalindromeDetector {

    String normal; // this is the formatted version of provided_candidate parameter
    String reversed_normal; // this is the reversed version of the normal formatted string

    public PalindromeDetector() {
        this.normal = "";
        this.reversed_normal = "";
    }

    // getters for normal and reversed_normal
    public String getNormal() {
        return normal;
    }

    public String getReversedNormal() {
        return reversed_normal;
    }


    public boolean checkIfPalindrome(String provided_candidate) throws NullPointerException {

        if (provided_candidate == null) {
            throw new NullPointerException("Provided candidate is null. ");
        }

        normal = provided_candidate.toLowerCase().trim().replaceAll("[^\\\\sa-zA-Z0-9]", ""); // regex to remove punctuation
        char[] normalArray = normal.toCharArray();

        StringBuilder normal_format = new StringBuilder();
        StringBuilder reversed_format = new StringBuilder();

        // e.g. A man, a plan, a canal, Panama
        for (int i = normal.length() - 1; i >= 0; i--) {
            char index = normalArray[i];
            reversed_format.append(index);
        }

        for (char i : normalArray) {normal_format.append(i);}
        System.out.println("Normal format: " + normal_format);
        System.out.println("Reversed format: " + reversed_format);

        reversed_normal = reversed_format.toString();

        return normal.equals(reversed_normal);

    }

    public static void main(String[] args) throws Exception {
        PalindromeDetector palindromeDetector = new PalindromeDetector();
        boolean res = palindromeDetector.checkIfPalindrome("A man, a plan, a canal, Panama");
        System.out.println(res);
    }

}
