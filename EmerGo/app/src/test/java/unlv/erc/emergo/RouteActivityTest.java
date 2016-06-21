package unlv.erc.emergo;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;

import junit.framework.TestCase;

import unlv.erc.emergo.controller.RouteActivity;

/**
 * Created by Matheus on 11/06/2016.
 */

public class RouteActivityTest extends TestCase {


    RouteActivity route = new RouteActivity();
    GoogleMap map;

    public void testIfMarkerIsSetOnMap(){
        route.setYourPositionOnMap();
        IndoorBuilding camera = map.getFocusedBuilding();
        camera.get

    }
}
