package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaneRepository {
    Connection conn = DatabaseConnectionManager.getDatabaseConnection();

    public boolean addPlane(Plane plane){

        String sql = "INSERT INTO PlaneList(ruteNr, ICAO, location) VALUES(?, ?, ?)";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, plane.getRuteNr());
            ps.setString(2, plane.getICAO());
            ps.setString(3, plane.getLocation());


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
    //Check for collumn index ved fejldata
    public int readSizeFromModel(Plane plane){
        String sql = "SELECT Size FROM ModelListe WHERE ICAO =" + plane.getICAO();
        int result = 0;
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            result = rs.getInt(1);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

}
