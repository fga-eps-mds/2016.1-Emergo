package helper;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import unlv.erc.emergo.controller.HealthUnitController;
import unlv.erc.emergo.model.HealthUnit;

public class Services extends AppCompatActivity{


    private static final String URL_BASE_DB = "https://emergodf.firebaseio.com/";
    public List<HealthUnit> mList;

    public void selectHealhUnitys(final LatLng location) {

        Firebase ref = new Firebase("https://emergodf.firebaseio.com/EmerGo");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {

                boolean latChecked, longChecked;
                double latitude = 0.0, longitude = 0.0;
                double ACCEPTABLEDISTANCE = 1.0; // 110Km

                String nameHospital = "", unityType = "", state = "", city = "",
                        district = "", adressNumber = "";
                for (DataSnapshot allUSs : snapshot.getChildren()) {
                    latChecked = false;
                    longChecked = false;
                    for (DataSnapshot usValues : allUSs.getChildren()) {
                        //usValues.getKey() sao os nomes dos atributos, ex.: regiao e no_fantasia
                        //usValues.getValue() sao os valores do atributos
                        if (usValues.getKey().equalsIgnoreCase("co_cep")) {
                            adressNumber = usValues.getValue().toString();
                        }
                        if (usValues.getKey().equalsIgnoreCase("ds_tipo_unidade")) {
                            unityType = usValues.getValue().toString();
                        }
                        if (usValues.getKey().equalsIgnoreCase("lat")) {
                            if ( (double) usValues.getValue() - location.latitude < ACCEPTABLEDISTANCE ||
                                    (double) usValues.getValue() - location.latitude > -(ACCEPTABLEDISTANCE)) {
                                latChecked = true;
                                latitude = (double) usValues.getValue();
                            }
                        }
                        if (usValues.getKey().equalsIgnoreCase("long")) {
                            if ((double) usValues.getValue() - location.longitude < ACCEPTABLEDISTANCE ||
                                    (double) usValues.getValue() - location.longitude > -(ACCEPTABLEDISTANCE)) {
                                longChecked = true;
                                longitude = (double) usValues.getValue();
                            }
                        }
                        if (usValues.getKey().equalsIgnoreCase("municipio")) {
                            city = usValues.getValue().toString();
                        }
                        if (usValues.getKey().equalsIgnoreCase("no_bairro")) {
                            district = usValues.getValue().toString();
                        }
                        if (usValues.getKey().equalsIgnoreCase("no_fantasia")) {
                            nameHospital = usValues.getValue().toString();
                        }

                        if (usValues.getKey().equalsIgnoreCase("uf")) {
                            state = usValues.getValue().toString();
                        }

                        if (latChecked && longChecked) {
                            latChecked = false;
                            longChecked = false;
                            HealthUnit health = HealthUnitController.createHealthUnit(latitude, longitude, nameHospital,
                                    unityType, state, city, district, adressNumber);
                            HealthUnitController.setClosestsUs(health);

                        }
                    }

                }
                Log.i("Database", "has finished");
                Log.i("Have been added" , HealthUnitController.getClosestsUs().size() + "US");
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.e("Error", "It was not possible to get the data from Firebase");
            }

        });
    }


    public void setMarkersOnMap(GoogleMap map,ArrayList<HealthUnit> uSs){
        //WE should define how many markers we shall show to the user
        //This method should be used to add many Markers on map
        int markersQuantity;
        for(markersQuantity = 0; markersQuantity < uSs.size(); markersQuantity++){
            map.addMarker(new MarkerOptions()
                    .position(new LatLng(uSs.get(markersQuantity).getLatitude()
                            ,uSs.get(markersQuantity).getLongitude()))
                    .title(uSs.get(markersQuantity).getNameHospital() + "")
                    .snippet(uSs.get(markersQuantity).getUnitType()));

        }
    }

    /*public LatLng getUserPosition(){
        GPSTracker gps = new GPSTracker(this.getBaseContext());
        boolean canGetLocation = gps.canGetLocation();
        Log.i("ENTREEEEEEI NO METODOOO" , canGetLocation + "");
        if(canGetLocation){
            double userLongitude = gps.getLongitude();
            double userLatitude = gps.getLatitude();
            LatLng userGeopoint = new LatLng(userLatitude , userLongitude);
            return userGeopoint;
        }
        return null;
    }*/


    // @Override
    //protected void onCreate(Bundle savedInstanceState) {


    public LatLng getUserPosition(){
        GPSTracker gps = new GPSTracker(this);
        boolean canGetLocation = gps.canGetLocation();
        gps.getLocation();
        double userLongitude = gps.getLongitude();
        double userLatitude = gps.getLatitude();
        LatLng userGeopoint = new LatLng(userLatitude, userLongitude);
        return userGeopoint;
    }


    public void showSettingsAlert(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this.getBaseContext());

        // Setting Dialog Title
        alertDialog.setTitle("GPS is settings");

        // Setting Dialog Message
        alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");

        // Setting Icon to Dialog
        //alertDialog.setIcon(R.drawable.delete);

        // On pressing Settings button
        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        });

        // on pressing cancel button
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }


}


