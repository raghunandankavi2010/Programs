package programs.strings;

public class RomanNumeralsToInteger {

    public static void main(String[] args) {
        String s = "XIV";
        RomanNumeralsToInteger romanNumeralsToInteger = new RomanNumeralsToInteger();
        int value = romanNumeralsToInteger.getInteger(s);
        System.out.println(value);

        // Number to Roman Numerals
        // credit https://leetcode.com/problems/integer-to-roman/discuss/775440/Java-Neat-and-clean-solution
        // based on https://www.youtube.com/watch?v=Gw-GNey94j8
        int inputValue = 17;
        String roman = romanNumeralsToInteger.intToRoman(inputValue);
        System.out.println(roman);

    }

    private int getInteger(String s){
        char[] arr = s.toCharArray();
        int res = 0;
        for(int i = 0;i < arr.length;i++){
            int value1 = getValue(arr[i]);
            if(i+1 < arr.length){
                int value2 = getValue(arr[i+1]);
                // if values are equal add to result
                if( value1 >= value2){
                    res = res + value1;
                }else {
                    res = res + value2 - value1;
                    // in case values are not equal increment index i
                    i++;
                }
            } else {
                // just one value
                res = res + value1;
                i++;
            }
        }
        return res;
    }

    private static int getValue(Character ch){

        if (ch == 'I')
            return 1;
        if (ch == 'V')
            return 5;
        if (ch == 'X')
            return 10;
        if (ch == 'L')
            return 50;
        if (ch == 'C')
            return 100;
        if (ch == 'D')
            return 500;
        if (ch == 'M')
            return 1000;

        return -1;
    }

    //////

    final static String[] ONES = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
    final static String[] TENS = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    final static String[] HUNDREDS = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    final static String[] THOUSANDS = {"","M","MM","MMM"};

    public String intToRoman(int num) {
        int place = 1;
        StringBuilder ans= new StringBuilder();
        while(num>0){
            int rem = num % 10;
            rem *= place;
            ans.insert(0, helper(rem));
            place*= 10;
            num = num / 10;
        }
        return ans.toString();
    }

    String helper(int num){
        if(num < 10) return ONES[num];
        else if(num<100) return TENS[num/10];
        else if(num<1000) return HUNDREDS[num/100];
        else return THOUSANDS[num/1000];
    }
}
