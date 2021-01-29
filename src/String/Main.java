package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int [] arr= {4,5,1,8,2};
        int [] intArr = new int[5];
        boolean [] boolArr = new boolean[5];
//        for(int i=0; i< intArr.length;i++){
//            System.out.println(boolArr[i]);
//        }

//        productOfArrayExceptSelf(arr);
//        System.out.println("Number of ways to decode ==>"+numDecodings("121121321"));
        int[][] arr2 = new int [][]{{1,3},{2,6},{8,10},{15,18}};
//        int[][] arr4  = merge(arr2);
//        for(int []list:arr4){
//            for(int i:list){
//                System.out.print(i+" " );
//            }
//        }

        String orders = "lmnopqrstuvwxyzabcdefghijk";
//        System.out.println(orders.toCharArray());
        int []  map = new int [26];
//        for(int i=0; i < orders.length();i++){
////            System.out.println(orders.charAt(i));
//            map[orders.charAt(i) - 'a'] = i;
//        }

        String nums = "0123456789";
//        System.out.println((int) nums.charAt(7)-'0');


//        for(int i=0; i < orders.length();i++){
//            System.out.print(map[i] + " ");
//        }


            int [] digits = new int[] {1,2,3};
//        public int[] plusOne(int[] digits) {
            int n = digits.length;
            for(int i = n -1; i>=0; i--){
                if(digits[i]==9){
                    digits[i]=0;
                } else{
                    digits[i]++;
                    System.out.println(Arrays.toString(digits));
                }
            }

            digits = new int[n+1];
            digits[0]=1;
        System.out.println(Arrays.toString(digits));

    }



    public static  int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();

        int[] added_interval = intervals[0];
        System.out.println("added_interval => "+added_interval);
        result.add(added_interval);
        for (int[] list : intervals) {
            if (list[0] <= added_interval[1]) // Overlapping intervals, move the end if needed
                added_interval[1] = Math.max(added_interval[1], list[1]);
            else {                             // Disjoint intervals, add the new interval to the list
                added_interval = list;
                result.add(added_interval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }



    public static void productOfArrayExceptSelf(int[] arr){
        int[] left_arr = new int[arr.length];
        int[] right_arr = new int[arr.length];
        int[] final_arr = new int[arr.length];
        left_arr[0]=1 ;
        right_arr[arr.length-1]=1;
        for(int i=1; i < arr.length; i++){
            left_arr[i] = left_arr[i-1]*arr[i-1];
        }

        for(int i=arr.length-2; i >= 0; i--){
            right_arr[i] = right_arr[i+1]*arr[i+1];
            System.out.println(right_arr[i]);
        }

        for(int i=0; i< arr.length; i++){
            final_arr[i] = left_arr[i]*right_arr[i];
        }

    }

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            System.out.println(first);
            int second = Integer.valueOf(s.substring(i - 2, i));
            System.out.println(second);
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
            System.out.println();
        }
        return dp[n];
    }
    }



