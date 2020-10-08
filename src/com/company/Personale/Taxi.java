package com.company.Personale;

import com.company.DatabaseConnectionManager;
import com.company.Plane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Taxi {
    Connection conn = DatabaseConnectionManager.getDatabaseConnection();

    public void toWaitingPosition(String ruteNr){
        String sql = "UPDATE planelist SET location = ? WHERE RuteListe_ruteNr = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Waiting");
            ps.setString(2, ruteNr);
            ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void toGate(String ruteNr){
        String sql = "UPDATE planelist SET location = ? WHERE RuteListe_ruteNr = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Waiting");
            ps.setString(2, ruteNr);
            ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
