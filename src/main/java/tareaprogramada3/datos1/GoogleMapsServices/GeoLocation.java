/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada3.datos1.GoogleMapsServices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.DirectionsApi.RouteRestriction;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;
import java.io.IOException;

/**
 *
 * @author
 */
public class GeoLocation {

    public static long Distance() throws ApiException, InterruptedException, IOException {

        String addrOne = "Basilica de Los Angeles";
        String addrTwo = "Tecnologico de Costa Rica";
        //set up key
        GeoApiContext distCalcer = new GeoApiContext.Builder()
                .apiKey("AIzaSyDslDVmXZsDFmXRo6mTVcJXVSb6m5K-qBI")
                .build();

        DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(distCalcer);
        DistanceMatrix result = req.origins(addrOne)
                .destinations(addrTwo)
                .mode(TravelMode.DRIVING)
                .avoid(RouteRestriction.TOLLS)
                .language("es-ES")
                .await();

        long distApart = result.rows[0].elements[0].distance.inMeters;

        return distApart;
    }

    public static long Time() throws ApiException, InterruptedException, IOException {

        String addrOne = "Basilica de Los Angeles";
        String addrTwo = "Tecnologico de Costa Rica";
        //set up key
        GeoApiContext distCalcer = new GeoApiContext.Builder()
                .apiKey("AIzaSyDslDVmXZsDFmXRo6mTVcJXVSb6m5K-qBI")
                .build();

        DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(distCalcer);
        DistanceMatrix result = req.origins(addrOne)
                .destinations(addrTwo)
                .mode(TravelMode.DRIVING)
                .avoid(RouteRestriction.TOLLS)
                .language("es-ES")
                .await();

        long distApart = result.rows[0].elements[0].duration.inSeconds;

        return distApart;
    }

    public static void main(String[] args) throws ApiException, IOException, InterruptedException {
        LatLng lugar = new LatLng(37.09024, -95.712891);
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDslDVmXZsDFmXRo6mTVcJXVSb6m5K-qBI")
                .build();
        GeocodingResult[] results = results = GeocodingApi.reverseGeocode(context, lugar).await();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(results[0].addressComponents) + "\n" + "\n" + "____1__");
        System.out.println(gson.toJson(results[0].formattedAddress) + "\n" + "\n" + "____2__"); //Muestra la dirección completa
        System.out.println(gson.toJson(results[0].geometry.location.lat) + "\n" + "\n" + "____3__");
        System.out.println(gson.toJson(results[0].geometry.location.lng) + "\n" + "\n" + "____33__");
        System.out.println(gson.toJson(results[0].partialMatch) + "\n" + "\n" + "____4__");
        System.out.println(gson.toJson(results[0].placeId) + "\n" + "\n" + "____5__");
        System.out.println(gson.toJson(results[0].plusCode) + "\n" + "\n" + "____6__");
        System.out.println(gson.toJson(results[0].postcodeLocalities) + "\n" + "\n" + "____7__");
        System.out.println(gson.toJson(results[0].types) + "\n" + "\n" + "____8__");
        System.out.println(gson.toJson(results[0].addressComponents[1]) + "\n" + "\n" + "____9__");
        Long kk = Distance();
        System.out.println(kk);
        Long aa = Time();
        System.out.println(aa);

    }
}
