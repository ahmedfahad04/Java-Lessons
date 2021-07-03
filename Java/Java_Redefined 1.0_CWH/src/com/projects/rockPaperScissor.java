package com.projects;

import java.util.Random;
import java.util.Scanner;

/*
 * @author ahmed
 */
public class rockPaperScissor {

    public static void main(String[] args) {
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();


        int pc_points = 0;
        int user_points = 0;
        while (true) {

            int pc_choice = rd.nextInt(3);
            System.out.print("Enter a random number between 0-2: ");

            int user_choice = sc.nextInt();
            user_choice = user_choice % 3;

            String user = null;
            String pc = null;

            switch (pc_choice) {
                case 0 -> pc = "Rock";
                case 1 -> pc = "Paper";
                case 2 -> pc = "Scissor";
            }

            switch (user_choice) {
                case 0 -> user = "Paper";
                case 1 -> user = "Rock";
                case 2 -> user = "Scissor";
            }

            //System.out.println("PC: " + pc + " --- " + "User: " + user);
            if (pc_choice == 0) {
                switch (user_choice) {
                    case 0 -> {
                        user_points++;
                    }
                    case 1 -> System.out.println("Tie");
                    case 2 -> {
                        pc_points++;
                    }
                }
            } else if (pc_choice == 1) {
                switch (user_choice) {
                    case 1 -> {
                        pc_points++;
                    }
                    case 0 -> System.out.println("Tie");
                    case 2 -> {
                        user_points++;
                    }
                }
            } else {
                switch (user_choice) {
                    case 1 -> {
                        user_points++;
                    }
                    case 2 -> System.out.println("Tie");
                    case 0 -> {
                        pc_points++;
                    }
                }
            }

            System.out.println("-------------------------------------------------");
            System.out.println("PC - " + pc + " - " + pc_points);
            System.out.println("USER - " + user + " - " + user_points);

            if (user_points == 5) {
                System.out.println(
                        "\n-----------------------------------\n"
                                + "             " + name + " Wins"
                                + "\n-----------------------------------\n"
                );
                break;
            } else if (pc_points == 5) {
                System.out.println(
                        "\n-----------------------------------\n"
                                + "             " + "PC Wins"
                                + "\n-----------------------------------\n"
                );
                break;
            }

        }

    }
}
