/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada3.datos1.administration;

import java.awt.Image;

/**
 *
 * @author
 */
public class Place {
    String PlaceID;
    String exactAddress;
    double latitude;
    double longitude;
    String phoneNumber;
    float rating;
    String webSite;
    String url;
    String schedule;
    String typePlace;
    Image photo=null;

    public Place() {
    }

    public Place(String PlaceID, String exactAddress, double latitude, double longitude, String phoneNumber, float rating, String webSite, String url, String schedule, String typePlace, Image photo) {
        this.PlaceID = PlaceID;
        this.exactAddress = exactAddress;
        this.latitude = latitude;
        this.longitude = longitude;
        this.phoneNumber = phoneNumber;
        this.rating = rating;
        this.webSite = webSite;
        this.url = url;
        this.schedule = schedule;
        this.typePlace = typePlace;
        this.photo = photo;
    }

    public String getPlaceID() {
        return PlaceID;
    }

    public void setPlaceID(String PlaceID) {
        this.PlaceID = PlaceID;
    }

    public String getExactAddress() {
        return exactAddress;
    }

    public void setExactAddress(String exactAddress) {
        this.exactAddress = exactAddress;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getTypePlace() {
        return typePlace;
    }

    public void setTypePlace(String typePlace) {
        this.typePlace = typePlace;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Place{" + "PlaceID=" + PlaceID + ", exactAddress=" + exactAddress + ", latitude=" + latitude + ", longitude=" + longitude + ", phoneNumber=" + phoneNumber + ", rating=" + rating + ", webSite=" + webSite + ", url=" + url + ", schedule=" + schedule + ", typePlace=" + typePlace + ", photo=" + photo + '}';
    }
    
}
