package DSA;

public class Heap {
    int size = 0;

    void insert(int[] array, int value){
        int id;
        id = ++size;
        array[id] = value;

        while(id>1 && array[id/2]<array[id]){
            int temp = array[id/2];
            array[id/2] = array[id];
            array[id] = temp;

            id = id/2;
        }
    }

    void print(int[] array){
        for(int i=1;i<=size;i++){
            System.out.println(array[i]);
        }
    }

    // main function activity
    //    public static void main(String[] args){
//        int[] ar = new int[6];
//        Scanner sc = new Scanner(System.in);
//
//        // max heap starts....
//        Heap h = new Heap();
//        for(int i=1 ; i<ar.length; i++){
//            int x = sc.nextInt();
//            h.insert(ar, x);
//        }
//        h.print(ar);
//        // max heap ends here....
//
//    }


}
