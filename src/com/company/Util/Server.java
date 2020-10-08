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
                System.out.println("Venter Client på port: " +
                serverSocket.getLocalPort());
                Socket server = serverSocket.accept();
                System.out.println(server.getRemoteSocketAddress() + " Has just connected");
                DataInputStream in = new DataInputStream(server.getInputStream());

                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("Hej Lukas!!!");
                //out.writeUTF("Hello connected user " + server.getLocalSocketAddress());

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


}
