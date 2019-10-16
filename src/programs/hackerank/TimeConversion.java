package programs.hackerank;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        DateFormat df = new SimpleDateFormat("hh:mm:ssaa");
        //Desired format: 24 hour format: Change the pattern as per the need
        DateFormat outputformat = new SimpleDateFormat("HH:mm:ss");
        Date date = null;
        String output = null;
        try {
            //Converting the input String to Date
            date = df.parse(s);
            //Changing the format of date and storing it in String
            output = outputformat.format(date);
            //Displaying the date

        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return output;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scan.nextLine();

        String result = timeConversion(s);
        System.out.println(result);

    }
}
