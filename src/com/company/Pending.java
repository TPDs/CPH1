package com.company;

import com.company.Personale.Job;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class Pending {
    Connection conn = DatabaseConnectionManager.getDatabaseConnection();

    public boolean add(String jobType, String gate, String size, LocalDateTime time, String status){
        Job j = new Job(jobType, gate, size, time, status);


        String sql = "INSERT INTO pendingtask(task, location, time, status) VALUES(?, ?, ?, ?)";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, jobType);
            ps.setString(2, gate);
            ps.setString(3, String.valueOf(time));
            ps.setString(4, status);


            int insertedRows = ps.executeUpdate();
            if(insertedRows > 0){
                System.out.println("Job was successfully created!");
            }
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<Job> fetchAll(){
        ArrayList<Job> jobList = new ArrayList<>();
        String sql = "SELECT * FROM pendingtask";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if(rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("task_id");
                    String jobType = rs.getString("task");
                    String gate = rs.getString("location");
                    String timeString = rs.getString("time");
                    String status = rs.getString("status");

                    LocalDateTime must = LocalDateTime.parse(timeString);
                    jobList.add(new Job(id, jobType, gate, must, status));
                }
            }
            return jobList;
        }catch(SQLException e){
            System.err.println(e);
        }
        return jobList;
    }

    public boolean delete(int id, ArrayList<Job> jobList){
        try {
            String sql = "DELETE FROM pendingtask WHERE task_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int deletedrows = ps.executeUpdate();
            if(deletedrows > 0){
                System.out.println("Deletion succesful");
                for (int i = 0; i < jobList.size(); i++) {
                    if (jobList.get(i).getId() == id) {
                        jobList.remove(i);
                    }
                }
                return true;
            }
            ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public void testUpload(Pending pending) {
        LocalDateTime time = LocalDateTime.now();
        pending.add("Cleaning", "A8", "Large", time, "Ok");
        pending.add("Fuel", "A8", "Large", time, "Ok");
        pending.add("BaggageIn", "A8", "Large", time, "Ok");
        pending.add("BaggageOut", "A8", "Large", time, "Ok");
        pending.add("PassengerIn", "A8", "Large", time, "Ok");
        pending.add("PassengerOut", "A8", "Large", time, "Ok");

        pending.add("Cleaning", "A9", "Standard", time, "Ok");
        pending.add("Fuel", "A9", "Standard", time, "Ok");
        pending.add("BaggageIn", "A9", "Standard", time, "Ok");
        pending.add("BaggageOut", "A9", "Standard", time, "Ok");
        pending.add("PassengerIn", "A9", "Standard", time, "Ok");
        pending.add("PassengerOut", "A9", "Standard", time, "Ok");

        pending.add("Cleaning", "A8", "Small", time, "Ok");
        pending.add("Fuel", "A8", "Small", time, "Ok");
        pending.add("BaggageIn", "A8", "Small", time, "Ok");
        pending.add("BaggageOut", "A8", "Small", time, "Ok");
        pending.add("PassengerIn", "A8", "Small", time, "Ok");
        pending.add("PassengerOut", "A8", "Small", time, "Ok");
    }

    public void testAfDownloadOgSlet(Pending pending) {
        ArrayList<Job> jobList = pending.fetchAll();
        System.out.println(jobList);

        Collections.sort(jobList);
        System.out.println(jobList);

        pending.delete(jobList.get(0).getId(), jobList);
        System.out.println(jobList);
    }

}
