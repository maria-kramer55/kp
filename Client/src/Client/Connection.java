package Client;

import Entity.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Connection {
    private  Socket socket;
    private  ObjectOutputStream cout;
    private  ObjectInputStream cin;

    public  String client;
    public  String access;

    public void connect() {
        try {
            socket = new Socket("localhost", 8080);
            cout = new ObjectOutputStream(socket.getOutputStream());
            cin = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void Send(Object obj) {
        try {
            cout.writeObject(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String receive() {
        String str = null;
        try{
           str = (String) cin.readObject();
            System.out.println(str);
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }

    public ArrayList<Client> receiveClientTable(){
        ArrayList<Client> res = null;
        try{
            res = (ArrayList<Client>)cin.readObject();
        }catch(Exception e ){

        }
        return res;
    }

    public ArrayList<Service> receiveServicesTable(){
        ArrayList<Service> services = null;
        try {
            services= (ArrayList<Service>)cin.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return services;
    }



    public ArrayList<Material> receiveMaterialTable(){
        ArrayList<Material> materials = null;
        try{
            materials = (ArrayList<Material>)cin.readObject();
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return materials;
    }



    public ArrayList<Worker> receiveWorkerTable(){
        ArrayList<Worker> workers = null;
        try {
            workers = (ArrayList<Worker>)cin.readObject();
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return workers;
    }




    public ArrayList<Order> receiveOrderTable(){
        ArrayList<Order> orders = null;
        try {
            orders = (ArrayList<Order>)cin.readObject();
        }catch(IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return orders;
    }
}
