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
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class RouteActivity extends AppCompatActivity {

    private LatLng location = new LatLng(-15.8303097,-48.101394);

    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_route);

//        map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
//        setGabrielHomeMarker(map, -15.812140, -47.976671, "Casa Do Gabriel");

        //map.addMarker(new MarkerOptions().position(location).title("ALGUM NOME AQUI"));
        //map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat,lng),20));
//        map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

        getDataFromFirebase();
    }

//    protected void setGabrielHomeMarker(GoogleMap map, double lat, double lng, String name){
//         map.addMarker(new MarkerOptions()
//                 .position(new LatLng(lat, lng))
//                 .title(name));
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 20));
//    }

    private void getDataFromFirebase() {
        Firebase ref = new Firebase("https://emergodf.firebaseio.com/EmerGo");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                int usNumber = 1;
                for (DataSnapshot allUSs : snapshot.getChildren()) {
                    Log.i("us number", usNumber + "");
                    for(DataSnapshot usValues : allUSs.getChildren()) {
                        //usValues.getKey() sao os nomes dos atributos, ex.: regiao e no_fantasia
                        //usValues.getValue() sao os valores do atributos
                        Log.i(usValues.getKey().toString(), usValues.getValue().toString());
                    }
                    usNumber++;
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.e("Error", "It was not possible to get the data from Firebase");
            }
        });
    }
}




















/*
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
/*
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Get user location - Lazy try.
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
        Location userLocation = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        double userLong = userLocation.getLongitude();
        double userLat = userLocation.getLatitude();

        //Defines a listener to location changes, preventing NULL location objects.
//        LocationListener locationListener = new LocationListener() {
//            public void onLocationChanged(Location location){
//                userLong = location.getLongitude();
//                userLat = location.getLatitude();
//            }
//        };

        //Checks if the app is enabled to use GPS. In case of failure, requests access.
//        int isPermissionGranted = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
//        if (isPermissionGranted == PackageManager.PERMISSION_GRANTED) {
//            locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, locationListener);
//        }

        // Add a marker on User's location and move the camera
        LatLng userGeopoint = new LatLng(userLat, userLong);
        mMap.addMarker(new MarkerOptions().position(userGeopoint).title("Localização Atual"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(userGeopoint));
    }


}
*/
