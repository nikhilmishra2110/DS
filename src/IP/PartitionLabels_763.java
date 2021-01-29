package IP;

import java.util.ArrayList;
import java.util.HashMap;

public class PartitionLabels_763 {
    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> hm = new HashMap<>();
        char[] A = S.toCharArray();
        for(int i=A.length-1; i >=0; i--){
            if(!hm.containsKey(A[i])) {
                hm.put(A[i], i);
            }
        }
        int maxindex = 0;
        int i = 0;
        for(int j=0; j < A.length; j++){
            maxindex = Math.max(maxindex, hm.get(A[j]));
            if( j == maxindex){
                res.add(j-i+1);
                i = j+1;
            }
        }

        for(int j=0; j < res.size(); j++){
            System.out.println(res.get(j));
        }
    }
}
