package DSA;

public class BubbleSort {

    //        int[] num = {12,2,13,41,5};
//        for(int item: num){
//            System.out.print(item + " ");
//        }
//        sort(num);
//
//        System.out.println("\nAFTER Sorting....");
//        for(int item: num){
//            System.out.print(item + " ");
//        }

        public static void sort(int[] x){
        int n = x.length+1;
        int t;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-1; j++){
                if(x[i]<x[j]){
                    t = x[i];
                    x[i] = x[j];
                    x[j] = t;
                }

            }
        }
    }

//    public static <E extends Comparable<E>> void BubbleSort(E[] x, int size) {
//        int i, j;
//        E t;
//
//        for (i = 0; i < size; i++) {
//            for (j = 0; j < size; j++) {
//                if (x[i].compareTo(x[j]) < 0) {
//
//                    t = x[i];
//                    x[i] = x[j];
//                    x[j] = t;
//                }
//            }
//        }
//    }



}
