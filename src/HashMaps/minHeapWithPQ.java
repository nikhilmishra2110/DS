package HashMaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class minHeapWithPQ {
    public static void main(String[] args) {
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(); //min heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //max heap
        maxHeap.add(119);
        maxHeap.add(1);
        maxHeap.add(69);
        maxHeap.add(89);
        maxHeap.add(39);
        maxHeap.add(29);
//        while (!maxHeap.isEmpty()){
//            System.out.print(maxHeap.poll() + " ");// 119 89 69 39 29 1
//        }
        int [] arr = {2,4,1,7,5,9,10};
        int k = 3;
        mergeKSortedArray(arr, k);
    }

    public static void mergeKSortedArray(int [] arr, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for(int i = 0; i < k + 1; i ++){
            maxHeap.add(arr[i]);
        }
        for(int i = k + 1; i < arr.length; i++){
            maxHeap.add(arr[i]);
            if(maxHeap.size()>k){
                System.out.println(maxHeap.poll());
            }
        }
        while(!maxHeap.isEmpty()){
            System.out.println(maxHeap.poll());
        }

    }

}
