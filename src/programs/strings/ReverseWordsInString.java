package programs.strings;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/submissions/
 */
public class ReverseWordsInString {

    public static void main(String[] args) {
        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        String s = " Hello World! ";
        reverseWordsInString.reverse(s);
        // philips test.
        String s2 = "I am working at Manyata";
        reverseWordsInString.reverseWords(s2);


    }

    private void reverseWords(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            // if it is not space then swap char at i and j
            // increment i and decrement j
            if (arr[i] != ' ' && arr[j]!= ' ') {
                arr[i] ^= arr[j];
                arr[j] ^= arr[i];
                arr[i] ^= arr[j];
                i++;
                j--;
            } else if(arr[i]==' ') { // space just increment i
                i++;
            } else if(arr[j]==' ') { // space just decrement j
                j--;
            }
        }
        System.out.println(String.valueOf(arr));

    }

    private String reverseWordsInString(String input) {
        char[] s = input.toCharArray();
        int start = 0;
        for (int end = 0; end < s.length; end++) {
            if(s[end] == ' ') {
                reverse(s,start, end);
                start= end  + 1;
            }
        }

        reverse(s, start, s.length - 1);

        reverse(s, 0, s.length - 1);

        return Arrays.toString(s);

    }

    private void reverse(char[] str, int start, int end) {
        // Temporary variable
        // to store character
        char temp;

        while (start <= end) {
            // Swapping the first
            // and last character
            temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }

    private void reverse(String s) {
        s = s.replaceAll("\\s+", " ").trim();
        String[] strgs = s.split("\\s");
        int n = strgs.length - 1;
        StringBuilder sb = new StringBuilder();
        int i = n;
        while (i >= 0) {
            if (i == 0) {
                sb.append(strgs[i]);
            } else {
                sb.append(strgs[i]).append(" ");
            }
            i--;
        }
        System.out.println("Reversed String : " + sb.toString());
    }

}
