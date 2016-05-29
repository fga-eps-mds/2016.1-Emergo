package unlv.erc.emergo.controller;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import org.osmdroid.api.IMapController;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.PathOverlay;

import java.util.ArrayList;

import helper.GPSTracker;
import unlv.erc.emergo.R;
import unlv.erc.emergo.model.HealthUnit;

public class MapMap extends Activity {


    public static final int ZOOM_LEVEL = 13;
    GPSTracker gps = new GPSTracker(this);

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapmap);


        Location userLocation = gps.getLocation();

        MapView map = setMapOnActivity();

        setInitialZoomLevel(userLocation, map);

        Drawable marker = getResources().getDrawable(R.drawable.my_location);

        GeoPoint geoLocation = new GeoPoint(userLocation);


        ArrayList<OverlayItem> items = new ArrayList<OverlayItem> ();

        OverlayItem userOverLayItem = getUserOverLayItem(geoLocation);

        items.add(userOverLayItem);

        addUsOnArray(items , HealthUnitController.getClosestsUs());

        setOverlayItemsOnMap(map, items);

        setRoute(map,new GeoPoint(userLocation),new GeoPoint(HealthUnitController.getClosestsUs().get(0).getLatitude(),
                                                             HealthUnitController.getClosestsUs().get(0).getLongitude()));

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
    }

    public void openMap(View mapScreen){
        Intent mapActivity = new Intent();
        mapActivity.setClass(this, MapMap.class);
        startActivity(mapActivity);
        finish();
    }


}
