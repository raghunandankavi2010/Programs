package programs.strings;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/submissions/
 */
public class ReverseWordsInString {

    public static void main(String[] args) {
        String s = " Hello World! ";
        reverse(s);
    }

    private static void reverse(String s) {
        s = s.replaceAll("\\s+", " ").trim();
        String[] strgs = s.split("\\s");
        int n = strgs.length - 1;
        StringBuilder sb = new StringBuilder();
        int i = n;
        while (i >= 0) {
            if(i==0){
                sb.append(strgs[i]);
            }else {
                sb.append(strgs[i]).append(" ");
            }
            i--;
        }
        System.out.println("Reversed String : " + sb.toString());
    }
}
