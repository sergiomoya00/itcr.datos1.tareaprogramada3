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
public class Patient implements Comparable<Patient>{

    private String name;
    private String birthdate;
    private String illnessDetails;
    private String sufferingType;
    private int phone;
    private boolean doctor;
    private Ticket ticket;

    public Patient(String name, String birthdate, String illnessDetails, String sufferingType, int phone, boolean doctor, Ticket ticket) {
        this.name = name;
        this.birthdate = birthdate;
        this.illnessDetails = illnessDetails;
        this.sufferingType = sufferingType;
        this.phone = phone;
        this.doctor = doctor;
        this.ticket = ticket;
    }

    public Patient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getbirthdate() {
        return birthdate;
    }

    public void setbirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getillnessDetails() {
        return illnessDetails;
    }

    public void setillnessDetails(String details) {
        illnessDetails = details;
    }

    public String getsufferingType() {
        return sufferingType;
    }

    public void setsufferingType(String type) {
        sufferingType = type;
    }

    public int getphone() {
        return phone;
    }

    public void setphone(int phone) {
        this.phone = phone;
    }

    public boolean isdoctor() {
        return doctor;
    }

    public void setdoctor(boolean doctor) {
        this.doctor = doctor;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Patient{" + "name=" + name + ", birthdate=" + birthdate + ", illnessDetails=" + illnessDetails + ", sufferingType=" + sufferingType + ", phone=" + phone + ", doctor=" + doctor + ", ticket=" + ticket + '}';
    }

    @Override
    public int compareTo(Patient o) {
        return this.ticket.compareTo(o.ticket);
    }
}
