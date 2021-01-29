package dpAdvanced;

public class Main {
    public static void main(String[] args) {
//        longestIncreasingSubsequence();
        longestIncreasingSubsequenceSum();
    }

    public static void longestIncreasingSubsequence() {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};
        int omax = 0; // overall max dp me
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {//iterate over arr
            int max = 0; //0 so i tak ka max

            // loop se max nikalo
            for (int j = 0; j < i; j++) { //0 se i ke pehle tak
                if (arr[j] <= arr[i]) { //only if this is true
                    if (dp[j] > max) {
                        max = dp[j]; //update max
                    }
                }
            }
            dp[i] = max + 1;
            if (dp[i] > omax) {
                omax = dp[i];
            }
        }
        System.out.println(omax);
    }


    public static void longestIncreasingSubsequenceSum() {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};
        int omax = Integer.MIN_VALUE;
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Integer max = null;
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i]) {
                    if (max == null || dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            if (max != null) {
                dp[i] = max + arr[i];
            } else {
                dp[i] = arr[i];
            }

            if (dp[i] > omax) {
                omax = dp[i];
            }
        }
        System.out.println(omax);
    }
}


