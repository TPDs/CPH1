package com.company.Util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server  extends  Thread{
    private ServerSocket serverSocket;

    public Server (int port) throws IOException {
       String host = "10.111.176.45"; // Dagens lokal ip på skolen.. TJEK MIG!

        InetAddress address = InetAddress.getByName(host);
        serverSocket = new ServerSocket(port,10,address);
        //serverSocket.setSoTimeout(100000);

    }

    public void run() {
        while (true){
            try {
                System.out.println("Tårn is Live on ip: " + serverSocket.getLocalPort());
                Socket server = serverSocket.accept();
                DataInputStream in = new DataInputStream(server.getInputStream());

                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("I hear you : " +server.getRemoteSocketAddress());
                //out.writeUTF("Hello connected user " + server.getLocalSocketAddress());
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
            }

        }

    }

    public void towerCommand( DataOutputStream out, DataInputStream in) throws IOException {
        boolean flag = true;
        System.out.println("Tower is live");

        String test = in.readUTF();

        while (flag) {
            switch (test) {

                case "fly":
                    System.out.println("Fly command ");
                    out.writeUTF("Fly command modtaget");
                    // call en fly method
                    break;

                case "personal":
                    System.out.println("Personal Command");
                    out.writeUTF("Personal  Command modtaget");
                    // Call en Personal command
                    break;

                case "taxi":
                    System.out.println("Taxi Command");
                    out.writeUTF("Taxi Command modtaget");
                    //Call en taxi method
                    break;
            }
        }






    }



}
