package programs.strings;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        String s = "madem";
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        while(start<end) {

            chars[start] ^= chars[end];
            chars[end] ^= chars[start];
            chars[start] ^= chars[end];

            ++start;
            --end;

        }
        String result = Arrays.toString(chars);
        System.out.println(result);
        System.out.println();
        if(checkPalindrome(s)){
            System.out.println(String.format("Given String %s is a Palindrome", s));
        }else{
            System.out.println(String.format("Given String %s is not a Palindrome", s));
        }
        if(isPalindrome(s)){
            System.out.println(String.format("Given String %s is a Palindrome", s));
        }else{
            System.out.println(String.format("Given String %s is not a Palindrome", s));
        }
    }

    private static boolean isPalindrome(String s) {   // if length is 0 or 1 then String is palindrome
        if(s.length() == 0 || s.length() == 1)
            return true;
        if(s.charAt(0) == s.charAt(s.length()-1))
            /* check for first and last char of String:
             * if they are same then do the same thing for a substring
             * with first and last char removed. and carry on this
             * until you string completes or condition fails
             * Function calling itself: Recursion
             */
            return isPalindrome(s.substring(1, s.length()-1));

        return false;
    }

    // This method check if a given String is palindrome or not using recursion
    private static boolean checkPalindrome(String input) {
        if (input == null) {
            return false;
        }
        String reversed = reverse(input);
        System.out.println();
        System.out.println("Reversed String: "+reversed);
        System.out.println();
        return input.equals(reversed);
    }
    private static String reverse(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() <= 1) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }
}
