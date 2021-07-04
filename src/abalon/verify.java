/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abalon;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class verify extends Thread{
    
    Socket S;
    avalonServer M;
    toConnect con = new toConnect();
    ObjectInputStream in1;
    ObjectOutputStream out1;
    Object obj1, obj2, obj3, obj4, name1;
    ArrayList<String> A = new ArrayList<>();
    boolean connectOrNot = false;
    boolean conOrSign;
    
    public verify(Socket S, avalonServer M){
        this.S = S;
        this.M = M;
    }

    @Override
    public void run() {
        try {
            in1 = new ObjectInputStream(S.getInputStream());
            conOrSign = (boolean)in1.readObject();
            do {
                if (conOrSign) {
                    in1 = new ObjectInputStream(S.getInputStream());
                    obj1 = in1.readObject();
                    in1 = new ObjectInputStream(S.getInputStream());
                    obj2 = in1.readObject();
                    connectOrNot = con.connect(obj1, obj2);
                    out1 = new ObjectOutputStream(S.getOutputStream());
                    out1.writeObject((Object) connectOrNot);
                    
                    if (connectOrNot) {
                        A = con.sql.getLastGames((String)obj1, 0);
                        out1 = new ObjectOutputStream(S.getOutputStream());
                        out1.writeObject((Object)A);
                        name1 = obj1;
                    }
                } else {
                    in1 = new ObjectInputStream(S.getInputStream());
                    obj1 = in1.readObject();
                    in1 = new ObjectInputStream(S.getInputStream());
                    obj2 = in1.readObject();
                    in1 = new ObjectInputStream(S.getInputStream());
                    obj3 = in1.readObject();
                    in1 = new ObjectInputStream(S.getInputStream());
                    obj4 = in1.readObject();
                    connectOrNot = con.createNew(obj1, obj2, obj3, obj4);
                    out1 = new ObjectOutputStream(S.getOutputStream());
                    out1.writeObject((Object) connectOrNot);
                    
                    if (connectOrNot) {
                        name1 = obj1;
                    }
                }
            } while (!connectOrNot);
            in1 = new ObjectInputStream(S.getInputStream());
            obj1 = in1.readObject();
            //System.out.println(obj1);
            M.srartGame(S, name1);
        } catch (IOException ex) {
            Logger.getLogger(verify.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(verify.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(verify.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
}
