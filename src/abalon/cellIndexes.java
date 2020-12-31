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
public class cellIndexes {
    
    private int r;
    private int c;

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
    

    public cellIndexes() {
    }

    public cellIndexes(int r, int c) {
        this.r = r;
        this.c = c;
    }/*
    public boolean eq(cellIndexes a){
    
    if(r==a.getR()&&c==a.getC()){
    return true;
    }
    return false;
    }*/
    void setR(Scanner SY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setC(Scanner SX) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void getR(int K) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void getC(int L) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
