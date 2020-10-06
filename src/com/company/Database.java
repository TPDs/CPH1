package com.company;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/?serverTimezone=CET";

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(DATABASE_URL, )
        }
    }
}
