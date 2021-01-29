package IP;

public class MaximumSwap {
    public static void main(String[] args) {
        int num = 99888569;
        char[] A = Integer.toString(num).toCharArray();
        System.out.println("Printing out A: ");
        for(int i =0; i < A.length; i++){
            System.out.print(A[i] -'0'+ " ");
        }
        System.out.println();
        System.out.println();


        int[] lastIndex = new int[10];
        for (int i = 0; i < A.length; i++) { // at i we have lastIndex occurrence of digit i
            lastIndex[A[i] - '0'] = i;
        }
        System.out.println();
        System.out.println("Printing out lastIndex: ");
        for(int i =0; i < lastIndex.length; i++){
            System.out.print(lastIndex[i] + " ");
        }
        System.out.println();
        System.out.println();

        for (int i = 0; i < A.length; i++) {
            for (int j = 9; j > A[i] - '0'; j--) { // kya j se bada banda hai kahi? Kya 9 se bada hai , kya 2 se bada hai
                System.out.println("i= "+i);
                System.out.println("j= "+j);
                System.out.println("A[i] - '0' = "+ A[i]);
                System.out.println("lastIndex[j] = "+lastIndex[j]);

                if (lastIndex[j] > i) { // kya mere baad hai bada number
                    System.out.println("True  mere baad hai bada number");
                    char tmp = A[i];
                    A[i] = A[lastIndex[j]];
                    A[lastIndex[j]] = tmp;
                    System.out.println(Integer.valueOf(new String(A)));
                    System.out.println("break");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                }
            }
        }
    }
}
