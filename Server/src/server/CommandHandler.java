package server;

import dao.DAOException;
import dao.UserDAO;
import model.Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CommandHandler {


    private UserDAO dao = new UserDAO();


    private ObjectInputStream in;
    private ObjectOutputStream out;

    CommandHandler(ObjectInputStream in, ObjectOutputStream out) {
        this.in = in;
        this.out = out;
    }
    void handle(String clientMessage) throws DAOException {
        System.out.println(clientMessage);
        String[] message = clientMessage.split(" ", 2);
        String comandNumberStr = message[0];
        String comand = message[1];
        switch (comandNumberStr) {
            case "logIn": {

                String[] values = comand.split(" ", 2);
                Client client1 = dao.getAllUsers().stream().filter(client -> {
                    if (client.getLogin().equals(values[0]) && client.getPassword().equals(values[1])) {
                        return true;
                    }
                    return false;
                }).findFirst().get();
                try {
                    out.writeObject(client1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case "sighUp": {
                String[] valuesSighUp = comand.split(" ", 5);
                Client client = new Client();
                client.setId(valuesSighUp[0]);
                client.setLogin(valuesSighUp[1]);
                client.setPassword(valuesSighUp[2]);
                client.setFirstName(valuesSighUp[3]);
                client.setLastName(valuesSighUp[4]);
                client.setPhoneNumber(valuesSighUp[5]);
                dao.create(client);
                break;
            }
            case "clientsTable": {
                try {
                    out.writeObject(dao.getAllUsers());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
