package com.practices;

public class practiceSet7 {
    static void MultiplicationTable(int n){
        for(int i = 1; i<= 10;i++){
            System.out.println(n + " X " + i + " = " + n*i);
        }
    }

    static void patter1(int n){
        for(int i=0; i<n; i++){
            for(int j=n-i; j>1 ; j--){
                System.out.print(" ");
            }
            for(int j=i+1; j>0; j--){
                System.out.print("*");
            }

            System.out.println();
        }
    }

    static int summation(int n){
        if(n==1) return 1;
        else return (n + summation(n-1));

    }

    static void pattern2(int n){
        for(int i=0; i<n; i++){
            for(int j=n-i; j>0; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern2Recursion(int n){

       if(n>0){
           pattern2Recursion(n-1);
           for(int j=0; j<n; j++){
               System.out.print("*");
           }
           System.out.println();
       }
       else return;
    }

    static void pattern1_rec(int n){
        if(n>0){

            for(int j=0; j<n-1; j++){
                System.out.print(" ");
            }
            int k = 5-n+1;
            while(k != 0){
                System.out.print("*");
                k--;
            }
            System.out.println();
            pattern1_rec(n-1);

        }
        else return;
    }

    static int fibonacci(int n){
        if(n == 1 || n == 2) return 1;
        else return (fibonacci(n-1)+ fibonacci(n-2));
    }

    static float average(float ...arr){
        float sum = 0;
        for(float x: arr){
            sum = sum + x;
        }
        return (sum/arr.length);
    }

    static float TempConverter(float celsius){
        return (float) (celsius * (9.0/5.0) + 32.0);
    }

    static int summationIterative(int n){
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += i+1;
        }

        return sum;
    }

    public static void main(String[] args) {
        // Question 1
//        MultiplicationTable(15);

        // Question 2
//        patter1(13);

        // Question 3
//        System.out.println("Summation: " + summation(10));

        // Question 4
//        pattern2(5);

        // Question 5
//        System.out.println(fibonacci(10));

        // Question 6
//        System.out.println("Average is: " + average(2,3,5) );

        // Question 7
//        pattern2Recursion(5);
        // Question 8
//        pattern1_rec(5);

        // Question 9
//        System.out.println("Fahrenheit: " + TempConverter(28));

        // Question 10
//           System.out.println("Summation: " + summationIterative(10));


    }
}
