package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Server extends Thread{
    private final Socket socket;

    public Server(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();
        try{
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream input = new DataInputStream(socket.getInputStream());
            Double tempC = input.readDouble();
            System.out.println("Recebendo - " + tempC);
            Double tempF = tempC * 1.8 + 32;
            out.writeDouble(tempF);
            out.flush();
            out.close();
            input.close();
            socket.close();
            System.out.println("Conexão fechada");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
