/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada3.datos1.administration;

import tareaprogramada3.datos1.structures.Graph.Grafo;

/**
 *
 * @author
 */
public class Clients {
    private String name;
    private int id;
    private int telephone;
    private String mail;
    private String birth;
    private Grafo subgraph;

    public Grafo getSubgraph() {
        return subgraph;
    }

    public void setSubgraph(Grafo subgraph) {
        this.subgraph = subgraph;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
    
}