package IP;

import java.util.HashMap;

public class subArraySumK {
    public static void main(String[] args) {
        int[] nums = {2,3,-1,4,-5,1,6,-4,3,-1,4};
        int k = 4;
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(count);
    }
}
