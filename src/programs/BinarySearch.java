package programs;

/**
 *  Search in sorted array binary search
 *  o(logn)
 */

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 2;
        BinarySearch binarySearch = new BinarySearch();
        int low = 0;
        int high = arr.length - 1;
        int searchIndex = binarySearch.binarySearch(arr, key, low, high);
        if (searchIndex != -1)
            System.out.println("Number :" + arr[searchIndex] +" found at index "+ searchIndex);
        else
            System.out.println("Element not found");
    }

    private int binarySearch(int[] arr, int key, int low, int high) {

        if (low > high)
            return -1;
        if (low == high && arr[low] == key)
            return low;
        int mid = (low + high) / 2;

        if (arr[mid] == key)
            return mid;
        if (arr[mid] < key)
            return binarySearch(arr, key, mid + 1, high);
        else if (arr[mid] > key)
            return binarySearch(arr, key, low, mid-1);
        else
            return -1;

    }
}
