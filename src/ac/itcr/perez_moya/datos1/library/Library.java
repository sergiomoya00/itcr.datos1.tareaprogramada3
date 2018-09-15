/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.itcr.perez_moya.datos1.library;

/**
 *
 * @author julatec
 */
public class Library {
    private String country, location, nameLib, phone;
    private int horario;

    public Library(String country, String location, String nameLib, int id, int horario) {
        this.country = country;
        this.location = location;
        this.nameLib = nameLib;
        this.phone = phone;
        this.horario = horario;
    }

    public Library() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNameLib() {
        return nameLib;
    }

    public void setNameLib(String nameLib) {
        this.nameLib = nameLib;
    }

    public String getPhone() {
        return phone;
    }
    

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }
    
    
    
}
