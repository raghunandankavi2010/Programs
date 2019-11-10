package programs.strings;

/**
 * Source : https://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
 */
public class LongestPalinSubstring {

    private static String subStr(String str, int low, int high) {
        return str.substring(low, high + 1);
    }

    private static String longestPalSubstr(String str) {
        int maxLength = 1;


        int start = 0;
        int len = str.length();
        // check if length of string is less than opr equal to 1
        if(len<=1){
            return str;
        }

        int low, high;

        for (int i = 1; i < len; ++i) {
            // Find the longest even length palindrome with
            // center points as i-1 and i for even length
            low = i - 1;
            high = i;
            while (low >= 0 && high < len
                    && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }

            // Find the longest odd length palindrome with
            // center point as i for odd length
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len
                    && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
        }

        return subStr(str, start, start + maxLength - 1);

    }

    public static void main(String[] args) {

        String str = "fmadam";
        System.out.println("Paldindrome Substring: " + longestPalSubstr(str));
    }
}