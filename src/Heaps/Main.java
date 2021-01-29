package Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    public static class Pair implements Comparable<Pair>{
        int li; // kis list ke ho
        int di; // tumhare index kya hai
        int val;// tumhare value kya hai
        Pair(int li, int di, int val) {
            this.di = di;
            this.val = val;
            this.li = li;
        }

        public int compareTo(Pair o){
            return this.val - o.val;
        }
    }


    public static void main(String[] args) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] ranks = {2, 11, 3, 99, 88, 4, 1};
//        for (int val : ranks) {
//            pq.add(val);
//        }
//
//        while(pq.size()>0){
//            System.out.println(pq.peek());
//            pq.remove();
//        }
        kLargestElements(ranks, 3);
        int[] ksorted = {2, 3, 1, 4, 6, 7, 5, 8, 9};
        kSortedArray(ksorted, 2);
    }

    public static void kLargestElements(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                pq.add(arr[i]);
            } else {
                if (arr[i] > pq.peek()) {
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }
        while (pq.size() != 0) {
            System.out.println(pq.remove());
        }
    }


    public static void kSortedArray(int[] arr, int k) {
        /*//TAP:
        k tak bharo
        k+1 se loop chalao
        */
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i <=k; i++){
            pq.add(arr[i]);
        }
        for(int i = k+1; i< arr.length; i++){
            System.out.println(pq.remove());
            pq.add(arr[i]);
        }
        while(pq.size()!=0){
            System.out.println(pq.remove());
        }
    }

    public static void mergeKSortedArrays(ArrayList<ArrayList<Integer>> lists){
        int [] arr1 = {10,20,30,40};
        int [] arr2 = {5,7,9,11,19,55,57};
        int [] arr3 = {1,2,3};
        int [] arr4 = {32,39};
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0; i < lists.size(); i++){
            Pair p = new Pair(i, 0, lists.get(i).get(0));// lith list ka zero th banda
            pq.add(p);
        }

        while(pq.size() >0){
            Pair p = pq.remove();
            res.add(p.val);
            p.di++;
            if(p.di < lists.get(p.li).size()){
                p.val = lists.get(p.li).get(p.di);
                pq.add(p);
            }
        }

    }
}
