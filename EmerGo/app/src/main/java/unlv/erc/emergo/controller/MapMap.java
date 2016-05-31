package unlv.erc.emergo.controller;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;

import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.PathOverlay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import helper.GPSTracker;
import unlv.erc.emergo.R;
import unlv.erc.emergo.model.HealthUnit;

public class MapMap extends Activity {


    public static final int ZOOM_LEVEL = 14;
    GPSTracker gps = new GPSTracker(this);

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapmap);
        checkPermissions();

        Location userLocation = gps.getLocation();

        MapView map = setMapOnActivity();

        setInitialZoomLevel(userLocation, map);

        Drawable marker = getResources().getDrawable(R.drawable.person);

        GeoPoint geoLocation = new GeoPoint(userLocation);


        ArrayList<OverlayItem> items = new ArrayList<>();

        OverlayItem userOverLayItem = getUserOverLayItem(geoLocation);
        userOverLayItem.setMarker(marker);
        items.add(userOverLayItem);

        addUsOnArray(items , HealthUnitController.getClosestsUs());

        setOverlayItemsOnMap(map, items);

        //setRoute(map,geoLocation,new GeoPoint(HealthUnitController.getClosestsUs().get(0).getLatitude(),
        // HealthUnitController.getClosestsUs().get(0).getLongitude()));

    }

    public void addUsOnArray(ArrayList<OverlayItem> items ,
                             ArrayList<HealthUnit> healthUnits){
        for(int numberOfUs = 0 ; numberOfUs < healthUnits.size() ;
            numberOfUs++){
            items.add(getUnitOverLayItem(healthUnits.get(numberOfUs).getNameHospital(),
                    healthUnits.get(numberOfUs).getUnitType(),
                    new GeoPoint(healthUnits.get(numberOfUs).getLatitude() ,
                            healthUnits.get(numberOfUs).getLongitude())));

        }
    }

    private OverlayItem getUnitOverLayItem(String unityName ,
                                           String unitType ,
                                           GeoPoint geoLocation) {
        return new OverlayItem
                (unityName , unitType  , geoLocation);
    }


    private void setOverlayItemsOnMap(MapView map, ArrayList<OverlayItem> items) {
        CustomResourceProxy resource = new CustomResourceProxy(this);
        ItemizedOverlayWithFocus<OverlayItem> mOverlay = new
                ItemizedOverlayWithFocus<OverlayItem>(items,
                new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
                    @Override
                    public boolean onItemSingleTapUp(final int index, final OverlayItem item) {
                        return true;
                    }

                    @Override
                    public boolean onItemLongPress(final int index, final OverlayItem item) {
                        return false;
                    }
                } , resource);
        mOverlay.setFocusItemsOnTap(true);
        map.getOverlays().add(mOverlay);
    }

    @NonNull
    private OverlayItem getUserOverLayItem(GeoPoint geoLocation) {
        return new OverlayItem
                ("Vocẽ está aqui" , ""  , geoLocation);
    }


    private void setInitialZoomLevel(Location userLocation, MapView map) {
        IMapController mapController = map.getController();
        mapController.setZoom(ZOOM_LEVEL);
        GeoPoint userGeoPoint = new GeoPoint(0,0);
        mapController.setCenter(userGeoPoint);
    }

    @NonNull
    private MapView setMapOnActivity() {
        MapView map = (MapView) findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setMultiTouchControls(true);
        return map;
    }

    public void setRoute(MapView mMapView, GeoPoint userPosition, GeoPoint unitPosition){
        mMapView.getController().setCenter(userPosition);
        PathOverlay myPath = new PathOverlay(Color.RED, this);
        myPath.addPoint(userPosition);
        myPath.addPoint(unitPosition);
        mMapView.getOverlays().add(myPath);
    }

    public void goClicked(View map_screen) {
        Toast.makeText(this, "Função não habilitada!", Toast.LENGTH_SHORT).show();
    }

    public void listMapsImageClicked(View map_screen){
        Intent listOfHealth = new Intent();
        listOfHealth.setClass(this , ListOfHealthUnitsController.class);
        startActivity(listOfHealth);
        finish();
    }

    public void openMap(View mapScreen){
        Intent mapActivity = new Intent();
        mapActivity.setClass(this, MapMap.class);
        startActivity(mapActivity);
        finish();
    }

    final private int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 124;

    private void checkPermissions() {
        List<String> permissions = new ArrayList<>();
        String message = "osmdroid permissions:";
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
            message += "\nLocation to show user location.";
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            message += "\nStorage access to store map tiles.";
        }
        if (!permissions.isEmpty()) {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            String[] params = permissions.toArray(new String[permissions.size()]);
            requestPermissions(params, REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
        } // else: We already have permissions, so handle as normal
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS: {
                Map<String, Integer> perms = new HashMap<>();
                // Initial
                perms.put(Manifest.permission.ACCESS_FINE_LOCATION, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.WRITE_EXTERNAL_STORAGE, PackageManager.PERMISSION_GRANTED);
                // Fill with results
                for (int i = 0; i < permissions.length; i++)
                    perms.put(permissions[i], grantResults[i]);
                // Check for ACCESS_FINE_LOCATION and WRITE_EXTERNAL_STORAGE
                Boolean location = perms.get(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
                Boolean storage = perms.get(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
                if (location && storage) {
                    // All Permissions Granted
                    Toast.makeText(MapMap.this, "All permissions granted", Toast.LENGTH_SHORT).show();
                } else if (location) {
                    Toast.makeText(this, "Storage permission is required to store map tiles to reduce data usage and for offline usage.", Toast.LENGTH_LONG).show();
                } else if (storage) {
                    Toast.makeText(this,"Location permission is required to show the user's location on map.", Toast.LENGTH_LONG).show();
                } else { // !location && !storage case
                    // Permission Denied
                    Toast.makeText(MapMap.this, "Storage permission is required to store map tiles to reduce data usage and for offline usage." +
                            "\nLocation permission is required to show the user's location on map.", Toast.LENGTH_SHORT).show();
                }
            }
            break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

}
