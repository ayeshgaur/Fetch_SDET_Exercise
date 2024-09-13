Feature: validation of geo utility for location name


  Scenario Outline:
    Given User accesses url with <api_Key> with input for <geo_location> parameters
    Then User gets "<exptectedOutput>" as a response for the provided location by name

    Examples:
    | api_Key                             | geo_location      | exptectedOutput |
    | "e160acda17*&c893fdd54e900bf7c8e2" | "Madison, WI" | 401             |
  #  | "%^&"                                | "Madison, WI" | 401             |
 #   | "11323"                                | "Madison, WI" | 401             |

#      | "e160acda17c893fdd54e900bf7c8e2a1" | "Madson, WI"  | "404"           |
#      | "e160acda17c893fdd54e900bf7c8e2a1" | "123456"      | "404"           |
#      | "e160acda17c893fdd54e900bf7c8e2a1" | "$%^$"        | "404"           |
