/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.itcr.perez_moya.datos1.library.user;

/**
 *
 * @author samoy
 */
public class Customer {

    private String nameCustomer, email, id, address, phoneCustomer;

    public Customer(String nameCustomer, String email, String id, String address, String phoneCustomer) {
        this.nameCustomer = nameCustomer;
        this.email = email;
        this.id = id;
        this.address = address;
        this.phoneCustomer = phoneCustomer;
    }

    public Customer() {
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneCustomer() {
        return phoneCustomer;
    }

    public void setPhoneCustomer(String phoneCustomer) {
        this.phoneCustomer = phoneCustomer;
    }

}
