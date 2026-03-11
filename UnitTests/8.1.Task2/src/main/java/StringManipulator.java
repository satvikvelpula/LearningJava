
public class StringManipulator {

    public StringManipulator() {}

    public String concatenate(String string_one, String string_two) {
        String concatenation = "";
        String one = string_one.trim();
        String two = string_two.trim();
        if (!one.isEmpty() && !two.isEmpty()) {
            concatenation = string_one + string_two;
        }
        return concatenation;
    }

    public int findLength(String string) {// take out spaces
        String string_without_spaces = string.trim();
        return string_without_spaces.length();
    }

    public String convertToUpperCase(String str) {
        return str.toUpperCase().trim();
    }

    public String convertToLowerCase(String str) {
        return str.toLowerCase().trim();
    }

    public boolean findSubstring(String str, String subStr) {
        int n = str.length();
        int m = subStr.length();

        // Edge case: empty substring is considered found
        if (m == 0) return true;

        // Slide the window across the main string
        for (int i = 0; i <= n - m; i++) {
            boolean match = true;

            // Check each character inside the window
            for (int j = 0; j < m; j++) {
                if (str.charAt(i + j) != subStr.charAt(j)) {
                    match = false;
                    break; // mismatch, move to next window
                }
            }

            if (match) {
                return true; // substring found
            }
        }

        // No match found after sliding through the whole string
        return false;
    }
}
