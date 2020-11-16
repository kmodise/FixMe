package src.main.java;

// import javax.swing.*;
import java.io.*;  
import java.net.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.*;
import server.*;

public class Main{

    public static void main(String[] args) {
        System.out.println("Starting Router server");
        BrokerServer s = new BrokerServer();
        s.start();
        MarketServer m = new MarketServer();
        m.start();
        System.out.println("Router listening on PORT 5000 and 5001");

    }
}
