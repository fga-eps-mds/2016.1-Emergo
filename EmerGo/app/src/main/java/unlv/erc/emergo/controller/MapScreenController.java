package unlv.erc.emergo.controller;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import helper.CallingMethods;
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

        Button Go = (Button) this.findViewById(R.id.buttonGo);

        Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:91907175"));
                startActivity(callIntent);
            }
        });

    }
/*
    public void goClicked(View map_screen){
        CallingMethods callMethods = new CallingMethods();
        CallingMethods.call(map_screen);
    }
*/
    public void listMapsImageClicked(View map_screen){
        Intent listOfHealth = new Intent();
        listOfHealth.setClass(this , ListOfHealthUnitsController.class);
        startActivity(listOfHealth);
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
