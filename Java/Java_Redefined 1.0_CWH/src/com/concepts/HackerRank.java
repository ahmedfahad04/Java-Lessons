package com.concepts;

import java.io.IOException;
import java.util.Scanner;

public class HackerRank {

    public static int flag = 0;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
//        for(int i=0;i<3;i++)
//        {
//            String s1=sc.next();
//            int x=sc.nextInt();
//
//
//            System.out.printf("%-15s%03d\n",s1,x); // left aligned and with one leading zero
//            //Complete this line
//        }
//        int t=sc.nextInt();
//
//        for(int i=0;i<t;i++)
//        {
//            try
//            {
//                long x=sc.nextLong();
//                System.out.println(x+" can be fitted in:");
//                if(x>=-128 && x<=127)System.out.println("* byte");
//                if(x>=-32768 && x<=32767)System.out.println("* short");
//                if(x>=-1*Math.pow(2,31) && x<=Math.pow(2,31)-1)System.out.println("* int");
//                if(x>=-1*Math.pow(2,63) && x<=Math.pow(2,63)-1)System.out.println("* long");
//                //Complete the code
//            }
//            catch(Exception e)
//            {
//                System.out.println(sc.next()+" can't be fitted anywhere.");
//            }
//
//        }

//        boolean a;
//        int i=1;
//        while((a = sc.hasNext())){ //take input until end of line
//            String x = sc.nextLine();
//            System.out.println(i + " "+ x);
//            i++;
//        }

        int B = sc.nextInt();
        int H = sc.nextInt();
        if(B<=0 || H<=0) System.out.println("java.lang.Exception: Breadth and height must be positive");
        else{
            System.out.println(B*H);
        }



        System.out.println("================================");

    }
}
