package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RuteRepository {
    Connection conn = DatabaseConnectionManager.getDatabaseConnection();

    public ArrayList<Rute> fetchAll(){
        ArrayList<Rute> ruteliste = new ArrayList<>();
        String sql = "SELECT * FROM ruteliste WHERE rutenr != null";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if(rs != null) {
                while (rs.next()) {
                    String date = rs.getString("date");
                    String ruteNr = rs.getString("ruteNr");
                    String tid = rs.getString("sta/std");
                    String destination = rs.getString("Org/Des");
                    String AC = rs.getString("AC");

                    ruteliste.add(new Rute(date, ruteNr, tid, destination, AC));
                }
            }

        }catch(SQLException e){
            System.err.println(e);
        }
        return ruteliste;
    }
}
