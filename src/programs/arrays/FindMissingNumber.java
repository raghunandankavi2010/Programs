package programs.arrays;

/**
 * Find the missing number in the given sequential array'
 */
public class FindMissingNumber {

    public static void main(String[] args){
        int[] arr = {1,2,4,5,6,7,8};
        int n = 9;
        int sum = getSum(n);
        // subtract sum of numbers with each number in array
        // to find missing number in the sequence.
        for( int number:arr){
            sum -= number;
        }
        System.out.println("The missing number in sequence is "+sum);
    }

    /// sum of n numbers formula : n*(n-1)/2
    private static int getSum(int n) {
        return (n*(n-1))/2;
    }
}
