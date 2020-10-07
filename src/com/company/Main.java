package com.company;

import com.company.Personale.Personale;

public class Main {

    public static void main(String[] args) {
        System.out.println("CP1");
        DatabaseConnectionManager.getDatabaseConnection();
        Personale objPersonale = new Personale();

    }
}
