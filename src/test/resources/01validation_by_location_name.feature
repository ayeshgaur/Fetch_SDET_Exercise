Feature: validation of geo utility for location name

  @validation_api_key_location
  Scenario Outline:
    Given User accesses geoloc utility
    When User sends http request with <api_Key> and input for <geo_location> parameters
    Then User gets <exptectedOutput> as a response for the provided location by name

    Examples:
      | api_Key                              | geo_location  | exptectedOutput | test_case                             |
#      | "e160acda17*&c893fdd54e900bf7c8e2"   | "Madison, WI"  | "{\"cod\":401, \"message\": \"Invalid API key. Please see https://openweathermap.org/faq#error401 for more info.\"}" | invalid apikey                              |
#      | "%^&"                                | "Madison, WI"  | "{\"cod\":401, \"message\": \"Invalid API key. Please see https://openweathermap.org/faq#error401 for more info.\"}" | api key with special characters only        |
#      | "11323"                              | "Madison, WI"  | "{\"cod\":401, \"message\": \"Invalid API key. Please see https://openweathermap.org/faq#error401 for more info.\"}" | api key with numeric values only            |
      | "e160acda17c893fdd 54e900b f7c8e2a1" | "Madison, WI" | "IllegalArgumentException"            | spaces in api key                     |
 #     | "f897a99d971b5eef57be6fafa0d83239"   | "Madson, WI"  | "[]"            | valid api key with invalid city name  |
 #     | "f897a99d971b5eef57be6fafa0d83239"   | "123456"      | "[]"            | only numeric values in city name      |
 #     | "f897a99d971b5eef57be6fafa0d83239"   | "$%^$"        | "[]"            | special characters in path parameters |
 #     | "f897a99d971b5eef57be6fafa0d83239"   | " "           | "[]"            | null value in path parameters         |
 #     | "f897a99d971b5eef57be6fafa0d83239"   | "1234567"     | "[]"            | invalid zipCode                       |


  Scenario Outline: validation of geoloc utility for valid api key and path parameters
    Given Given User accesses geoloc utility
    When User sends http request with <api_Key> and input for <geo_location> parameters
    Then User gets valid <expected_country> and <expected_city> in response output

    Examples:
      | api_Key                            | geo_location  | expected_country | expected_city | test_case                    |
      | "f897a99d971b5eef57be6fafa0d83239" | "Madison, WI" | "US"             | "Madison"     | valid parameters and api key |
      | "f897a99d971b5eef57be6fafa0d83239" | "12345"       | "US"             | "Schenectady" | valid parameters and api key |