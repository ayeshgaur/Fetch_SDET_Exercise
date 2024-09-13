# GeolocUtility

Geoloc utility uses openweather geocoding API. It takes the input as City name, State, zipcode and returns information about the city with longitude, latitude, name, zipcode and any other necessary informtaion.

## Run through Config
To run the geoloc utility we can pass the city, state as path parameters from run configurations

![image](https://github.com/user-attachments/assets/0f9cef82-1233-4480-99d3-cc9e33269d1c)

## Run through Commandline
To run the utility through command line, please follow steps in the screenshot
![image](https://github.com/user-attachments/assets/1a0b887c-9be3-46d1-a16b-935d1fd2623b)

# Testing geoloc Utility

To test the utility, TestNg runner with BDD- cucumber framework, is implemented.

### dependencies required
1. cucumber-java
2. cucumber-jvm-deps
3. cucumber-testng
4. testng

### Running the test:

#### Via TestNG Runner:
Use your IDE (e.g., IntelliJ or Eclipse) to run the TestRunner class.
This will execute all feature files and scenarios defined in the @CucumberOptions.

#### From the Feature File:
Right-click on a feature file in your IDE and select "Run" to execute individual scenarios.
