package com.company;

import com.company.AirPlane.Plane;
import com.company.Repository.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

            passIn.setInt(1, plane.getId());
            passIn.setString(2, "Passengers In");
            passIn.setString(3, "Pending");
            //passOut....time(4, time.getTime() + plane.getSize());

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
        sql = "INSERT INTO FlyEventList(Planelist_idPlane, task, Status, Time) VALUES(?, ?, ?, ?)";
        try{
            PreparedStatement bagOff = conn.prepareStatement(sql);
            desc = "Bagage from flight " + plane.getId() + " have been taken out";

            bagOff.setInt(1, plane.getId());
            bagOff.setString(2, "Bagage off");
            bagOff.setString(3, "Pending");
            //passOut....time(4, time.getTime() + plane.getSize());

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
        sql = "INSERT INTO FlyEventList(Planelist_idPlane, task, Status, Time) VALUES(?, ?, ?, ?)";
        try{
            PreparedStatement bagOn = conn.prepareStatement(sql);
            desc = "Bagage have been loaded on flight " + plane.getId();

            bagOn.setInt(1, plane.getId());
            bagOn.setString(2, "Bagage on");
            bagOn.setString(3, "Pending");
            //passOut....time(4, time.getTime() + plane.getSize());

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
        sql = "INSERT INTO FlyEventList(Planelist_idPlane, task, Status, Time) VALUES(?, ?, ?, ?)";
        try{
            PreparedStatement fuelOn = conn.prepareStatement(sql);
            desc = "Flight " + plane.getId() + " have been refueled";

            fuelOn.setInt(1, plane.getId());
            fuelOn.setString(2, "Fuel on");
            fuelOn.setString(3, "Pending");
            //passOut....time(4, time.getTime() + plane.getSize());

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
        sql = "INSERT INTO FlyEventList(Planelist_idPlane, task, Status, Time) VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement planeClean = conn.prepareStatement(sql);
            desc = "Plane " + plane.getId() + " have been cleaned";

            planeClean.setInt(1, plane.getId());
            planeClean.setString(2, "Plane cleaned");
            planeClean.setString(3, "Finished");
            //passOut....time(4, time.getTime() + plane.getSize());

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
