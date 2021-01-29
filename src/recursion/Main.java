package recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
   /*     printDecresing(n);
        printIncreasing(n);
        pdi(n);
        System.out.println(fac(n));
        System.out.println(power(n, 3));
        System.out.println(power_logarithmic(3,4));
            pzz(2);
            pzz1(2);
        toh(1,2,3,  3);
    int[] a = {1, 22, 3, 4, 55};
        printArray(a);

//        printArray1(a,a.length);
        displayArray(a, 0);
        displayArrayReverse(a, 0);
        System.out.println(maxInArray(a , 0));

        int [] arr = {2,3,6,9,8,3,2,6,2,4};
        System.out.println(firstIndex(arr, 0, 3));
        System.out.println(lastIndexint(arr, 0, 3));
        System.out.println(firstIndexImproved(arr, 0, 2));
        System.out.println(gss("abc"));
        System.out.println(kpc("678"));
        System.out.println(getStairsPath(4));
        System.out.println(gerMazePaths(1, 1, 4, 4));
        System.out.println(gerMazePathsWithJump(1, 1, 4, 4));
        printSS("abcdefg", "");
        printKPC("123", "");

        printStairsPath(5, "");
        printMazePaths(1, 2, 4, 4, "");
        printMazePathsWithJump(1, 2, 4, 4, "");
        printpermutation("abc", "");
        printEncodings("123","");
//*/
//        int M = 8
//        int N = 8
//        int maze[M][N] =
//        {   {1, 1, 1, 1, 1, 1, 1, 1},
//            {1, 1, 1, 1, 1, 1, 0, 0},
//            {1, 0, 0, 1, 1, 0, 1, 1},
//            {1, 2, 2, 2, 2, 0, 1, 0},
//            {1, 1, 1, 2, 2, 0, 1, 0},
//            {1, 1, 1, 2, 2, 2, 2, 0},
//            {1, 1, 1, 1, 1, 2, 1, 1},
//            {1, 1, 1, 1, 1, 2, 2, 1},
//        };
//        floodFill(maze, 0, 0, "", visited);
    }

    public static void printDecresing(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printDecresing(n - 1);
    }

    public static void printIncreasing(int n) {
        if (n == 0) {
            return;
        }
        printIncreasing(n - 1);
        System.out.println(n);

    }

    public static void pdi(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        pdi(n - 1);
        System.out.println(n);
    }

    public static int fac(int n) {
        if (n == 1) {
            return 1;
        }

        return n * fac(n - 1);
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * power(x, n - 1);
    }

    public static int power_logarithmic(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int p = power_logarithmic(x, n / 2);
        if (n % 2 == 0) {
            return p * p;
        }
        return x * p * p;
    }

    public static void pzz(int n) {
        if (n == 0) {
            return;
        }
        System.out.println("Pre " + n);
        pzz(n - 1);
        System.out.println("In " + n);
        pzz(n - 1);
        System.out.println("Post " + n);
    }


    public static void pzz1(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        pzz1(n - 1);
        System.out.println(n);
        pzz1(n - 1);
        System.out.println(n);
    }

    public static void toh(int s, int h, int d, int n) {
        if (n == 1) {
            System.out.println("move disk " + n + " from " + s + " to destination " + d);
            return;
        }
        toh(s, d, h, n - 1);
        System.out.println("move disk " + n + " from " + s + " to destination " + d);
        toh(h, s, d, n - 1);
    }

    public static void printArray(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        System.out.print(arr[0] + " ");
//        System.out.println(arr);
        printArray(Arrays.copyOfRange(arr, 1, arr.length));
    }

    public static void displayArray(int[] arr, int idx) {
        if (idx == arr.length) {
            return;
        }
        System.out.print(arr[idx] + " ");
        displayArray(arr, idx + 1);
    }

    public static void displayArrayReverse(int[] arr, int idx) {
        if (idx == arr.length) {
            return;
        }
        displayArrayReverse(arr, idx + 1);
        System.out.print(arr[idx] + " ");
    }

    public static int maxInArray(int[] arr, int idx) {
        if (idx == arr.length) {
            return -1;
        }

        int misa = maxInArray(arr, idx + 1);
        if (misa > arr[0]) {
            return misa;
        } else {
            return arr[idx];
        }
    }

    public static int firstIndex(int[] arr, int idx, int x) {
        // first occurance of value x in array arr
        if (idx == arr.length) {
            return -1;
        }

        int fiisa = firstIndex(arr, idx + 1, x);
        if (arr[idx] == x) {
            return idx;
        } else {
            return fiisa;
        }

    }

    public static int firstIndexImproved(int[] arr, int idx, int x) {
        // first occurance of value x in array arr
        if (idx == arr.length) {
            return -1;
        }
        if (arr[idx] == x) {
            return idx;
        } else {
            int fiisa = firstIndex(arr, idx + 1, x);
            return fiisa;
        }
    }

    public static int lastIndexint(int[] arr, int idx, int x) {
        //last index of a number
        if (idx == arr.length) {
            return -1;
        }
        int liisa = lastIndexint(arr, idx + 1, x);

        if (liisa == -1) { // nahi mila agar to pehle se compare karke aur dekh lo
            if (arr[idx] == x) {
                return idx;
            } else { // ye bhi nahi hai to return karo -1
                return -1;
            }
        } else {
            return liisa; // mil chuka hai last occurrence
        }
    }


    // String pe recursion
    public static ArrayList<String> gss(String str) {
        // generate subsequence
        if (str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> rres = gss(ros); //recursion result - this is called on the rest of the string
        // since we are calculating subsequence we need to maintain order
        ArrayList<String> myresult = new ArrayList<>(); // return karne wala array, baad me sirf print karnege inhe

        for (String i : rres) {// ya to add na karo
            myresult.add("" + i);
        }
        for (String i : rres) {// ya add karo
            myresult.add(ch + i);
        }
        return myresult;
    }

    public static ArrayList<String> kpc(String str) {
        if (str.length() == 0) {
            // agar koi char nahi bacha hai to add a  blank to array and return
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch = str.charAt(0); // 6
        String ros = str.substring(1); //78

        ArrayList<String> rres = kpc(ros); //recursion result
        ArrayList<String> myresult = new ArrayList<>();

        String codeforch = codes[ch - '0']; // 6 index pe jo codes hai unhe uthao
        for (int i = 0; i < codeforch.length(); i++) {
            char chcode = codeforch.charAt(i);
            for (String j : rres) {
                myresult.add(chcode + j); // ek ek baar sab ass karo recursion ke result me
            }
        }
        return myresult;
    }


    public static ArrayList<String> getStairsPath(int n) {
        if (n == 0) {
            // 0 se 0 jane ke raste hai chalo hi mat
            ArrayList<String> bres = new ArrayList<>();
            bres.add(""); // do nothing
            return bres;

        } else if (n < 0) {
            // negative me ho tum
            ArrayList<String> bres = new ArrayList<>();
            return bres; // kuch mat karo, na khade raho na chalo
        }
        ArrayList<String> paths1 = getStairsPath(n - 1); // faith that this will get me all the paths from n-1 to 0
        ArrayList<String> paths2 = getStairsPath(n - 2); // faith that this will get me all the paths from n-2 to 0
        ArrayList<String> paths3 = getStairsPath(n - 3); // faith that this will get me all the paths from n-3 to 0
        ArrayList<String> paths = new ArrayList<>();
        for (String path : paths1) {
            paths.add(1 + path);
        }
        for (String path : paths2) {
            paths.add(2 + path);
        }
        for (String path : paths3) {
            paths.add(3 + path);
        }
//        getStairsPath(n-3); // faith that this will get me all the paths from n-3 to
        return paths;
    }

    public static ArrayList<String> gerMazePaths(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add(""); // do nothing
            return bres;
        }

        ArrayList<String> hpaths = new ArrayList<>();
        ArrayList<String> vpaths = new ArrayList<>();

        if (sc < dc) {
            hpaths = gerMazePaths(sr, sc + 1, dr, dc);
        }
        if (sr < dr) {
            vpaths = gerMazePaths(sr + 1, sc, dr, dc); // inke upar h step or v step jodna hai begninning me
        }

        ArrayList<String> paths = new ArrayList<>();

        for (String hpath : hpaths) {
            paths.add("h" + hpath);
        }

        for (String vpath : vpaths) {
            paths.add("v" + vpath);
        }
        return paths;
    }


    public static ArrayList<String> gerMazePathsWithJump(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        ArrayList<String> paths = new ArrayList<>();
        // horizontal moves karke idhar ja sakta
        for (int ms = 1; ms <= dc - sc; ms++) { //ms = move size
            ArrayList<String> hpaths = gerMazePathsWithJump(sr, sc + ms, dr, dc);
            for (String hpath : hpaths) {
                paths.add("h" + ms + hpath);
            }
        }
        // vertical moves karke idhar ja sakta
        for (int ms = 1; ms <= dr - sr; ms++) { //ms = move size
            ArrayList<String> vpaths = gerMazePathsWithJump(sr + ms, sc, dr, dc);
            for (String vpath : vpaths) {
                paths.add("v" + ms + vpath);
            }
        }
        // diagonal moves karke idhar ja sakta
        for (int ms = 1; ms <= dr - sr && ms < dc - sc; ms++) { //ms = move size
            ArrayList<String> dpaths = gerMazePathsWithJump(sr + ms, sc + ms, dr, dc);
            for (String dpath : dpaths) {
                paths.add("d" + ms + dpath);
            }
        }
        return paths;
    }


    public static void printSS(String question, String answer) {
        /* In mathematics, a subsequence is a sequence that can be derived from another sequence by deleting
        some or no elements without changing the order of the remaining elements. */
        if (question.length() == 0) {
            System.out.println(answer);
            return;
        }
        char ch = question.charAt(0);
        String ros = question.substring(1);

        printSS(ros, answer + "");
        printSS(ros, answer + ch);
    }


    public static void printKPC(String ip, String op) {//key pad codes
        if (ip.length() == 0) {
            System.out.println(op);
            return;
        }
        char ch = ip.charAt(0); // 6
        String ros = ip.substring(1); //78

        String codeforch = codes[ch - '0']; // 6 index pe jo codes hai unhe uthao
        for (int i = 0; i < codeforch.length(); i++) { //p q r or s
            char chcode = codeforch.charAt(i);
            printKPC(ros, op + chcode);
        }
    }


    /*
    1. You are given a number n, representing the number of stairs in a staircase.
    2. You are on the 0th step and are required to climb to the top.
    3. In one move, you are allowed to climb 1, 2 or 3 stairs.
    4. You are required to print the number of different paths via which you can climb to the top.
    */
    public static void printStairsPath(int in, String path) {
        if (in == 0) { // jaha ho wahi khade raho
            System.out.println(path);
            return;
        } else if (in < 0) {// negative me ho tum
            return;
        }
        printStairsPath(in - 1, path + "1"); // faith that this will get me all the paths from n-1 to 0
        printStairsPath(in - 2, path + "2"); // faith that this will get me all the paths from n-1 to 0
        printStairsPath(in - 3, path + "3"); // faith that this will get me all the paths from n-1 to 0
    }


    public static void printMazePaths(int sr, int sc, int dr, int dc, String path) {// path here is path so far
        if (sr == dr && sc == dc) {
            System.out.println(path);
            return;
        }
        if (sc < dc) {
            printMazePaths(sr, sc + 1, dr, dc, path + "h");
        }
        if (sr < dr) {
            printMazePaths(sr + 1, sc, dr, dc, path + "v"); // inke upar h step or v step jodna hai begninning me
        }
    }

    public static void printMazePathsway2(int sr, int sc, int dr, int dc, String path) {// path here is path so far
        if (sr > dr && sc > dc) {
            return;
        }
        if (sr == dr && sc == dc) {
            System.out.println(path);
            return;
        }
        printMazePaths(sr, sc + 1, dr, dc, path + "h");
        printMazePaths(sr + 1, sc, dr, dc, path + "v"); // inke upar h step or v step jodna hai begninning me
    }


    public static void printMazePathsWithJump(int sr, int sc, int dr, int dc, String psf) {
        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }
        // horizontal moves karke idhar ja sakta
        for (int ms = 1; ms <= dc - sc; ms++) { //ms = move size
            printMazePathsWithJump(sr, sc + ms, dr, dc, psf + "h");

        }
        // vertical moves karke idhar ja sakta
        for (int ms = 1; ms <= dr - sr; ms++) { //ms = move size
            printMazePathsWithJump(sr + ms, sc, dr, dc, psf + "v");

        }
        // diagonal moves karke idhar ja sakta
        for (int ms = 1; ms <= dr - sr && ms < dc - sc; ms++) { //ms = move size
            printMazePathsWithJump(sr + ms, sc + ms, dr, dc, psf + "d");
        }
    }


    public static void printpermutation(String str, String asf) {// answer so far
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String lpart = str.substring(0, i);
            String rpart = str.substring(i + 1);
            printpermutation(lpart + rpart, asf + ch);
        }
    }


    public static void printEncodings(String ques, String asf) {
        // Case 1 - agar question ki length zero hai - return a one se start hota
        if (ques.length() == 0) {
            System.out.println(asf);
            return;
        } else if (ques.length() == 1) {
            // agar length 1 hai and last me bacha zero hai
            char ch = ques.charAt(0);
            if (ch == 0) {
                return;
            } else {//koi valid number hai--> '1' != 1, to convert char to int minus '0'
                int chv = ch - '0'; // if number is '3' not it is 3
                char code = (char) ('a' + chv - 1); // have to convert 3 to c -- if 1 a + 1 - 1
                asf = asf + code;
                System.out.println(asf);
            }
        } else {            // length 2 ya two se bada
            char ch = ques.charAt(0);
            String roq = ques.substring(1);            // agar ye pehla char zero hai to laut jao
            if (ch == 0) {
                return;
            } else {//koi valid number hai
                // '1' != 1, to convert char to int minus '0'
                int chv = ch - '0'; // if number is '3' not it is 3
                char code = (char) ('a' + chv - 1); // have to convert 3 to c -- if 1 a + 1 - 1
                printEncodings(roq, asf + code);
            }
            String ch12 = ques.substring(0, 2);// if given 12345-here 12
            String roq12 = ques.substring(2); // here 345
            int ch12v = Integer.parseInt(ch12);
            if (ch12v < 26) {
                int chv = ch - '0'; // if number is '3' not it is 3
                char code = (char) ('a' + ch12v - 1); // have to convert 3 to c -- if 1 a + 1 - 1
                printEncodings(roq12, asf + code);
            }
        }
    }

    public static void floodFill(int[][] maze, int row, int col, String psf, boolean[][] visited) {
        if (row < 0 || col < 0 || row == maze.length || col == maze.length || maze[row][col] == 1 || visited[row][col] == true) {
            return;
        }
        visited[row][col] = true;
        floodFill(maze, row - 1, col, psf + "t", visited);
        floodFill(maze, row, col - 1, psf + "l", visited);
        floodFill(maze, row + 1, col, psf + "d", visited);
        floodFill(maze, row, col + 1, psf + "r", visited);
        visited[row][col] = false;
    }
}