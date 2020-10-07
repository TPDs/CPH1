package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaneRepository {
    Connection conn = DatabaseConnectionManager.getDatabaseConnection();

    public boolean addPlane(String ruteNr){
        Plane fly = new Plane();

        String sql = "INSERT INTO PlaneList(ruteNr, ICAO, location) VALUES(?, ?, ?)";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, ruteNr);
            ps.setString(2, readModelFromRuteNr(ruteNr));
            ps.setString(3, "Runway");


            int insertedRows = ps.executeUpdate();
            if(insertedRows > 0){
                System.out.println("Plane was successfully created!");
            }
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    //Henter et modelNr i databasen ud fra et ruteNr
    public String readModelFromRuteNr(String ruteNr){
        String sql = "SELECT AC FROM ruteliste WHERE ruteNr = ?";
        Plane plane2 = new Plane();
        String result = null;
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ruteNr);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                plane2.setICAO(rs.getString("AC"));
            }
            result = plane2.getICAO();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    //Læser en size fra databasen ud fra et modelNr
    public char readSizeFromModel(String modelNr){
        String sql = "SELECT Size FROM modelliste WHERE ICAO = ?";
        Plane plane2 = new Plane();
        char result = 0;
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, modelNr);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                plane2.setICAO(rs.getString("Size"));
            }
            result = plane2.getICAO().charAt(0);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

}
