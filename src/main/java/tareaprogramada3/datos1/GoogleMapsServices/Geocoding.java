/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author
 */
package tareaprogramada3.datos1.GoogleMapsServices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.maps.DirectionsApi.RouteRestriction;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;
import com.google.maps.model.TravelMode;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;


public class Geocoding {

    String lugar;
    String origin;
    String destiny;
    String info;

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void Geocoding(String sitio) {
        sitio = lugar;
    }

    public String getdirection(String lugar) {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDEcRlP4hWCSsl0U6mG9VLkCsLrjnbUqp8")
                .build();
        GeocodingResult[] results = GeocodingApi.geocode(context,
                lugar).awaitIgnoreError();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String direccion = gson.toJson(results[0].formattedAddress);
        return direccion;
    }

    public String getlat(String lugar) {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDEcRlP4hWCSsl0U6mG9VLkCsLrjnbUqp8")
                .build();
        GeocodingResult[] results = GeocodingApi.geocode(context,
                lugar).awaitIgnoreError();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String latitud = gson.toJson(results[0].geometry.location.lat);
        return latitud;
    }

    public String getlon(String lugar) {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDEcRlP4hWCSsl0U6mG9VLkCsLrjnbUqp8")
                .build();
        GeocodingResult[] results = GeocodingApi.geocode(context,
                lugar).awaitIgnoreError();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String longitud = gson.toJson(results[0].geometry.location.lng);
        return longitud;
    }

    public long getDriveDist(String origin, String destiny) throws ApiException, InterruptedException, IOException {
        String addrOne = origin;
        String addrTwo = destiny;
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

    public String getid(String lugar) {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDEcRlP4hWCSsl0U6mG9VLkCsLrjnbUqp8")
                .build();
        GeocodingResult[] results = GeocodingApi.geocode(context,
                lugar).awaitIgnoreError();
        String direccion = results[0].placeId;
        return direccion;
    }

    public String getinfo(String info) throws ApiException, InterruptedException, IOException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyAx6wyHg-u40Cll05DxD8d1v0jnnCyuIdM")
                .build();
        PlaceDetails results = PlacesApi.placeDetails(context, "ChIJI4HuuIbjoI8RdoRCEaF6a1U").await();
        String resulta = String.valueOf(results.openingHours.openNow);
        return resulta;
    }

    public String Time(String origin, String destiny) throws ApiException, InterruptedException, IOException {
        String addrOne = origin;
        String addrTwo = destiny;
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
        String resulta = String.valueOf(distApart);
        return resulta;
    }

    public static String URL(String id) throws ApiException, InterruptedException, IOException {
        // String w=id;
        URL url;
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDslDVmXZsDFmXRo6mTVcJXVSb6m5K-qBI")
                .build();
        com.google.maps.model.PlaceDetails results = PlacesApi.placeDetails(context, id).await();
        url = results.url;
        String Url = url.toString();
        return Url;
    }

    public void goToURL(String URL) throws URISyntaxException, IOException {
        if (java.awt.Desktop.isDesktopSupported()) {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                java.net.URI uri = new java.net.URI(URL);
                desktop.browse(uri);
            }
        }
    }

    public static String Rating(String place) throws ApiException, InterruptedException, IOException {
        float Rating;
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDslDVmXZsDFmXRo6mTVcJXVSb6m5K-qBI")
                .build();
        com.google.maps.model.PlaceDetails results = PlacesApi.placeDetails(context, place).await();
        Rating = results.rating;
        String r = String.valueOf(Rating);
        return r;
    }

    public static String PhoneNumber(String place) throws ApiException, InterruptedException, IOException {
        String Phone;
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDslDVmXZsDFmXRo6mTVcJXVSb6m5K-qBI")
                .build();
        com.google.maps.model.PlaceDetails results = PlacesApi.placeDetails(context, place).await();
        Phone = results.internationalPhoneNumber;
        String t = String.valueOf(Phone);
        return Phone;
    }

    public static String WebSite(String place) throws ApiException, InterruptedException, IOException {
        URL Web;
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDslDVmXZsDFmXRo6mTVcJXVSb6m5K-qBI")
                .build();
        com.google.maps.model.PlaceDetails results = PlacesApi.placeDetails(context, place).await();
        Web = results.website;
        String web = Web.toString();
        return web;
    }

    public static String PlaceType(String place) throws ApiException, InterruptedException, IOException {
        String Type;
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDslDVmXZsDFmXRo6mTVcJXVSb6m5K-qBI")
                .build();
        GeocodingResult[] results = GeocodingApi.geocode(context,
                place).awaitIgnoreError();
        Type = Arrays.toString(results[0].types);
        return Type;
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
        String schedule = "";
        while (cont != gsonWeek.size()) {
            schedule = schedule + "\n" + gsonWeek.get(cont);
            cont++;
            System.out.println(gsonWeek.get(cont));
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
        String types = "";
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
