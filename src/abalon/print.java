/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abalon;

/**
 *
 * @author user
 */
public class print {

    public void printBoard(board B){
        for (int i = 0; i < B.getGameBoard().length; i++) {
            for (int j = 0; j < B.getGameBoard()[0].length; j++) {
                switch(B.getGameBoard()[i][j].getType()){
                    case notUsed:{
                        System.out.print(" ");
                        break;
                    }
                    case empty:{
                        System.out.print("1");
                        break;
                    }
                    case black:{
                        System.out.print("2");
                        break;
                    }
                    case white:{
                        System.out.print("3");
                        break;
                    }
                    default:
                }
            }
            System.out.println("");
        }
        
        System.out.println(B.getAmountOfBlack());
        System.out.println(B.getAmountOfWhite());
        /*
        for (int i = 0; i < 4; i++) {
        System.out.println("");
        }
        System.out.println("    3 3 3 3 3    ");
        System.out.println("   3 3 3 3 3 3   ");
        System.out.println("  1 1 3 3 3 1 1  ");
        System.out.println(" 1 1 1 1 1 1 1 1 ");
        System.out.println("1 1 1 1 1 1 1 1 1");
        System.out.println(" 1 1 1 1 1 1 1 1 ");
        System.out.println("  1 1 2 2 2 1 1  ");
        System.out.println("   2 2 2 2 2 2   ");
        System.out.println("    2 2 2 2 2    ");*/
    }
}
