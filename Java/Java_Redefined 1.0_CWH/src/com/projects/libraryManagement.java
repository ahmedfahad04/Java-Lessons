package com.projects;

// You have to implement a library using Java Class "Library"
// Methods: addBook, issueBook, returnBook, showAvailableBooks
// Properties: Array to store the available books,
// Array to store the issued books

import java.util.Scanner;

class Library {
    Scanner sc = new Scanner(System.in);

    String[] books = new String[100];
    int id = 0;

    public String takeInput(){
        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();
        return name;
    }

    public void addBook() {

        books[id] = takeInput();
        id++;
        System.out.println("Book added successfully");

    }

    public void issueBook() {
        System.out.println("Enter the book name you want to issue: ");
        String issue_book = sc.nextLine();

        for (int i = 0; i < books.length; i++) {
            if (books[i].equals(issue_book)) {
                books[i] += " [issued]";
                System.out.println("Issue successful");
            }
        }

    }

    public void returnBook() {
        System.out.println("Enter the book name you want to return: ");
        String return_book = sc.nextLine();

        for (int i = 0; i < books.length; i++) {
            if (books[i].contains(return_book)) {
                books[i].replace(" [issued]", "");
                System.out.println("Return book successful");
            }
        }

    }

    public void showAvailableBook() {
        System.out.println("Available books are: ");
        int i = books.length;

        if (i == 0) {
            System.out.println("No books available");
        } else {
            for (String name : books) {
                if (name != null) {
                    System.out.println(i + ". " + name);
                }
            }
        }
    }

    public void execute() { // here is the main issue
        System.out.println("""
                Enter your choices:
                1. Add Books
                2. Issue Books
                3. Return Books
                4. Available Books
                5. Exit
                """);

        System.out.print("Choice: ");
        int i = sc.nextInt();

        while (i != 0) {

            if (i == 1) {
                this.addBook();
            } else if (i == 2) {
                this.issueBook();
            } else if (i == 3) {
                this.returnBook();
            } else {
                this.showAvailableBook();
            }

            System.out.print("Choice: ");
            i = sc.nextInt();
        }

    }
}

public class libraryManagement {
    public static void main(String[] args) {

        Library customer1 = new Library();
        customer1.execute();
    }
}
