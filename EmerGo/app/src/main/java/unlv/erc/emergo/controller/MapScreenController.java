package unlv.erc.emergo.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import helper.Services;
import unlv.erc.emergo.R;

public class MapScreenController extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Services services = new Services();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.map_screen);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    public void goClicked(View map_screen){
        Toast.makeText(this , "Função não habilitada!" , Toast.LENGTH_SHORT).show();
        Intent routeActivity = new Intent();
        routeActivity.setClass(this, RouteActivity.class);
        startActivity(routeActivity);
    }

    public void listMapsImageClicked(View map_screen){
        Intent listOfHealth = new Intent();
        listOfHealth.setClass(this , ListOfHealthUnitsController.class);
        startActivity(listOfHealth);
    }

    public void openConfig(View map_screen){
        Intent config = new Intent();
        config.setClass(this , UserController.class);
        startActivity(config);
    }

    public void openMap(View mapScreen){
        Intent mapActivity = new Intent();
        mapActivity.setClass(this, MapScreenController.class);
        startActivity(mapActivity);
        finish();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng a = new LatLng(-16.002955 , -48.0616721);
        mMap = googleMap;

        mMap.addMarker(new MarkerOptions().position(a).title("Sua posição")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom
                (new LatLng(a.latitude, a.longitude), 13.0f));

        services.setMarkersOnMap(mMap , HealthUnitController.getClosestsUs() );

    }

}
