/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abalon;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class play {

    public play() {
        this.B = new board();
    }

    public play(board B) {
        this.B = B;
    }
    private board B;
    private boolean P = true;

    public void playing(board B) {

        String direction;
        while (B.getAmountOfBlack() > 8 && B.getAmountOfWhite() > 8) {

            direction = null;
            Scanner S = new Scanner(System.in);
            Scanner in = new Scanner(System.in);
            cellIndexes point = new cellIndexes();

            do {

                do {

                    System.out.println("put row:");
                    point.setR(S.nextInt());
                } while (!(point.getR() > 0 && point.getR() < 10));
                do {

                    System.out.println("put colomn:");
                    point.setC(S.nextInt());
                } while (!(point.getC() > 1 && point.getC() < 19));

            } while (!chackPoint(point.getR(), point.getC()));

            System.out.println("good");

            do {
                System.out.println("put dir:");
                direction = in.nextLine();
            } while (!isPusible(point, direction));

            /*boolean m = isPusible(point, direction);
            System.out.println(m);*/
            P = !P;
        }
        if (B.getAmountOfWhite() == 8) {
            System.out.println("black wins !!!!!!!!!!!!!!");
        }
        if (B.getAmountOfBlack() == 8) {
            System.out.println("white wins !!!!!!!!!!!!!!");
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
            }else{
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

        System.out.println("K = " + K);
        System.out.println("L = " + L);

        point_1.setR(point.getR() + (K + L) * i);
        point_1.setC(point.getC() + (K + L) * j);
        return point_1;

    }
    private void move(cellIndexes point, int i, int j) {
        
        for (int S = K + L;S != 0; S--) {
            if(B.getGameBoard()[point.getR() + (S * i)][point.getC() + (S * j)].getType().equals(typeOfCell.notUsed)){
                continue;
            }else{
        typeOfCell keep = B.getGameBoard()[point.getR() + (S * i) - i][point.getC() + (S * j) - j].getType();
            B.getGameBoard()[point.getR() + (S * i)][point.getC() + (S * j)].setType(keep);
            }
        }
        B.getGameBoard()[point.getR()][point.getC()].setType(typeOfCell.empty);
        
        print P = new print(B);
        
    }

}