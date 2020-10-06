import java.io.*;
import java.net.*;

public class client {
    public  static void main(String[] args){
        try {
            Socket socketObj = new Socket("localhost", 6666);
            DataOutputStream dataOutputStreamObj = new DataOutputStream(socketObj.getOutputStream());
            dataOutputStreamObj.writeUTF("HELLO FROM THE OTHER SIDE");
            dataOutputStreamObj.flush();
            dataOutputStreamObj.close();
            dataOutputStreamObj.close();
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
