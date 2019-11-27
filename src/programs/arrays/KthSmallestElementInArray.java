package programs.arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInArray {

    public static void main(String[] args) {
        int[] arr= {2,3,15,1,0,23,21};
        int k=3;
        int kthSmallestElement = findKthSmallestElement(arr,k);
        System.out.println(String.format("Smallest %d element is %d",k,kthSmallestElement));
    }

    private static int findKthSmallestElement(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<k;i++){
            pq.add(arr[i]); //15 2 3
        }
        // from 1 to 21
        // arr[i] now is 1
        // remove from queue ie 15
        // 3 2 1
        // remove 3 from queue
        // 2 1 0
        for(int i=k;i<arr.length;i++){
            if(arr[i]<pq.peek()){
                pq.poll(); // remove fr
                pq.add(arr[i]);
            }
        }
        return pq.peek(); // return 2
    }
}
