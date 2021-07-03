/*
 * Practice Problem on Array
 */
package com.practices;

/**
 *
 * @author ahmed
 */
public class practiceSet6 {
    public static void main(String[]args){
       
        //Question 1
        float[] num = {2.5f,14.6f,2.6f,3.4f,2.9f};
        float sum = 0.0f;
        for(float x: num){
            sum += x;
        }
        
        System.out.println("Summation of the float array: " + sum);
        
        // Question 2
        int req = 15;
        int[] numbers = {5,74,8,1,6,8,6,4,8,1};
        int flag = 0; 
        for(int x: numbers){
            if(x == req){
                flag = 1;
                break;
            }
        }
        if(flag==1) System.out.println(req + " is present.");
        else System.out.println(req  + " is not found");
        
        //Question 3
        int[] physics = {89,95,90,96,85,80,41,69,71,72,75};
        sum += 0;
        for(int x: physics){
            sum += x;
        }
        System.out.println("Average of Physics Marks: " + sum/physics.length);
        
        //Question 4
        int[][] mat1 = {
            {1,2,3},
            {4,5,6}   
        };
        
        int[][] mat2 = {
            {6,5,4},
            {3,2,1}   
        };
        
        int[][] res = {
            {0,0,0},
            {0,0,0}
        };
        
        for(int row=0; row<mat1.length; row++){
            for(int col = 0; col < mat1[0].length; col++){
                res[row][col] = mat1[row][col] + mat2[row][col];
            }
        }
        
        System.out.println("Matrix Summation result.");
        for(int row=0; row<mat1.length; row++){
            for(int col = 0; col < mat1[0].length; col++){
                System.out.print(res[row][col] + " ");
            }
            System.out.println();
        }
        
        //Question 5
        int size = numbers.length;
        
        System.out.println("Actual Array");
        for(int i: numbers){
            System.out.print(i + " ");
        }
        
        for(int i=0; i<size/2; i++){ // loop size must be half of array size
            //swapping elements
            int temp = numbers[i];
            numbers[i] = numbers[size-i-1];
            numbers[size-i-1] = temp;
        }

        System.out.println("\nReversed Array");
        for(int j: numbers){
            System.out.print(j + " ");
        }
        
        //Question 6,7
        int max = 0;
        int min = 110;
        for(int number: physics){
            if(number > max) max = number;
            if(number < min) min = number;
        }
        
        System.out.println("\nHeighst mark in Physics is: " + max);
        System.out.println("Lowest mark in Physics is: " + min);
        
        //Question 8
        int[] physic = {2,1,3,4,5};
        int f = physic[0];
        flag = 1;
        for(int i = 1; i< physic.length; i++){
            if(f<physic[i]) continue;
            else{
                flag = 0;
                System.out.println("Its not a sorted array");
                break;
            }
        }
        
        if(flag == 1) System.out.println("Its Sorted");
        
    }
    
}
