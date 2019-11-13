package programs.arrays;

/**
 * Given a sorted array of distinct integers, Find the Magic index or Fixed point in the array.
 *
 * Magic Index or Fixed Point: Magic index or a Fixed point in an array is an index i in the array such that A[i] = i.
 */
public class MagicIndex {

    public static void main(String[] args){
        int[] arr = { -1, 0, 1, 2, 4, 10 };
        int magicIndex = searchIndex(arr,0,arr.length-1);
        System.out.println(String.format("Magic Index is %d",magicIndex));
    }

    // this works if array is sorted and elements are unique
    private static int searchIndex(int[] arr, int low, int high) {
        int mid = (low+high)/2;
        if(arr[mid] == mid){
            return mid;
        }
        if(arr[mid]<mid){
            return searchIndex(arr,mid+1,high);
        }else{
            return searchIndex(arr,low,mid-1);
        }
    }
}
