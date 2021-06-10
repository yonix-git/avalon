package abalon;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
this class has been created to make a serverSocket,
it's accept to two clients and open thread for tham
 */
/**
 *
 * @author user
 */
public class avalonServer {

    toConnect con = new toConnect();
    ObjectInputStream in1, in2;
    ObjectOutputStream out1, out2;
    Object obj1, obj2, obj3, obj4;
    boolean connectOrNot = false;
    boolean conOrLog;

    public void server() throws IOException, ClassNotFoundException {

        ServerSocket myServer = null;

        try {
            myServer = new ServerSocket(5845);
        } catch (Exception e) {
            System.err.println("can't open!");
        }

        Socket mySocket1, mySocket2;
        while (true) {
            
            mySocket1 = myServer.accept();
            in1 = new ObjectInputStream(mySocket1.getInputStream());
            conOrLog = (boolean)in1.readObject();
            do {
                if (conOrLog) {
                    in1 = new ObjectInputStream(mySocket1.getInputStream());
                    obj1 = in1.readObject();
                    in1 = new ObjectInputStream(mySocket1.getInputStream());
                    obj2 = in1.readObject();
                    connectOrNot = con.connect(obj1, obj2);
                    out1 = new ObjectOutputStream(mySocket1.getOutputStream());
                    out1.writeObject((Object) connectOrNot);
                } else {
                    in1 = new ObjectInputStream(mySocket1.getInputStream());
                    obj1 = in1.readObject();
                    in1 = new ObjectInputStream(mySocket1.getInputStream());
                    obj2 = in1.readObject();
                    in1 = new ObjectInputStream(mySocket1.getInputStream());
                    obj3 = in1.readObject();
                    in1 = new ObjectInputStream(mySocket1.getInputStream());
                    obj4 = in1.readObject();
                    connectOrNot = con.createNew(obj1, obj2, obj3, obj4);
                }
            } while (!connectOrNot);
            
            
            connectOrNot = false;
            System.out.println("number 1 is ready;");
            
            mySocket2 = myServer.accept();
            
            do{
            in2 = new ObjectInputStream(mySocket2.getInputStream());
            obj1 = in2.readObject();
            in2 = new ObjectInputStream(mySocket2.getInputStream());
            obj2 = in2.readObject();
            con.connect(obj1, obj2);
            }while(!connectOrNot);
            
            System.out.println("number 2 is ready;");
            
            thread T = new thread(mySocket1, mySocket2);
        }
    }

    public avalonServer() {
    }
}
