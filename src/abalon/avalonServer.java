package abalon;

import abalon.thread;
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
    verify veri;
    ObjectInputStream in1, in2;
    ObjectOutputStream out1, out2;
    Object obj1, obj2, obj3, obj4, name1, name2;
    boolean connectOrNot = false;
    Socket mySocket, mySocket1, mySocket2;
    boolean conOrSing, B = true;

    public avalonServer() throws IOException, ClassNotFoundException {

        ServerSocket myServer = null;

        try {
            myServer = new ServerSocket(5845);
        } catch (Exception e) {
            System.err.println("can't open!");
        }

        while (true) {

            mySocket = myServer.accept();
            veri = new verify(mySocket, this);
            veri.start();

        }

    }

    public void srartGame(Socket S, Object name) throws IOException {

        System.out.println(B);
        if (B) {
            this.mySocket1 = S;
            this.name1 = name;
        } else {
            this.mySocket2 = S;
            this.name2 = name;
            int i = con.newGame(name1, name2);
            thread T = new thread(mySocket1, mySocket2, i, this.con, this.name1, this.name2);
            System.out.println(i);
            T.start();
        }
        B = !B;
    }

}

/*in1 = new ObjectInputStream(mySocket1.getInputStream());
            conOrSing = (boolean)in1.readObject();
            do {
            if (conOrSing) {
            in1 = new ObjectInputStream(mySocket1.getInputStream());
            obj1 = in1.readObject();
            in1 = new ObjectInputStream(mySocket1.getInputStream());
            obj2 = in1.readObject();
            connectOrNot = con.connect(obj1, obj2);
            out1 = new ObjectOutputStream(mySocket1.getOutputStream());
            out1.writeObject((Object) connectOrNot);
            
            if (connectOrNot) {
            name1 = obj1;
            }
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
            out1 = new ObjectOutputStream(mySocket1.getOutputStream());
            out1.writeObject((Object) connectOrNot);
            
            if (connectOrNot) {
            name1 = obj1;
            }
            }
            } while (!connectOrNot);
            
            
            connectOrNot = false;
            
            mySocket2 = myServer.accept();
            in2 = new ObjectInputStream(mySocket2.getInputStream());
            conOrSing = (boolean)in2.readObject();
            
            do{
            if (conOrSing) {
            in2 = new ObjectInputStream(mySocket2.getInputStream());
            obj1 = in2.readObject();
            in2 = new ObjectInputStream(mySocket2.getInputStream());
            obj2 = in2.readObject();
            connectOrNot = con.connect(obj1, obj2);
            System.out.println(connectOrNot);
            out2 = new ObjectOutputStream(mySocket2.getOutputStream());
            out2.writeObject((Object) connectOrNot);
            
            if (connectOrNot) {
            name2 = obj1;
            }
            } else {
            in2 = new ObjectInputStream(mySocket2.getInputStream());
            obj1 = in2.readObject();
            in2 = new ObjectInputStream(mySocket2.getInputStream());
            obj2 = in2.readObject();
            in2 = new ObjectInputStream(mySocket2.getInputStream());
            obj3 = in2.readObject();
            in2 = new ObjectInputStream(mySocket2.getInputStream());
            obj4 = in2.readObject();
            connectOrNot = con.createNew(obj1, obj2, obj3, obj4);
            out2 = new ObjectOutputStream(mySocket2.getOutputStream());
            out2.writeObject((Object) connectOrNot);
            
            if (connectOrNot) {
            name2 = obj1;
            }
            }
            }while(!connectOrNot);*/
//int i = con.newGame(name1, name2);
/*ObjectOutputStream obo = new ObjectOutputStream(mySocket1.getOutputStream());
            obo.writeObject((Object)i);
            obo = new ObjectOutputStream(mySocket2.getOutputStream());
            obo.writeObject((Object)i);*/
//System.out.println("GAME ID:" + i);
            /*thread T = new thread(mySocket1, mySocket2);
            T.start();*/
