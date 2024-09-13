#Weather API

The Weatherstack API allows you to get the current weather status based on the location you enter.

**/Parameters
"location" where based on location, the API will provide the weather data
*/

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



On POSTMAN:

  http://localhost:8080/weather (GET)



             
