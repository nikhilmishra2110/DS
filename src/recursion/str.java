package recursion;

import java.util.ArrayList;

public class str {
    public static void main(String[] args) {
//        String str = "Nikhil Mishra";
//        System.out.println(str);
////        char ch = str.charAt(0);
////        System.out.println(ch);
//        for (int i =0; i < str.length(); i++){
//            char ch = str.charAt(i);
//            System.out.println(ch);
//
//        }
//
//        String ss = str.substring(1,4);
//        System.out.println(ss);
//        String ss1 = str.substring(4);
//        System.out.println(ss1);

        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(list);
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(10);
//        System.out.println(list);
//        System.out.println(list.size());
//        for (int val: list){
//            System.out.println(val);
//        }
        list.set(2,3212);
        for (int i =0; i <list.size();i++){
            int val = list.get(i);
            System.out.println(val);
        }


    }

}

