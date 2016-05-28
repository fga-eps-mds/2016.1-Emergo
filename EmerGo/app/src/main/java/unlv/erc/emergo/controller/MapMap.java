package unlv.erc.emergo.controller;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.osmdroid.ResourceProxy;
import org.osmdroid.api.IMapController;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.util.ResourceProxyImpl;
import org.osmdroid.views.MapView;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.Overlay;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.IMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

import helper.GPSTracker;
import unlv.erc.emergo.R;
import unlv.erc.emergo.model.HealthUnit;

public class MapMap extends Activity {

    public static final int ZOOM_LEVEL = 13;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapmap);

        GPSTracker gps = new GPSTracker(this);
        Location userLocation = gps.getLocation();

        MapView map = setMapOnActivity();

        setInitialZoomLevel(userLocation, map);

        GeoPoint geoLocation = new GeoPoint(userLocation);


        ArrayList<OverlayItem> items = new ArrayList<OverlayItem>
                ();

        OverlayItem userOverLayItem = getUserOverLayItem(geoLocation);

        items.add(userOverLayItem);

        addUsOnArray(items , HealthUnitController.getClosestsUs());

        setOverlayItemsOnMap(map, items);

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
        GeoPoint userGeoPoint = new GeoPoint(userLocation.getLatitude(),
                                            userLocation.getLongitude());
        mapController.setCenter(userGeoPoint);
    }

    @NonNull
    private MapView setMapOnActivity() {
        MapView map = (MapView) findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        //map.setBuiltInZoomControls(true);
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
