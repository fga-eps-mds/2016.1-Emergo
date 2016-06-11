package unlv.erc.emergo.controller;

import android.Manifest;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import helper.DirectionsJSONParser;
import helper.GPSTracker;
import unlv.erc.emergo.R;


public class RouteActivity  extends FragmentActivity {

    final int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 124;
    private GoogleMap mMap;
    GPSTracker gps = new GPSTracker(RouteActivity.this);
    ArrayList<LatLng> pointsOfRoute = new ArrayList<>();
    LatLng myLocation = new LatLng(-15.6898743 , -47.8299874); // my location (leo's house)
    int indexOfClosestUs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.route_activity);

        checkPermissions();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mMap = mapFragment.getMap();

        setYourPositionOnMap();
        focusOnYourPosition();

        pointsOfRoute.add (myLocation);
        String urlInitial =  getDirectionsUrl(myLocation ,
                new LatLng(HealthUnitController.getClosestsUs().get(indexOfClosestUs).getLatitude(),
                        HealthUnitController.getClosestsUs().get(indexOfClosestUs).getLongitude()));
        DownloadTask downloadTask = new DownloadTask();
        downloadTask.execute(urlInitial);

        setMarkerOfClosestUsOnMap();


    }

    public void cancelClicked(View view ){
        Intent mapScreen = new Intent();
        mapScreen.setClass(RouteActivity.this , MapScreenController.class);
        startActivity(mapScreen);
        finish();
    }

    private void setMarkerOfClosestUsOnMap() {
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(HealthUnitController.getClosestsUs().get(indexOfClosestUs).getLatitude()
                        ,HealthUnitController.getClosestsUs().get(indexOfClosestUs).getLongitude()))
                .title(HealthUnitController.getClosestsUs().get(indexOfClosestUs).getNameHospital() + "")
                .snippet(HealthUnitController.getClosestsUs().get(indexOfClosestUs).getUnitType()));
    }


    private void focusOnYourPosition() {
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom
                (new LatLng(myLocation.latitude, myLocation.longitude), 13.0f));
    }

    public void focusOnYourPosition(View view) {
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom
                (new LatLng(myLocation.latitude, myLocation.longitude), 13.0f));
    }

    private void setYourPositionOnMap() {
        final String yourPosition = "Sua posição";
        mMap.addMarker(new MarkerOptions().position(myLocation).title(yourPosition)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
    }


    private String getDirectionsUrl(LatLng origin,LatLng dest){

        String str_origin = "origin="+origin.latitude+","+origin.longitude;
        String str_dest = "destination="+dest.latitude+","+dest.longitude;
        String sensor = "sensor=false";
        String parameters = str_origin+"&"+str_dest+"&"+sensor;
        String output = "json";
        String url = "https://maps.googleapis.com/maps/api/directions/"+output+"?"+parameters;

        return url;
    }

    private class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... url) {

            String data = "";

            try{
                data = downloadUrl(url[0]);
            }catch(Exception e){
                Log.d("Background Task",e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask();
            parserTask.execute(result);
        }
    }

    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try{
            URL url = new URL(strUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb  = new StringBuffer();

            String line = "";
            while( ( line = br.readLine())  != null){
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        }catch(Exception e){
            Log.d("Error downloading url", e.toString());
        }finally{

            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String,String>>> >{

        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try{
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();

                routes = parser.parse(jObject);
            }catch(Exception e){
                e.printStackTrace();
            }
            return routes;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;

            for(int i=0;i<result.size();i++){
                points = new ArrayList<LatLng>();
                lineOptions = new PolylineOptions();

                List<HashMap<String, String>> path = result.get(i);

                for(int j=0;j<path.size();j++){
                    HashMap<String,String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                lineOptions.addAll(points);
                lineOptions.width(7);
                lineOptions.color(Color.BLUE);
            }
            mMap.addPolyline(lineOptions);
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
                    Toast.makeText(this, "Permita o acesso para te localizar", Toast.LENGTH_SHORT).show();
                }
            }
            break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

    }






}

