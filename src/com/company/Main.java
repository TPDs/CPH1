package com.company;

import com.company.Personale.Personale;
import com.company.Util.Client;
import com.company.Util.Server;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("CP1");
        DatabaseConnectionManager.getDatabaseConnection();
        Personale objPersonale = new Personale();

        System.out.println("Tast 1 for Tårn mode ");
        System.out.println("Tast 2 for Fly mode ");
        System.out.println("Tast 3 for Personal mode ");
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

            case 3:
                Client cl = new Client();
                cl.client();
                break;

        }
    }
}