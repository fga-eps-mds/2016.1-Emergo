package helper;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
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

public class Services extends Activity {
    private static final String URL_BASE_DB = "https://emergodf.firebaseio.com/EmerGo";
    private List<HealthUnit> healthUnitList;
    public void selectHealhUnitys(final LatLng location) {

        Firebase ref = new Firebase(URL_BASE_DB);

        //healthUnitList = HealthUnit.listAll(HealthUnit.class);
        Log.d("Lista preenchida", "LISTA PREENCHIDA");

        if (healthUnitList == null || healthUnitList.isEmpty()) {
            Log.d("LISTA VAZIA", "CHOREMOS");

            ref.child("EmerGo").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        String nameHospital = child.child("no_fantasia").getValue().toString();
                        String state = child.child("uf").getValue().toString();
                        String district = child.child("no_bairro").getValue().toString();
                        String city = child.child("municipio").getValue().toString();
                        String adressNumber = child.child("co_cep").getValue().toString();
                        String unitType = child.child("ds_tipo_unidade").getValue().toString();
                        double longitude = (double) child.child("long").getValue();
                        double latitude = (double) child.child("lat").getValue();

                        HealthUnit healthUnit = new HealthUnit(latitude, longitude, nameHospital,
                                unitType, adressNumber, district,
                                state, city);
                        HealthUnit health = HealthUnitController.createHealthUnit(latitude, longitude, nameHospital,
                                unitType, state, city, district, adressNumber);
                        HealthUnitController.setClosestsUs(health);
                        healthUnit.save();
                        Log.d("LOG 42!", nameHospital + " " + city);
                    }
                    //healthUnitList = HealthUnit.listAll(HealthUnit.class);
                    Log.d("ACABOU", "FINISH");
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        } else {
            Log.d("LOG 14", "LISTA PREENCHIDA OFFLINE");
        }
    }
        //ref.addListenerForSingleValueEvent(new ValueEventListener() {

            /*@Override
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
    }*/


    public void setMarkersOnMap(GoogleMap map,ArrayList<HealthUnit> uSs){
        int markersQuantity;
        for(markersQuantity = 0; markersQuantity < uSs.size(); markersQuantity++){
            map.addMarker(new MarkerOptions()
                    .position(new LatLng(uSs.get(markersQuantity).getLatitude()
                            ,uSs.get(markersQuantity).getLongitude()))
                    .title(uSs.get(markersQuantity).getNameHospital() + "")
                    .snippet(uSs.get(markersQuantity).getUnitType()));

        }
    }

    public void setDistance(Context context, ArrayList<HealthUnit> healthUnitList ,LatLng userGeopoint) {

        Log.i("TAMANHO DO VETOR:",healthUnitList.size()+"");
        float resultsAdapter[] = new float[1];
        int cont = 0;
        for (int aux = 0; aux < healthUnitList.size(); aux++) {
            Location.distanceBetween(healthUnitList.get(aux).getLatitude(),
                    healthUnitList.get(aux).getLongitude(),
                    userGeopoint.latitude, userGeopoint.longitude, resultsAdapter);
                    healthUnitList.get(aux).setDistance(resultsAdapter[0]);
        }
    }

    public LatLng getUserPosition(){
        GPSTracker gps = new GPSTracker(this.getBaseContext());
        boolean canGetLocation = gps.canGetLocation();
        double userLongitude = gps.getLongitude();
        double userLatitude = gps.getLatitude();
        LatLng userGeopoint = new LatLng(userLatitude, userLongitude);
        return userGeopoint;
    }
}