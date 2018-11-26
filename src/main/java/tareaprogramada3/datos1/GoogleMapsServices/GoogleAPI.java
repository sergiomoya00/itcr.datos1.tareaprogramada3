/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada3.datos1.GoogleMapsServices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.maps.DirectionsApi;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;
import com.google.maps.model.TravelMode;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

/**
 *
 * @author
 */
public class GoogleAPI {

    public static String PlaceID(String place) throws ApiException, InterruptedException, IOException {
        String PlaceID;
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDslDVmXZsDFmXRo6mTVcJXVSb6m5K-qBI")
                .build();
        GeocodingResult[] results = GeocodingApi.geocode(context,
                place).awaitIgnoreError();
        PlaceID = results[0].placeId;
        return PlaceID;
    }

    public static String ExactAddress(String place) throws ApiException, InterruptedException, IOException {
        String Address;
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDslDVmXZsDFmXRo6mTVcJXVSb6m5K-qBI")
                .build();
        GeocodingResult[] results = GeocodingApi.geocode(context,
                place).awaitIgnoreError();
        Address = results[0].formattedAddress;
        return Address;
    }

    public static double Latitude(String place) throws ApiException, InterruptedException, IOException {
        double Latitude;
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDslDVmXZsDFmXRo6mTVcJXVSb6m5K-qBI")
                .build();
        GeocodingResult[] results = GeocodingApi.geocode(context,
                place).awaitIgnoreError();
        Latitude = results[0].geometry.location.lat;
        return Latitude;
    }

    public static double Longitude(String place) throws ApiException, InterruptedException, IOException {
        double Longitude;
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDslDVmXZsDFmXRo6mTVcJXVSb6m5K-qBI")
                .build();
        GeocodingResult[] results = GeocodingApi.geocode(context,
                place).awaitIgnoreError();
        Longitude = results[0].geometry.location.lng;
        return Longitude;
    }

    public static String PhoneNumber(String place) throws ApiException, InterruptedException, IOException {
        String Phone;
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDslDVmXZsDFmXRo6mTVcJXVSb6m5K-qBI")
                .build();
        com.google.maps.model.PlaceDetails results = PlacesApi.placeDetails(context, "place").await();
        Phone = results.internationalPhoneNumber;
        return Phone;
    }

    public static float Rating(String place) throws ApiException, InterruptedException, IOException {
        float Rating;
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDslDVmXZsDFmXRo6mTVcJXVSb6m5K-qBI")
                .build();
        com.google.maps.model.PlaceDetails results = PlacesApi.placeDetails(context, "place").await();
        Rating = results.rating;
        return Rating;
    }

    public static String WebSite(String place) throws ApiException, InterruptedException, IOException {
        URL Web;
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDslDVmXZsDFmXRo6mTVcJXVSb6m5K-qBI")
                .build();
        com.google.maps.model.PlaceDetails results = PlacesApi.placeDetails(context, "place").await();
        Web = results.website;
        String web = Web.toString();
        return web;
    }

    public static String URL(String place) throws ApiException, InterruptedException, IOException {
        URL url;
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDslDVmXZsDFmXRo6mTVcJXVSb6m5K-qBI")
                .build();
        com.google.maps.model.PlaceDetails results = PlacesApi.placeDetails(context, "place").await();
        url = results.url;
        String Url = url.toString();
        return Url;
    }

    public static long Distance(String AddressOne, String AddressTwo) throws ApiException, InterruptedException, IOException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDslDVmXZsDFmXRo6mTVcJXVSb6m5K-qBI")
                .build();
        DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(context);
        DistanceMatrix result = req.origins(AddressOne)
                .destinations(AddressTwo)
                .mode(TravelMode.DRIVING)
                .avoid(DirectionsApi.RouteRestriction.TOLLS)
                .language("es-ES")
                .await();
        long distApart = result.rows[0].elements[0].distance.inMeters;
        return distApart;
    }

    public static long Time(String AddressOne, String AddressTwo) throws ApiException, InterruptedException, IOException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDslDVmXZsDFmXRo6mTVcJXVSb6m5K-qBI")
                .build();
        DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(context);
        DistanceMatrix result = req.origins(AddressOne)
                .destinations(AddressTwo)
                .mode(TravelMode.DRIVING)
                .avoid(DirectionsApi.RouteRestriction.TOLLS)
                .language("es-ES")
                .await();
        long distApart = result.rows[0].elements[0].duration.inSeconds;
        return distApart;
    }

    public static String getSchedule(String IDPlace) throws ApiException, InterruptedException, IOException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDslDVmXZsDFmXRo6mTVcJXVSb6m5K-qBI")
                .build();
        com.google.maps.model.PlaceDetails results = PlacesApi.placeDetails(context, IDPlace).await();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String gson2 = gson.toJson(results);

        JsonParser parser = new JsonParser();
        JsonArray gsonAr = parser.parse("[" + gson2 + "]").getAsJsonArray();
        JsonObject gsonObj = gsonAr.get(0).getAsJsonObject();
        JsonObject gsonSche = gsonObj.get("openingHours").getAsJsonObject();
        JsonArray gsonWeek = gsonSche.get("weekdayText").getAsJsonArray();
        int cont = 0;

        String schedule = "Horario: ";
        while (cont != gsonWeek.size()) {
            schedule = schedule + "\n" + gsonWeek.get(cont);
            cont++;
        }
        return schedule;
    }

    public static String getType(String IDPlace) throws ApiException, InterruptedException, IOException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDslDVmXZsDFmXRo6mTVcJXVSb6m5K-qBI")
                .build();
        com.google.maps.model.PlaceDetails results = PlacesApi.placeDetails(context, IDPlace).await();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String gson2 = gson.toJson(results);

        JsonParser parser = new JsonParser();
        JsonArray gsonAr = parser.parse("[" + gson2 + "]").getAsJsonArray();
        JsonObject gsonObj = gsonAr.get(0).getAsJsonObject();
        JsonArray gsonTyp = gsonObj.get("types").getAsJsonArray();
        int cont = 0;

        String types = "Tipo de Lugar: ";
        while (cont != gsonTyp.size()) {
            types = types + "\n" + gsonTyp.get(cont);
            cont++;
        }
        return types;
    }

    public static String getCoincidences(String namePlace) throws ApiException, InterruptedException, IOException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDslDVmXZsDFmXRo6mTVcJXVSb6m5K-qBI")
                .build();
        PlacesSearchResponse results = PlacesApi.textSearchQuery(context, namePlace).await();
        String coincidences = "";
        for (PlacesSearchResult result : results.results) {
            coincidences = coincidences + "\n" + result.name;
        }
        return coincidences;
    }
    
    
}