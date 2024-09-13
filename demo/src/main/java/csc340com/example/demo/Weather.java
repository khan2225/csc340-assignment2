package csc340com.example.demo;

public class Weather {
    private String location;
    private String weatherDescriptions;
    private double temperature;

    public Weather(String location, String weatherDescriptions, double temperature){
        this.location = location;
        this.weatherDescriptions = weatherDescriptions;
        this.temperature = temperature;

    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getWeatherDescriptions(){
        return weatherDescriptions;
    }

    public void setWeatherDescriptions(String weatherDescriptions){
        this.weatherDescriptions = weatherDescriptions;
    }

    public double getTemperature(){
        return temperature;
    }

    public void setTemperature(double temperature){
        this.temperature = temperature;
    }
}
