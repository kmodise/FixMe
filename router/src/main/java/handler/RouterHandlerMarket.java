package handler;

import java.io.*;  
import java.net.*; 
import check.*;

public class RouterHandlerMarket implements Runnable{

    private Socket client;
    private static Handle sendmessage = Handle.getInc(); 

    public RouterHandlerMarket(Socket socket){
        this.client = socket;
        sendmessage.updateMarket(socket);
    }
    
    public void run(){
        try{
            while(true){
                DataInputStream dis = new DataInputStream(client.getInputStream());  
                String  str= (String)dis.readUTF();  
                System.out.println(" message = "+ client);
            }
        }catch (IOException e){

        }
    }
}