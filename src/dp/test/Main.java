package dp.test;

import java.nio.charset.IllegalCharsetNameException;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        function();
    }

    public static void function()
    {
        int n = 6;
        int m = 6;
        int[][] arr = new int[][]{
                {0, 1, 4, 2, 8, 2},
                {4, 3, 6, 5, 0, 4},
                {1, 2, 4, 1, 4, 6},
                {2, 0, 7, 3, 2, 2},
                {3, 1, 5, 9, 2, 4},
                {2, 7, 0, 8, 5, 1}
        };
        int[][] dp = new int[arr.length][arr[0].length];

        for(int i = arr.length-1; i >=0; i--){
            for(int j = arr[0].length-1; j >=0; j--){
                if (i == arr.length-1 && j == arr[0].length-1){
                    dp[i][j] = arr[i][j];
                } else if (i == arr.length- 1){
                    dp[i][j] = arr[i][j] + dp[i][j+1];
                } else if (j == arr[0].length-1){
                    dp[i][j] = arr[i][j] + dp[i+1][j];
                } else{
                    dp[i][j] = arr[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}

