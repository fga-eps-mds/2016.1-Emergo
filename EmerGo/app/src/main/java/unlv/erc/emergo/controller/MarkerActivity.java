package unlv.erc.emergo.controller;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by gabriel on 27/04/16.
 */
public class MarkerActivity {


    protected void setMarkerOnMap(GoogleMap map, double lat, double lng, String title) {
        map.addMarker(new MarkerOptions()
                .position(new LatLng(lat, lng))
                .title(title));
    }
}
/*
    protected void closestUSs(double latUser, double lngUser, ArrayList<HealthUnit> USs){
        ArrayList<HealthUnit> closestUSs = new ArrayList<HealthUnit>();
        int addedUSs = 0;

        while(addedUSs<=USs.size()){
            //if com condição que avalia proximidade de acordo com a posicao do user
            if(/*HealthUnit is close enough*///)//{
                //closestUSs.add(USs[addedUSs]);
               // addedUSs++;
         //   }
      //  }
 //   }


    /*This method should be used to add many Markers on map
    protected void setMarkersOnMap(GoogleMap map,ArrayList<HealtUnit> USs){
         //WE should define how many markers we shall show to the user
         int markersQuantity;
        for(markersQuantity = 0; markersQuantity < USs.size(); markersQuantity++){
            map.addMarker(new MarkerOptions()
                    .position(new LatLng(markers[markersQuantity].lat,markers[markersQuantity].lng))
                    .title("%s",markers[markersQuantity].title);
        }
    }
*/
