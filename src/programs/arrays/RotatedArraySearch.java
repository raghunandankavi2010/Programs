package programs.arrays;

/**
 * Search an element in a sorted and rotated array
 * 1. find the pivot element
 * 2. the pivot element is always greater than the right element to it.
 * 3. check if pivot index is the key return the index.
 * 4. if arr[pivot]<=key then search left part of array. low = 0, high = pivot-1
 * 5. else search right part of array, low = pivot+1, high = n-1
 * 6. the other case to handle is if array is not rotated then pivot is -1 so do normal binary search.
 * Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
 * key = 3
 * Output : Found at index 8
 */
public class RotatedArraySearch {

    public static void main(String[] args){
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int[] temp = {3,1,2};
        if(checkArrayRotation(temp)){
            System.out.println("Array is not rotated");
        } else{
            System.out.println("Array rotated right");
        }
        int n = arr.length;
        int key = 3;
        int searchedElementIndex = search(arr,n,key);
        System.out.println("Searched Element is at index: "+searchedElementIndex);
    }

    private static int search(int[] arr, int n, int key) {
        int pivot = findPivot(arr,0,n-1);

        if(pivot==-1){
            // array not rotated
           return binarySearch(arr,0,n-1,key);
        }
        if(arr[pivot]==key){
            return pivot;
        }
        if(arr[pivot]<=key){
           return binarySearch(arr,0,pivot-1,key);
        }
        return binarySearch(arr,pivot+1,n-1,key);
    }

    private static int binarySearch(int[] arr, int low, int high, int key) {
        if (high < low)
            return -1;

        /* low + (high - low)/2; */
        int mid = (low + high)/2;
        if (key == arr[mid])
            return mid;
        if (key > arr[mid])
            return binarySearch(arr, (mid + 1), high, key);
        return binarySearch(arr, low, (mid -1), key);
    }

    private static int findPivot(int[] arr,int low, int high) {
        if(low>high){
            return -1;
        }
        if(low==high){
            return low;
        }
        int mid = (low+high)/2;
        if(arr[mid]>arr[mid+1]){
            return mid;
        }else if(arr[mid]<arr[mid-1]){
            return mid-1;
        }
        if(arr[low]>=arr[mid]){
            return findPivot(arr,low,mid-1);
        }
        else {
            return findPivot(arr,mid+1,high);
        }

    }

    // just a util function to check array rotation
    private static boolean checkArrayRotation(int[] arr){
        return arr[0] < arr[arr.length - 1];
    }
}
