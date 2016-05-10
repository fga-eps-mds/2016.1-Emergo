package unlv.erc.emergo.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.HealthUnitAdapter;
import helper.GPSTracker;
import unlv.erc.emergo.model.HealthUnit;
import unlv.erc.emergo.R;

public class HealthUnitListController extends Activity {
    ListView listView;
    ArrayList<HealthUnit> hospitalList;
    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);

        // Initializing list view
        listView = (ListView) findViewById(R.id.list_of_hospitalUnit);

        gps = new GPSTracker(this);

        // Instancing controller
        final HealthUnitController hospitalUnitController = HealthUnitController.getInstance(getApplicationContext());
        // Initialize and fill list of hospital
        hospitalList = (ArrayList<HealthUnit>) HealthUnitController.healthUnitList;

        if(gps.canGetLocation()) {

            HealthUnitController.setDistance(getApplicationContext(), hospitalList);
            // Initializing new HospitalAdapter with list of hospitals
            HealthUnitAdapter adapter = new HealthUnitAdapter(getApplicationContext(), hospitalList);
            // Setting adapter to listView
            listView.setAdapter(adapter);
        }else {
            Toast.makeText(getApplicationContext(), "Voce não esta conectado ao gps ou a internet!\n Conecte-se para prosseguir.",Toast.LENGTH_LONG).show();
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int position,
                                    long id) {
                HealthUnitController.setHealthUnit(hospitalList.get(position));

                /*Intent intent = new Intent(getBaseContext(), GoogleMapHospital.class);

                startActivity(intent);*/
            }
        });

    }
}

