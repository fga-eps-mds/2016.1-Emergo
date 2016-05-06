package unlv.erc.emergo.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.HospitalUnitAdapter;
import helper.GPSTracker;
import unlv.erc.emergo.controller.HospitalUnitController;
import unlv.erc.emergo.model.HospitalUnit;
import unlv.erc.emergo.R;

public class HospitalList extends Activity {
    ListView listView;
    ArrayList<HospitalUnit> hospitalList;
    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);

        // Initializing list view
        listView = (ListView) findViewById(R.id.list_of_hospitalUnit);

        gps = new GPSTracker(this);

        // Instancing controller
        final HospitalUnitController hospitalUnitController = HospitalUnitController.getInstance(getApplicationContext());
        // Initialize and fill list of hospital
        hospitalList = (ArrayList<HospitalUnit>) HospitalUnitController.getHospitalList();

        if(gps.canGetLocation()) {

            HospitalUnitController.setDistance(getApplicationContext(), hospitalList);
            // Initializing new HospitalAdapter with list of hospitals
            HospitalUnitAdapter adapter = new HospitalUnitAdapter(getApplicationContext(), hospitalList);
            // Setting adapter to listView
            listView.setAdapter(adapter);
        }else {
            Toast.makeText(getApplicationContext(), "Voce não esta conectado ao gps ou a internet!\n Conecte-se para prosseguir.",Toast.LENGTH_LONG).show();
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int position,
                                    long id) {
                HospitalUnitController.setHospitalUnit(hospitalList.get(position));

                /*Intent intent = new Intent(getBaseContext(), GoogleMapHospital.class);

                startActivity(intent);*/
            }
        });

    }
}

