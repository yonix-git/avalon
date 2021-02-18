/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abalon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author user
 */
public class thread extends Thread{
    
    private  Socket mySocket1, mySocket2;
    private play pl = new play();
    print p = new print();
    board B = new board();
    private BufferedReader b1 = null;
    private BufferedReader b2 = null;
    /*
    public thred(){
    
    }*/
    
    public thread(Socket mySocket1, Socket mySocket2) throws IOException{
        
        this.mySocket1 = mySocket1;
        this.mySocket2 = mySocket2;
        
        InputStreamReader input1 = new InputStreamReader(mySocket1.getInputStream());
        b1 = new BufferedReader(input1);
        InputStreamReader input2 = new InputStreamReader(mySocket2.getInputStream());
        b2 = new BufferedReader(input2);
        
        /*ObjectOutputStream obj1 = new ObjectOutputStream(mySocket1.getOutputStream());
        ObjectOutputStream obj2 = new ObjectOutputStream(mySocket2.getOutputStream());
        obj1.writeObject(B);
        obj2.writeObject(B);*/
        p.printBoard(B);
        pl.playing( b1, b2);
        
    }
    /*  @Override
    public void run(){
    print pr = new print();
    boolean P = true;
    
    
    }*/
}
