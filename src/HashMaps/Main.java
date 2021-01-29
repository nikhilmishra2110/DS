//package HashMaps;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//
//public class Main {
//    public static void main(String[] args) {
//      /*  HashMap<String, Integer> hm = new HashMap<>();
//        hm.put("India", 100);
//        hm.put("UK", 20);
//        hm.put("Japan", 14);
//        hm.put("US", 34);
//        System.out.println(hm.get("US"));
//        System.out.println(hm.get("UU"));
//        System.out.println("hm.containsKey(India)"+hm.containsKey("India"));
//        System.out.println(hm.containsKey("USA"));
//        System.out.println(hm.containsValue(10));
//        System.out.println(hm );
//         hm.put("Nigeria", 3124);
//        System.out.println(hm );
//
//        Set<String> keys = hm.keySet();
//        System.out.println(keys );
//
//        //loop over a hashmap using a keySet
//        for(String key: hm.keySet()){
//            System.out.println(key + " : "+ hm.get(key));
//        }*/
//
////        highestFrequencyCharacter("abracadabra");
////
//        int[] arr1 = {1, 1, 2, 2, 2, 3, 5};
//        int[] arr2 = {1, 1, 1, 2, 2, 4, 5};
//        int[] arr3 = {10, 5, 9, 1, 11, 8, 6, 15, 3, 12, 2};
//        int[] arr4 = {2,5,5,6,3,2,3,2,4,5,2,2,2,2,3,6};
//        int[] arr5 = {2,8,-3,-5,2,-4,6,1,2,1,-3,4};
////        getCommonElementInTwoArrays(arr1, arr2);
////        getCommonElementInTwoArrays_2(arr1, arr2);
////        getCommonElementInTwoArrays_HashSet(arr1, arr2);
////        longestConsecutiveSubsequence(arr3);
////        lcss(arr3);
////        System.out.println(distinctInKItems(arr4,4));
////        System.out.println(largestSubarrayWithZeroSum(arr5, 3));
//        int [] a = {1,2,3,4,5,10,6,7,8,9};
//        System.out.println(canArrange(a, 5));
//    }
//
//
//    public static void highestFrequencyCharacter(String str) {
//        /*
//         * TAP:
//         *   Init ke time capital wale char and int use karne honge
//         * Bad me bhale hi smal use kar lo
//         * agar present hai to existing me one add karna hai nao to set karna hai bas
//         * keySet se loop laga sakte hai
//         * */
//        HashMap<Character, Integer> hm = new HashMap<>();
//        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            if (hm.containsKey(c)) {
//                hm.put(c, hm.get(c) + 1);
//            } else {
//                hm.put(c, 1);
//            }
//        }
//        int maxVal = Integer.MIN_VALUE;
//        char maxChar = str.charAt(0);
//        for (Character key : hm.keySet()) {
//            if (hm.get(key) > maxVal) {
//                maxVal = hm.get(key);
//                maxChar = key;
//            }
//        }
//        System.out.println(maxVal);
//        System.out.println(maxChar);
//    }
//
//
//    public static void getCommonElementInTwoArrays(int[] arr1, int[] arr2) {
//        /*TAP:
//         * make hashmap of char frequency for first array(can also use hashset or boolen hashmap)
//         * loop over second array and if data is present in hashmap 1 then
//         *   print tht element and
//         *   delete that element
//         * */
//        HashMap<Integer, Integer> hm = new HashMap<>();
//       /* for(int i=0; i < arr1.length; i++){
//            if(hm.containsKey(arr1[i])){
//                hm.put(arr1[i], hm.get(arr1[i])+ 1);
//            } else{
//                hm.put(arr1[i], 1);
//            }
//        }*/
//        for (int val : arr1) {
//            if (hm.containsKey(val)) {
//                int of = hm.get(val);
//                int nf = of + 1;
//                hm.put(val, nf);
//            } else {
//                hm.put(val, 1);
//            }
//
//        }
///*        for(int i=0; i < arr2.length; i++){
//            if(hm.containsKey(arr2[i])){
//                System.out.print(arr2[i]+" ");
//                hm.remove(arr2[i]);
//            }
//        }*/
//        for (int val : arr2) {
//            if (hm.containsKey(val)) {
//                System.out.println(val);
//                hm.remove(val);
//            }
//        }
//
//    }
//
//
//    public static void getCommonElementInTwoArrays_2(int[] arr1, int[] arr2) {
//        /*TAP:
//         * make hashmap of char frequency for first array(can also use hashset or boolen hashmap)
//         *
//         * */
//        HashMap<Integer, Integer> hm = new HashMap<>();
//        for (int val : arr1) {
//            if (hm.containsKey(val)) {//exist karta
//                int of = hm.get(val);
//                int nf = of + 1;
//                hm.put(val, nf);
//            } else {// exist nahi karta
//                hm.put(val, 1);
//            }
//        }//freq map bhar gaya
//
//        for (int val : arr2) {
//            if (hm.containsKey(val)) {
//                if (hm.get(val) > 0) {
//                    System.out.print(hm.get(val) + " ");
//                }
//                int of = hm.get(val);
//                int nf = of - 1;
//                hm.put(val, nf);
//            }
//        }
//    }
//
//    public static void longestConsecutiveSubsequence(int[] arr) {
//        /* HashMap of integer and boolean
//         *   Boolean represent that a sequence starts from here or not
//         * val se chota pada hai to wo shuruwat nahi ho sakta - false karo
//         * sare ture uthao an with badhao - find max width
//         * */
//        HashMap<Integer, Boolean> hm = new HashMap<>();
//
//        for (int val : arr) {
//            hm.put(val, true);
//        }// sabko true bana diya
//
//        for (int val : arr) {
//            if (hm.containsKey(val - 1)) {
//                hm.put(val, false);
//            }
//        }// false kar deta hai jinka ek chota available hai
//
//        int maxLen = 0;
//        int maxStart = 0;
//        for (int val : arr) {
//            if (hm.get(val) == true) {
//                int start = val;
//                int width = 1;
//                while (hm.containsKey(start + width)) {
//                    width++;
//                }
//                if (width > maxLen) {
//                    maxLen = width;
//                    maxStart = start;
//                }
//            }
//        }
//        System.out.println(maxLen);
//    }
//
//
//    private static void findCount(HashMap<String, String> map) {
//        HashMap<String, HashSet<String>> tree = new HashMap<>();
//        String ceo = ""; // tree root
//        for (String employee : map.keySet()) {
//            String manager = map.get(employee);
//            if (manager.equals(employee)) {
//                ceo = manager;
//            } else { // this  is common code and remains the same most of the times
//                if (tree.containsKey(manager)) {
//                    HashSet<String> employees = tree.get(manager);
//                    employees.add(employee);
//                } else {
//                    HashSet<String> employees = new HashSet<>();
//                    employees.add(employee);
//                    tree.put(manager, employees);
//                }
//            }
//        }
//        HashMap<String, Integer> result = new HashMap<>();
//        getSize(tree, ceo, result);
//        for (String emp : result.keySet()) {
//            System.out.println(emp + " " + result.get(emp));
//        }
//    }
//
//    public static int getSize(HashMap<String, HashSet<String>> tree, String manager, HashMap<String, Integer> result) {
//        // Just like generic tree sum - left ka sizr + right ka size + 1
//        // return 6 and khud pe 5
//        if (tree.containsKey(manager) == false) {//Base case
//            result.put(manager, 0);
//            return 1;
//        }
//
//        int size = 0;
//        for (String emp : tree.get(manager)) {
//            int childSize = getSize(tree, emp, result);
//            size += childSize;
//        }
//        result.put(manager, size);
//        return size + 1;
//    }
//
///*
//    public findItenary()
//    {
//        *//*  4
//            Chennai Banglore
//            Bombay Delhi
//            Goa Chennai
//            Delhi Goa *//*
//
//        Scanner scn = new Scanner(System.in);
//        int noofpairs_src_des = scn.nextInt();
//        HashMap<String, String> map = new HashMap<>();
//        for (int i = 0; i < noofpairs_src_des; i++) {
//            String s1 = scn.next();
//            String s2 = scn.next();
//            map.put(s1, s2);
//        }
//
//
//
//    }*/
//
//
//    public static boolean canArrange(int[] arr, int k) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int n : arr) {
//            int rem = n % k;
//            System.out.println("Remainder ==> " + rem);
////            if (rem < 0) rem += k;
//            map.put(rem, map.getOrDefault(rem, 0) + 1);
//            System.out.println("\t Inserted in map " + map);
//        }
//        for (int key : map.keySet()) {
//            if (key == k - key || key == 0) {
//                if (map.get(key) % 2 != 0) return false;
//            } else if (!map.get(key).equals(map.getOrDefault(k - key, 0)))
//                return false;
//        }
//        return true;
//    }
//
//
//    public static ArrayList<Integer> distinctInKItems(int []arr, int k){
//        ArrayList<Integer> list = new ArrayList<>();
//        HashMap<Integer, Integer> hm  = new HashMap<>();
//        for(int i = 0; i <= k-2; i++){
//            hm.put(arr[i], hm.getOrDefault(arr[i],0) + 1);
//        }
//
//        for(int i = k-1, j=0; i < arr.length;){
//            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
//            list.add(hm.size());
//            int freq = hm.get(arr[j]);
//            if (freq ==1){
//                hm.remove(arr[j]);
//            } else{
//                hm.put(arr[j], freq-1);
//            }
//            i++;
//            j++;
//        }
//      return list;
//    }
//
//    public static Integer largestSubarrayWithZeroSum(int[]arr, int k){
//        HashMap<Integer, Integer> hm = new HashMap<>();
//        int i = -1;
//        int sum = 0;
//        hm.put(sum,i);
//        int maxLen = 0;
//        while(i < arr.length-1){
//            i++;
//            sum+=arr[i];
//            if(hm.containsKey(sum) ==false){
//                hm.put(sum, i);
//            } else{
//                int len = i - hm.get(sum);
//                if(len>maxLen){
//                    maxLen = len;
//                }
//            }
//        }
//    return maxLen;
//    }
//
//public static int countofZeroSumSubarray(int [] arr){
//        int count  =0;
//        HashMap<Integer, Integer> hm = new HashMap<>();
//
//        int i = -1;
//        int sum = 0;
//        hm.put(sum, i);
//        while(i < arr.length-1){
//            i++;
//            sum+=arr[i];
//
//
//            if(hm.containsKey(sum)){
//                count+= hm.get(sum);
//                hm.put(sum, hm.get(sum)+1);
//            }else {
//                hm.put(sum, i);
//
//            }
//        }
//        return count;
//
//}
//
//
//    public static String minimumWindowSubstring(String s1, String s2)
//    {
//        String ans = "";
//        HashMap<Character, Integer> map2 = new HashMap<>();
//        for(int i = 0; i < s2.length(); i++){
//            char ch = s2.charAt(i);
//            map2.put(ch, map2.getOrDefault(ch, 0)+ 1);
//        }
//
//
//        int mct = 0;//match count
//        int dsmt = s2.length();//desired match count
//        HashMap<Character, Integer> map1 = new HashMap<>();
//        int i = -1;
//        int j = -1; // using twp pointers
//
//        while(true){
//            boolean f1 = false;
//            boolean f2 = false;
//            //acquire
//            while(i <s1.length() -1 && mct < dmct){
//                i++;
//                char ch = s1.charAt(i);
//                map1.put(ch, map1.getOrDefault(ch,0)+ 1);
//
//                if (map1.getOrDefault(ch, 0) <= map1.getOrDefault(ch, 0)) {// freq comparision
//                    mct++;
//                    }
//                f1 = true;
//                }
//
//            //collect answer and release
//            while(j< i && mct == dmct){
//                String pans = s1.substring(j+1, i+1);
//                if(ans.length()==0 || pans.length()<ans.length()){
//                    ans = pans;
//                }
//                j++;
//                char ch = s1.charAt(j);
//
//                if(map1.get(ch)==1){
//                    map1.remove(ch);
//                }else{
//                    map1.put(ch, map1.get(ch)-1);
//                }
//
//                if(map1.getOrDefault(ch,0)< map2.getOrDefault(ch, 0)){// freq comparision
//                    mct--;
//                }
//                f2 = true;
//            }
//            if(f1==false && f2==false){
//                break;
//            }
//            }
//        return ans;
//        }
//
//
//
//    }
//
//
