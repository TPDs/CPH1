package com.company.Repository;

import com.company.Airport.Gate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GateRepository {
    Connection conn = DatabaseConnectionManager.getDatabaseConnection();


    public boolean readAllGates(Gate gate){
        String sql = "SELECT * FROM gate";
        List<Gate> gates = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Gate tempGate = new Gate();
            while(rs.next()){
                tempGate.setIdGate(rs.getInt(1));
                tempGate.setSize(rs.getString(2));
                tempGate.setIdPlane(rs.getInt(3));
                tempGate.setIdFinger(rs.getInt(4));
                tempGate.setSide(rs.getString(5));
                gates.add(tempGate);
            }
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public int checkAvailable(String pSize){
        List<Gate> gates = new ArrayList<>();
        int result = 0;
        String sql = "SELECT * FROM gate WHERE idPlane IS NULL AND size = " + pSize;

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pSize);
            ResultSet rs = ps.executeQuery();
            Gate tempGate = new Gate();
            while(rs.next()){
                tempGate.setIdGate(rs.getInt(1));
                tempGate.setSize(rs.getString(2));
                tempGate.setIdPlane(rs.getInt(3));
                tempGate.setIdFinger(rs.getInt(4));
                tempGate.setSide(rs.getString(5));
                gates.add(tempGate);
            }

            result = gates.get(0).getIdGate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;

    }

    public boolean removePlaneFromGate(int id){
        String sql = "UPDATE gate SET idPlane = NULL WHERE idPlane=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int deletedRows = ps.executeUpdate();
            if (deletedRows > 0) {
                System.out.println("Plane removed from gate");
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Gate findPlaneIDInGates(int id){
        String sql = "SELECT * FROM gate WHERE idPlane=?";
        Gate gate = new Gate();

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                gate.setIdGate(rs.getInt(1));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return gate;
    }

}
