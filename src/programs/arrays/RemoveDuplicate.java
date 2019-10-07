package programs.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * This is from geeks for geeks
 */

public class RemoveDuplicate
{
    // Function to remove duplicate elements
    // This function returns new size of modified
    // array.

    private static int removeDuplicates(int[] arr, int n)
    {
        // Return, if array is empty
        // or contains a single element
        if (n==0 || n==1)
            return n;

        int[] temp = new int[n];

        // Start traversing elements
        int j = 0;
        for (int i=0; i<n-1; i++) {
            // If current element is not equal
            // to next element then store that
            // current element
            if (arr[i] != arr[i + 1])
                temp[j++] = arr[i];
        }

        // Store the last element as whether
        // it is unique or repeated, it hasn't
        // stored previously
        temp[j++] = arr[n-1];

        // Modify original array
        if (j >= 0) System.arraycopy(temp, 0, arr, 0, j);

        return j;
    }

    public static void main (String[] args) {
        /*
         * unsorted array find duplicates
         */

        int[] array = {0,4, 2, 4, 5, 2, 3, 1};
        int arr_size = array.length;
        printRepeating(array, arr_size);
        findRepeat(array);

        /*
         * below array is sorted
         */

        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int n = arr.length;

        n = removeDuplicates(arr, n);

        // Print updated array
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
    }



       private static  void printRepeating(int[] arr, int size)
        {
            int[] count = new int[size];
            int i;

            /*
               4 (count 1),2 (count 1), 4 (count already 1 so dup), 5 (count 1) , 2 (count already 1 so dup), 3 (count 1) , 1 (count 1)
               count[0] = 0, count[2] = 1, count[3] = 1 ,count[4] = 1, count[5] = 1, count[6] = 0
             */
            System.out.println("Repeated elements are : ");
            for (i = 0; i < size; i++) {
                if (count[arr[i]] == 1) {
                    System.out.println("Repeated " + arr[i]);
                }
                else {
                    count[arr[i]] = count[arr[i]] + 1;
                }

            }
            // for logging purpose. Not required
            for (i = 0; i < size; i++) {
                    System.out.println("Number :"+arr[i] +" Count at pos " + count[i]);

            }
        }

    // find duplicates using HashSet.
    private static int findRepeat(int[] numbers) {
        Set<Integer> numbersSeen = new HashSet<>();
        for (int number : numbers) {
            if (numbersSeen.contains(number)) {
                return number;
            } else {
                numbersSeen.add(number);
            }
        }

        // whoops--no duplicate
        throw new IllegalArgumentException("no duplicate!");
    }
}