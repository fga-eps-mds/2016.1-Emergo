package unlv.erc.emergo.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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
        finish();
    }


    public List<String> get50closestUs(ArrayList<HealthUnit> closest){

        List<String> closestsUs = new ArrayList<String>();
        int numberOfUs;
        for(numberOfUs = 0 ; numberOfUs < HealthUnitController.getClosestsUs().size() ; numberOfUs++){
            closestsUs.add(closest.get(numberOfUs).getNameHospital());
        }
        return closestsUs;
    }
    
    public void setuSsList(ListView uSsList) {
        this.uSsList = uSsList;
    }

    public void goClicked(View map_screen) {
            final String ROUTETRACED = "Rota mais próxima traçada";

            Toast.makeText(this, ROUTETRACED , Toast.LENGTH_SHORT).show();
            Intent routeActivity = new Intent();
            routeActivity.setClass(ListOfHealthUnitsController.this , RouteActivity.class);
            routeActivity.putExtra("numeroUs" , -1);
            startActivity(routeActivity);
            finish();

    }

    public void listMapsImageClicked(View map_screen){

    }

    public void openMap(View mapScreen){
        Intent mapActivity = new Intent();
        mapActivity.setClass(this, MapScreenController.class);
        startActivity(mapActivity);
        finish();
    }

}
