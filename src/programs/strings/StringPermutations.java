package programs.strings;

/**
 * Created by raghu on 3/7/17.
 */
public class StringPermutations {
    public static void main(String args[]) {
        permutation("abab");


    }
    /** A method exposed to client to calculate permutation of String in Java. */

    public static void permutation(String input) {
        try {
            permutation( "", input);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     Recursive method which actually prints all permutations
     * of given String, but since we are passing an empty String
     * as current permutation to start with,
     * I have made this method private and didn't exposed it to client.
     */

    private static void permutation(String perm, String word) throws InterruptedException {

       //
        if (word.isEmpty()) {
            /* String s = perm+word;
           String reverse = "";
            for(int i = s. length() - 1; i >= 0; i--) {
                reverse = reverse + s.charAt(i);
            }

            if(s.equals(reverse)) {
                System.out.println(s + " is palindrome");
            }*/
            System.out.println(perm);

        } else {
            for (int i = 0;i < word.length();i++){
                permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1,word.length()));

            }

        }
    }
}


