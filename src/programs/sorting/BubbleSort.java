package programs.sorting;

public class BubbleSort {

    public static void main(String[] args){
        int[] arr= {5,3,1,2,12,24};
        int[] sortedArray = sort(arr);
        for(int number: sortedArray){
            System.out.println(number);
        }
    }

    private static int[] sort(int[] arr){
        int n = arr.length-1;
        // to check if array is already sorted
        boolean swap = false;
        for(int i=0;i<=n;i++){
            for(int j= i+1;j<= n-(i+1);j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    swap = true;
                }
            }
            // check if no element bubble to the last position
            // this means that array is already sorted.
            // so no need fo further iteration return arr;
            if(!swap){
                return arr;
            }
        }
        return arr;
    }
}
