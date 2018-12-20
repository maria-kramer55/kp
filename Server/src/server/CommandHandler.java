package server;

import dao.DAOException;
import dao.UserDAO;
import model.Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CommandHandler {

    /*Сюда пишешь ту же самую хуйню для своих дао
     * точно также как и для юзера*/
    private UserDAO dao = new UserDAO();

    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    CommandHandler(ObjectInputStream inputStream, ObjectOutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    void handle(String clientMessage) throws DAOException {
        System.out.println(clientMessage);
        String[] message = clientMessage.split(" ", 2);
        String comandNumberStr = message[0];
        String comand = message[1];
        switch (comandNumberStr) {

            /*здесь ты пишешь все свои юзкейсы
             * в которых ты вызываешь дао и либо получаешь что то либо отправляешь*/

            case "logIn": {
                String[] values = comand.split(" ", 2);
                /*получил инфу о клиенте*/
                Client client1 = dao.getAllUsers().stream().filter(client -> {
                    if (client.getLogin().equals(values[0]) && client.getPassword().equals(values[1])) {
                        return true;
                    }
                    return false;
                }).findFirst().get();

                /*отправил его на клиент*/
                post(client1);
                break;
            }
            /*тебе надо сделать все тоже самое только для остальных*/


            case "sighUp": {
                String[] valuesSighUp = comand.split(" ", 5);
                Client client = new Client();
                client.setId(Long.parseLong(valuesSighUp[0]));
                client.setLogin(valuesSighUp[1]);
                client.setPassword(valuesSighUp[2]);
                client.setFirstName(valuesSighUp[3]);
                client.setLastName(valuesSighUp[4]);
                client.setPhoneNumber(valuesSighUp[5]);
                dao.create(client);
                post(dao.getAllUsers());
                break;
            }


            case "clientsTable": {
                try {
                    outputStream.writeObject(dao.getAllUsers());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    private void post(Object obj) {
        try {
            outputStream.writeObject(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Object get() {
        try {
            return inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
