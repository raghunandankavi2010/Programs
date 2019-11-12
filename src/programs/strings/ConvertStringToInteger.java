package programs.strings;

/**
 * Implement atoi which converts a string to an integer.
 *
 *  The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 *
 *  The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 *
 *  If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 *  If no valid conversion could be performed, a zero value is returned.
 *
 *  Note:
 *
 *  Only the space character ' ' is considered as whitespace character.
 *  Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 *  Example 1:
 *
 *  Input: "42"
 *  Output: 42
 *  Example 2:
 *
 *  Input: "   -42"
 *  Output: -42
 *  Explanation: The first non-whitespace character is '-', which is the minus sign.
 *  Then take as many numerical digits as possible, which gets 42.
 *  Example 3:
 *
 *  Input: "4193 with words"
 *  Output: 4193
 *  Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 *  Example 4:
 *
 *  Input: "words and 987"
 *  Output: 0
 *  Explanation: The first non-whitespace character is 'w', which is not a numerical
 *  digit or a +/- sign. Therefore no valid conversion could be performed.
 *  Example 5:
 *
 *  Input: "-91283472332"
 *  Output: -2147483648
 *  Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 *  Thefore INT_MIN (−231) is returned.
 */
public class ConvertStringToInteger {

    public static void main(String[] args) {
        String input = "  -0012a42".trim();
        String output = "";
        boolean flag = false;
        boolean added = false;
        char[] value;
        System.out.print(String.format("Given %s converted to integer : ",input));
        if(input.length()>0){
            value = input.toCharArray();
            for(int i=0;i<value.length;i++){
                char val = value[i];
                // add + or - only once if it is first char in input string
                if((value[0]=='-'||value[0]=='+') && !added){
                    output = output+val;
                    added = true;
                }
                // check if there is a invalid char
                else if(isLetter(val)||val==' '||val=='.'||val=='+'||val=='-'||val=='@'||val=='*'||val=='/'){
                    break;
                }else if(val=='0' && !flag){ // just skip 0's at the beginning
                    output = output+"";
                }else  { // just add the input chars to output;
                    output = output+val;
                    flag = true;
                }
            }
            // if length of output after processing is 0 return 0
            // else if input length is less than 11(including + or -) or 10 parse the string to int
            // check for overflow conditions and return appropriate values.
            if(output.length()>0 && value[0]=='-' && output.length()<11){
                System.out.println(parseIntWithOverflow(output));
            }else if(output.length()>0 &&value[0]!='-' && output.length()<10){
                System.out.println(parseIntWithOverflow(output));
            }else if(output.length()>0 && value[0]=='-' && output.length()>=11){
                int val =parseIntWithOverflow(output);
                if(val!=0){
                    System.out.println(val);
                }else {
                    System.out.println((int)Math.pow(-2,31));
                }
            }else if(output.length()>0 && value[0]!='-'&& output.length()>=10){
                int val = parseIntWithOverflow(output);
                if(val!=0){
                    System.out.println(val);
                }else {
                    int num = (int)Math.pow(2,31);
                    System.out.println(num);
                }

            }else{
                System.out.println(0);
            }
        }else{
            System.out.println(0);
        }

    }

    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z');
    }

    private static int parseIntWithOverflow(String s) {
        int result;
        try {
            result = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            result = 0;
        }
        return result;
    }
}