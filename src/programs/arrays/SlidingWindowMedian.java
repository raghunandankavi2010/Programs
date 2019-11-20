package programs.arrays;


public class SlidingWindowMedian {
    public static void main(String[] args) {
        int[] arr ={1,3,-1,-3,5,3,6,7};
        int k = 3;
        double[] output =calculateMedian(arr,k);
        for(double num:output){
            System.out.print(num+" ");
        }

    }

    private static double[] calculateMedian(int[] arr, int k) {

        double[] output = new double[arr.length - k + 1];
        int startIndex = 0;
        int endIndex = k-1;
        int index =0;
        while(endIndex<arr.length){
            output[index]=calculateMedianWindow(arr,startIndex,endIndex,k);
            startIndex++;
            endIndex++;
            index++;
        }
        return output;
    }


    private static double calculateMedianWindow(int[] arr,int startIndex, int endIndex,int k) {
       int[] numbers = new int[k];
       int i = startIndex;
       int index = 0;
        while(i<=endIndex){
            numbers[index]= arr[i];
            i++;
            index++;
        }
        double median =0;
        quicksort(0,k-1,numbers);
       if(k%2==0){
            double val = add(numbers[(numbers.length - 1) / 2] , numbers[numbers.length / 2])/2.0;
            if(val>=Integer.MAX_VALUE){
                median = Integer.MAX_VALUE;
            }else if( val <= Integer.MIN_VALUE){
                median = Integer.MIN_VALUE;
            }else {
                median = val;
            }
        }else{
            double val = ((double)numbers[numbers.length / 2]);
            if(val>=Integer.MAX_VALUE){
                median = Integer.MAX_VALUE;
            }else if( val <= Integer.MIN_VALUE){
                median = Integer.MIN_VALUE;
            }else {
                median = val;
            }
        }
        return median;
    }

    private static void quicksort(int low, int high,int[] numbers) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j,numbers);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            // sort left part of array
            quicksort(low, j,numbers);
        if (i < high)
            // sort right part of array
            quicksort(i, high,numbers);
    }
    private static void exchange(int i, int j,int[] numbers) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private static double  add(int a, int b) {
        return ((double) a) + (double)b;
    }
}

