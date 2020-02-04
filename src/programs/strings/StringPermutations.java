package programs.strings;

/**
 * Created by raghu on 3/7/17.
 */
public class StringPermutations {

    public static void main(String[] args) {
        String input = "abab";
        permutation(input);
        printPermutationsIterative(input);
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

    // To print permutation iteratively
    // find the factorial at each position
    // cause if ou have 3 chars 3! is 6
    // you will have 6 combinations.
    // then loop through factorial array length
    // temp = "abab"
    // pc = 0
    // loop from factorial length to 0
    // selectedpos = pc / factorial[i-1] = 0/ factorial[3] = 0/6 = 0
    // onepermutation = onepermutaiton + temp.chartAt(selectedPos) = ""+a = a
    // pc = pc % factorial[i-1] = 0 % 6 = 0
    // temp needs to be updated. so now temp is bab
    // so first iteration prints abab
    // second iteration pc =1
    // sp = 1/6 = 0
    // op = ""+a
    // pc = 1 % 6 = 1
    // pc =1
    // sp = 1/ 2 = 0
    // op = a+b = ab
    // pc = 1 % 2 = 1
    // temp = ab
    // sp = 1 / 1 = 1
    // op = ab+b = abb
    // pc = 1 % 1 = 0
    // temp = b
    // next iteration you will have abba with pc = 0 and so on..
    private static void printPermutationsIterative(String string){
        int [] factorials = new int[string.length()+1];
        factorials[0] = 1;
        for (int i = 1; i<=string.length();i++) {
            factorials[i] = factorials[i-1] * i;
        }

        for (int i = 0; i < factorials[string.length()]; i++) {
            String onePermutation="";
            String temp = string;
            int positionCode = i;
            for (int position = string.length(); position > 0 ;position--){
                int selected = positionCode / factorials[position-1];
                onePermutation += temp.charAt(selected);
                positionCode = positionCode % factorials[position-1];
                temp = temp.substring(0,selected) + temp.substring(selected+1);
            }
            System.out.println(onePermutation);
        }
    }
}


