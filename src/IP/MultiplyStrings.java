package IP;

public class MultiplyStrings {

    public static void main(String[] args) {
        String ans = multiply("123", "56");
        System.out.println(ans);
    }
    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int val = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int idx1 = i + j, idx2 = i + j + 1;
                int sum = val + res[idx2];
                res[idx1] += sum / 10; //carry
                res[idx2] = (sum) % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int p : res) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
