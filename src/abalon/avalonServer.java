package abalon;

import myClasses.board;
import java.io.IOException;
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


    public void server() throws IOException {

        ServerSocket myServer = null;

        try {
            myServer = new ServerSocket(5845);
        } catch (Exception e) {
            System.err.println("can't open!");
        }

        Socket mySocket1, mySocket2;
        while (true) {
            mySocket1 = myServer.accept();
            System.out.println("number 1 is ready;");
            mySocket2 = myServer.accept();
            System.out.println("number 2 is ready;");
            
            thread T = new thread(mySocket1, mySocket2);
        }
    }

    public avalonServer() {
    }
}
