import java.net.*;
import java.io.*;

public class Broker {
    public static void main(String[] args) throws IOException{
        try{
            Socket  brokerS = new Socket("127.0.0.1", 5000);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
