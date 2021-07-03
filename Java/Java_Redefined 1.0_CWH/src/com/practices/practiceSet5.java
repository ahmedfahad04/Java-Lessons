/*
 * Practice Problem on Loops(for, while)
 */
package com.practices;

/**
 *
 * @author ahmed
 */
public class practiceSet5 {
    public static void main(String []args){
        //Question 1
        for(int i=0; i < 5; i++){
            for(int j=5-i; j>0; j--){
                System.out.print("*");
            }
            System.out.println("\n");
        }
        
        //Question 2
        int n=10;
        int sum=0, i=2;
        
        while(i <= 2*n){
            sum += i;
            i+=2;
        }
        
        System.out.println("First "+ n +" even number summation: " + sum);
              
        // Question 3
        System.out.println("Find Mulitplication Table Of n");
        int m=5;
        for (int j=1; j<=10; j++){
            System.out.println(m + "x" + j + " = " + m*j);
        }
        
        //Question 4
        System.out.println("Mulitplication Table Of 10 in revere order");
        for (int j=10; j>=1; j--){
            System.out.println(10 + "x" + j + " = " + 10*j);
        }
        
        //Question 5
        int num = 8;
        System.out.println("Find Factorials");
        long fact = 1;
        for(i=num; i>0; i--){
            fact *= i;
        }
        
        System.out.println("Factorial of " + num + " is: " + fact);
        
        //Question 6
        int j = num;
        int factorial = 1;
        while (j>0){
            factorial *= j;
            j--;
        }
        System.out.println("Factorial (using While loop) of " + num + " is: " + factorial);
        
        //Question 7
        System.out.println("Pattern Printing useing while loop");
        n = 5; // number of rows of the  pattern
        i = 0;
        while(i<n){
            j = n - i;
            while(j>0){
                System.out.print("*");
                j--;
            }
            System.out.println("\n");
            i++;
            
        }
        
        
       //Question 8
       System.out.println("Summation of the results of 8th Multiplicaition table");
       sum=0;
       n = 5;
       for (j=10; j>=1; j--){
            System.out.println(n + "x" + j + " = " + n*j);
            sum+=n*j;
        }
       
       System.out.println("Summation: " + sum);
       
       //Question 9
       System.out.println("Summation of first nth even numbers");
       n = 5;
       sum = 0; 
       for(i=2; i<=2*n; i+=2){
           sum += i;
       }
       
       System.out.println("Summation: " + sum);
        
        
    }
}
