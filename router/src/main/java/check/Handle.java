package check;

import java.io.*;  
import java.net.*; 

public class Handle{


    private static Handle handle = null;
    private static Socket socket;
    private Handle(){

    }
    
    public static Handle getInc(){
        if (handle == null)
            handle = new Handle();
        return (handle);
    }

    public static void updateMarket(Socket market){
        socket = market;
    }

    public static void sendMessage(Socket client, String message ){
        try{
            // while(true){
                PrintWriter out;
                out = new PrintWriter(socket.getOutputStream(), true);
                out.println(message);
                System.out.println(message);
            // }
         
        }catch(Exception e){
            System.exit(1);
        }finally {
            // serverSocketBroker.close();
        } 
    }

}