package unlv.erc.emergo.controller;

import unlv.erc.emergo.R;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class RouteActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Get user location - Lazy try.
        LocationManager locManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Location userLocation = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        final double userLong = userLocation.getLongitude();
        final double userLat = userLocation.getLatitude();

        //Defines a listener to location changes, preventing NULL location objects.
        private final LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location){
                userLong = location.getLongitude();
                userLat = location.getLatitude();
            }
        };

        //Checks if the app is enabled to use GPS. In case of failure, requests access.
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION});
        }
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, locationListener);

        // Add a marker on User's location and move the camera
        LatLng userGeopoint = new LatLng(userLat, userLong);
        mMap.addMarker(new MarkerOptions().position(userGeopoint).title("Localização Atual"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(userGeopoint));
    }


}
