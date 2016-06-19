


package unlv.erc.emergo.controller;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import helper.GPSTracker;
import helper.Services;
import unlv.erc.emergo.R;



public class MapScreenController extends FragmentActivity implements OnMapReadyCallback  {

    final int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 124;
    final String yourPosition = "Sua posição";
    private GoogleMap mMap;
    private Services services = new Services();
    Location location;
    GPSTracker gps = new GPSTracker(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_screen);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mMap = mapFragment.getMap();

    }



    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
        try {
            checkPermissions();
            location = new Location("");// gps.getLocation();
            location.setLatitude(-15.879405);
            location.setLongitude(-47.8077307);
            LatLng userLatLng = new LatLng(location.getLatitude() , location.getLongitude());
            mMap.addMarker(new MarkerOptions().position(userLatLng).title(yourPosition)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom
                    (new LatLng(userLatLng.latitude, userLatLng.longitude), 13.0f));
            services.setMarkersOnMap(mMap , HealthUnitController.getClosestsUs() );

        } catch (NullPointerException nullPointer) {
            Toast.makeText(this, "Habilite o GPS", Toast.LENGTH_SHORT).show();
            Intent mainScreen = new Intent();
            mainScreen.setClass(this, MainScreenController.class);
            startActivity(mainScreen);
            finish();
        }

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                for(int aux = 0 ; aux < HealthUnitController.getClosestsUs().size() ; aux++){
                    if(marker.getTitle().toString().compareTo(HealthUnitController.getClosestsUs().get(aux).getNameHospital()) == 0){
                        Intent information = new Intent();
                        information.setClass(MapScreenController.this , InformationUsScreenController.class);
                        information.putExtra("position" , aux);
                        startActivity(information);
                        finish();
                    }
                }
                return false;
            }
        });

    }


    public void goClicked(View map_screen) throws IOException, JSONException {
        final String ROUTETRACED = "Rota mais próxima traçada";

        Toast.makeText(this, ROUTETRACED , Toast.LENGTH_SHORT).show();
        Intent routeActivity = new Intent();
        routeActivity.setClass(MapScreenController.this , RouteActivity.class);
        routeActivity.putExtra("numeroUs" , -1);
        startActivity(routeActivity);
        finish();
    }

    public void listMapsImageClicked(View map_screen) {
        Intent listOfHealth = new Intent();
        listOfHealth.setClass(this, ListOfHealthUnitsController.class);
        startActivity(listOfHealth);
        finish();
    }

    public void openMap(View mapScreen) {

    }
    public void openConfig(View map_screen){
        Intent config = new Intent();
        config.setClass(MapScreenController.this , ConfigController.class);
        startActivity(config);
    }


    private void checkPermissions() {

        List<String> permissions = new ArrayList<>();
        String message = "Permissão";
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
            message += "\nTer acesso a localização no mapa";
        }
        if (!permissions.isEmpty()) {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            String[] params = permissions.toArray(new String[permissions.size()]);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(params, REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS: {
                Map<String, Integer> perms = new HashMap<>();

                perms.put(Manifest.permission.ACCESS_FINE_LOCATION, PackageManager.PERMISSION_GRANTED);

                for (int i = 0; i < permissions.length; i++)
                    perms.put(permissions[i], grantResults[i]);

                Boolean location = false , storage = false;
                location = perms.get(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
                try{
                    storage = perms.get(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
                }catch (RuntimeException ex){
                    Toast.makeText(this , "É necessário ter a permissão" , Toast.LENGTH_LONG).show();
                    Intent main = new Intent();
                    main.setClass(this , MainScreenController.class);
                    startActivity(main);
                    finish();
                }

                if (location && storage) {
                    Toast.makeText(this, "Permissão aprovada", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(this,"Permita ter o acesso para te localizar", Toast.LENGTH_SHORT).show();
                }
            }
            break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

    }

}

