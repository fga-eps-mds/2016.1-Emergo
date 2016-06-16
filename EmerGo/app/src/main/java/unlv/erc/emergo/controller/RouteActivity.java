package unlv.erc.emergo.controller;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.PathOverlay;


import unlv.erc.emergo.R;

public class RouteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.map_screen);

//        setRoute(map, geoLocation, new GeoPoint(HealthUnitController.getClosestsUs().get(0).getLatitude(),
//                                  HealthUnitController.getClosestsUs().get(0).getLongitude()));

    }

    public void setRoute(MapView mMapView, GeoPoint userPosition, GeoPoint unitPosition){
        mMapView.getController().setCenter(userPosition);
        PathOverlay myPath = new PathOverlay(Color.RED, this);
        myPath.addPoint(userPosition);
        myPath.addPoint(unitPosition);
        mMapView.getOverlays().add(myPath);
    }

    public void goClicked(View map_screen) {
        Intent mapRoute = new Intent();
        mapRoute.setClass(this, RouteActivity.class);
        startActivity(mapRoute);
        finish();
    }

    public void listMapsImageClicked(View map_screen){
        Intent listOfHealth = new Intent();
        listOfHealth.setClass(this, ListOfHealthUnitsController.class);
        startActivity(listOfHealth);
        finish();
    }

    public void openMap(View mapScreen){
        Intent mapActivity = new Intent();
        mapActivity.setClass(this, MapScreenController.class);
        startActivity(mapActivity);
        finish();
    }



}




