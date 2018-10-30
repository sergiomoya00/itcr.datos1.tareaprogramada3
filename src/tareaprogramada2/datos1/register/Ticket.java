/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada2.datos1.register;

public class Ticket implements Comparable<Ticket> {

    ColorPatientCondition color;
    IncidentPatientCondition cause;
    Integer ticket;

    public Ticket(ColorPatientCondition color, IncidentPatientCondition cause, Integer ticket) {
        this.color = color;
        this.cause = cause;
        this.ticket = ticket;
    }
    
    
    public Ticket (){
    }

    public ColorPatientCondition getColor() {
        return color;
    }

    public void setColor(ColorPatientCondition color) {
        this.color = color;
    }

    public IncidentPatientCondition getCause() {
        return cause;
    }

    public void setCause(IncidentPatientCondition cause) {
        this.cause = cause;
    }

    public Integer getTicket() {
        return ticket;
    }

    public void setTicket(Integer ticket) {
        this.ticket = ticket;
    }
    
    

    @Override
    public int compareTo(Ticket o) {
        int result = this.color.compareTo(o.color);
        if (result != 0) {
            return result;
        }

        result = this.cause.compareTo(o.cause);
        if (result != 0) {
            return result;
        }

        return this.ticket.compareTo(o.ticket);

    }

    @Override
    public String toString() {
        return "Ticket{" + "color=" + color + ", cause=" + cause + ", ticket=" + ticket + '}';
    }
    
    
    
}
