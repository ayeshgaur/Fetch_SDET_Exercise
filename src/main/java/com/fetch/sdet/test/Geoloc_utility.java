package com.fetch.sdet.test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Geoloc_utility {
    private static final String API_KEY = "f897a99d971b5eef57be6fafa0d83239";

    public static void main(String[] args) {
        if (args.length > 0) {
            for (String inLoc : args) {
                System.out.println(inLoc);
                inLoc = inLoc.replaceAll("\\s+", "");
                String zipCode = inLoc;
                String regex = "\\d{5}(-\\d{4})?";

                System.out.println("The zip code is: " + zipCode);
                System.out.println("Is the above zip code valid? " + zipCode.matches(regex));
                if (zipCode.matches(regex)) {
                    fetchByGeoByZipCode(zipCode);

                } else {
                    fetchGeoByLocationName(inLoc);
                }
            }
        }

    }

    private static void fetchGeoByLocationName(String locationName) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.openweathermap.org/geo/1.0/direct?limit=1&appid=f897a99d971b5eef57be6fafa0d83239&q=" + locationName + ",US"))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }

    private static void fetchByGeoByZipCode(String zipCode) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.openweathermap.org/geo/1.0/zip?&appid=f897a99d971b5eef57be6fafa0d83239&zip=" + zipCode + ",US"))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }
}
