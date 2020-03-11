package programs.strings;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/submissions/
 */
public class ReverseWordsInString {

    public static void main(String[] args) {
        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        String s = " Hello World! ";
        reverseWordsInString.reverse(s);
        // philips test.
        String s2 = "I am working at manyata ";
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
