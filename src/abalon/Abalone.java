/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abalon;

import java.io.IOException;

/**
 *
 * @author user
 */
public class Abalone {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        sqlData sql = new sqlData();
        avalonServer a = new avalonServer();
        a.server();
        //sqlData b = new sqlData();
        
        /* board B = new board();
        print P = new print();
        P.printBoard(B);
        play PL = new play();
        PL.playing();*/
    }

}
