package Graph;

public class Solution {
    public static void main(String[] args) {
        int[][]M = {{1,1,0},
                    {1,1,0},
                    {0,0,1}};
        System.out.println(findCircleNum(M));
    }

    public static  void dfs(int[][] M, int[] seen, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && seen[j] == 0) {
                seen[j] = 1;
                dfs(M, seen, j);
            }
        }
    }
    public static int findCircleNum(int[][] M) {
        int[] seen = new int[M.length];
        int res = 0;
        for (int i = 0; i < M.length; i++) {
            if (seen[i] ==0) {
                dfs(M, seen, i);
                res++;
            }
        }
        return res;
    }



}
