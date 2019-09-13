package programs.arrays;

public class ArrayfindPairsSum {


    public static void main(String args[]) {
        int[] arr = {11, 11, 11, 12, 55};
        int sum = 23;
        getPairsCount(arr, sum);
    }

    // Prints number of pairs in arr[0..n-1] with sum equal
    // to 'sum'
    public static void getPairsCount(int[] arr, int sum) {

        //int count = 0;// Initialize result

        // Consider all possible pairs and check their sums
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if ((arr[i] + arr[j]) == sum) {

                    System.out.println("pairs"+arr[i] +" " +arr[j]);
                   // count++;
                }

        //System.out.printf("Count of pairs is %d", count);
    }

}
