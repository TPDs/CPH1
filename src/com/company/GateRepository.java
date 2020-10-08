package com.company;

import javax.xml.transform.Result;
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
        System.out.println(result);
        return result;

    }
}
