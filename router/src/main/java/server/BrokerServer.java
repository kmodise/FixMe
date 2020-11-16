package server;

import java.io.*;  
import java.net.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.*;
import handler.*;

public class BrokerServer extends Thread {

    private static ArrayList<RouterHandlerClient> broker = new ArrayList<>();
    private static ExecutorService Brokerpool = Executors.newFixedThreadPool(4);
    private static final int Brokerport = 5000;
    private Thread b;
    private int i = new Random().nextInt(42_000);
    public BrokerServer(){
    }

    public void run(){

            ServerSocket serverSocketBroker = null;
        try{  
            InetAddress inetAddress = InetAddress.getByName("localhost");

            serverSocketBroker = new ServerSocket();
            SocketAddress BrokerendPoint = new InetSocketAddress(inetAddress, Brokerport);
            serverSocketBroker.bind(BrokerendPoint);
        }catch(Exception e){
            System.err.println("Could not listen on port: 6666");
            System.exit(1);
        }

        try{
            while(true){
                Socket Broker = serverSocketBroker.accept();
                RouterHandlerClient client = new RouterHandlerClient(Broker, ++(this.i));
                broker.add(client);

                PrintWriter out;
                out = new PrintWriter(Broker.getOutputStream(), true);
                out.println("ID: " + i);

                DataOutputStream dout = new DataOutputStream(Broker.getOutputStream());  
                dout.writeUTF("" + i + "");  
                dout.flush();  
                System.out.println("Broker connected with brokerid:" + i );
                Brokerpool.execute(client);
            }
         
        }catch(Exception e){
            System.err.println("Accept failed");
            System.exit(1);
        }finally {
            // serverSocketBroker.close();
        } 
        
    }
    
    public void start(){
        b = new Thread(this);
        b.start();
    }
}