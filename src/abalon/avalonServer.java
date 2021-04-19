package abalon;


import myClasses.board;
import com.sun.corba.se.impl.io.IIOPOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import myClasses.seri;

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
            System.out.println("go fuck yourself");
        }
        
        Socket mySocket1, mySocket2;
        board BToSeri = new board();
        while (true) {
            mySocket1 = myServer.accept();
            System.out.println("n1 is ready");
            mySocket2 = myServer.accept();
            System.out.println("n2 is ready");

            /*seri K1 = new seri();
            ObjectOutputStream obj1 = new ObjectOutputStream(mySocket1.getOutputStream());
            ObjectOutputStream obj2 = new ObjectOutputStream(mySocket2.getOutputStream());
            K1.setSharedBoard(BToSeri);
            obj1.writeObject(K1.getSharedBoard());
            obj2.writeObject(K1.getSharedBoard());*/

            thread T = new thread(mySocket1, mySocket2);
        }
    }

    public avalonServer() {
    }
}
