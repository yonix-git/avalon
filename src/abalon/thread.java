/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abalon;

import Net.listiner;
import myClasses.print;
import myClasses.board;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author user
 */
public class thread extends Thread{
    
    private  Socket mySocket1, mySocket2;
    private play pl; 
    print p = new print();
    board B = new board();
    /*private BufferedReader b1 = null;
    private BufferedReader b2 = null;*/
   
    
    public thread(Socket mySocket1, Socket mySocket2) throws IOException{
        
        this.mySocket1 = mySocket1;
        this.mySocket2 = mySocket2;
        listiner lis1 = new listiner(mySocket1);
        listiner lis2 = new listiner(mySocket2);
        
        /*InputStreamReader input1 = new InputStreamReader(mySocket1.getInputStream());
        b1 = new BufferedReader(input1);
        InputStreamReader input2 = new InputStreamReader(mySocket2.getInputStream());
        b2 = new BufferedReader(input2);*/
        
        pl = new play(lis1, lis2);
        p.printBoard(B);
        pl.playing( mySocket1, mySocket2);
        
    }
    /*  @Override
    public void run(){
    print pr = new print();
    boolean P = true;
    
    
    }*/
}
