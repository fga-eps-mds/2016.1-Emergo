package unlv.erc.emergo.controller;


import android.content.Intent;
import android.content.pm.PackageManager;

import android.graphics.Color;

import android.location.Location;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;


import android.view.View;

import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import helper.Services;

import android.Manifest;


import org.json.JSONException;

import unlv.erc.emergo.R;


public class MapScreenController extends FragmentActivity implements OnMapReadyCallback {

    final int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 124;
    private GoogleMap mMap;
    private Services services = new Services();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_screen);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mMap = mapFragment.getMap();
    }


    public void goClicked(View map_screen) throws IOException, JSONException {
        final String ROUTETRACED = "Rota mais próxima traçada";
        Toast.makeText(this, ROUTETRACED , Toast.LENGTH_SHORT).show();
        Intent routeActivity = new Intent();
        routeActivity.setClass(MapScreenController.this , RouteActivity.class);
        startActivity(routeActivity);
        finish();
    }


    public void listMapsImageClicked(View map_screen) {
        Intent listOfHealth = new Intent();
        listOfHealth.setClass(this, ListOfHealthUnitsController.class);
        startActivity(listOfHealth);
    }

    public void openMap(View mapScreen) {
        Intent mapActivity = new Intent();
        mapActivity.setClass(this, MapScreenController.class);
        startActivity(mapActivity);
        finish();
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        try {
            checkPermissions();
            LatLng userLatLng = new LatLng(-15.6898743 , -47.8299874);

            mMap = googleMap;
            final String yourPosition = "Sua posição";
            mMap.addMarker(new MarkerOptions().position(userLatLng).title(yourPosition)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom
                    (new LatLng(userLatLng.latitude, userLatLng.longitude), 13.0f));
            mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {
                    try{
                        if (!marker.getTitle().contentEquals(yourPosition)){
                            Toast.makeText(MapScreenController.this, "CLicked" , Toast.LENGTH_SHORT).show();
                        }
                    }catch (NullPointerException ex){
                        Toast.makeText(MapScreenController.this , "Não pode traçar rota para a sua posição" , Toast.LENGTH_LONG).show();
                    }

                }
            });
            services.setMarkersOnMap(mMap , HealthUnitController.getClosestsUs() );

        } catch (NullPointerException nullPointer) {
            Toast.makeText(this, "Habilite o GPS", Toast.LENGTH_LONG).show();
            Intent mainScreen = new Intent();
            mainScreen.setClass(this, MainScreenController.class);
            startActivity(mainScreen);
            finish();
        }

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
