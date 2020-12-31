/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abalon;

import java.util.LinkedList;

/**
 *
 * @author user
 */
public class listsOfCellsByType {

    private LinkedList<cellIndexes> toBeNotUsed;
    private LinkedList<cellIndexes> toBeEmpty;
    private LinkedList<cellIndexes> toBeBlack;
    private LinkedList<cellIndexes> toBeWhite;
    
    public listsOfCellsByType() {
        this.toBeNotUsed = new LinkedList<>();
        this.toBeEmpty = new LinkedList<>();
        this.toBeBlack = new LinkedList<>();
        this.toBeWhite = new LinkedList<>();
        
        addToToBeNotUsed();
        addToToBeEmpty();
        addToToBeWhite();
        addToToBeBlack();
    }

    public LinkedList<cellIndexes> getToBeNotUsed() {
        return toBeNotUsed;
    }

    public void setToBeNotUsed(LinkedList<cellIndexes> toBeNotUsed) {
        this.toBeNotUsed = toBeNotUsed;
    }

    public LinkedList<cellIndexes> getToBeEmpty() {
        return toBeEmpty;
    }

    public void setToBeEmpty(LinkedList<cellIndexes> toBeEmpty) {
        this.toBeEmpty = toBeEmpty;
    }

    public LinkedList<cellIndexes> getToBeBlack() {
        return toBeBlack;
    }

    public void setToBeBlack(LinkedList<cellIndexes> toBeBlack) {
        this.toBeBlack = toBeBlack;
    }

    public LinkedList<cellIndexes> getToBeWhite() {
        return toBeWhite;
    }

    public void setToBeWhite(LinkedList<cellIndexes> toBeWhite) {
        this.toBeWhite = toBeWhite;
    }


    private void addToToBeNotUsed() {
        //row 0
        for (int i = 0; i < 21; i++) {
            
        toBeNotUsed.add(new cellIndexes(0, i));
        }
        
        //row 1
        toBeNotUsed.add(new cellIndexes(1, 0));
        toBeNotUsed.add(new cellIndexes(1, 1));
        toBeNotUsed.add(new cellIndexes(1, 2));
        toBeNotUsed.add(new cellIndexes(1, 3));
        toBeNotUsed.add(new cellIndexes(1, 4));
        toBeNotUsed.add(new cellIndexes(1, 5));
        toBeNotUsed.add(new cellIndexes(1, 7));
        toBeNotUsed.add(new cellIndexes(1, 9));
        toBeNotUsed.add(new cellIndexes(1, 11));
        toBeNotUsed.add(new cellIndexes(1, 13));
        toBeNotUsed.add(new cellIndexes(1, 15));
        toBeNotUsed.add(new cellIndexes(1, 16));
        toBeNotUsed.add(new cellIndexes(1, 17));
        toBeNotUsed.add(new cellIndexes(1, 18));
        toBeNotUsed.add(new cellIndexes(1, 19));
        toBeNotUsed.add(new cellIndexes(1, 20));

        //row 2
        toBeNotUsed.add(new cellIndexes(2, 0));
        toBeNotUsed.add(new cellIndexes(2, 1));
        toBeNotUsed.add(new cellIndexes(2, 2));
        toBeNotUsed.add(new cellIndexes(2, 3));
        toBeNotUsed.add(new cellIndexes(2, 4));
        toBeNotUsed.add(new cellIndexes(2, 6));
        toBeNotUsed.add(new cellIndexes(2, 8));
        toBeNotUsed.add(new cellIndexes(2, 10));
        toBeNotUsed.add(new cellIndexes(2, 12));
        toBeNotUsed.add(new cellIndexes(2, 14));
        toBeNotUsed.add(new cellIndexes(2, 16));
        toBeNotUsed.add(new cellIndexes(2, 17));
        toBeNotUsed.add(new cellIndexes(2, 18));
        toBeNotUsed.add(new cellIndexes(2, 19));
        toBeNotUsed.add(new cellIndexes(2, 20));

        //row 3
        toBeNotUsed.add(new cellIndexes(3, 0));
        toBeNotUsed.add(new cellIndexes(3, 1));
        toBeNotUsed.add(new cellIndexes(3, 2));
        toBeNotUsed.add(new cellIndexes(3, 3));
        toBeNotUsed.add(new cellIndexes(3, 5));
        toBeNotUsed.add(new cellIndexes(3, 7));
        toBeNotUsed.add(new cellIndexes(3, 9));
        toBeNotUsed.add(new cellIndexes(3, 11));
        toBeNotUsed.add(new cellIndexes(3, 13));
        toBeNotUsed.add(new cellIndexes(3, 15));
        toBeNotUsed.add(new cellIndexes(3, 17));
        toBeNotUsed.add(new cellIndexes(3, 18));
        toBeNotUsed.add(new cellIndexes(3, 19));
        toBeNotUsed.add(new cellIndexes(3, 20));
        
        //row 4
        
        toBeNotUsed.add(new cellIndexes(4, 0));
        toBeNotUsed.add(new cellIndexes(4, 1));
        toBeNotUsed.add(new cellIndexes(4, 2));
        toBeNotUsed.add(new cellIndexes(4, 4));
        toBeNotUsed.add(new cellIndexes(4, 6));
        toBeNotUsed.add(new cellIndexes(4, 8));
        toBeNotUsed.add(new cellIndexes(4, 10));
        toBeNotUsed.add(new cellIndexes(4, 12));
        toBeNotUsed.add(new cellIndexes(4, 14));
        toBeNotUsed.add(new cellIndexes(4, 16));
        toBeNotUsed.add(new cellIndexes(4, 18));
        toBeNotUsed.add(new cellIndexes(4, 19));
        toBeNotUsed.add(new cellIndexes(4, 20));

        //row 5
        for (int i = 1; i < 20; i += 2) {
            toBeNotUsed.add(new cellIndexes(5, i));
        }
        
        toBeNotUsed.add(new cellIndexes(5, 0));
        toBeNotUsed.add(new cellIndexes(5, 20));

        //row 6
        toBeNotUsed.add(new cellIndexes(6, 0));
        toBeNotUsed.add(new cellIndexes(6, 1));
        toBeNotUsed.add(new cellIndexes(6, 2));
        toBeNotUsed.add(new cellIndexes(6, 4));
        toBeNotUsed.add(new cellIndexes(6, 6));
        toBeNotUsed.add(new cellIndexes(6, 8));
        toBeNotUsed.add(new cellIndexes(6, 10));
        toBeNotUsed.add(new cellIndexes(6, 12));
        toBeNotUsed.add(new cellIndexes(6, 14));
        toBeNotUsed.add(new cellIndexes(6, 16));
        toBeNotUsed.add(new cellIndexes(6, 18));
        toBeNotUsed.add(new cellIndexes(6, 19));
        toBeNotUsed.add(new cellIndexes(6, 20));

        //row 7
        toBeNotUsed.add(new cellIndexes(7, 0));
        toBeNotUsed.add(new cellIndexes(7, 1));
        toBeNotUsed.add(new cellIndexes(7, 2));
        toBeNotUsed.add(new cellIndexes(7, 3));
        toBeNotUsed.add(new cellIndexes(7, 5));
        toBeNotUsed.add(new cellIndexes(7, 7));
        toBeNotUsed.add(new cellIndexes(7, 9));
        toBeNotUsed.add(new cellIndexes(7, 11));
        toBeNotUsed.add(new cellIndexes(7, 13));
        toBeNotUsed.add(new cellIndexes(7, 15));
        toBeNotUsed.add(new cellIndexes(7, 17));
        toBeNotUsed.add(new cellIndexes(7, 18));
        toBeNotUsed.add(new cellIndexes(7, 19));
        toBeNotUsed.add(new cellIndexes(7, 20));

        //row 8
        toBeNotUsed.add(new cellIndexes(8, 0));
        toBeNotUsed.add(new cellIndexes(8, 1));
        toBeNotUsed.add(new cellIndexes(8, 2));
        toBeNotUsed.add(new cellIndexes(8, 3));
        toBeNotUsed.add(new cellIndexes(8, 4));
        toBeNotUsed.add(new cellIndexes(8, 6));
        toBeNotUsed.add(new cellIndexes(8, 8));
        toBeNotUsed.add(new cellIndexes(8, 10));
        toBeNotUsed.add(new cellIndexes(8, 12));
        toBeNotUsed.add(new cellIndexes(8, 14));
        toBeNotUsed.add(new cellIndexes(8, 16));
        toBeNotUsed.add(new cellIndexes(8, 17));
        toBeNotUsed.add(new cellIndexes(8, 18));
        toBeNotUsed.add(new cellIndexes(8, 19));
        toBeNotUsed.add(new cellIndexes(8, 20));

        //row 9
        toBeNotUsed.add(new cellIndexes(9, 0));
        toBeNotUsed.add(new cellIndexes(9, 1));
        toBeNotUsed.add(new cellIndexes(9, 2));
        toBeNotUsed.add(new cellIndexes(9, 3));
        toBeNotUsed.add(new cellIndexes(9, 4));
        toBeNotUsed.add(new cellIndexes(9, 5));
        toBeNotUsed.add(new cellIndexes(9, 7));
        toBeNotUsed.add(new cellIndexes(9, 9));
        toBeNotUsed.add(new cellIndexes(9, 11));
        toBeNotUsed.add(new cellIndexes(9, 13));
        toBeNotUsed.add(new cellIndexes(9, 15));
        toBeNotUsed.add(new cellIndexes(9, 16));
        toBeNotUsed.add(new cellIndexes(9, 17));
        toBeNotUsed.add(new cellIndexes(9, 18));
        toBeNotUsed.add(new cellIndexes(9, 19));
        toBeNotUsed.add(new cellIndexes(9, 20));

    }

    private void addToToBeEmpty() {
        //row 3
        for (int i = 4; i < 17; i += 2) {
            toBeEmpty.add(new cellIndexes(3, i));
        }
        
        //row 4
        for (int i = 3; i < 18; i += 2) {
            toBeEmpty.add(new cellIndexes(4, i));
        }
        
        //row 5
        for (int i = 2; i < 19; i += 2) {
            toBeEmpty.add(new cellIndexes(5, i));
        }
        
        //row 6
        for (int i = 3; i < 18; i += 2) {
            toBeEmpty.add(new cellIndexes(6, i));
        }
        
        //row 7
        for (int i = 4; i < 17; i += 2) {
            toBeEmpty.add(new cellIndexes(7, i));
        }
    }

    private void addToToBeBlack() {
        //row 9
        for (int i = 6; i < 15; i += 2) {
            toBeBlack.add(new cellIndexes(9, i));
        }
        
        //row 8
        for (int i = 5; i < 16; i += 2) {
            toBeBlack.add(new cellIndexes(8, i));
        }
        
        //row 7
        toBeBlack.add(new cellIndexes(7, 8));
        toBeBlack.add(new cellIndexes(7, 10));
        toBeBlack.add(new cellIndexes(7, 12));
    }

    private void addToToBeWhite() {
        //row 1
        for (int i = 6; i < 15; i += 2) {
            toBeWhite.add(new cellIndexes(1, i));
        }
        
        //row 2
        for (int i = 5; i < 16; i += 2) {
            toBeWhite.add(new cellIndexes(2, i));
        }
        
        //row 3
        toBeWhite.add(new cellIndexes(3, 8));
        toBeWhite.add(new cellIndexes(3, 10));
        toBeWhite.add(new cellIndexes(3, 12));
    }

}
