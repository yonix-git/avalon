/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abalon;

import myClasses.print;
import myClasses.cellIndexes;
import myClasses.typeOfCell;
import myClasses.board;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
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
    private BufferedReader b1 = null;
    private BufferedReader b2 = null;

    public play() {
        this.B = new board();
    }

    public play(board B) {
        this.B = B;
    }

    public void playing(Socket mySocket1, Socket mySocket2) throws IOException {

        InputStreamReader input1 = new InputStreamReader(mySocket1.getInputStream());
        b1 = new BufferedReader(input1);

        InputStreamReader input2 = new InputStreamReader(mySocket2.getInputStream());
        b2 = new BufferedReader(input2);

        Object obj;
        ObjectInputStream getInput1;
        inputDitels getDitels;

        try {
            String direction;
            while (B.getAmountOfBlack() > 8 && B.getAmountOfWhite() > 8) {

                direction = null;
                cellIndexes point = new cellIndexes();

                do {

                    do {
                        if (P) {
                            getInput1 = new ObjectInputStream(mySocket1.getInputStream());
                            obj = getInput1.readObject();
                            getDitels = (inputDitels) obj;
                            point.setR(getDitels.getRow());
                            point.setC(getDitels.getColumn());
                            direction = getDitels.getDir();
                        } else {
                            ObjectInputStream getInput2 = new ObjectInputStream(mySocket2.getInputStream());
                            obj = getInput2.readObject();
                            getDitels = (inputDitels) obj;
                            point.setR(getDitels.getRow());
                            point.setC(getDitels.getColumn());
                            direction = getDitels.getDir();
                        }
                    } while (!chackPoint(getDitels.getRow(), getDitels.getColumn()));

                } while (!isPusible(point, direction));

                /*do {
                
                do {
                
                System.out.println("put row:");
                if (P) {
                String S = b1.readLine();
                if (S.equals("1") || S.equals("2") || S.equals("3")
                || S.equals("4") || S.equals("5") || S.equals("6")
                || S.equals("7") || S.equals("8") || S.equals("9")) {
                
                point.setR(Integer.parseInt(S));
                }
                } else {
                String S = b2.readLine();
                if (S.equals("1") || S.equals("2") || S.equals("3")
                || S.equals("4") || S.equals("5") || S.equals("6")
                || S.equals("7") || S.equals("8") || S.equals("9")) {
                
                point.setR(Integer.parseInt(S));
                }
                }
                
                } while (!(point.getR() > 0 && point.getR() < 10));
                
                do {
                
                System.out.println("put colomn:");
                if (P) {
                String S = b1.readLine();
                if (S.equals("2") || S.equals("3") || S.equals("4")
                || S.equals("5") || S.equals("6") || S.equals("7")
                || S.equals("8") || S.equals("9") || S.equals("10")
                || S.equals("11") || S.equals("12") || S.equals("13")
                || S.equals("14") || S.equals("15") || S.equals("16")
                || S.equals("17") || S.equals("18")) {
                
                point.setC(Integer.parseInt(S));
                }
                } else {
                String S = b2.readLine();
                if (S.equals("2") || S.equals("3") || S.equals("4")
                || S.equals("5") || S.equals("6") || S.equals("7")
                || S.equals("8") || S.equals("9") || S.equals("10")
                || S.equals("11") || S.equals("12") || S.equals("13")
                || S.equals("14") || S.equals("15") || S.equals("16")
                || S.equals("17") || S.equals("18")) {
                
                point.setC(Integer.parseInt(S));
                }
                }
                
                } while (!(point.getC() > 1 && point.getC() < 19));
                
                } while (!chackPoint(point.getR(), point.getC()));
                
                System.out.println("-----");
                
                do {
                System.out.println("put dir:");
                if (P) {
                direction = b1.readLine();
                } else {
                direction = b2.readLine();
                }
                
                } while (!isPusible(point, direction));*/
                if(P){
                ObjectOutputStream obj1 = new ObjectOutputStream(mySocket1.getOutputStream());
                obj1.writeObject(this.B);
                }else{

                ObjectOutputStream obj2 = new ObjectOutputStream(mySocket2.getOutputStream());
                obj2.writeObject(this.B);
                }

                P = !P;
            }
            if (B.getAmountOfWhite() == 8) {
                System.out.println("black wins !!!!!!!!!!!!!!");
            }
            if (B.getAmountOfBlack() == 8) {
                System.out.println("white wins !!!!!!!!!!!!!!");
            }
        } catch (IOException iOException) {
            System.out.println("abalon.play.playing() - 1");
        } catch (NumberFormatException numberFormatException) {
            System.out.println("abalon.play.playing() - 2");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(play.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean chackPoint(int R, int C) {

        if (P) {
            if (B.getGameBoard()[R][C].getType().equals(typeOfCell.black)) {
                return true;
            } else {
                return false;
            }
        } else {
            if (B.getGameBoard()[R][C].getType().equals(typeOfCell.white)) {
                return true;
            } else {
                return false;
            }
        }
    }

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

        return pusible;
    }

    private boolean canMove(cellIndexes amount, cellIndexes point) {

        if (K <= L) {
            return false;
        } else if (B.getGameBoard()[amount.getR()][amount.getC()].getType().equals(typeOfCell.empty)) {
            return true;
        } else if (L != 0 && B.getGameBoard()[amount.getR()][amount.getC()].getType().equals(typeOfCell.notUsed)) {
            if (P) {
                B.setAmountOfWhite(B.getAmountOfWhite() - 1);
            } else {
                B.setAmountOfBlack(B.getAmountOfBlack() - 1);
            }
            return true;
        }
        return false;
    }

    private int K, L;

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
