package com.fetch.sdet.integration.test.stepDef;

import com.fetch.sdet.test.Geoloc_utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;


public class Geolocation_by_name {
String actualOutput = null;
    @Given("User accesses url with {string} with input for {string} parameters")
    public void user_accesses_url_with_with_input_for_parameters(String api_Key, String geo_location) {
        Geoloc_utility geolocUtility = new Geoloc_utility();
        actualOutput= geolocUtility.weatherGeoApiCall(geo_location,api_Key);
    }

    @Then("User gets {string} as a response for the provided location by name")
    public void user_gets_as_a_response_for_the_provided_location_by_name(String exptectedOutput) {
        System.out.println(actualOutput);
        JsonPath jsonPath= new JsonPath(actualOutput);
        Assert.assertEquals(jsonPath.getString("cod"), exptectedOutput);
    }

}
