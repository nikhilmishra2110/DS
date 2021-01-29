package Heaps;

import java.util.*;

class Pair {
    Integer key;
    Integer value;

    //Constructor
    public Pair(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}

public class pqPractice {
    public static void main(String[] args) {
        int[] arr = {1, 9, 6, 3, 11, 65, 43, 32};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

//       while(!pq.isEmpty()){
//           System.out.println(pq.poll());
//       }

//        kthSmallest(arr, 3);
//        kthLargest(arr, 3);
        int[] arr1 = {1, 3, 2, 4, 5, 7, 6, 9, 8};
//       mergeKSortedLists(arr1, 3);


        int[] arr3 = {-10, -50, 20, 17, 80};
        int[] arr4 = {1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        int x = 20, k = 2;
        int n = arr3.length;
//        printKclosest(arr3, n, x, k);
//        topKFrequent(arr4, 3);

        int [] arr5 = {1,2,2,3,3,3,4,4,4,5,5,5,5,5};
//        frequencySort(arr5);


        int [][] points = {{1,3},{-2,2}};
        int K = 1;
        int [][]res;
//        res  = kClosest(points,k);

        int [] sticks = {2,4,3};
        System.out.println(connectSticks(sticks));

    }




    public static void kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            maxheap.add(arr[i]);
            if (maxheap.size() > k) {
                System.out.println("Removing : " + maxheap.peek());
                maxheap.poll();
            }
        }

        System.out.println("Smallest " + k + " elements are =>>");
        while (!maxheap.isEmpty()) {
            System.out.println(maxheap.poll());

        }
    }


    public static void kthLargest(int[] arr, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            minheap.add(arr[i]);
            if (minheap.size() > k) {
                minheap.poll();
            }
        }
        while (!minheap.isEmpty()) {
            System.out.println(minheap.poll());
        }
    }


    public static void mergeKSortedLists(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k + 1; i++) {
            minHeap.add(arr[i]);
        }

        for (int i = k + 1; i < arr.length; i++) {
            minHeap.add(arr[i]);
            if (minHeap.size() > k) {
                System.out.println(minHeap.poll());
            }
        }
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
    }


    public static void printKclosest(int[] arr, int n, int x, int k) {
        // Make a max heap.
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                new Comparator<Pair>() {
                    public int compare(Pair p1, Pair p2) {
                        return p2.getKey().compareTo(//can also make a comparision on value
                                p1.getKey());
                    }
                });

        for (int i = 0; i < n; i++) {
            pq.add(new Pair(Math.abs(arr[i] - x), arr[i]));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            System.out.print(pq.poll().getValue() + " ");
        }
    }


    public static void topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return;
        }
        Map<Integer, Integer> hm = new HashMap();
        for (int n : nums) {
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> hm.get(n1) - hm.get(n2));

        for (int n : hm.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
    }



    public static void frequencySort(int[] nums) {
        Map<Integer, Integer> hm = new HashMap();
        for (int n : nums) {
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Pair> heap = new PriorityQueue<>(
                new Comparator<Pair>() {
                    public int compare(Pair p1, Pair p2) {
                        return p2.getKey().compareTo(//can also make a comparision on value
                                p1.getKey());
                    }
                });

        for (int n : hm.keySet()) {
            heap.add(new Pair(hm.get(n),n));
        }

        while(heap.size()>0){
            int freq = heap.peek().key;
            int elem = heap.peek().value;
            for(int i = 0; i < freq; i++){
                System.out.println(elem);
            }
            heap.poll();
        }

    }


    public static  int[][] kClosest(int[][] points, int K) {
        if(K == points.length) return points;

        PriorityQueue<int[]> pq = new PriorityQueue<>(K, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]);
            }
        });

        for(int[] point: points) {
            pq.add(point);
            if(pq.size() > K) {
                pq.poll();
            }
        }
        return pq.toArray(new int[0][0]);
    }



    public static int connectSticks(int[] sticks) {
            int totalCost = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            // add all sticks to the min heap.
            for (int stick : sticks) {
                pq.add(stick);
            }

            // combine two of the smallest sticks until we are left with just one.
            while (pq.size() > 1) {
                int stick1 = pq.remove();
                int stick2 = pq.remove();

                int cost = stick1 + stick2;
                totalCost += cost;

                pq.add(stick1 + stick2);
            }

            return totalCost;
        }

}
