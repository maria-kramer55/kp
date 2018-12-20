package starter;

import server.CommandDispatcher;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RunServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    int numberClient = 1;
    private int port = 8080;

    public RunServer() {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(RunServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true) {
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException ex) {
                Logger.getLogger(RunServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            Runnable runnable = new CommandDispatcher(clientSocket);
            Thread thread = new Thread(runnable);
            thread.start();
            numberClient++;
        }
    }

    public void Disconnect() {
        try {
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(RunServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
