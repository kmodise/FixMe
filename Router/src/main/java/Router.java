import java.io.IOException;
import java.net.ServerSocket;

public class Router {
    static int brokerPort = 5000;
    static int marketPort = 5001;
    public Router(int port) throws IOException {
        ServerSocket serverSocketObj = new ServerSocket(port);

         serverSocketObj.accept();
         System.out.println("Broker connected");
    }
}
