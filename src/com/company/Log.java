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

    public boolean passengerOut(Plane plane){
        Connection conn = DatabaseConnectionManager.getDatabaseConnection();
        sql = "INSERT INTO FlyEventList(Planelist_idPlane, task, Status, Time) VALUES(?, ?, ?, ?)";
        try{
            PreparedStatement passOut = conn.prepareStatement(sql);

            passOut.setInt(1, plane.getId());
            passOut.setString(2, "Passengers out");
            passOut.setString(3, "Pending");
            //passOut....time(4, time.getTime() + plane.getSize());



            int insertedRows = passOut.executeUpdate();
            if(insertedRows > 0){
                System.out.println("Log was successfully created(Passengers out)!");
            }
            return true;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }


    public boolean passengersIn(Plane plane){
        Connection conn = DatabaseConnectionManager.getDatabaseConnection();
        sql = "INSERT INTO FlyEventList(Planelist_idPlane, task, Status, Time) VALUES(?, ?, ?, ?)";
        try{
            PreparedStatement passIn = conn.prepareStatement(sql);
            desc = "All passengers for flight " + plane.getId() + " have boardet the flight";

            passIn.setString(1, desc);

            int insertedRows = passIn.executeUpdate();
            if(insertedRows > 0){
                System.out.println("Log was successfully created(Passengers in)!");
            }
            return true;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }


    public boolean bagageOff(Plane plane){
        Connection conn = DatabaseConnectionManager.getDatabaseConnection();
        sql = "INSERT INTO worklog(Personale_id, task, starttime, endtime) VALUES(?, 'Bagage Off', ?, ?)";
        try{
            PreparedStatement bagOff = conn.prepareStatement(sql);
            desc = "Bagage from flight " + plane.getId() + " have been taken out";

            bagOff.setString(1, desc);

            int insertedRows = bagOff.executeUpdate();
            if(insertedRows > 0){
                System.out.println("Log was successfully created (Bagage off)!");
            }
            return true;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }


    public boolean bagageOn(Plane plane){
        Connection conn = DatabaseConnectionManager.getDatabaseConnection();
        sql = "INSERT INTO worklog(Personale_id, task, starttime, endtime) VALUES(?, 'Bagage on', ?, ?)";
        try{
            PreparedStatement bagOn = conn.prepareStatement(sql);
            desc = "Bagage have been loaded on flight " + plane.getId();

            bagOn.setString(1, desc);

            int insertedRows = bagOn.executeUpdate();
            if(insertedRows > 0){
                System.out.println("Log was successfully created (Bagage on)!");
            }
            return true;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }


    public boolean fuelOnPlane(Plane plane){
        Connection conn = DatabaseConnectionManager.getDatabaseConnection();
        sql = "INSERT INTO worklog(Personale_id, task, starttime, endtime) VALUES(?, 'Fuel on', ?, ?)";
        try{
            PreparedStatement fuelOn = conn.prepareStatement(sql);
            desc = "Flight " + plane.getId() + " have been refueled";

            fuelOn.setString(1, desc);

            int insertedRows = fuelOn.executeUpdate();
            if(insertedRows > 0){
                System.out.println("Log was successfully created (Fuel on)!");
            }
            return true;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }


    public boolean planeCleanedLog(Plane plane){
        Connection conn = DatabaseConnectionManager.getDatabaseConnection();
        sql = "INSERT INTO worklog(Personale_id, task, starttime, endtime) VALUES(?, 'Plane cleaned', ?, ?)";
        try {
            PreparedStatement planeClean = conn.prepareStatement(sql);
            desc = "Plane " + plane.getId() + " have been cleaned";

            planeClean.setString(1, desc);
            int insertedRows = planeClean.executeUpdate();
            if(insertedRows > 0){
                System.out.println("Log successfully created (Plane cleaned)!");
            }

            return true;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}
