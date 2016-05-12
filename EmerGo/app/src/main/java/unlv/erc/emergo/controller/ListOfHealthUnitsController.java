package unlv.erc.emergo.controller;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import adapter.HealthUnitAdapter;
import helper.GPSTracker;
import helper.Services;
import unlv.erc.emergo.R;
import unlv.erc.emergo.model.HealthUnit;

public class ListOfHealthUnitsController extends Activity {

    private List<String> fifthClosestsUs = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private ListView uSsList ;
    private View convertView;
    private Context context;
    private Services services = new Services();
    private InformationUsScreenController informationUsScreenController = new InformationUsScreenController();
    private int numberOfUsClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_health_unit);

//        HealthUnitController.setDistance(this, HealthUnitController.getClosestsUs(), services.getUserPosition());
        fifthClosestsUs = set50closestUs(HealthUnitController.getClosestsUs(), fifthClosestsUs);

        adapter = new ArrayAdapter<String>(this, R.layout.item, R.id.hospitalUnitText, fifthClosestsUs);
        uSsList = (ListView) findViewById(R.id.list_of_hospitalUnit);
        uSsList.setAdapter(adapter);
        uSsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                numberOfUsClicked = parent.getPositionForView(view);
                openInformationScreen();
            }
        });

    }

    public void openInformationScreen(){

        Intent informationScreen = new Intent();
        informationScreen.setClass(ListOfHealthUnitsController.this, InformationUsScreenController.class);
        startActivity(informationScreen);
//        informationUsScreenController.addInformationToList(HealthUnitController.getClosestsUs()
//                .get(numberOfUsClicked));
    }

    public List<String> set50closestUs(ArrayList<HealthUnit> closest , List<String> closestsUs){
        final int MAXNUMBERUS = 50;
        int numberOfUs;
        for(numberOfUs = 1 ; numberOfUs < MAXNUMBERUS ; numberOfUs++){
            closestsUs.add(closest.get(numberOfUs).getNameHospital());
        }
        return closestsUs;
    }

    private Float convertToKM(Float distance){

        return distance/1000;
    }
}

/*
    public void getDistanceOnScreen(View convertView, int position) {

        if (HealthUnitController.healthUnitList.get(position).getDistance() < 1f) {
            // Setting distance of drugstore on list item
            TextView textViewDistance = (TextView) convertView.findViewById(R.id.distanceText);
            textViewDistance.setText(HealthUnitController.healthUnitList.get(position).getDistance() + " m");
        } else {
            // Setting distance of drugstore on list item
            TextView textViewDistance = (TextView) convertView.findViewById(R.id.distanceText);
            textViewDistance.setText(convertToKM(HealthUnitController.healthUnitList.get(position).getDistance()).toString() + " Km");
        }
    }*/