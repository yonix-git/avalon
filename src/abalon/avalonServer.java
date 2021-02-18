package abalon;


import com.sun.corba.se.impl.io.IIOPOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import serialize.seri;

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
    
        private board B = new board();
        
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
     
            /*seri K1 = new seri();
            ObjectOutputStream obj1 = new ObjectOutputStream(mySocket1.getOutputStream());
            obj1.writeObject(K1);
            K1.a = 1;*/
            
            thread T = new thread(mySocket1, mySocket2);
        }
    }

    public avalonServer() {
    }
}
