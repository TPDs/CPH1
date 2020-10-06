package com.company;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.Collection;

public class Log {

    String sql;
    String desc;

    @Override
    public boolean passengerOut(Plane plane){
        Connection conn = Database.getConnection();
        sql = "INSERT INTO Log(description) VALUES(?)";
        try{
            PreparedStatement passOut = conn.prepareStatement(sql);
            desc = "All passengers have left flight " + plane.id;

            passOut.setString(1, desc);

            int insertedRows = passOut.executeUpdate();
            if(insertedRows > 0){
                System.out.println("Log was successfully created(Passengers out)!");
            }
            return true;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }


    @Override
    public boolean passengersIn(Plane plane){
        Connection conn = Database.getConnection();
        sql = "INSERT INTO log(description) VALUES(?)";
        try{
            PreparedStatement passIn = conn.prepareStatement(sql);
            desc = "All passengers for flight " + plane.id + " have boardet the flight";

            passIn.setString(1, desc);

            int insertedRows = passIn.executeUpdate();
            if(insertedRows > 0){
                System.out.println("Log was successfully created(Passengers in)!");
            }
            return true;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }


    @Override
    public boolean bagageOff(Plane plane){
        Connection conn = Database.getConnection();
        sql = "INSERT INTO log(description) VALUES(?)";
        try{
            PreparedStatement bagOff = conn.prepareStatement(sql);
            desc = "Bagage from flight " + plane.id + " have been taken out";

            bagOff.setString(1, desc);

            int insertedRows = bagOff.executeUpdate();
            if(insertedRows > 0){
                System.out.println("Log was successfully created (Bagage off)!");
            }
            return true;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }


    @Override
    public boolean bagageOn(Plane plane){
        Connection conn = Database.getConnection();
        sql = "INSERT INTO log(description) VALUES(?)";
        try{
            PreparedStatement bagOn = conn.prepareStatement(sql);
            desc = "Bagage have been loaded on flight " + plane.id;

            bagOn.setString(1, desc);

            int insertedRows = bagOn.executeUpdate();
            if(insertedRows > 0){
                System.out.println("Log was successfully created (Bagage on)!");
            }
            return true;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }


    @Override
    public boolean fuelOnPlane(Plane plane){
        Connection conn = Database.getConnection();
        sql = "INSERT INTO log(description) VALUES(?)";
        try{
            PreparedStatement fuelOn = conn.prepareStatement(sql);
            desc = "Flight " + plane.id + " have been refueled";

            fuelOn.setString(1, desc);

            int insertedRows = fuelOn.executeUpdate();
            if(insertedRows > 0){
                System.out.println("Log was successfully created (Fuel on)!");
            }
            return true;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }


    @Override
    public boolean planeCleanedLog(Plane plane){
        Connection conn = Database.getConnection();
        sql = "INSERT INTO log(description) VALUES(?)";
        try {
            PreparedStatement planeClean = conn.prepareStatement(sql);
            desc = "Plane " + plane.id + " have been cleaned";

            planeClean.setString(1, desc);
            int insertedRows = planeClean.executeUpdate();
            if(insertedRows > 0){
                System.out.println("Log successfully created (Plane cleaned)!");
            }

            return true;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }

}
