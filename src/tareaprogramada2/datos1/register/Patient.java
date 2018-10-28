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
public class Patient {

    private String name;
    private String birthdate;
    private String illnessDetails;
    private String sufferingType;
    private String token;
    private int phone;
    private boolean doctor;
    private int numberTab;
    private int priority;

    public Patient(String name, String birthdate, String illnessDetails, String sufferingType, String token, int phone, boolean doctor, int numbernumberTab, int priority) {
        this.name = name;
        this.birthdate = birthdate;
        this.illnessDetails = illnessDetails;
        this.sufferingType = sufferingType;
        this.token = token;
        this.phone = phone;
        this.doctor = doctor;
        this.numberTab = numberTab;
        this.priority = priority;
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

    public String gettoken() {
        return token;
    }

    public void settoken(String token) {
        this.token = token;
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

    public int getpriority() {
        return priority;
    }

    public void setpriority(int priority) {
        this.priority = priority;
    }

    public int getnumberTab() {
        return numberTab;
    }

    public void setnumberTab(int numberTab) {
        this.numberTab = numberTab;
    }

    @Override
    public String toString() {
        return "Patient{" + "name=" + name + ", birthdate=" + birthdate + ", illnessDetails=" + illnessDetails + ", sufferingType=" + sufferingType + ", token=" + token + ", phone=" + phone + ", doctor=" + doctor + ", numberTab=" + numberTab + ", priority=" + priority + '}';
    }
}
