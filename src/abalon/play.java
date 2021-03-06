/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abalon;

import Net.listiner;
import java.awt.Toolkit;
import myClasses.print;
import myClasses.cellIndexes;
import myClasses.typeOfCell;
import myClasses.board;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import myClasses.inputDitels;

/**
 *
 * @author user
 */
public class play {

    private board B;
    private boolean P = true;
    private listiner lis1, lis2;
    toConnect con;
    Object name1, name2;
    int IDgame;

    //constructor
    public play(listiner lis1, listiner lis2, toConnect con, Object name1, Object name2, int IDgame) {
        this.B = new board();
        this.lis1 = lis1;
        this.lis2 = lis2;
        this.con = con;
        this.name1 = name1;
        this.name2 = name2;
        this.IDgame = IDgame;

        this.lis1.start();
        this.lis2.start();
    }

    public play(board B) {
        this.B = B;
    }

    /*
    this function get a listiner and wait to get a object from the thread 
    and when it's done return this object
     */
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

    /*
    this function get the sockets and make the game betwin the players
    the 'while' runing until one of the players win
    the function make a move and send the board to the clients
     */
    public void playing(Socket mySocket1, Socket mySocket2) throws IOException {

        Object obj;
        inputDitels getDitels;
        ObjectOutputStream obj1, obj2;

        try {
            String direction;
            while (B.getAmountOfBlack() < 6 && B.getAmountOfWhite() < 6) {

                B.setBlackOrWhite(P);
                direction = null;
                cellIndexes point = new cellIndexes();

                obj1 = new ObjectOutputStream(mySocket1.getOutputStream());
                obj1.writeObject(this.B);

                /*for (int i = 0; i < B.getGameBoard().length; i++) {
                for (int j = 0; j < B.getGameBoard()[0].length; j++) {
                B2.setTYpe(i, j, B.getTYpe(B.getGameBoard().length - i - 1, B.getGameBoard()[0].length - j -1));
                }
                }*/
                obj2 = new ObjectOutputStream(mySocket2.getOutputStream());
                obj2.writeObject(this.B);

                do {

                    do {
                        if (P) {
                            obj = waitAndGet(lis1);
                        } else {
                            obj = waitAndGet(lis2);
                        }
                        getDitels = (inputDitels) obj;

                        point.setR(getDitels.getRow());
                        point.setC(getDitels.getColumn());
                        direction = getDitels.getDir();
                    } while (!chackPoint(getDitels.getRow(), getDitels.getColumn()));

                } while (!isPusible(point, direction));

                P = !P;
            }

            obj1 = new ObjectOutputStream(mySocket1.getOutputStream());
            obj1.writeObject(this.B);

            obj2 = new ObjectOutputStream(mySocket2.getOutputStream());
            obj2.writeObject(this.B);

            if (B.getAmountOfWhite() == 6) {
                System.out.println("black wins !!!!!!!!!!!!!!");
                con.sql.setWinner((String)name1, IDgame);
            }
            if (B.getAmountOfBlack() == 6) {
                System.out.println("white wins !!!!!!!!!!!!!!");
                con.sql.setWinner((String)name2, IDgame);
            }
        } catch (IOException iOException) {
            System.out.println("abalon.play.playing() - 1");
        } catch (NumberFormatException numberFormatException) {
            System.out.println("abalon.play.playing() - 2");
        } catch (SQLException ex) {
            Logger.getLogger(play.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
    this function chack if the plyer picked his part or not
    if he picked his part return true if not return false
     */
    private boolean chackPoint(int R, int C) {

        if (P) {
            if (B.getGameBoard()[R][C].getType().equals(typeOfCell.black)) {
                return true;
            } else {
                Toolkit.getDefaultToolkit().beep();
                return false;
            }
        } else {
            if (B.getGameBoard()[R][C].getType().equals(typeOfCell.white)) {
                return true;
            } else {
                Toolkit.getDefaultToolkit().beep();
                return false;
            }
        }
    }

    /*
    this function chack if the move he want is pusible or not (after he pick a direction)
    if it's pusible return true if not return false
     */
    private boolean isPusible(cellIndexes point, String direction) {

        cellIndexes amount = new cellIndexes();
        boolean pusible = false;

        switch (direction) {
            case "w": {
                amount = chackWithDirection(point, -1, -1);
                pusible = canMove(amount, point);
                if (pusible) {
                    move(point, -1, -1);
                }
                break;
            }
            case "e": {
                amount = chackWithDirection(point, -1, 1);
                pusible = canMove(amount, point);
                if (pusible) {
                    move(point, -1, 1);
                }
                break;
            }
            case "d": {
                amount = chackWithDirection(point, 0, 2);
                pusible = canMove(amount, point);
                if (pusible) {
                    move(point, 0, 2);
                }
                break;
            }
            case "x": {
                amount = chackWithDirection(point, 1, 1);
                pusible = canMove(amount, point);
                if (pusible) {
                    move(point, 1, 1);
                }
                break;
            }
            case "z": {
                amount = chackWithDirection(point, 1, -1);
                pusible = canMove(amount, point);
                if (pusible) {
                    move(point, 1, -1);
                }
                break;
            }
            case "a": {
                amount = chackWithDirection(point, 0, -2);
                pusible = canMove(amount, point);
                if (pusible) {
                    move(point, 0, -2);
                }
                break;
            }
            default:
                return false;
        }

        if (!pusible) {
            Toolkit.getDefaultToolkit().beep();
        }
        return pusible;
    }

    /*
    this function chack if the move he wants can be
    (if the parts you move more then the moved)
     */
    private boolean canMove(cellIndexes amount, cellIndexes point) {

        if (K <= L) {
            return false;
        } else if (B.getGameBoard()[amount.getR()][amount.getC()].getType().equals(typeOfCell.empty)) {
            return true;
        } else if (L != 0 && B.getGameBoard()[amount.getR()][amount.getC()].getType().equals(typeOfCell.notUsed)) {
            if (P) {
                B.setAmountOfWhite(B.getAmountOfWhite() + 1);
            } else {
                B.setAmountOfBlack(B.getAmountOfBlack() + 1);
            }
            return true;
        }
        return false;
    }

    private int K, L;

    /*
    this function counting the parts of the playing now and 
    how much after them and put it on K and L
     */
    private cellIndexes chackWithDirection(cellIndexes point, int i, int j) {

        if (P) {
            for (K = 1; K < 3 && B.getGameBoard()[point.getR() + (i * K)][point.getC() + (j * K)].getType().equals(typeOfCell.black); K++);
            for (L = 0; L < 2 && B.getGameBoard()[point.getR() + (i * (K + L))][point.getC() + (j * (K + L))].getType().equals(typeOfCell.white); L++);
        } else {
            for (K = 1; K < 3 && B.getGameBoard()[point.getR() + (i * K)][point.getC() + (j * K)].getType().equals(typeOfCell.white); K++);
            for (L = 0; L < 2 && B.getGameBoard()[point.getR() + (i * (K + L))][point.getC() + (j * (K + L))].getType().equals(typeOfCell.black); L++);
        }
        cellIndexes point_1 = new cellIndexes();

        point_1.setR(point.getR() + (K + L) * i);
        point_1.setC(point.getC() + (K + L) * j);
        return point_1;

    }

    /*
    this function move the parts on the matrix and keep the matrix in B
     */
    private void move(cellIndexes point, int i, int j) {

        for (int S = K + L; S != 0; S--) {
            if (B.getGameBoard()[point.getR() + (S * i)][point.getC() + (S * j)].getType().equals(typeOfCell.notUsed)) {
                continue;
            } else {
                typeOfCell keep = B.getGameBoard()[point.getR() + (S * i) - i][point.getC() + (S * j) - j].getType();
                B.getGameBoard()[point.getR() + (S * i)][point.getC() + (S * j)].setType(keep);
            }
        }
        B.getGameBoard()[point.getR()][point.getC()].setType(typeOfCell.empty);

        myClasses.print P = new print(B);

    }

}
