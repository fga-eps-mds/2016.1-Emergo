package unlv.erc.emergo.controller;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;


import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;

import org.osmdroid.api.IMapController;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.Overlay;
import org.osmdroid.views.overlay.OverlayItem;


import java.util.ArrayList;
import java.util.List;

import helper.GPSTracker;
import osmdroid.OSRMRoadManager;
import osmdroid.Road;
import osmdroid.RoadManager;
import unlv.erc.emergo.R;
import unlv.erc.emergo.model.HealthUnit;

public class MapScreenController extends Activity {


    public static final int ZOOM_LEVEL = 14;
    GPSTracker gps = new GPSTracker(this);
    Location userLocation;
    GeoPoint geoLocation;
    MapView map;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_screen);

        try{
            userLocation = gps.getLocation();
            geoLocation = new GeoPoint(userLocation);
            map = setMapOnActivity();

            setInitialZoomLevel(userLocation, map);

            Drawable marker = getResources().getDrawable(R.drawable.person);

            ArrayList<OverlayItem> items = new ArrayList<OverlayItem>();
            OverlayItem userOverLayItem = getUserOverLayItem(geoLocation);
            userOverLayItem.setMarker(marker);
            items.add(userOverLayItem);
            addUsOnArray(items, HealthUnitController.getClosestsUs());

            setOverlayItemsOnMap(map, items);

        }catch (NullPointerException ex){

            Toast.makeText(this, "O GPS PRECISA ESTAR HABILITADO", Toast.LENGTH_LONG).show();
            finish();
        }

        RoadManager roadManager = new OSRMRoadManager(this);
        ArrayList<GeoPoint> waypoints = new ArrayList<GeoPoint>();
        waypoints.add(geoLocation);
        waypoints.add(new GeoPoint(HealthUnitController.getClosestsUs().
                get(0).getLatitude(),
                HealthUnitController.getClosestsUs().
                        get(0).getLongitude()));

        Road road = roadManager.getRoad(waypoints);
        Polyline roadOverlay =  RoadManager.buildRoadOverlay(road, this);

        List<LatLng> list = roadOverlay.getPoints();
        List<GeoPoint> list1 = new ArrayList<GeoPoint>();
        for(int aux = 0 ; aux < list.size(); aux++) {
           list1.add(new GeoPoint(list.get(aux).latitude,
                                    list.get(aux).longitude));
        }

        ArrayList<OverlayItem> routePoints = new ArrayList<OverlayItem>();
        for(int aux = 0 ; aux < list1.size(); aux++) {
            OverlayItem routePoint = getUserOverLayItem(list1.get(aux));
            routePoints.add(routePoint);
        }

        setOverlayItemsOnMap(map , routePoints);


        map.invalidate(); // refresh the map



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
        map.setMultiTouchControls(true);
        return map;
    }

    public void goClicked(View map_screen) {
        Intent mapRoute = new Intent();
        mapRoute.putExtra("latitude" , gps.getLocation().getLatitude());
        mapRoute.putExtra("longitude" , gps.getLocation().getLongitude());
        mapRoute.setClass(this, RouteActivity.class);
        startActivity(mapRoute);
        finish();
    }

    public void listMapsImageClicked(View map_screen){
        Intent listOfHealth = new Intent();
        listOfHealth.setClass(this , ListOfHealthUnitsController.class);
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
