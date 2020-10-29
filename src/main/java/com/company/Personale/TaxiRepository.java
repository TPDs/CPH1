package com.company.Personale;

import com.company.Repository.DatabaseConnectionManager;
import com.company.Repository.GateRepository;
import com.company.Repository.PlaneRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaxiRepository {
    PlaneRepository planeRepository = new PlaneRepository();
    GateRepository gateRepository = new GateRepository();
    Connection conn = DatabaseConnectionManager.getDatabaseConnection();

    //Finds the first available plane, and the first available gate based on the plane's size and taxi's the plane there.
    public void taxiFirstWaitingPlaneToFirstAvailableGate() {
        int planeID = planeRepository.chooseFirstWaitingPlane(planeRepository.checkWaitingPlanes());
        String ruteNr = planeRepository.readRuteNrFromId(planeID);
        int gateID = gateRepository.checkAvailable(planeRepository.readSizeFromModel(planeRepository.readModelFromRuteNr(ruteNr)));

        String sql = "UPDATE gate SET idPlane = ? WHERE idGate = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, planeID);
            ps.setInt(2, gateID);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        registerGateInPlane(planeID, gateID);
    }
        //Registers the gateNr in the planes "location" row.
        public void registerGateInPlane(int flyID, int gateNavn){
            String sql = "UPDATE planelist SET location = ? WHERE idPlane = ?";

            try{
                PreparedStatement ps = conn.prepareStatement(sql);
                String gate = Integer.toString(gateNavn);
                ps.setString(1, gate);
                ps.setInt(2, flyID);
                ps.executeUpdate();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
        //Taxi a specific plane to the first available gate of it's size
    public void taxiSpecificPlaneToFirstAvailableGate(int planeId) {
        String ruteNr = planeRepository.readRuteNrFromId(planeId);
        int gateId = gateRepository.checkAvailable(planeRepository.readSizeFromModel(planeRepository.readModelFromRuteNr(ruteNr)));

        String sql = "UPDATE gate SET idPlane = ? WHERE idGate = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, planeId);
            ps.setInt(2, gateId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        registerGateInPlane(planeId, gateId);
    }
    //taxi's a specific plane to a specific gate.
    public void taxiSpecificPlaneToSpecificGate(int planeId, int gateID) {

        String sql = "UPDATE gate SET idPlane = ? WHERE idGate = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, planeId);
            ps.setInt(2, gateID);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        registerGateInPlane(planeId, gateID);
    }
    //Puts the plane's location to waiting
    public void TaxiToWaitingPosition(String ruteNr){
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
    //Sets the plane to being on the runway again
    public void TaxiToRunway(int planeiD){
        String sql = "UPDATE planelist SET location = ? WHERE idPlane = ?";
        String plane = Integer.toString(planeiD);
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Runway");
            ps.setString(2, plane);
            ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    //Sets the plane to "parked"
    public void TaxiToParked(int planeiD){
        String sql = "UPDATE planelist SET location = ? WHERE idPlane = ?";
        String plane = Integer.toString(planeiD);
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Parked");
            ps.setString(2, plane);
            ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
