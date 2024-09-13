package com.fetch.sdet;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GeolocUtility {
    private static final String API_KEY = "f897a99d971b5eef57be6fafa0d83239";

    public static void main(String[] args) {
        if (args.length > 0) {
            for (String inLoc : args) {
                System.out.println(inLoc);
                if(inLoc.equalsIgnoreCase("--locations"))
                    continue;
                GeolocUtility geolocUtility = new GeolocUtility();
                geolocUtility.weatherGeoApiCall(inLoc, API_KEY);
            }
        }

    }

    public String weatherGeoApiCall(String inLoc, String API_KEY) {

        try {
            inLoc = URLEncoder.encode(inLoc, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String zipCode = inLoc;
        String regex = "\\d{5}(-\\d{4})?";

        System.out.println("The zip code is: " + zipCode);
        System.out.println("Is the above zip code valid? " + zipCode.matches(regex));
        if (zipCode.matches(regex)) {
          return  fetchByGeoByZipCode(zipCode, API_KEY);

        } else {
           return fetchGeoByLocationName(inLoc, API_KEY);
        }
    }

    /**
     * accepts city name, state name as input and return location information as json string
     * @param locationName
     * @return
     */
    private static String fetchGeoByLocationName(String locationName, String API_KEY) {

        HttpClient client = HttpClient.newHttpClient();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    //.uri(URI.create("http://api.openweathermap.org/geo/1.0/direct?limit=1&appid=f897a99d971b5eef57be6fafa0d83239&q=" + locationName + ",US"))
                    .uri(URI.create("http://api.openweathermap.org/geo/1.0/direct?limit=1&appid="+ API_KEY+ "&q=" + locationName + ",US"))
                    .build();
            String locationsResponse = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    //.thenAccept(System.out::println)
                    .join();
            System.out.println(locationsResponse);
            return locationsResponse;

        } catch (Exception ex){
            // we can also throw exception and handle in the calling class/method.
                return ex.getClass().getSimpleName();
        }
    }

    /**
     * accepts zipcode as an input and return location information json as a string
     * @param zipCode
     * @return
     */
    private static String fetchByGeoByZipCode(String zipCode, String API_KEY) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.openweathermap.org/geo/1.0/zip?&appid="+ API_KEY+ "&zip=" + zipCode + ",US"))
                .build();

        String locationsResponse = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                //.thenAccept(System.out::println)
                .join();
        System.out.println(locationsResponse);
        return locationsResponse;
    }
}
