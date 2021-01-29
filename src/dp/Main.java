package dp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = 3;/*

        System.out.println("Enter a number ... ");
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(Fib(6));
        int fibn = FibMemoize(6, new int[6 + 1]);
        System.out.println(fibn);
        System.out.println(countPath(3));
        System.out.println(countPathMemoise(n, new int[n + 1]));
        System.out.println(countPathMemoise(n, new int[n + 1]));
        System.out.println(countPathTabluation(n));
        System.out.println(countPathVariableJumps(6));
        System.out.println(minimumCostMazeTraversal());
        coinCombinations();
        coinPermutations();
        Knapsack01();
        System.out.println(Knapsack01());
        KnapsackUnbounded();
        countBinaryStrings();
        countBinaryStringsBetter();
        arrangeBuildings();
//        countEncodings();
        countABCSubSequqnce();
        maximumSumNonAdjacentElements();
        paintHouse();
        paintHouseManyColors();
        paintFence();
        tiling();
        tiling2();
        buyAndSellStocks();
        buyAndSellStocksInfiniteTx();
        buyAndSellStocksInfiniteTxWithFees();
        buyAndSellStocksInfiniteTxWithFeesCooldown();
        buyAndSellStocksITwoTx();*/
    }


    public static int Fib(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        System.out.println("Hello " + n);

        int fibnm1 = Fib(n - 1);
        int fibnm2 = Fib(n - 2);
        int fibn = fibnm1 + fibnm2;
        return fibn;
    }

    // dp has started, we will pass a question bank
    // n is question, return is answer
    // n and its answer is stored in qb
    //qb kitna bada hoga? 0 se n ka fib - n+1 size ka array bagega
    public static int FibMemoize(int n, int[] qb) {
        if (n == 1 || n == 0) {
            return n;
        }
        if (qb[n] != 0) {
            return qb[n];
        }
        for (int i = 0; i < qb.length; i++) {
            System.out.println(qb[i]);
        }
        System.out.println("Hello " + n);
        int fibnm1 = FibMemoize(n - 1, qb);
        int fibnm2 = FibMemoize(n - 2, qb);
        int fibn = fibnm1 + fibnm2;
        qb[n] = fibn;
        return fibn;
    }


    public static void fibTabulation() {
        int n = 5;
        long[] arr = new long[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(arr[n]);
    }

    /*    1. You are given a number n, representing the number of stairs in a staircase.
    2. You are on the 0th step and are required to climb to the top.
    3. In one move, you are allowed to climb 1, 2 or 3 stairs.
    4. You are required to print the number of different paths via which you can climb to the top */
    public static int countPath(int n) {
        // Climb stairs
        if (n < 0) {
            // yaha print nahi karna isiliye print nahi likha
            return 0;
        } else if (n == 0) {
            return 1;
        }
        // faith hai hamara - n se we can go to n-1, n-2, n-3 only
        System.out.println("Hello-" + n);
        int nm1 = countPath(n - 1); // we just need to give count, we dnt have to print it
        int nm2 = countPath(n - 2);
        int nm3 = countPath(n - 3);
        int cp = nm1 + nm2 + nm3;
        return cp;
    }

    public static int countPathMemoise(int n, int[] qb) {
        if (n < 0) {
            return 0; // ek bhi rasta nahi hai
        } else if (n == 0) {
            return 1; // ek rasta hai ki chalo mat
        }
        if (qb[n] != 0) {
            return qb[n];
        }
        // faith hai hamara - n se we can go to n-1, n-2, n-3 only
//        System.out.println("Hello-" + n);
        int nm1 = countPathMemoise(n - 1, qb);
        int nm2 = countPathMemoise(n - 2, qb);
        int nm3 = countPathMemoise(n - 3, qb);
        int cp = nm1 + nm2 + nm3;
        qb[n] = cp;
        return cp;
    }


    /*Question
        1. You are given a number n, representing the number of stairs in a staircase.
        2. You are on the 0th step and are required to climb to the top.
        3. In one move, you are allowed to climb 1, 2 or 3 stairs.
        4. You are required to print the number of different paths via which you can climb to the top.
        Input Format
        A number n
        Output Format
        A number representing the number of ways to climb the stairs from 0 to top.
        Constraints
        0 <= n <= 20
        Sample Input
        4
        Sample Output
7
*/
    public static int countPathTabluation(int n) {
        // uses iteration not recursion
        // make a array of size n + 1
        // [1,2,2,4,7,13,24] -- we build the array from left to right
        // each cell has meaning -> ktine raste us stair tak pohuchne ke
        int[] dp = new int[n + 1]; // makee a table
        dp[0] = 1; // 0 se 0 ka ek rasta hai

        for (int i = 1; i <= n; i++) { //
            if (i == 1) {
                dp[i] = dp[i - 1]; // i-1 se kitne raste hai... baki board ke bahar hai
            } else if (i == 2) {
                dp[i] = dp[i - 1] + dp[i - 2];// i-1 se kitne raste hai +  i-2 se kitne raste hai
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]; // i-1 se klitne raste hai +  i-2 se kitne raste hai + i-3 se kitne raste hai
            }

        }
        return dp[n];
    }

    /*
    1. You are given a number n, representing the number of stairs in a staircase.
    2. You are on the 0th step and are required to climb to the top.
    3. You are given n numbers, where ith element's value represents - till how far from the step you could jump to in a single move.
     You can of-course fewer number of steps in the move.
    4. You are required to print the number of different paths via which you can climb to the top.*/
    public static int countPathVariableJumps(int n) {
        int arr[] = {3, 3, 0, 2, 2, 3};
        //meaning ==> at cell 3 we will store number of ways to go from 3 to 6
        // final dp will look like = [8,5,0,3,2,1,1]
        int[] dp = new int[n + 1]; // storage n+1
        dp[n] = 1; //if n=6, 6 se 6 jane ka ek rasta hai - wahi khade raho
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                dp[i] += dp[i + j]; //
            }
        }
        return dp[0];
    }

    /*
        Question
        1. You are given a number n, representing the number of stairs in a staircase.
        2. You are on the 0th step and are required to climb to the top.
        3. You are given n numbers, where ith element's value represents - till how far from the step you
                    could jump to in a single move.  You can of-course fewer number of steps in the move.
        4. You are required to print the number of minimum moves in which you can reach the top of staircase.
        Note -> If there is no path through the staircase print null.
        Input Format
        A number n
        .. n more elements
        Output Format
        A number representing the number of ways to climb the stairs from 0 to top.*/
    public static int climbStairsWithMinimumMoves(int n) {

        // 10 steps hai to 11 ka array banao
        // direction right to left
        int arr[] = {4, 2, 0, 2, 2, 3};
        Integer[] dp = new Integer[n + 1];
        dp[n] = 0;//move zero hai
        for (int i = n - 1; i >= 0; i--) {
            if (arr[n] > 0) {// tabhi age bade jab move allowed hai
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                    if (dp[i + j] != null) {// null ko minimum calculate karne me use nahi karna hai
                        dp[i] = Math.min(min, dp[i + j]); //jo bhi path minimum moves ka hai wo store karo
                        // sari jagaho ka min lene hai
                    }
                }
                if (min != Integer.MAX_VALUE) {//hame abhi tak rasta nahi mila
                    dp[i] = min + 1;
                }
            }
        }
        return dp[0];
    }


    /*Question
    1. You are given a number n, representing the number of rows.
    2. You are given a number m, representing the number of columns.
    3. You are given n*m numbers, representing elements of 2d array a, which represents a maze.
    4. You are standing in top-left cell and are required to move to bottom-right cell.
    5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
    6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom-right cell).
    7. You are required to traverse through the matrix and print the cost of path which is least costly.*/
    public static int minimumCostMazeTraversal() {
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

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr[0].length - 1; j >= 0; j--) {
                if (i == arr.length - 1 && j == arr[0].length - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == arr.length - 1) {
                    dp[i][j] = arr[i][j] + dp[i][j + 1];
                } else if (j == arr[0].length - 1) {
                    dp[i][j] = arr[i][j] + dp[i + 1][j];
                } else {
                    dp[i][j] = arr[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        System.out.println(dp[0][0]);

        return dp[0][0];
    }


    public static int goldMine() {
        /*
        https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/goldmine-official/ojquestion
        *
        1. You are given a number n, representing the number of rows.
        2. You are given a number m, representing the number of columns.
        3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
        4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from any row in the left wall.
        5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).
*/
        int arr[][] = new int[2][2]; //You are given n*m numbers
        int dp[][] = new int[2][2];

        // max goal kaunsa raste lene pe milega -
        // dependent cells solve hone chahiye
        // direction - right to left

        // division - top row, last row, last coulmn, baki
        for (int j = arr[0].length - 1; j >= 0; j--) { // max to least column
            for (int i = arr.length - 1; i >= 0; i--) {
                if (j == arr[0].length - 1) {//last columns - same as srr
                    dp[i][j] = arr[i][j];
                } else if (i == 0) {// pehla row = 2 hi option hai,  right and right below
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]); // arr[i][j] =apna gold ,,,Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                } else if (i == arr.length - 1) {// last row = option 2 hi hai sirf = right and upper right
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                } else {//baki ke
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1]));
                }
            }
        }
        int max = dp[0][0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i][0] > max) {
                max = dp[i][0];
            }
        }

        return max;
    }


    /*Question
        1. You are given a number n, representing the count of elements.
        2. You are given n numbers.
        3. You are given a number "tar".
        4. You are required to calculate and print true or false, if there is a subset the elements of which add
             up to "tar" or not.
        Input Format
            A number n
            n1
            n2
            .. n number of elements
            A number tar
        Output Format
            true or false as required
        Constraints
            1 <= n <= 30
            0 <= n1, n2, .. n elements <= 20
            0 <= tar <= 50
        Sample Input
                5
                4
                2
                7
                1
                3
                10
        Sample Output
            true
*/
    public static void targetSumSubset() {
        int n = 5;
        int[] arr = new int[n];
        int tar = 10;
        boolean[][] dp = new boolean[n + 1][tar + 1];

        // we will divide in 4 parts
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    if (dp[i - 1][j] == true) {// when you did not bat at all
                        // .... pehle wali team ko bana lene the sare run
                        dp[i][j] = true;
                    } else {//abb batting karani padegi ...
                        // uske liye

                        int val = arr[i - 1]; //i-1 agar i 3 hai dp me to
                        // array me i-1
                        if (j >= val) { // isne j score kar diya...bakie team ko
                            // j-val score karne diye hone honge
                            if (dp[i - 1][j - val] == true) {//baki ke run = j -  val
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(dp[arr.length][tar]);
    }


    public static void coinCombinations() {
//        int [] arr = {2,3,5}; amt = 7
        // see notes
        int[] arr = {2, 3, 5, 6};
        int amt = 10;
        int[] dp = new int[amt + 1];
        dp[0] = 1;// kuch len den na kare
        for (int i = 0; i < arr.length; i++) {//bahar wala hai coins ka loop, pehle 2, fir 3  and so on
            System.out.println("i is => " + i);
            for (int j = arr[i]; j < dp.length; j++) { ///j = 2 to 2 se aage chalaye, 1 amount 3 ke coin se nahi de sakte
                System.out.print("\tj is => " + j);
//                System.out.println("i is =>"+i);
                dp[j] = dp[j] + dp[j - arr[i]];// j is dp wla index, i is coin
                //coin jitna peche jao dp me
                System.out.print("\t\tdp[j] is => " + dp[j]);
                System.out.println();
            }
        }
        System.out.println(dp[amt]);
    }

    public static void coinPermutations() {
//        int [] arr = {2,3,5}; amt = 7
        int[] coins = {2, 3, 5, 6};
        int tar = 10;
        int[] dp = new int[tar + 1];
        dp[0] = 1;
        for (int amt = 0; amt < dp.length; amt++) {
            for (int coin : coins) {
                if (coin <= amt) {
                    int remAmount = amt - coin;
                    dp[amt] += dp[remAmount];
                }
            }
        }
        System.out.println(dp[tar]);
    }

    /*1. You are given a number n, representing the count of items.
    2. You are given n numbers, representing the values of n items.
    3. You are given n numbers, representing the weights of n items.
    3. You are given a number "cap", which is the capacity of a bag you've.
    4. You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.
    Note1 -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item again and again.

    public static void printSS(String question, String answer) {
        if (question.length() == 0) {
        System.out.println(answer);
        return;
    }
    char ch = question.charAt(0);
    String ros = question.substring(1);

    printSS(ros, answer + "");
    printSS(ros, answer + ch);
}

*/
    public static int Knapsack01() {
        int[] vals = {15, 14, 10, 45, 30};
        int[] wts = {2, 5, 1, 3, 4};
        int n = 5;
        int cap = 7;
        int[][] dp = new int[n + 1][cap + 1];

        for (int i = 1; i < dp.length; i++) {//loop kaha se chal raha hai??by default 0 bhara hua hota hai
            for (int j = 1; j < dp[0].length; j++) {//row by row solve kar rahe hai
                //we will solve row by row
                // aggar isse batting nahi karao to upar wali  row se purane runs utha lo

                // j = balls
                // i = players
                if (j >= wts[i - 1]) {
                    // sufficient balls hai batting kra sakte
                    if (dp[i - 1][j - wts[i - 1]] + vals[i - 1] > dp[i - 1][j]) {
                        //https://youtu.be/bUSaenttI24?t=1481
                        //i-1 is baki ki team
                        // bachi hui balls [j - wts[i - 1]

                        //dp[i-1][j - wts[i-1]] == upar ka row, j - wts[i-1] col pe
                        // hai baki team ne jo bachi hui balls pe run banaye

                        // vals[i] pe abhi wale bande ne kitne run banaye
                        // batting nahi karta jba
                        dp[i][j] = dp[i - 1][j - wts[i - 1]] + vals[i - 1];
                    } else {
                        // isko batting karane se fayeda nahi, mat karao batting isse
                        dp[i][j] = dp[i - 1][j]; // when I doesnt bat
                    }
                }
                // balls hi nhi hia purani team ke run uthao
                else {
                    dp[i][j] = dp[i - 1][j];// when doesn't bat, i-1 ki team ko j balls mil gai
                }
            }
        }
        return dp[n][cap];
    }

    public static void KnapsackUnbounded() {
        int[] vals = {15, 14, 10, 45, 30};
        int[] wts = {2, 5, 1, 3, 4};
        int n = 5;
        int cap = 7;
        int[] dp = new int[cap + 1];
        dp[0] = 0; // 0 kg bag me kuch nahi aa sakta
        for (int bagCapacity = 1; bagCapacity < dp.length; bagCapacity++) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (wts[i] <= bagCapacity) {
                    int remainingBagCapacity = bagCapacity - wts[i];
                    int remainingBagValue = dp[remainingBagCapacity];
                    int totalBagValue = remainingBagValue + vals[i];
                    if (totalBagValue > max) {
                        max = totalBagValue;
                    }
                }
            }
            dp[bagCapacity] = max;
        }
        System.out.println(dp[cap]);
    }


    /*Question
        1. You are given a number n.
        2. You are required to print the number of binary strings of length n with no consecutive 0's.
        Input Format
        A number n
        Output Format
        A number representing the number of binary strings of length n with no consecutive 0's.
        Constraints
        0 < n <= 45
        Sample Input
        6
        Sample Output
        21
*/
    public static void countBinaryStrings() {
        int n = 6;
        int[] dp0 = new int[n + 1];
        int[] dp1 = new int[n + 1];
        dp0[0] = 0;
        dp1[0] = 0;
        dp0[1] = 1;
        dp1[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp1[i] = dp1[i - 1] + dp0[i - 1];
            dp0[i] = dp1[i - 1];
        }
        System.out.println(dp1[n] + dp0[n]);
    }

    public static void countBinaryStringsBetter() {
        int n = 6;
        int oldcountzeros = 1;
        int oldcountones = 1;
        for (int i = 2; i <= n; i++) {
            int newCountZeros = oldcountones;
            int newCountOnes = oldcountones + oldcountzeros;
            oldcountones = newCountOnes;
            oldcountzeros = newCountZeros;
        }
        System.out.println(oldcountones + oldcountzeros);
    }

    public static void arrangeBuildings() {
        long n = 5;
        int oldBuilding = 1;
        int oldSpace = 1;
        for (int i = 2; i <= n; i++) {
            int newBuilding = oldSpace;
            int newSpace = oldBuilding + oldSpace;
            oldSpace = newSpace;
            oldBuilding = newBuilding;
        }
        int total = oldSpace + oldBuilding;
        System.out.println(total * total);
    }

    public static void countEncodings() {
        String str = "21123";
        int[] dp = new int[str.length()];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            if (str.charAt(i - 1) == '0' && str.charAt(i) == '0') {
                dp[i] = 0;
            } else if (str.charAt(i - 1) == '0' && str.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            } else if (str.charAt(i - 1) != '0' && str.charAt(i) == '0') {
                if (str.charAt(i - 1) == '1' || str.charAt(i - 1) == '2') {
                    dp[i] = i > 2 ? dp[i - 2] : 1;
                } else {
                    dp[i] = 0;
                }

            } else {
                if (Integer.parseInt(str.substring(i - 1, i + 1)) <= 26) {
                    dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        System.out.println(dp[str.length() - 1]);
    }

    /*
    Question
        1. You are given a string str.
        2. You are required to calculate and print the count of subsequences of the nature a+b+c+.
        For abbc -> there are 3 subsequences. abc, abc, abbc
        For abcabc -> there are 7 subsequences. abc, abc, abbc, aabc, abcc, abc, abc.
        Input Format
        A string str
        Output Format
        count of subsequences of the nature a+b+c+
        Constraints
        0 < str.length <= 10
        Sample Input
        abcabc
    */
    public static void countABCSubSequqnce() {
        String str = "abcabc";
        int a = 0;
        int ab = 0;
        int abc = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a') {
                a = 2 * a + 1;
            } else if (ch == 'b') {
                ab = 2 * ab + a;
            } else if (ch == 'c') {
                abc = 2 * abc + ab;
            }
        }
        System.out.println(abc);
    }

    /*Question
            1. You are given a number n, representing the count of elements.
            2. You are given n numbers, representing n elements.
            3. You are required to find the maximum sum of a subsequence with no adjacent elements.
        Input Format
            A number n
            n1
            n2
            .. n number of elements
        Output Format
            A number representing the maximum sum of a subsequence with no adjacent elements.
        Constraints
            1 <= n <= 1000
            -1000 <= n1, n2, .. n elements <= 1000
        Sample Input
            6
            5
            10
            10
            100
            5
            6
        Sample Output
          116
*/
    public static void maximumSumNonAdjacentElements() {
        int n = 6;
        int[] arr = {5, 10, 10, 100, 5, 6};

        int inc = arr[0];
        int exc = 0;

        for (int i = 1; i < arr.length; i++) {
            int newinc = exc + arr[i];
            int newexc = Math.max(inc, exc);

            inc = newinc;
            exc = newexc;
        }
        int ans = Math.max(inc, exc);
        System.out.println(ans);

        System.out.println();
    }


    /*
       * Question
            1. You are given a number n, representing the number of houses.
            2. In the next n rows, you are given 3 space separated numbers representing the cost of painting nth house with red or blue or green color.
            3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.
        Input Format
            A number n
            n1red n1blue n1green
            n2red n2blue n2green
            .. n number of elements
        Output Format
            A number representing the minimum cost of painting all houses without painting any consecutive house with same color.
        Constraints
            1 <= n <= 1000
            0 <= n1red, n1blue, .. <= 1000
        Sample Input
            4
            1 5 7
            5 8 4
            3 2 9
            1 2 4
        Sample Output
            8
    * */
    public static void paintHouse() {
        int n = 4; // number of houses
        int[][] arr = new int[n][3];
        arr[0][0] = 1;
        arr[0][1] = 5;
        arr[0][2] = 7;
        arr[1][0] = 5;
        arr[1][1] = 8;
        arr[1][2] = 4;
        arr[2][0] = 3;
        arr[2][1] = 2;
        arr[2][2] = 9;
        arr[3][0] = 1;
        arr[3][1] = 2;
        arr[3][2] = 4;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }
        long[][] dp = new long[n][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);//pichle ghar ka blue ya green
            dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = arr[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        long ans = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        System.out.println(ans);
    }

    /*
    Question
        1. You are given a number n and a number k separated by a space, representing the number of houses and number of colors.
        2. In the next n rows, you are given k space separated numbers representing the cost of painting nth house with one of the k colors.
        3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.

        Input Format
        A number n
        n1-0th n1-1st n1-2nd .. n1-kth
        n2-0th n2-1st n2-2nd .. n2-kth
        .. n number of elements

        Output Format
        A number representing the minimum cost of painting all houses without painting any consecutive house with same color.
        Constraints
        1 <= n <= 1000
        1 <= k <= 10
        0 <= n1-0th, n1-1st, .. <= 1000

        Sample Input
        4 3
        1 5 7
        5 8 4
        3 2 9
        1 2 4

        Sample Output
        8
*/
    public static void paintHouseManyColors() {
        int n = 4; // number of houses
        int c = 6;
        int[][] arr = new int[n][c];

        arr[0][0] = 1;        arr[0][1] = 5;        arr[0][2] = 7;        arr[0][3] = 2;
        arr[0][4] = 1;        arr[0][5] = 4;        arr[1][0] = 5;        arr[1][1] = 8;
        arr[1][2] = 4;        arr[1][3] = 3;        arr[1][4] = 6;        arr[1][5] = 1;
        arr[2][0] = 3;        arr[2][1] = 2;        arr[2][2] = 9;        arr[2][3] = 7;
        arr[2][4] = 2;        arr[2][5] = 3;        arr[3][0] = 1;        arr[3][1] = 2;
        arr[3][2] = 4;        arr[3][3] = 9;        arr[3][4] = 1;        arr[3][5] = 7;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }
        int[][] dp = new int[n][c];
        for (int j = 0; j < dp[0].length; j++) {// pehli row fill karlo
            dp[0][j] = arr[0][j];
        }
        for (int i = 1; i < dp.length; i++) { //har ghar me
            for (int j = 0; j < dp[0].length; j++) { // har color me
                // i ghar ka number hai
                // j color ka number hai
                int min = Integer.MAX_VALUE; // min nikalna hai
                for (int k = 0; k < dp[0].length; k++) { // sare columns me ghumenge
                    if (k != j) { // ye color chor ke
                        if (dp[i - 1][k] < min) { // pichli row = i-1, sare colors = k
                            min = dp[i - 1][k];
                        }
                    }
                }
                dp[i][j] = arr[i][j] + min; // apna new color =arr[i][j]
            }
        }
        // ye loop me akri row  ka min nikalna hai
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < dp[0].length; k++) {// akhri row ka min
            if (dp[n - 1][k] < min) {// akri row = dp[n - 1]
                min = dp[n - 1][k];
            }
        }
        System.out.println(min);
    }



    /*Question
        1. You are given a number n and a number k in separate lines, representing the number of fences and number of colors.
        2. You are required to calculate and print the number of ways in which the fences could be painted so that not more than two fences have same colors.

        Input Format
        A number n
        A number k

        Output Format
        A number representing the number of ways in which the fences could be painted so that not more than two fences have same colors.

        Constraints
        1 <= n <= 10
        1 <= k <= 10

        Sample Input
        8
        3

        Sample Output
        3672
*/
    public static void paintFence() {
        Scanner scn = new Scanner((System.in));
//        int n = scn.nextInt() ;
//        int k = scn.nextInt() ;
        int n = 8; // number of fences
        int k = 3; // number of colors
        // A number representing the number of ways in which the fences
        // could be painted so that not more than two fences have same colors.
        int same = k * 1;
        int diff = k * (k - 1);
        int total = same + diff;
        for (int i = 3; i <= n; i++) {
            same = diff * 1;
            diff = total * (k - 1);
            total = same + diff;
        }
        System.out.println(total);
    }


    /*
    Question
    1. You are given a number n representing the length of a floor space which is 2m wide. It's a 2 * n board.
    2. You've an infinite supply of 2 * 1 tiles.
    3. You are required to calculate and print the number of ways floor can be tiled using tiles.

    Input Format
    A number n

    Output Format
    A number representing the number of ways in which the number of ways floor can be tiled using tiles.

    Constraints
    1 <= n <= 100

    Sample Input
    8

    Sample Output
    34
    */
    public static void tiling() {
//        Scanner scn = new Scanner(System.in);
//        int n = scn.nextInt();
        int n = 4;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
    }

    public static void tiling2() {
//        Scanner scn = new Scanner(System.in);
//        int n = scn.nextInt();
//        int m = scn.nextInt();
        int n = 8;
        int m = 3;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i < m) {
                dp[i] = 1;
            } else if (i == m) {
                dp[i] = 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - m];
            }
        }

        System.out.println(dp[n]);
    }


    public static void buyAndSellStocks() {
        int[] prices = {1, 2, 3};
        int lsf = Integer.MAX_VALUE;
        int op = 0;
        int pist = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lsf) {
                lsf = prices[i];
            }
            pist = prices[i] - lsf;
            if (pist > op) {
                op = pist;
            }

        }
        System.out.println(op);
    }


    public static void buyAndSellStocksInfiniteTxWithFees() {
        int[] arr = {10, 20, 30};
        int obsp = -arr[0];
        int ossp = 0;
        int fee = 2;

        for (int i = 1; i < arr.length; i++) {
            int nbsp = 0;
            int nssp = 0;

            // ajj buy karne ke options
            if (ossp - arr[i] > obsp) { // naya stock arr[i] ka hai
                nbsp = ossp - arr[i]; // agar stock lene se fayeda hai to lelo
            } else {
                nbsp = obsp; // mat lo
            }

            //ajj sell karne ke options:
            if (obsp + arr[i] - fee > ossp) {
                nssp = obsp + arr[i] - fee; // becha to ajj jinte pe hai utna milega=arr[i] and fee jaegi jeb se
            } else {
                nssp = ossp;

            }
            ossp = nssp;
            obsp = nbsp;
        }
        System.out.println(ossp);

    }


    public static void buyAndSellStocksInfiniteTxWithFeesCooldown() {
        int[] arr = {10, 20, 30};
        int obsp = -arr[0];
        int ossp = 0;
        int ocsp = 0;

        for (int i = 1; i < arr.length; i++) {
            int nbsp = 0;
            int nssp = 0;
            int ncsp = 0;

            // ajj buy karne ke options
            if (ocsp - arr[i] > obsp) { // naya stock arr[i] ka hai
                // kaunsa kam negetive hai -- kareedah ai to paise gae
                nbsp = ocsp - arr[i]; // purani cooling me se iska price minus kar do
            } else {
                nbsp = obsp; // mat lo
            }

            //ajj sell karne ke options:
            if (obsp + arr[i] > ossp) { // bachne pe arr[i] paisa aya
                nssp = obsp + arr[i]; // becha to ajj jinte pe hai utna milega=arr[i] and fee jaegi jeb se
            } else {
                nssp = ossp;

            }

            if (ossp > ocsp) {
                ncsp = ossp;
            } else {
                ncsp = ocsp;
            }

            ossp = nssp;
            obsp = nbsp;
            ocsp = ncsp;
        }
        System.out.println(ossp);
    }


    public static void buyAndSellStocksITwoTx() {
        int[] arr = {10, 20, 30};        // left to right move karke find max profit if sold today or before today
        int mpist = 0; // max profit if sold today
        int leastsf = arr[0]; // least so far == yaha buy least point
        int[] dpleft = new int[arr.length]; // max profit if sold upto today
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < leastsf) {// ye maintain karna hai
                leastsf = arr[i];
            }
            mpist = arr[i] - leastsf; //max profit if sold today,, ajj kahreda least pe becha -- ajj ka answer not best
            // abb pehle dekho aur best nikal abhi tak
            if (mpist > dpleft[i - 1]) {
                dpleft[i] = mpist; //
            } else {
                dpleft[i] = dpleft[i - 1]; // pichle me better hai-chalte hue ara hai
            }
        } // ulta direction wala loop        // ajj buy karna hai to future me kiss din beche jisse max profit hoga
        int mpibt = 0; // max profit if bought today
        int maxat = arr[arr.length - 1]; // max after today
        int[] dpright = new int[arr.length];
        for (int i = arr.length - 2; i >= 0; i--) { // loop second last se chalga
            if (arr[i] > maxat) {
                maxat = arr[i]; //ise maintain karo hamesha
            }
            mpibt = maxat - arr[i]; // ajj ki price ghata do future ki max value se ya ajj ki hi value se agar future me nhi hai to
            if (mpibt > dpright[i + 1]) {
                dpright[i] = mpibt;
            } else {
                dpright[i] = dpright[i + 1];
            }
        }
        int op = 0;//overall profit
        for (int i = 0; i < arr.length; i++) {
            // har point pe dpleft me best tx on the left & har point pe dpright me best tx on the right
            if (dpleft[i] + dpright[i] > op) {
                op = dpleft[i] + dpright[i];
            }
        }
        System.out.println(op);    }
}
