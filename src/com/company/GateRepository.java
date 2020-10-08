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

    private List<Gate> gates = new ArrayList<>();

    public boolean readAllGates(Gate gate){
        String sql = "SELECT * FROM gate";
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

    public List<Gate> checkAvailable(String pSize){
        pSize = "L";
        String sql = "SELECT * FROM gate WHERE idPlane IS NULL AND size = " + pSize;
        List<Gate> returnGate = new ArrayList<>();
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

            returnGate.add(gates.get(0));
            gates.remove(0);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return returnGate;
    }
}
