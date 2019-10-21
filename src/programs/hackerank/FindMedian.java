package programs.hackerank;

import java.util.Arrays;
import java.util.Scanner;

public class FindMedian {

    private static double findMedian(int[] arr) {
        Arrays.sort(arr);
        for (int number : arr) {
            System.out.print("" + number + " ");
        }
        int n = arr.length;
        double median;
        if (n % 2 == 0) {
            median = (double)(arr[(n-1)/2] + arr[n/2])/2.0;
        } else {
            median =  arr[n / 2];
        }

        return median;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        double result = findMedian(arr);
        double avg  = findAvg(arr);
        System.out.println("Median is :" + result);
        System.out.println("Avg is :" + avg);
        scanner.close();
    }

    private static double findAvg(int[] arr) {
        double sum=0;
        int n = arr.length;
        for (int number : arr) {
            sum += number;
        }
        return sum/n;
    }
}
