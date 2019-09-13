package programs.strings;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        String s = "Madam";
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
    }
}
