/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada3.datos1.GoogleMapsServices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

/**
 *
 * @author
 */
public class GeoCode {
//Obtiene la dirección del lugar
    
    public static void main(String[] args) {

        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDslDVmXZsDFmXRo6mTVcJXVSb6m5K-qBI")
                .build();
        GeocodingResult[] results = GeocodingApi.geocode(context,
                "Escuela").awaitIgnoreError();        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(results[0].addressComponents)+"\n"+"\n"+"____1__");
        System.out.println(gson.toJson(results[0].formattedAddress)+"\n"+"\n"+"____2__"); //Muestra la dirección completa
        System.out.println(gson.toJson(results[0].geometry.location.lat)+"\n"+"\n"+"____3__");
        System.out.println(gson.toJson(results[0].geometry.location.lng)+"\n"+"\n"+"____33__");
        System.out.println(gson.toJson(results[0].partialMatch)+"\n"+"\n"+"____4__");
        System.out.println(gson.toJson(results[0].placeId)+"\n"+"\n"+"____5__");
        System.out.println(gson.toJson(results[0].plusCode)+"\n"+"\n"+"____6__");
        System.out.println(gson.toJson(results[0].postcodeLocalities)+"\n"+"\n"+"____7__");
        System.out.println(gson.toJson(results[0].types)+"\n"+"\n"+"____8__");
        
        LatLng lugar = new LatLng(37.09024,-95.712891);
        
    }
}