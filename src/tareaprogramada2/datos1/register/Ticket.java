/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada2.datos1.register;

public class Ticket implements Comparable<Ticket> {

    ColorPatientCondition color;
    IncidentPatientCondition cause;
    int ticket;

    @Override
    public int compareTo(Ticket o) {
        int result = this.color.compareTo(o.color);
        if (result != 0) {
            return result;
        }
        
        result = this.cause.compareTo(o.cause);
        if (result != 0){
            return result;
        }
        
        ticket = this.cause.compareTo(o.cause);
            if (result != 0){
            return ticket;
            }
            return 0;
        }


}
