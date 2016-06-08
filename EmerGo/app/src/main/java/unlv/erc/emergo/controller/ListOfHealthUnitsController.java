package unlv.erc.emergo.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import unlv.erc.emergo.R;
import unlv.erc.emergo.model.HealthUnit;

public class ListOfHealthUnitsController extends Activity {

    private List<String> uSs = new ArrayList<>();
    private ListView uSsList ;
    private int numberOfUsClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_health_unit);


        for(int aux = 0 ; aux < HealthUnitController.getClosestsUs().size() ; aux++){
            uSs.add(HealthUnitController.getClosestsUs().get(aux).getNameHospital());
        }

        setuSsList((ListView) findViewById(R.id.list_of_hospitalUnit));
        uSsList.setAdapter(new ArrayAdapter<String>(this, R.layout.item, R.id.hospitalUnitText,
                            uSs));
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


    
    public void setuSsList(ListView uSsList) {
        this.uSsList = uSsList;
    }

    public void goClicked(View map_screen) {
        Intent mapRoute = new Intent();
        mapRoute.setClass(this, RouteActivity.class);
        startActivity(mapRoute);
        finish();
    }

    public void listMapsImageClicked(View map_screen){
        Intent listOfHealth = new Intent();
        listOfHealth.setClass(this , ListOfHealthUnitsController.class);
        startActivity(listOfHealth);
        finish();
    }

    public void openMap(View mapScreen){
        Intent mapActivity = new Intent();
        mapActivity.setClass(this, MapScreenController.class);
        startActivity(mapActivity);
        finish();
    }

    public void open_search(View mapScreen){
        Intent openSearch = new Intent();
        openSearch.setClass(this , SearchUsController.class);
        startActivity(openSearch);
    }

}
