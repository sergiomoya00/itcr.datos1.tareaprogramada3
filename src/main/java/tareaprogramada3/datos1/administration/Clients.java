/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada3.datos1.administration;

import tareaprogramada3.datos1.structures.Graph.*;

public class Clients implements Comparable<Clients> {
    public String name;
    public int id;
    public int telephone;
    public String mail;
    public String birth;
    public GraphLeader subgraph;

    public Clients(String name, int id, int telephone, String mail, String birth, GraphLeader subgraph) {
        this.name = name;
        this.id = id;
        this.telephone = telephone;
        this.mail = mail;
        this.birth = birth;
        this.subgraph = subgraph;
    }

    public Clients(GraphLeader subgraph) {
        this.subgraph = subgraph;
    }
    
    

    public GraphLeader getSubgraph() {
        return subgraph;
    }

    public void setSubgraph(GraphLeader subgraph) {
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

    @Override
    public int compareTo(Clients o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
