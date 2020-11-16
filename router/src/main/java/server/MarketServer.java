package server;

import java.io.*;  
import java.net.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.*;
import handler.*;

public class MarketServer  extends Thread {

    private static ArrayList<RouterHandlerMarket> marketlist = new ArrayList<>();
    private static ExecutorService Marketpool = Executors.newFixedThreadPool(4);
    private static final int Marketport = 5001;
    private Thread m;

    public MarketServer(){
    }
    
    public void run(){
            ServerSocket serverSocketMarket = null;
        try{  
            InetAddress inetAddress = InetAddress.getByName("localhost");

            serverSocketMarket = new ServerSocket();
            SocketAddress MarketendPoint = new InetSocketAddress(inetAddress, Marketport);
            serverSocketMarket.bind(MarketendPoint);
        }catch(Exception e){
            System.err.println("Could not listen on port: 6666");
            System.exit(1);
        }

        try{
            while(true){
                Socket Market = serverSocketMarket.accept();
                RouterHandlerMarket market = new RouterHandlerMarket(Market);
                marketlist.add(market);
                Marketpool.execute(market);
            }

        }catch(Exception e){
            System.err.println("Accept failed");
            System.exit(1);
        }finally {
            // serverSocketMarket.close();
        } 
    }

    public void start(){
        m = new Thread(this);
        m.start();
    }
}