package csc340com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    /**
     * The Weatherstack API allows you to get the current
     * weather status based on the location you enter.
     *
     * @param location where based on location, the API will provide the weather data
     * @return Weather Object
     */

    @GetMapping("/weather")
    public Object getWeather(@RequestParam(value = "location", defaultValue = "London") String location) {
        try {
            String url = "https://api.weatherstack.com/current?access_key=60618fedf6c20659f02784bb2bdc02d4&query=" + location;
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            /**
             *  The response from the above API is a 'single' JSON object that looks like this:
             *
             *  <pre>
             *     {
             *     "request": {
             *         "type": "City",
             *         "query": "London, United Kingdom",
             *         "language": "en",
             *         "unit": "m"
             *     },
             *     "location": {
             *         "name": "London",
             *         "country": "United Kingdom",
             *         "region": "City of London, Greater London",
             *         "lat": "51.517",
             *         "lon": "-0.106",
             *         "timezone_id": "Europe/London",
             *         "localtime": "2024-09-13 04:19",
             *         "localtime_epoch": 1726201140,
             *         "utc_offset": "1.0"
             *     },
             *     "current": {
             *         "observation_time": "03:19 AM",
             *         "temperature": 5,
             *         "weather_code": 113,
             *         "weather_icons": [
             *             "https://cdn.worldweatheronline.com/images/wsymbols01_png_64/wsymbol_0008_clear_sky_night.png"
             *         ],
             *         "weather_descriptions": [
             *             "Clear"
             *         ],
             *         "wind_speed": 9,
             *         "wind_degree": 340,
             *         "wind_dir": "NNW",
             *         "pressure": 1025,
             *         "precip": 0,
             *         "humidity": 93,
             *         "cloudcover": 0,
             *         "feelslike": 3,
             *         "uv_index": 1,
             *         "visibility": 10,
             *         "is_day": "no"
             *     }
             * }
             *  </pre>
             */

            String jsonResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonResponse);

            //Extracting relevant information from WeatherStack
            String locationName = root.path("location").path("name").asText();
            String weatherDescriptions = root.path("current").path("weather_descriptions").get(0).asText();
            double temperature = root.path("current").path("temperature").asDouble();

            Weather weather = new Weather(locationName, weatherDescriptions, temperature);
            return weather;

        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
