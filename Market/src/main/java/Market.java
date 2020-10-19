import java.net.Socket;
import java.io.*;

public class Market {

    public  Market(){
        try{
            Socket marketSocket = new Socket("127.0.0.1", 5001);
            System.out.println("Market connected");
        }
        catch (IOException e){System.out.println(e);}

    }

    public static void main(String[] args) {
       new Market();
    }

}
