import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JUnitTest {

    @BeforeAll
    public static void statement() {
        System.out.println("Beginning tests of StringManipulator.java");
    }


    @Test
    public void checkIfResultConcatenated() {
        StringManipulator obj = new StringManipulator();
        String string_one = "Juha";
        String string_two = "Tauriainen";
        String res = obj.concatenate(string_one, string_two);
        assertNotEquals(string_one.length(), res.length(), "Checking to see if the outcome really has changed. ");
        assertTrue(res.contains(string_one), "Result should contain first string sequence. ");
        assertTrue(res.contains(string_two), "Result should contain second string sequence. ");
    }

    @Test
    public void checkConcatenateWithEmptyStringReturnsEmpty() {
        StringManipulator obj = new StringManipulator();
        String res = obj.concatenate("Hello", "");
        assertEquals("", res, "Concatenating with empty string should return empty string");

        res = obj.concatenate("", "World");
        assertEquals("", res, "Concatenating with empty string should return empty string");

        res = obj.concatenate("", "");
        assertEquals("", res, "Concatenating two empty strings should return empty string");
    }

    @Test
    public void checkIfLengthMatchesTrimmedString() {
        StringManipulator obj = new StringManipulator();
        String string_example = "  Jarkko Vuori  "; // extra spaces
        int res = obj.findLength(string_example.replace(" ", ""));
        assertEquals(string_example.trim().replace(" ", "").length(), res, "Length should match trimmed string");
    }

    @Test
    public void checkUpperCaseConversion() {
        StringManipulator obj = new StringManipulator();
        String string_example = "Functional Interface";
        String res = obj.convertToUpperCase(string_example);
        assertEquals(string_example.toUpperCase().trim(), res, "Uppercase conversion should match expected result");
    }

    @Test
    public void checkLowerCaseConversion() {
        StringManipulator obj = new StringManipulator();
        String string_example = "Inheritance";
        String res = obj.convertToLowerCase(string_example);
        assertEquals(string_example.toLowerCase().trim(), res, "Lowercase conversion should match expected result");
    }

    @Test
    public void checkSubstringIsPresent() {
        StringManipulator obj = new StringManipulator();
        String main_string = "The fox jumped over the lazy dog.";
        String substring = "fox";

        boolean res = obj.findSubstring(main_string, substring);
        assertTrue(res, "Substring should be found in main string");

        // Negative test: substring not present
        substring = "cat";
        res = obj.findSubstring(main_string, substring);
        assertFalse(res, "Substring not present should return false");
    }

    @Test
    public void checkEmptySubstringReturnsTrue() {
        StringManipulator obj = new StringManipulator();
        String main_string = "Anything";

        boolean res = obj.findSubstring(main_string, "");
        assertTrue(res, "Empty substring should always return true");
    }


    @Test
    public void checkIfLengthOfListMatches() {
        StringManipulator obj = new StringManipulator();
        String string_example = "Jarkko Vuori"; // JarkkoVuori because of whitespace removal in StringManipulation
        String replaced = string_example.replace(" ", "").trim();
        int res = obj.findLength(replaced);
        assertEquals(replaced.length(), res);
    }

    @Test
    public void checkIfExampleMatchesUpperCaseMethod() {
        StringManipulator obj = new StringManipulator();
        String string_example = "Functional Interface";
        String res = obj.convertToUpperCase(string_example);
        assertEquals(string_example.toUpperCase().trim(), res);
    }

    @Test
    public void checkIfExampleMatchesLowerCaseMethod() {
        StringManipulator obj = new StringManipulator();
        String string_example = "Inheritance";
        String res = obj.convertToLowerCase(string_example);
        assertEquals(string_example.toLowerCase().trim(), res);
    }

    @Test
    public void checkIfSubstringIsPresentWithBoolean() {
        StringManipulator obj = new StringManipulator();
        String main_string = "The fox jumped over the lazy dog.";
        String substring = "fox";
        boolean res = obj.findSubstring(main_string.trim(), substring.trim());
        assertTrue(res);

    }

}
