package unlv.erc.emergo.controller;


import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.osmdroid.api.IMapController;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;

import java.util.Map;

import helper.GPSTracker;
import unlv.erc.emergo.R;

public class MapMap extends Activity {

    public static final int ZOOM_LEVEL = 13;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapmap);

        GPSTracker gps = new GPSTracker(this);
        Location userLocation = gps.getLocation();

        Log.i("latitude", userLocation.getLatitude() + "");
        Log.i("Longitude", userLocation.getLongitude() + "");

        MapView map = setMapOnActivity();

        setInitialZoomLevel(userLocation, map);
    }

    private void setInitialZoomLevel(Location userLocation, MapView map) {
        IMapController mapController = map.getController();
        mapController.setZoom(ZOOM_LEVEL);
        GeoPoint userGeoPoint = new GeoPoint(userLocation.getLatitude(),
                                            userLocation.getLongitude());
        mapController.setCenter(userGeoPoint);
    }

    @NonNull
    private MapView setMapOnActivity() {
        MapView map = (MapView) findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);
        return map;
    }

    public void goClicked(View map_screen) {
        Toast.makeText(this, "Função não habilitada!", Toast.LENGTH_SHORT).show();
    }

    public void listMapsImageClicked(View map_screen){
        Intent listOfHealth = new Intent();
        listOfHealth.setClass(this , ListOfHealthUnitsController.class);
        startActivity(listOfHealth);
    }

    public void openMap(View mapScreen){
        Intent mapActivity = new Intent();
        mapActivity.setClass(this, MapMap.class);
        startActivity(mapActivity);
        finish();
    }


}
