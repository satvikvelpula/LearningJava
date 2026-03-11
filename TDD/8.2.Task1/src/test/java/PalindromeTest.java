import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class PalindromeTest {

    @BeforeAll
    public static void message() {
        System.out.println("Starting Palindrome Tests");
    }

    @Test
    // first check if String is not a Palindrome
    public void returnFalseIfStringIsNotPalindrome() throws NullPointerException {
        PalindromeDetector palindromeDetector = new PalindromeDetector();
        String candidate = "Palindrome";
        boolean res = palindromeDetector.checkIfPalindrome(candidate);
        assertFalse(res, "If the result is not a palindrome, the result should always be false. ");
    }

    @Test
    // check if String is a Palindrome
    public void returnTrueIfStringIsPalindrome() throws NullPointerException {
        PalindromeDetector palindromeDetector = new PalindromeDetector();
        String candidate = "bob";
        boolean res = palindromeDetector.checkIfPalindrome(candidate);
        assertTrue(res, "If the result is a palindrome, the result should always be true. ");
    }

    @Test
    // check if the palindrome candidate was skimmed into normal variable in PalindromeDetector
    public void checkIfCandidateIsEqualToSkimmed() throws NullPointerException {
        PalindromeDetector palindromeDetector = new PalindromeDetector();
        String candidate = "A man, a plan, a canal, Panama";
        palindromeDetector.checkIfPalindrome(candidate);
        String get_normal_format = palindromeDetector.getNormal();
        assertNotEquals(candidate, get_normal_format, "When the method is in action, the string entered in the parameter signature can NOT be the same as the formatted version. Otherwise the formatting didn't work. ");
    }

    @Test
    public void singularLetterIsAlwaysAPalindrome() throws NullPointerException {
        PalindromeDetector palindromeDetector = new PalindromeDetector();
        String candidate = "a";
        boolean res = palindromeDetector.checkIfPalindrome(candidate);
        assertTrue(res, "Singular character is always a palindrome. ");
    }

    @Test
    public void ifNullAcceptThrow() throws NullPointerException {
        PalindromeDetector palindromeDetector = new PalindromeDetector();
        String candidate = null;
        assertThrows(NullPointerException.class, () -> palindromeDetector.checkIfPalindrome(candidate));
    }









}
