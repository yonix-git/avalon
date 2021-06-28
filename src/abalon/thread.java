/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abalon;

import Net.listiner;
import myClasses.print;
import myClasses.board;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
this class get two sockets and start a game for them
 */
public class thread extends Thread{
    
    private  Socket mySocket1, mySocket2;
    private play pl; 
    print p = new print();
    board B = new board();
   
    
    public thread(Socket mySocket1, Socket mySocket2) throws IOException{
        
        this.mySocket1 = mySocket1;
        this.mySocket2 = mySocket2;
       
        
        
    }

    @Override
    public void run() {
        
        listiner lis1 = new listiner(mySocket1);
        listiner lis2 = new listiner(mySocket2);
        
        pl = new play(lis1, lis2);
        try {
            pl.playing( mySocket1, mySocket2);
        } catch (IOException ex) {
            Logger.getLogger(thread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
