package com.company;

import com.company.Repository.DatabaseConnectionManager;
import com.company.Util.Client;
import com.company.Util.Server;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DatabaseConnectionManager.getDatabaseConnection();

        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_RESET = "\u001B[0m";

        System.out.println(ANSI_GREEN + " ________  ________  ___  ___           _____     \n" +
                "|\\   ____\\|\\   __  \\|\\  \\|\\  \\         / __  \\    \n" +
                "\\ \\  \\___|\\ \\  \\|\\  \\ \\  \\\\\\  \\       |\\/_|\\  \\   \n" +
                " \\ \\  \\    \\ \\   ____\\ \\   __  \\      \\|/ \\ \\  \\  \n" +
                "  \\ \\  \\____\\ \\  \\___|\\ \\  \\ \\  \\          \\ \\  \\ \n" +
                "   \\ \\_______\\ \\__\\    \\ \\__\\ \\__\\          \\ \\__\\\n" +
                "    \\|_______|\\|__|     \\|__|\\|__|           \\|__|\n" +
                "                                                  \n" +
                "                                                  \n" +
                "                                                  " + ANSI_RESET);


        System.out.println(ANSI_YELLOW+"Tast 1 for Tårn mode ");
        System.out.println("Tast 2 for Fly mode ");
        System.out.println("Tast 3 for Personal mode " +ANSI_RESET);


        Scanner sc = new Scanner(System.in);

        int pick = sc.nextInt();

        switch (pick) {
            case 1:
                int port = 48880;
                try {
                    Thread t = new Server(port);
                    t.start();
                } catch (IOException e) {

                    e.printStackTrace();
                }
                break;
            case 2:
                Client plane = new Client();
                plane.client("Plane");
                break;

            case 3:
                Client personal = new Client();
                personal.client("Personal");
                break;

        }
    }
}