/*
 *Practice problem on String operations.
 */

package com.practices;

import java.util.Scanner;

public class practiceSet3 {
    public static void main(String[] args) {
        //Question1:
        String a = "Istiaq Ahmed Fahad";
        System.out.println("Main: " + a + ", LowerCase: " + a.toLowerCase()) ;

        //Question2:
        System.out.println("Replaced spaces with underscores: "+ a.replace(" ", "_"));

        //Question3:
        String temp = "Hello <name>! Nice to meet you.";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter participants name: ");
        String name = sc.nextLine();
        System.out.println(temp.replace("<name>", name));

        //Questino3:
        String info = "Testing Double and  Triple space. Here we have  two double and one triple space";
        if(info.contains("  ")) System.out.println("Double space detected");
        if(info.contains("   ")) System.out.println("Triple space detected");

        //Question4:
        String data = "\" Dear Asad, How are you \", said by Kashem.";
        System.out.println(data);
    }
}
