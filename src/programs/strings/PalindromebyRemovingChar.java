package programs.strings;

public class PalindromebyRemovingChar {

    public static void main(String[] args) {
        String str = "aaa";
        int index = possiblePalinByRemovingOneChar(str);
        System.out.println(index);
    }

    private static int possiblePalinByRemovingOneChar(String str) {
            int low = 0, high = str.length()-1;
            while(low<high){
                if(str.charAt(low)==str.charAt(high)){
                    low++;
                    high--;
                }else{
                    // check if removing the left char forms a palindrome
                    if (isPalindrome((low+1), high,str))
                        return low;

                    // check if removing the right char forms a palindrome
                    if (isPalindrome(low,high-1,str))
                        return high;

                }
            }
            return -1;
    }

    private static boolean isPalindrome(int low, int high,String str) {
        boolean check = false;
        while (low < high) {
            if(str.charAt(low)==str.charAt(high)) {
                low++;
                high--;
                check = true;
            }else{
              return  false;
            }
        }
        return check;
    }
}
