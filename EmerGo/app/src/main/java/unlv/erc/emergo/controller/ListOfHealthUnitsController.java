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

import java.util.ArrayList;
import java.util.List;

import unlv.erc.emergo.R;
import android.widget.Toast;
import unlv.erc.emergo.model.HealthUnit;

public class ListOfHealthUnitsController extends Activity {

    private List<String> uSs = new ArrayList<>();
    private ListView uSsList;
    private int numberOfUsClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_health_unit);

        uSs = get50closestUs(HealthUnitController.getClosestsUs());


        setuSsList((ListView) findViewById(R.id.list_of_hospitalUnit));

        uSsList.setAdapter(new ArrayAdapter<String>(this, R.layout.item, R.id.hospitalUnitText, uSs));


        uSsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                numberOfUsClicked = parent.getPositionForView(view);
                openInformationUsScreen();
            }
        });
    }

    public void openInformationUsScreen() {

        Intent informationScreen = new Intent();
        informationScreen.putExtra("position", numberOfUsClicked);
        informationScreen.setClass(ListOfHealthUnitsController.this, InformationUsScreenController.class);
        startActivity(informationScreen);
        finish();
    }

    public List<String> get50closestUs(ArrayList<HealthUnit> closest) {

        List<String> closestsUs = new ArrayList<String>();
        int numberOfUs;
        for (numberOfUs = 0; numberOfUs < HealthUnitController.getClosestsUs().size(); numberOfUs++) {
            closestsUs.add(closest.get(numberOfUs).getNameHospital());
        }
        Log.i("distancia + proxima: ", closest.get(0).getDistance() + "");
        return closestsUs;
    }


    public void setuSsList(ListView uSsList) {
        this.uSsList = uSsList;
    }


    public void goClicked(View map_screen) {
        final String ROUTETRACED = "Rota mais próxima traçada";

        Toast.makeText(this, ROUTETRACED, Toast.LENGTH_SHORT).show();
        Intent routeActivity = new Intent();
        routeActivity.setClass(ListOfHealthUnitsController.this, RouteActivity.class);
        routeActivity.putExtra("numeroUs", -1);
        startActivity(routeActivity);
        finish();

    }

    public void listMapsImageClicked(View map_screen) {

    }

    public void openMap(View mapScreen) {
        Intent mapActivity = new Intent();
        mapActivity.setClass(this, MapScreenController.class);
        startActivity(mapActivity);
        finish();
    }


    public void openConfig(View map_screen) {
        Intent config = new Intent();
        config.setClass(ListOfHealthUnitsController.this, ConfigController.class);
        startActivity(config);
    }

    public void open_search(View mapScreen) {
        Intent openSearch = new Intent();
        openSearch.setClass(this, SearchUsController.class);
        startActivity(openSearch);
        finish();
    }

}

