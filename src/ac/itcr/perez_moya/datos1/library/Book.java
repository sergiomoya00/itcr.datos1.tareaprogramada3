/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.itcr.perez_moya.datos1.library;


public class Book {
    
    private String name, topic, description, issn;
    private int soldBooks, availableBooks;
    private float price;
    private String imagePath;

    public Book() {
    }
    
    public Book(String name, String topic, String description, String issn, int soldBooks, int availableBooks, int price, String imagePath) {
        this.name = name;
        this.topic = topic;
        this.description = description;
        this.issn = issn;
        this.soldBooks = soldBooks;
        this.availableBooks = availableBooks;
        this.price = price;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public int getSoldBooks() {
        return soldBooks;
    }

    public void setSoldBooks(int soldBooks) {
        this.soldBooks = soldBooks;
    }

    public int getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(int availableBooks) {
        this.availableBooks = availableBooks;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    
}
