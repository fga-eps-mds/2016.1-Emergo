package unlv.erc.emergo.controller;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import unlv.erc.emergo.model.HealthUnit;

import java.util.ArrayList;

import unlv.erc.emergo.model.HealthUnit;

/**
 * Created by gabriel on 27/04/16.
 */
public class MarkerActivity {


    protected ArrayList<HealthUnit> findClosestUSs(double latUser, double lngUser, ArrayList<HealthUnit> USs){
        ArrayList<HealthUnit> closestUSs = new ArrayList<HealthUnit>();
        int addedUSs = 0;

        while(addedUSs<=USs.size())){
            if((USs[addedUSs].longitude - lngUser)<1 && (USs[addedUSs].latitude - latUser)-1){
                closestUSs.add(USs[addedUSs]);
                addedUSs++;
            }
        }
        return closestUSs;
    }


   //This method should be used to add many Markers on map
    protected void setMarkersOnMap(GoogleMap map,ArrayList<HealthUnit> USs){
         //WE should define how many markers we shall show to the user
         int markersQuantity;
        for(markersQuantity = 0; markersQuantity < USs.size(); markersQuantity++){
            map.addMarker(new MarkerOptions()
                    .position(new LatLng(USs[markersQuantity],USs[markersQuantity].longitude)
                    .title("%s",USs[markersQuantity].namehospital)));

        }
    }

