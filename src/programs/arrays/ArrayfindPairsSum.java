package programs.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class ArrayfindPairsSum {


    public static void main(String[] args) {
        int[] arr = {11, 11, 11, 12, 55};
        //int sum = 23;
        //getPairsCount(arr, sum);
        int[] arrUnsorted = { 10,1,1};
        int total = 11;

        //findPairsEqualToSum(arrUnsorted,total);
       findPairsEqualToSumHashMap(arrUnsorted, total);
    }

    // Prints number of pairs in arr[0..n-1] with sum equal
    // to 'sum'
    private static void getPairsCount(int[] arr, int sum) {

        //int count = 0;// Initialize result

        // Consider all possible pairs and check their sums
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if ((arr[i] + arr[j]) == sum) {

                    System.out.println("pairs" + arr[i] + " " + arr[j]);
                    // count++;
                }

        //System.out.printf("Count of pairs is %d", count);
    }

    // Method Two
    // 1. sort the array
    // 2. have two pointers pointing to start and end of array
    // 3. increment start if arr[start]+arr[end] is less than sum
    // 4. decrement end if arr[start]+arr[end] is greater than sum
    // 5. if equal print pair and increment start and decrement end
    // 6. repeat above until start<end
    private static void findPairsEqualToSum(int[] arr, int sum) {
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] + arr[end] > sum) {
                end--;
            } else if (arr[start] + arr[end] < sum) {
                start++;
            } else if (arr[start] + arr[end] == sum) {
                System.out.println("pairs : " + arr[start] + " " + arr[end] + " Sum is: " + (arr[start] + arr[end]));
                start++;
                end--;
            }
        }
    }

    private static void findPairsEqualToSumHashMap(int[] arr, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length - 1; i++) {
                map.put(arr[i], arr[i]);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            // number + x = sum
            // sum - number = x
            // check if map contains that number
            // check if that number and arr[i] total to sum given
            // print the value in map and arr[i]
           if(map.containsKey(sum - arr[i])) {
               int x =  map.get(sum - arr[i]);
               if (x+arr[i] == sum) {
                   System.out.println("Pairs :" + x + " " + arr[i]);
               }
           }
        }
    }
}
