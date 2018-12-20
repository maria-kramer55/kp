package Client;

import Enum.ConnectInstance;

public class LogIn {

    public static String access;
    public static String clientName;
    public static String clientLastName;

    public static void Access (){
        String str = ConnectInstance.INSTANCE.getInstance().receive();
        System.out.println(str);
        int symbolAmount = str.length();
        if (symbolAmount> 1){
            String [] split = str.split(" ", 3);
            access = split[0];
            clientName = split[1];
            clientLastName = split[2];
        }
        else {
            access = str;
        }

    }
}
