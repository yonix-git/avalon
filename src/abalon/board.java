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
public class board {
    private cell gameBoard[][];
    private int amountOfBlack;
    private int amountOfWhite;

    public board() {
        this.gameBoard = new cell[11][21];
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 21; j++) {
                this.gameBoard[i][j] = new cell();
            }
        }
        gameBoard = sb(gameBoard);
    }

    public board(cell[][] gameBoard) {
        this.gameBoard = gameBoard;
    }
    
    public cell[][] sb(cell[][] tmp){
        
          listsOfCellsByType locb = new listsOfCellsByType();
          
        for (int i = 0; i < locb.getToBeNotUsed().size(); i++) {
            tmp[locb.getToBeNotUsed().get(i).getR()][locb.getToBeNotUsed().get(i).getC()].setType(0);
        }
        for (int i = 0; i < locb.getToBeEmpty().size(); i++) {
            tmp[locb.getToBeEmpty().get(i).getR()][locb.getToBeEmpty().get(i).getC()].setType(1);
        }
        for (int i = 0; i < locb.getToBeBlack().size(); i++) {
            tmp[locb.getToBeBlack().get(i).getR()][locb.getToBeBlack().get(i).getC()].setType(2);
        }
        for (int i = 0; i < locb.getToBeWhite().size(); i++) {
            tmp[locb.getToBeWhite().get(i).getR()][locb.getToBeWhite().get(i).getC()].setType(3);
        }
        
        setAmountOfBlack(locb.getToBeBlack().size());
        setAmountOfWhite(locb.getToBeWhite().size());
        return tmp;
    }
    
    public cell[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(cell[][] gameBoard) {
        this.gameBoard = gameBoard;
    }
    public int getAmountOfBlack() {
        return amountOfBlack;
    }

    public void setAmountOfBlack(int amountOfBlack) {
        this.amountOfBlack = amountOfBlack;
    }

    public int getAmountOfWhite() {
        return amountOfWhite;
    }

    public void setAmountOfWhite(int amountOfWhite) {
        this.amountOfWhite = amountOfWhite;
    }
}

