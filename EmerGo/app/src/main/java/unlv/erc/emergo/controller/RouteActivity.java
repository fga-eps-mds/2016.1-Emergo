package unlv.erc.emergo.controller;

import helper.GPSTracker;
import unlv.erc.emergo.R;
import unlv.erc.emergo.model.HealthUnit;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.plus.model.people.Person;

import java.util.ArrayList;

public class RouteActivity extends AppCompatActivity {

    private double ACCEPTABLEDISTANCE = 1.0; //equivale a 111 KM
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_route);

    }

//        map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
//        setGabrielHomeMarker(map, -15.812140, -47.976671, "Casa Do Gabriel");

        //map.addMarker(new MarkerOptions().position(location).title("ALGUM NOME AQUI"));
        //map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat,lng),20));
//        map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);


    }

//    protected void setGabrielHomeMarker(GoogleMap map, double lat, double lng, String name){
//         map.addMarker(new MarkerOptions()
//                 .position(new LatLng(lat, lng))
//                 .title(name));
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 20));
//    }




/*

public class RouteActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        //
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        makeRoute();
    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
/*
    @Override
    public void onMapReady(GoogleMap googleMap){
        mMap=googleMap;

        //Get user location - Lazy try.
        LocationManager locManager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED&&ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
        // TODO: Consider calling
        //    ActivityCompat#requestPermissions
        // here to request the missing permissions, and then overriding
        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
        //                                          int[] grantResults)
        // to handle the case where the user grants the permission. See the documentation
        // for ActivityCompat#requestPermissions for more details.
        return;
        }
        Location userLocation=locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        double userLong=userLocation.getLongitude();
        double userLat=userLocation.getLatitude();

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LocationManager locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }


        GPSTracker gps = new GPSTracker(this.getBaseContext());
        boolean canGetLocation = gps.canGetLocation();
        if (canGetLocation) {
            double userLongitude = gps.getLongitude();
            double userLatitude = gps.getLatitude();

            LatLng userGeopoint = new LatLng(userLatitude, userLongitude);
            mMap.addMarker(new MarkerOptions().position(userGeopoint).title("Localização Atual"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(userLatitude, userLongitude), 13.0f));


        // Add a marker on User's location and move the camera
        LatLng userGeopoint=new LatLng(userLat,userLong);
        mMap.addMarker(new MarkerOptions().position(userGeopoint).title("Localização Atual"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(userGeopoint));
        }

        }
    }


    public void makeRoute (){
        // Create a Uri from an intent string. Use the result to create an Intent.
        Uri gmmIntentUri = Uri.parse("google.navigation:q=-16.02824,-48.05841");

        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        // Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");

        // Attempt to start an activity that can handle the Intent
        startActivity(mapIntent);
    }
}*/
