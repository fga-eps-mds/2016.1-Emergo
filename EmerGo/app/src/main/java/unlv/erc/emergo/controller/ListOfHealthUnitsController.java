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

import com.google.android.gms.drive.internal.StringListResponse;
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
        //AQUI ORDENAMOS POR DISTANCIA
        LatLng a = new LatLng(-16.002955 , -48.0616721);
        services.setDistance(this,HealthUnitController.getClosestsUs(),a);
        ordenaPorDistancia(HealthUnitController.getClosestsUs());
     //   fifthClosestsUs = get50closestUs(HealthUnitController.getClosestsUs());

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
        informationScreen.putExtra("position", numberOfUsClicked);
        informationScreen.setClass(ListOfHealthUnitsController.this, InformationUsScreenController.class);
        startActivity(informationScreen);
    }

    public void ordenaPorDistancia(ArrayList<HealthUnit> closest){
        int aux,flag;
        HealthUnit helper;
        for(aux = 0; aux < closest.size()-1; aux++){
            for(flag = aux+1; flag < closest.size(); flag++){
                if(closest.get(aux).getDistance()>closest.get(flag).getDistance()){
                    helper = closest.get(flag);
                    closest.add(flag,closest.get(aux));
                    closest.add(aux,helper);
                    Log.i("Ordenando...","");
                }
            }
        }
        Log.i("Ordenamos por distancia","");
    }

    public List<String> get50closestUs(ArrayList<HealthUnit> closest){
        final int MAXNUMBERUS = 50;
        List<String> closestsUs = new ArrayList<String>();
        int numberOfUs;
        for(numberOfUs = 0 ; numberOfUs < MAXNUMBERUS ; numberOfUs++){
            closestsUs.add(closest.get(numberOfUs).getNameHospital());
        }
        Log.i("distancia + proxima: ",closest.get(0).getDistance()+"");
        return closestsUs;
    }

    private Float convertToKM(Float distance){

        return distance/1000;
    }

}
