package handler;

import java.io.*;  
import java.net.*; 
import check.*;
public class RouterHandlerClient implements Runnable{

    private Socket client;
    private int id;
    private static Handle sendmessage = Handle.getInc(); 

    public RouterHandlerClient(Socket socket, int id){
        this.client = socket;
        this.id = id;
    }
    
    public void run(){
        try{
            while(true){
                // DataInputStream dis = new DataInputStream(client.getInputStream());

                BufferedReader in = new BufferedReader(new InputStreamReader( client.getInputStream()));

                // String  str= (String)dis.readUTF();  
                String line = in.readLine();
                if (line != null)
                    sendmessage.sendMessage(this.client, line);

            }
        }catch (IOException e){

        }
    }
}