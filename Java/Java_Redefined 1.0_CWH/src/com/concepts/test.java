package com.concepts;

import java.util.Scanner;


class Library{
    Scanner sc = new Scanner(System.in);
    String[] books = new String[100];
    int i=0;

    public void add(){
        System.out.print("Enter name: ");
        books[i] = sc.nextLine();
        i++;
        System.out.println("Book added Successfully");
    }

    public void issueBook() {
        System.out.println("Enter the book name you want to issue: ");
        String issue_book = sc.nextLine();

        for (int i = 0; i < books.length; i++) {
            if(books[i] != null) {
                if (books[i].equals(issue_book)) {
                    books[i] += " [issued]";
                    System.out.println("Issue successful");
                    return;
                }
            }
        }
        System.out.println("Book not found. Try again");

    }

    public void returnBook() {
        System.out.println("Enter the book name you want to return: ");
        String return_book = sc.nextLine();

        for (int i = 0; i < books.length; i++) {
            if(books[i] != null){
                if (books[i].contains(return_book)) {
                    books[i] = books[i].replace(" [issued]", "");
                    System.out.println("Return book successful");
                    return;
                }
            }

        }
        System.out.println("Book name is not valid. Try again later.");

    }

    public void showAvailableBooks(){
        System.out.println("Available books are: ");
        int i = books.length;

        if (i == 0) {
            System.out.println("No books available");
        } else {
            for(int j=0; j<i; j++){
                if(books[j]!=null){
                    System.out.println(j+1 + ". " + books[j]);
                }
            }

        }
    }

    public void print(){
        System.out.println("""
                Enter your choices:
                1. Add Books
                2. Issue Books
                3. Return Books
                4. Available Books
                0. Exit
                """);
    }

    public void run(){
        Scanner sc =new Scanner(System.in);

        print();
        System.out.print("Choice: ");
        int i = sc.nextInt();

        while(i!=0){
            if(i == 1) {
                this.add();
            }

            else if(i == 2) {
                this.issueBook();
            }

            else if(i == 3){
                this.returnBook();
            }

            else{
                this.showAvailableBooks();
            }

            print();
            System.out.print("Choice: ");
            i = sc.nextInt();
        }
    }

}

public class test {


    public static void main(String[] args) {

        Library cr = new Library();
        cr.run();

    }
}
