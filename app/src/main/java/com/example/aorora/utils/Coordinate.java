package com.example.aorora.utils;

//Inner class to store coordinates in the Map data structure
public class Coordinate{
    double latitude;
    double longitude;
    final double notFound = -999999;
    public Coordinate(double inputLat, double inputLong){
        this.latitude = inputLat;
        this.longitude = inputLong;
    }
    public Coordinate() {
        this.latitude = notFound;
        this.longitude = notFound;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
    @Override
    public String toString(){
        if(latitude == notFound){
            return "Location was not found! Geocoordinate is not registered.";
        }
        return "Latitude " + getLatitude() + " Longitude: " + getLongitude();
    }
}
