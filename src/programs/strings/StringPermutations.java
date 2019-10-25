package programs.strings;

/**
 * Created by raghu on 3/7/17.
 */
public class StringPermutations {

    public static void main(String[] args) {
        String input = "abab";
        permutation(input);
    }

    /**
     * A method exposed to client to calculate permutation of String in Java.
     */

    private static void permutation(String input) {
        permutation("", input);
    }

    /**
     * Recursive method which actually prints all permutations
     * of given String, but since we are passing an empty String
     * as current permutation to start with,
     * I have made this method private and didn't exposed it to client.
     */

    private static void permutation(String perm, String word) {

        if (word.isEmpty()) {

            checkPalindrome(perm);
        } else {
            for (int i = 0; i < word.length(); i++) {
                permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
            }
        }
    }

    private static void checkPalindrome(String perm) {

        String reversed = reverse(perm);
        if (perm.equals(reversed)) {
            System.out.println("Permutation " + perm + " is a palindrome");
        }
    }

    private static String reverse(String input) {
        StringBuilder builder = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            builder.append(input.charAt(i));
        }
        return builder.toString();

    }
}


