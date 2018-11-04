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

/**
 *
 * @author
 */
public class GeoCode {

    public static void main(String[] args) {

        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDslDVmXZsDFmXRo6mTVcJXVSb6m5K-qBI")
                .build();
        GeocodingResult[] results = GeocodingApi.geocode(context,
                "1600 Amphitheatre Parkway Mountain View, CA 94043").awaitIgnoreError();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(results[0].addressComponents));
    }
}