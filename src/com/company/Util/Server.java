package com.company.Util;

import com.company.Airport.Gate;
import com.company.Repository.GateRepository;
import com.company.Repository.PlaneRepository;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server extends Thread{
    private ServerSocket serverSocket;

    public Server (int port) throws IOException {
       String host = "10.111.176.147"; // Dagens lokal ip på skolen.. TJEK MIG!

        InetAddress address = InetAddress.getByName(host);
        serverSocket = new ServerSocket(port,1000000,address);
        //serverSocket.setSoTimeout(100000);
    }

    public void run() {
        while (true){
            try {
                System.out.println("Tårn is Live on ip: " + serverSocket.getLocalPort());
                Socket server = serverSocket.accept();
                DataInputStream in = new DataInputStream(server.getInputStream());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                String user = in.readUTF();
                String rute = in.readUTF();

                PlaneRepository planeRepository = new PlaneRepository();
                GateRepository gate = new GateRepository();
                int planID = planeRepository.findPlaneIdFromRutenNr(rute);
                Gate lok = gate.findPlaneIDInGates(planID);
                out.writeUTF("Du er på plads " + lok.getIdGate());
                out.writeUTF("I hear you " + user + " :" + rute + " Dit iD er " +planID);
                towerCommand(out,in);
               server.close();


            }
            catch (SocketTimeoutException s) {
                System.out.println("Connection timed out");
                break;
            }
            catch (IOException e) {
                e.printStackTrace();
                break;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

    }

    public void towerCommand(DataOutputStream out, DataInputStream in) throws IOException, ClassNotFoundException {
        boolean flag = true;
        System.out.println("TowerCommand loaded...");

        while (flag) {
            int test = in.read();
            switch (test) {

                case 1:
                    System.out.println("Fly command ");
                    out.writeUTF("Fly command modtaget");
                    // call en fly method
                    break;

                case 2:
                    System.out.println("Personal Command");
                    out.writeUTF("Personal  Command modtaget");
                    // Call en Personal command
                    break;

                case 3:
                    System.out.println("Taxi Command");
                    out.writeUTF("Taxi Command modtaget");
                    //Call en taxi method
                    break;
            }
        }

    }



}
