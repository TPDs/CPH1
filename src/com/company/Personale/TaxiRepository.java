package com.company.Personale;

import com.company.DatabaseConnectionManager;
import com.company.GateRepository;
import com.company.Plane;
import com.company.PlaneRepository;

import javax.xml.parsers.ParserConfigurationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaxiRepository {
    PlaneRepository planeRepository = new PlaneRepository();
    GateRepository gateRepository = new GateRepository();
    Connection conn = DatabaseConnectionManager.getDatabaseConnection();

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
    public void taxiSpecificPlaneToFirstAvailableGate(int planeId) {
        String ruteNr = planeRepository.readRuteNrFromId(planeId);
        int gateID = gateRepository.checkAvailable(planeRepository.readSizeFromModel(planeRepository.readModelFromRuteNr(ruteNr)));

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
            ps.setString(1, "RunWay");
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
