package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    private static final int port = 12345; //0 a 65535

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server socket criado");
        while(true){
            System.out.println("Aguardando conexões...");
            Socket socket = serverSocket.accept();
            System.out.println("Conexão estabelecida...");
            new Server(socket).start();
        }
    }
}
