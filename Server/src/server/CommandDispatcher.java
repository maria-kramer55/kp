package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CommandDispatcher implements Runnable {

    private Socket clientSocket;
    private ObjectInputStream in;
    private ObjectOutputStream out;


    public CommandDispatcher(Socket sk) {
        this.clientSocket = sk;
    }

    @Override
    public void run() {
        try {
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());
            CommandHandler commandHandler = new CommandHandler(in, out);
            while (true) {
                commandHandler.handle((String) in.readObject());
            }
        } catch (Exception e) {
            try {
                clientSocket.close();
                in.close();
                out.close();
            } catch (IOException ex) {
            }
            e.printStackTrace();
        }
        return;
    }
}
