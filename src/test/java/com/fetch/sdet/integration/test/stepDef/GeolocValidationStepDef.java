package com.fetch.sdet.integration.test.stepDef;

import com.fetch.sdet.GeolocUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class GeolocValidationStepDef {
String actualOutput = null;

    @Given("User accesses geoloc utility")
    public void user_accesses_geoloc_utility() {
        System.out.println("accessing geoloc uitlity");
    }

    @When("User sends http request with {string} and input for {string} parameters")
    public void user_sends_http_request_with_and_input_for_parameters(String api_Key, String geo_location) {
        GeolocUtility geolocUtility = new GeolocUtility();
        actualOutput= geolocUtility.weatherGeoApiCall(geo_location,api_Key);
    }


    @Then("User gets {string} as a response for the provided location by name")
    public void user_gets_as_a_response_for_the_provided_location_by_name(String exptectedOutput) {

        System.out.println(actualOutput);
        Assert.assertEquals(actualOutput, exptectedOutput);
    }

    @Given("Given User accesses geoloc utility")
    public void given_user_accesses_geoloc_utility() {
        System.out.println("accessing geoloc uitlity");
    }
    @Then("User gets valid {string} and {string} in response output")
    public void user_gets_valid_and_in_response_output(String expected_country, String expected_city) {

        Assert.assertTrue(actualOutput.contains(expected_country));
        Assert.assertTrue(actualOutput.contains(expected_city));
    }


}
