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
public class cell {

    private typeOfCell type;

    public cell() {
        this.type = typeOfCell.notUsed;
    }

    public cell(typeOfCell type) {
        this.type = type;
    }
    


    public cell(int type) {
        switch (type) {
            case (0): {
                this.type = typeOfCell.notUsed;
                break;
            }
            case (1): {
                this.type = typeOfCell.empty;
                break;
            }
            case (2): {
                this.type = typeOfCell.black;
                break;
            }
            case (3): {
                this.type = typeOfCell.white;
                break;
            }
            default: {
                this.type = typeOfCell.notUsed;
            }

        }
    }

    public typeOfCell getType() {
        return type;
    }

    public void setType(int type) {
        switch (type) {
            case (0): {
                this.type = typeOfCell.notUsed;
                break;
            }
            case (1): {
                this.type = typeOfCell.empty;
                break;
            }
            case (2): {
                this.type = typeOfCell.black;
                break;
            }
            case (3): {
                this.type = typeOfCell.white;
                break;
            }
            default: {
                this.type = typeOfCell.notUsed;
            }
        }
    } 

}

enum typeOfCell {

    black,
    white,
    empty,
    notUsed
}
