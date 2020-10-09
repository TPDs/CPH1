package com.company.Util;

import com.company.Plane;

import java.io.*;
import java.net.Socket;

public class Client {


    public void client(String user){
    String serverName = "10.111.176.147"; // Dagens lokal ip på skolen.. TJEK MIG!
    int port = 48880;


    try {
        System.out.println("Connecting to " + serverName + " på port " + port);
        Socket client = new Socket(serverName, port);


        System.out.println(user + " connected via " + client.getRemoteSocketAddress());
        OutputStream toServer = client.getOutputStream();
        DataOutputStream out = new DataOutputStream(toServer);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);

        objectOutputStream.writeObject(user);



        out.writeInt(2);

        InputStream inFromServer = client.getInputStream();
        DataInputStream in = new DataInputStream(inFromServer);
        Plane test = new Plane();
        System.out.println("Server :" + in.readUTF());

        client.close();

    }
    catch (IOException e) {
        e.printStackTrace();
    }

}
}