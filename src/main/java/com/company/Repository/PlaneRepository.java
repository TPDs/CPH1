package com.company.Repository;

import com.company.AirPlane.Plane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class PlaneRepository {
    Connection conn = DatabaseConnectionManager.getDatabaseConnection();

    //Lands a plane, creating it based on a ruteNr.
    public boolean landplane(String ruteNr){
        Plane fly = new Plane();
        String modelnummer = readModelFromRuteNr(ruteNr);
        String sql = "INSERT INTO PlaneList(idPlane, RuteListe_ruteNr, ModelListe_IATA, location) VALUES(DEFAULT, ?, ?, ?)";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, ruteNr);
            ps.setString(2, modelnummer);
            ps.setString(3, "Runway");


            int insertedRows = ps.executeUpdate();
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
    public String readSizeFromModel(String modelNr){
        String sql = "SELECT Size FROM modelliste WHERE ICAO = ?";
        Plane plane2 = new Plane();
        String result = null;
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, modelNr);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                plane2.setICAO(rs.getString("Size"));
            }
            result = plane2.getICAO();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    //Finds the planeID in planeslist from the given ruteNr
    public int findPlaneIdFromRutenNr(String ruteNr){
        String sql = "SELECT idPlane FROM planelist WHERE  RuteListe_ruteNr = ?";
        Plane plane = new Plane();
        int result = 0;
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ruteNr);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                plane.setId(rs.getInt("idPlane"));
            }
            result = plane.getId();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    //Deletes a plane with the given id from planelist
    public boolean deletePlane(int id){
        try {
            String sql = "DELETE FROM planelist WHERE idPlane = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    //Checks waiting planes from planelist
    public ArrayList<Integer> checkWaitingPlanes(){
        ArrayList<Integer> waitingPlanes = new ArrayList<>();
        String sql = "SELECT * FROM planelist WHERE location = ?";
        String planeLocation = "Waiting";
        int result = 0;
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, planeLocation);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                waitingPlanes.add(rs.getInt("idPlane"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return waitingPlanes;
    }
    public int chooseFirstWaitingPlane(ArrayList<Integer> waitingplanes){
        int result = waitingplanes.get(0);
        return result;
    }
    //reads the ruteNr from a given ID in planelist
    public String readRuteNrFromId(int planeId){
        String sql = "SELECT RuteListe_ruteNr FROM planelist WHERE  idPlane = ?";
        Plane plane = new Plane();
        String result = null;
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, planeId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                plane.setRuteNr(rs.getString("RuteListe_ruteNr"));
            }
            result = plane.getRuteNr();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    //Creates a list of all ruteNr's in rutelist and chooses a random one, returning it's ruteNr
    public String generateRandomPlane(){
        ArrayList<String> ruteNrs = new ArrayList<>();
        String sql = "SELECT ruteNr FROM ruteliste WHERE ruteNr != null";
        String result = null;
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ruteNrs.add(rs.getString("ruteNr"));
            }
            Random ran = new Random(ruteNrs.size());
            int index = ran.nextInt();
            result = ruteNrs.get(index);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
