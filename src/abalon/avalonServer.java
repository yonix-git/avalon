package abalon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class avalonServer {
    
    public void server() throws IOException {
        
        ServerSocket myServer = null;
        
        try {
            myServer = new ServerSocket(5845);
        } catch (Exception e) {
            System.err.println("go fuck yourself");
        }
        
        Socket mySocket1, mySocket2;
        
        while(true){
            mySocket1 = myServer.accept();
            mySocket2 = myServer.accept();
     
            thred T = new thred(mySocket1, mySocket2);
        }
    }

    public avalonServer() {
    }
}
