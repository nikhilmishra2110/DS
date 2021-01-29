package String;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IntroArrays {
    public static void main(String[] args) {
        int []arr = {4,3,2,7,8,2,3,1};
        findDisappearedNumbers(arr);
    }
        public static void findDisappearedNumbers(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int newIndex = Math.abs(nums[i]) - 1;
                System.out.println("i = "+i);
//                System.out.println("nums[i] = "+nums[i]);
                System.out.println("newIndex = "+ newIndex);
                System.out.println("nums[newIndex] = "+nums[newIndex]);
                System.out.println("Doing nums[newIndex] *= -1;");

                if (nums[newIndex] > 0) {
                    nums[newIndex] *= -1;
                }

                for(int j=0; j< nums.length; j++){
                    System.out.print(nums[j]+" ");
                }
                System.out.println();
                System.out.println();
            }
            List<Integer> result = new ArrayList<>();
            for (int i = 1; i <= nums.length; i++) {
                if (nums[i - 1] > 0) {
                    result.add(i);
                }
            }
            for(int i:result){
                System.out.println(i);
            }
        }
    }




