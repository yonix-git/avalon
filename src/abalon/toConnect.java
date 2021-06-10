/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abalon;

import Net.listiner;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class toConnect extends Thread {
    public toConnect(){
        
    }

    sqlData sql = new sqlData();
    Socket S;
    listiner lis;

    public toConnect(Socket s) {

        this.S = s;
        lis = new listiner(this.S);
    }

    public boolean connect(Object obj1, Object obj2) {

        boolean B = false;
        try {
            B = sql.chackNameAndPass((String) obj1, (String) obj2);

        } catch (SQLException ex) {
            Logger.getLogger(toConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return B;
    }

    public boolean createNew(Object obj1, Object obj2, Object obj3, Object obj4) {
        
        boolean B = false;
        try {
            B = sql.newPlayer((String)obj1, (String)obj2, (String)obj3, (String)obj4);
        } catch (SQLException ex) {
            Logger.getLogger(toConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return B;

    }

    private Object waitAndGet(listiner lis) {

        Object toReturn = null;
        lis.setObjectNull();
        while (toReturn == null) {
            try {
                Thread.sleep(25);
            } catch (InterruptedException ex) {
                Logger.getLogger(play.class.getName()).log(Level.SEVERE, null, ex);
            }
            toReturn = lis.getTmpObject();
        }
        return toReturn;
    }
}
