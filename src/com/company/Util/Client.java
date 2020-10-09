package com.company.Util;

import java.io.*;
import java.net.Socket;

public class Client {


    public void client(String user) {
        String serverName = "10.111.176.139"; // Dagens lokal ip på skolen.. TJEK MIG!
        int port = 48880;


        try {
            System.out.println("Connecting to " + serverName + " på port " + port);
            Socket client = new Socket(serverName, port);

            System.out.println(user + " connected via " + client.getRemoteSocketAddress());
            OutputStream toServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(toServer);
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);


            out.writeUTF(user);
            out.writeUTF("D8 3563");
            out.writeInt(1);


            System.out.println("Server :" + in.readUTF());
            System.out.println("Server :" + in.readUTF());
            System.out.println("Server :" + in.readUTF());



            plane(in,out);
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void plane (DataInputStream in,DataOutputStream out) throws IOException {
        out.writeUTF("hej");
        in.readUTF();




    }


}