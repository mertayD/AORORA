package com.example.aorora.utils;
import android.location.*;
import android.util.Log;
import android.widget.Toast;


import java.util.Hashtable;
import java.util.Map;

public class LocationInfo {
    Map<String, Coordinate> coordinateMap;


    public LocationInfo() {
        coordinateMap = new Hashtable<>();
        coordinateMap.put("Home", new Coordinate(33.361306899999995,-111.6185036 ));
        coordinateMap.put("Union", new Coordinate(35.18885857101099, -111.65491450017184));
    }

    public Coordinate getLocation(String location){
        //If we have the coordinate registered, return it.
        if(coordinateMap.get(location) != null){
            return coordinateMap.get(location);
        }
        //Otherwise there is not a mapping to that stop.
        Log.d("Coord not registered", "COORDINATE NOT FOUND IN LOCATIONINFO COORDINATEMAP");
        return new Coordinate();

    }
}

