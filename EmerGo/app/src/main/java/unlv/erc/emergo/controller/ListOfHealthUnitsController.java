package unlv.erc.emergo.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.HealthUnitAdapter;
import helper.Services;
import unlv.erc.emergo.R;
import unlv.erc.emergo.model.HealthUnit;

public class ListOfHealthUnitsController extends Activity {

    private Services services = new Services();
    private List<String> fifthClosestsUs = new ArrayList<String>();
    private ListView uSsList ;
    private int numberOfUsClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_health_unit);


        fifthClosestsUs = get50closestUs(HealthUnitController.getClosestsUs());

        setuSsList((ListView) findViewById(R.id.list_of_hospitalUnit));
        uSsList.setAdapter(new ArrayAdapter<String>(this, R.layout.item, R.id.hospitalUnitText,
                            fifthClosestsUs));
        uSsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                numberOfUsClicked = parent.getPositionForView(view);
                openInformationUsScreen();
            }
        });

    }

    public void openInformationUsScreen(){

        Intent informationScreen = new Intent();
        informationScreen.putExtra("position", numberOfUsClicked);
        informationScreen.setClass(ListOfHealthUnitsController.this, InformationUsScreenController.class);
        startActivity(informationScreen);
    }


    public List<String> get50closestUs(ArrayList<HealthUnit> closest){
        final int MAXNUMBERUS = 50;
        List<String> closestsUs = new ArrayList<String>();
        int numberOfUs;
        for(numberOfUs = 1 ; numberOfUs < MAXNUMBERUS ; numberOfUs++){
            closestsUs.add(closest.get(numberOfUs).getNameHospital());
        }
        return closestsUs;
    }
    
    public void setuSsList(ListView uSsList) {
        this.uSsList = uSsList;
    }

    public void goClicked(View map_screen) {
        Toast.makeText(this, "Função não habilitada!", Toast.LENGTH_SHORT).show();
    }

    public void listMapsImageClicked(View map_screen){
        Intent listOfHealth = new Intent();
        listOfHealth.setClass(this , ListOfHealthUnitsController.class);
        startActivity(listOfHealth);
        finish();
    }

    public void openMap(View mapScreen){
        Intent mapActivity = new Intent();
        mapActivity.setClass(this, MapMap.class);
        startActivity(mapActivity);
        finish();
    }

}
