package Leetcode;

import java.util.*;

public class Solution {
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int idx = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[res.size()];
        for (int num : res) {
            result[idx++] = num;
        }
        return result;

    }

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> hm = new HashSet<>(); //for storing common elements
        Arrays.sort(nums2); // to use binary search

        for (Integer num : nums1) {
            if (binarySearch(nums2, num)) {//elems of arr1 present in arr2
                hm.add(num);
            }
        }

        int[] result = new int[hm.size()]; // to return arr
        int index = 0;
        for (int num : hm) {// hashSet to array
            result[index++] = num;
        }

        return result;
    }

    public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 3, 5, 5, 6};
        int[] arr2 = {1, 2, 3, 3, 5, 6, 7};

        int[] array = intersect(arr1, arr2);                    // obtain the array
        System.out.println(Arrays.toString(array)); // now print it


    }
}
