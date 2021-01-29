package SlidingWindow;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int arr[] = {1, 22, 23, 24, 53, 56, 7, 8, 9, 103};
        int k = 3;
        int n = arr.length;
//        bruteFroceSlidingWindowMaxSum(arr, k);
//        slidingWindowMaxSum(arr, k);

        int [] arr1 = {1,2,-3,4,5,6,7,9,10};
//        printFirstNegativeInteger(arr1, k);
//        firstNegetiveNumberinWindow(arr1,k);
        System.out.println(lengthOfLongestSubstring("pwwkew"));


    }

    public static void bruteFroceSlidingWindowMaxSum(int[] A, int k) {
        int maxSum = 0;
        for (int i = 0; i <= A.length - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += A[j];
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        System.out.println("Max Sum is " + maxSum);
    }


    public static void slidingWindowMaxSum(int[] A, int k) {
        int size = A.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        int maxSum = 0;
        while (j < size) { // kaha tak leke jana hai j ko
            sum += A[j]; // aage se add karo peche se delete neeche kiya gaya hai
            if (j - i + 1 < k) { // window size attain karo k desired lenght ki
                j++;
            } else if (j - i + 1 == k) { // window size desired length ki aa gai
                maxSum = Math.max(maxSum, sum); // calculations karo yaha
                        sum -= A[i]; //peche se delete karo
                i++; // window size maintain kanra hai desired size ki
                j++; // window size maintain kanra hai desired size ki
            }
        }
        System.out.println("Max Sum is " + maxSum);
    }


    public static void printFirstNegativeInteger(int [] A, int k){
        boolean isNegetiveFlag;
        int n = A.length;
        for(int i = 0; i< n-k+1; i++){
            isNegetiveFlag = false;
            for(int j = 0; j< k; j++){
                if( A[i+j] < 0){
                    System.out.println(A[i+j]);
                    isNegetiveFlag = true;
                    break;
                }
            }
            if(!isNegetiveFlag){
                System.out.println("0"+ " ");
            }
        }
    }

    public static void firstNegetiveNumberinWindow(int[] A, int k) {
        int size = A.length;
        int i = 0;
        int j = 0;
//        ArrayList<Integer> list = new ArrayList<Integer>();
        LinkedList<Integer> list = new LinkedList<>();
        while (j < size) { // kaha tak leke jana hai j ko
            if(A[j]< 0){// calculation
                list.add(A[j]); // calculations kar lo bad me kaam ayga ye
            }
            if (j - i + 1 < k) { // window size attain karo k desired lenght ki
                j++;
            } else if (j - i + 1 == k) { // window size desired length ki aa gai
                if(list.isEmpty()){
                    System.out.println("0"+ "__");
                } else{
                    System.out.println(list.getFirst());
                    if(A[i] == list.getFirst()){
                        list.remove();
                    }
                }; // is window ka answer yaha calculate karo
                i++; // window size maintain kanra hai desired size ki
                j++; // window size maintain kanra hai desired size ki
            }
        }

    }



    public static int lengthOfLongestSubstring(String s){
        /*The idea is use a hash set to track the longest substring
        without repeating characters so far, use a fast pointer j
        to see if character j is in the hash set or not,
        if not, great, add it to the hash set,
        move j forward and update the max length,
         otherwise, delete from the head by using a slow pointer
         i until we can put character j to the hash set.
         */
        int size = s.length();
        int i=0;
        int j=0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while(j< size){
            if(!set.contains((s.charAt(j)))){
                set.add(s.charAt(j));
                max = Math.max(max, set.size());
                j++;
            } else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }



}
