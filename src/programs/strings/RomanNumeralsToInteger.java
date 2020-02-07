package programs.strings;

public class RomanNumeralsToInteger {

    public static void main(String[] args) {
        String s = "XIV";
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
        System.out.println(res);

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
}
