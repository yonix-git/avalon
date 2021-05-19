/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class listiner extends Thread{

    public listiner(Socket net) {
        this.net = net;
    }
    
    private Socket net;
    private ObjectInputStream in;
    private Object tmpObject;

    @Override
    public void run() {
        Object tmp;
        try {
            in = new ObjectInputStream(net.getInputStream());
            while(true){
                Thread.sleep(25);
                tmp = in.readObject();
                tmpObject = tmp;
                tmp = null;
            }
        } catch (IOException ex) {
            Logger.getLogger(listiner.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(listiner.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(listiner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Object getTmpObject() {
        return tmpObject;
    }
    public void setObjectNull(){
        tmpObject = null;
    }

}
