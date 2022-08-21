package com.fwsa;

import java.net.ServerSocket;
import java.net.Socket;

public class Server_Socket {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket();
        Socket socket = ss.accept();
    }
}
