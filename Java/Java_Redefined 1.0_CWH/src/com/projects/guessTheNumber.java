package com.projects;

import java.util.Random;
import java.util.Scanner;

/*
Create a class Game, which allows a user to play "Guess the Number" game once. Game should have the following methods:
    Constructor to generate the random number
    takeUserInput() to take a user input of number
    isCorrectNumber() to detect whether the number entered by the user is true
    getter and setter for noOfGuesses
Use properties such as noOfGuesses(int), etc to get this task done!
 */

class Game {
    private int noOfGuesses = 0;
    int pc_guess;
    int user_guess = 0;

    // constructor
    public Game() {
        Random rand = new Random();
        this.pc_guess = rand.nextInt(15);
    }

    // user input
    public void takeUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your number: ");
        user_guess = sc.nextInt();
    }

    // check input number
    public boolean isCorrectNumber() {
        return user_guess == pc_guess;
    }

    // core method of playing game
    public void play() {
        this.takeUserInput();

        if (this.isCorrectNumber()) {
            System.out.println(
                    "\n-----------------------------------\n"
                            + "         " +  "Bingo!! You Wins"
                            + "\n-----------------------------------\n"
            );
            System.out.println("Total attempt: " + getNoOfGuess());
        } else {
            setNoOfGuess();
            if (user_guess > pc_guess) {
                System.out.println("Your number is <GREATER> than PC's Number");
            } else if (user_guess < pc_guess) {
                System.out.println("Your number is <SMALLER> than PC's Number");
            }
            play();
        }
    }

    //getter
    public int getNoOfGuess() {
        return noOfGuesses;
    }

    //setter
    public void setNoOfGuess() {
        noOfGuesses += 1;
    }

}

public class guessTheNumber {
    public static void main(String[] args) {
        Game pl1 = new Game();
        pl1.play();
    }
}
