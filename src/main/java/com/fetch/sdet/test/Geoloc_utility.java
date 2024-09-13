package com.fetch.sdet.test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Geoloc_utility {
    private static final String API_KEY = "f897a99d971b5eef57be6fafa0d83239";

    public static void main(String[] args) {
        if (args.length > 0) {
            for (String inLoc : args) {
                System.out.println(inLoc);
                if(inLoc.equalsIgnoreCase("--locations"))
                    continue;
                Geoloc_utility geolocUtility = new Geoloc_utility();
                geolocUtility.weatherGeoApiCall(inLoc, API_KEY);
            }
        }

    }

    public String weatherGeoApiCall(String inLoc, String API_KEY) {

        inLoc = inLoc.replaceAll("\\s+", "");
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
