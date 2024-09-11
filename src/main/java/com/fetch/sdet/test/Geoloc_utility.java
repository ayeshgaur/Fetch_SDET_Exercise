package com.fetch.sdet.test;

import java.util.Scanner;

public class Geoloc_utility {
    private static final String base_url = "(https://openweathermap.org/api/geocoding-api";
    private static final String get_by_name_endpoint = "/geo/1.0/zip?zip={zip code},{country code}&appid={API key}";
    private static final String GET_BY_ZIPCODE_ENDPOINT = "/geo/1.0/direct?q={city name},{state code},{country code}&limit={limit}&appid={API key}";

    public static void main(String[] args){
        try(Scanner scanner = new Scanner(System.in)){
            // Input for option (1. by city, state name OR 2. by zipcode)
            int option = scanner.nextInt();
            scanner.nextLine();

            if(option == 1){
                Scanner by_City_State_Name = new Scanner(System.in);
                // provide city, state name
                String city_state_name = by_City_State_Name.nextLine();
            }

        }
    }
}
