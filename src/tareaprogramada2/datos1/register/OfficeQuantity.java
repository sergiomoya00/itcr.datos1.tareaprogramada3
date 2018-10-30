/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada2.datos1.register;

/**
 *
 * @author samoy
 */
public class OfficeQuantity {

    private int greenQuantity;
    private int yellowQuantity;
    private int redQuantity;
    private int attentionQuantity;

    public OfficeQuantity(int greenQuantity, int yellowQuantity, int redQuantity, int attentionQuantity) {
        
        this.greenQuantity = greenQuantity;
        this.yellowQuantity = yellowQuantity;
        this.redQuantity = redQuantity;
        this.attentionQuantity = attentionQuantity;
    
    }
    
    public OfficeQuantity(){
    }

    public int getGreenQuantity() {
        return greenQuantity;
    }

    public void setGreenQuantity(int greenQuantity) {
        this.greenQuantity = greenQuantity;
    }

    public int getYellowQuantity() {
        return yellowQuantity;
    }

    public void setYellowQuantity(int yellowQuantity) {
        this.yellowQuantity = yellowQuantity;
    }

    public int getRedQuantity() {
        return redQuantity;
    }

    public void setRedQuantity(int redQuantity) {
        this.redQuantity = redQuantity;
    }

    public int getAttentionQuantity() {
        return attentionQuantity;
    }

    public void setAttentionQuantity(int attentionQuantity) {
        this.attentionQuantity = attentionQuantity;
    }   

}


/**
 * private int uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,diez;
 *
 * public OfficeQuantity() { }
 *
 * public OfficeQuantity(int uno, int dos, int tres, int cuatro, int cinco, int
 * seis, int siete, int ocho, int nueve, int diez) { this.uno = 1; this.dos = 2;
 * }
 */
