package programs.search;

public class MissingElementSearch {

    public static void main(String[] args) {
        int[] arr = {1,3,4,5};
        int x = findMissingElement(arr);
        System.out.println(x);
    }

    static int findMissingElement(int[] arr){
        int low = 0;
        int high = arr.length-1;

        while(low<=high){
            int middle = (low+high)/2;
            // this is the most important condition which i missed
            if(arr[middle]!= middle+1 && arr[middle-1]==middle){
                return middle+1;
            }
            // this is straight forward. if arr[mid] != middle+1 move left or move right
            if(arr[middle]!= middle+1){
                high = middle-1;
            } else {
                low = middle+1;

            }
        }
        return -1;
    }
}
