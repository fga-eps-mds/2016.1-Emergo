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

import java.util.ArrayList;

/**
 * Created by gabriel on 27/04/16.
 */
public class MarkerActivity {



    protected void setMarkerOnMap(GoogleMap map,double lat,double lng, String title) {
       map.addMarker(new MarkerOptions()
               .position(new LatLng(lat,lng))
               .title(title));
    }

   /* This method should be used to add many Markers on map
    protected void setMarkersOnMap(GoogleMap map,ArrayList<HealtUnit> USs){
         //WE should define how many markers we shall show to the user
         int markersQuantity;
        for(markersQuantity = 0; markersQuantity < USs.size(); markersQuantity++){
            map.addMarker(new MarkerOptions()
                    .position(new LatLng(markers[markersQuantity].lat,markers[markersQuantity].lng))
                    .title("%s",markers[markersQuantity].title);
        }*/
    }

