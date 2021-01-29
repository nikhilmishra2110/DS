
package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int val : a) {
            sb.append(val + " ");

        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
//        duplicateBracket();
//        balancedBracket() ;
        int[] arr = {1, 2, 3, 7, 6, 2, 9, 7, 3, 4, 5, 6};
//        int []age  = ngetr(arr);
//        int []age  = ngetrApproach2(arr);
//        int[] res = stockSpan(arr);
//        int res = largestAreaHistogram(arr);
//        System.out.println(res);

//        slidingWindowMaximumUsingStack(arr);
//        infixEvaluation();
//        InfixConversions();
//        display(res1);

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int[][] arr = new int[n][n];
//
//        for (int j = 0; j < n; j++) {
//            String line = br.readLine();
//            for (int k = 0; k < n; k++) {
//                arr[j][k] = line.charAt(k) - '0';
//            }
//        }
//
//        findCelebrity(arr);
        String s = "(((}}}";
        System.out.println(isValid(s));




    }


    public static  boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {

            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')

                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
//            if(!stack.empty()){System.out.println(stack.peek());}
        }
        return stack.isEmpty();
    }




    public static int[] ngetr(int[] arr) {
        int[] nge = new int[arr.length]; //input jitna
        Stack<Integer> st = new Stack<>(); // stack banai
        st.push(arr[arr.length - 1]); // last element ko puch kar do pehle hi
        nge[arr.length - 1] = -1; // answer me -1 dala for last element
        for (int i = arr.length - 2; i >= 0; i--) {
            // - a +
            while (st.size() > 0 && arr[i] >= st.peek()) {
                // arr[i] >= st.peek() = chote element ko pop karz
                st.pop();
            }
            // loop ke bad 2 cases ho sakte hai
            if (st.size() == 0) {
                nge[i] = -1; // ye sabse bada
            } else {
                nge[i] = st.peek(); //
            }
            st.push(arr[i]);
        }
        return nge;
    }

    public static int[] ngetrApproach2(int[] arr) {
        int[] nge = new int[arr.length]; //input jitna
        Stack<Integer> st = new Stack<>(); // stack banai
        st.push(0); // address pusk kiya
        for (int i = 1; i < arr.length; i++) {
            // (- a)
            // +
            while (st.size() > 0 && arr[i] > arr[st.peek()]) {
                // b > a , (arr[i] = b) >
                int position = st.peek();
                nge[position] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        //baki ko -1 kar do
        while (st.size() > 0) {
            int position = st.peek();
            nge[position] = -1;
            st.pop();
        }

        return nge;
    }

    public static int[] stockSpan(int[] arr) {
        int[] span = new int[arr.length]; //input jitna
        Stack<Integer> st = new Stack<>(); // stack banai
        st.push(0); // address pusk kiya
        span[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            //pop
//            answer
            // push
            while (st.size() > 0 && arr[i] > arr[st.peek()]) {
//          tabhi rukenge jab  mere se bada milega ya size khatam hoga
                st.pop();
            }
            if (st.size() == 0) {//sare pop kara diye
                span[i] = i + 1;
            } else {//sare pop nahi kara pae
                span[i] = i - st.peek(); //peek pe left ka highest pada hai - span ke liye ye wala i and last highest
            }
            st.push(i);
        }

        return span;
    }

    public static int largestAreaHistogram(int[] arr) {
        int[] rb = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length - 1);
        rb[arr.length - 1] = arr.length;
        for (int i = arr.length - 1; i >= 0; i--) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()]) { //bado ko poop kara do
                st.pop();
            }
            if (st.size() == 0) {
                rb[i] = arr.length;
            } else {
                rb[i] = st.peek();
            }
            st.push(i);
        }
        int[] lb = new int[arr.length];
        st = new Stack<>();
        st.push(0);
        lb[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                lb[i] = -1;
            } else {
                lb[i] = st.peek();
            }
        }
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = arr[i] * width;
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void slidingWindowMaximumUsingStack(int[] arr) {
        int k = 4;
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[arr.length];
        st.push(arr.length - 1);
        nge[arr.length - 1] = arr.length;

        for(int i = arr.length - 2; i >= 0; i--){
            while(st.size() > 0 && arr[i] >= arr[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                nge[i] = arr.length;
            } else {
                nge[i] = st.peek();
            }
            st.push(i);
        }

        // nge end
        int j = 0;
        for(int i = 0; i <= arr.length - k; i++){
            if(j < i){
                j = i;
            }
            while(nge[j] < i + k){
                j = nge[j];
            }
            System.out.println(arr[j]);
        }
    }




    public static void infixEvaluation(){
        String exp = "(2+3)";        // code
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(') {
                operators.push(ch);
            } else if (Character.isDigit(ch)) {
                operands.push(ch - '0');
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operators.size() > 0 && operators.peek() != '(' &&
                        precedence(ch) <= precedence(operators.peek())) {
                    int val2 = operands.pop();
                    int val1 = operands.pop();
                    char op = operators.pop();

                    int opval = operation(val1, val2, op);
                    operands.push(opval);
                }
                operators.push(ch);
            } else if (ch == ')') {
                while (operators.size() > 0 && operators.peek() != '(') {
                    int val2 = operands.pop();
                    int val1 = operands.pop();
                    char op = operators.pop();

                    int opval = operation(val1, val2, op);
                    operands.push(opval);
                }
                if (operators.size() > 0) {
                    operators.pop();
                }
            }
        }
        while (operators.size() > 0) {
            int val2 = operands.pop();
            int val1 = operands.pop();
            char op = operators.pop();
            int opval = operation(val1, val2, op);
            operands.push(opval);
        }
        int val = operands.pop();
        System.out.println(val);
    }
    public static int precedence(char op){
        if(op == '+'){
            return 1;
        } else if(op == '-'){
            return 1;
        } else if(op == '*'){
            return 2;
        } else {
            return 2;
        }
    }

    public static int operation(int val1, int val2, char op){
        if(op == '+'){
            return val1 + val2;
        } else if(op == '-'){
            return val1 - val2;
        } else if(op == '*'){
            return val1 * val2;
        } else {
            return val1 / val2;
        }
    }

    public static void InfixConversions(){
        String exp = "(a+b)";
        Stack<String> postfix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(') {//bas push hoga
                operators.push(ch);
            } else if ((ch >='0' && ch <= '9') || (ch >='a' && ch <= 'z') || (ch >='A' && ch <= 'Z'))  {
                postfix.push(ch + "");
                prefix.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operators.size() > 0 && operators.peek() != '(' && precedence(ch) <= precedence(operators.peek())) {
                    char op = operators.pop();
                    String postval2 = postfix.pop();
                    String postval1 = postfix.pop();
                    postfix.push(postval1 + postval2 + op);
                    String preval2 = prefix.pop();
                    String preval1 = prefix.pop();
                    prefix.push(op + preval1 + preval2);                }
                operators.push(ch);
            } else if (ch == ')') {
                while (operators.size() > 0 && operators.peek() != '(') {
                    char op = operators.pop();
                    String postval2 = postfix.pop();
                    String postval1 = postfix.pop();
                    postfix.push(postval1 + postval2 + op);
                    String preval2 = prefix.pop();
                    String preval1 = prefix.pop();
                    prefix.push(op + preval1 + preval2);
                }
                if (operators.size() > 0) {
                    operators.pop();
                }            }        }
        while (operators.size() > 0) {
            char op = operators.pop();
            String postval2 = postfix.pop();
            String postval1 = postfix.pop();
            postfix.push(postval1 + postval2 + op);
            String preval2 = prefix.pop();
            String preval1 = prefix.pop();
            prefix.push(op + preval1 + preval2);
        }
        System.out.println(postfix.peek());
        System.out.println(prefix.peek());
    }


    public static void findCelebrity(int[][] arr){
        // if a celebrity is there print it's index (not position), if there is not then print "none"
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            st.push(i);
        }

        while(st.size() > 1){
            int i = st.pop();
            int j = st.pop();

            if(arr[i][j] == 1){
                st.push(j);
            } else {
                st.push(i);
            }
        }
        int pot = st.pop();
        boolean flag = true;
        for(int i = 0; i < arr.length; i++){
            if(i != pot){
                if(arr[i][pot] == 0 || arr[pot][i] == 1){
                    flag = false;
                    break;
                }
            }
        }
        if(flag){
            System.out.println(pot);
        } else {
            System.out.println("none");
        }
    }


    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        Pair[] pairs = new Pair[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }
        Arrays.sort(pairs);

        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < pairs.length; i++) {
            if (i == 0) {
                st.push(pairs[i]);
            } else {
                Pair top = st.peek();
                Pair curr = pairs[i];

                if (curr.st > top.et) {
                    st.push(curr);
                } else {
                    top.et = Math.max(top.et, pairs[i].et);
                }
            }
        }

        Stack<Pair> rs = new Stack<>();
        while (st.size() > 0) {
            rs.push(st.pop());
        }

        while (rs.size() > 0) {
            Pair p = rs.pop();
            System.out.println(p.st + " " + p.et);
        }

    }

    public static class Pair implements Comparable<Pair> {
        int st;
        int et;

        public Pair(int st, int et) {
            this.st = st;
            this.et = et;
        }

        public int compareTo(Pair other) {
            if (this.st != other.st) {
                return this.st - other.st;
            } else {
                return this.et - other.et;
            }
        }
    }



}

