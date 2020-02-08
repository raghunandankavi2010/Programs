package programs.arrays;

import java.util.Arrays;

/**
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 *
 * You need to find the shortest such subarray and output its length.
 *
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending
 */
public class ShortestNonContinuousSubArray {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4};
        ShortestNonContinuousSubArray shortestNonContinuousSubArray = new ShortestNonContinuousSubArray();
        System.out.println(shortestNonContinuousSubArray.findSubArrayLength(arr,arr.length));
    }

    private int findSubArrayLength(int[] arr, int length) {
        int[] dup = Arrays.copyOf(arr,length);
        Arrays.sort(dup);
        int left = 0;
        int right = arr.length-1;
        while(left<arr.length && arr[left]==dup[left]){
            left++;
        }
        while(right>0 && arr[right]==dup[right]){
            right--;
        }

        if(right>left)
        return right - left+1;
        return 0;
    }
}
