package programs.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestAndLargestElementInArray {

    public static void main(String[] args) {
        int[] arr= {2,3,15,1,0,23,21};
        int k=2;
        int kthSmallestElement = findKthSmallestElement(arr,k);
        int kthLargestElement = findKthLargestElement(arr,k);
        System.out.println(String.format("Smallest %d element is %d",k,kthSmallestElement));
        System.out.println(String.format("Largest %d element is %d",k,kthLargestElement));
    }

    private static int findKthSmallestElement(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<k;i++){
            pq.add(arr[i]); // 3 2
        }
        // from 1 to 21
        // arr[i] now is 1
        // remove from queue ie 15
        // 3 2
        // remove 3 from queue
        // 2 1 0
        for(int i=k;i<arr.length;i++){
            if(arr[i]<pq.peek()){
                pq.poll(); // remove from queue
                pq.add(arr[i]);
            }
        }
        return pq.peek(); // return 2
    }

    private static int findKthLargestElement(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(arr[i]); //2 3
        }
        // from 1 to 21
        // arr[i] now is 1
        // 1 > 2 skip
        // 0 > 2 skip
        // 3 > 23 true
        // remove 2 and add 23
        // 3 15 23
        // 21 > 3
        // remove 3 and add 21
        // 15 23 21
        // return 15
        for(int i=k;i<arr.length;i++){
            if(arr[i]>pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }
}
