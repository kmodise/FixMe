import  java.io.*;
import java.net.*;

public class Server {
    public static void  main(String[] args){
        try{
            ServerSocket serverSocketObj = new ServerSocket(6666);
            Socket socketObj = serverSocketObj.accept();
            DataInputStream dis = new DataInputStream(socketObj.getInputStream());
            String str = (String)dis.readUTF();
            System.out.println("message = "+ str);
            serverSocketObj.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
