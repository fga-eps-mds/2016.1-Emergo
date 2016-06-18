package unlv.erc.emergo.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.orm.SugarContext;

import dao.DataAccessObject;
import helper.Services;

import unlv.erc.emergo.R;

public class MainScreenController extends Activity {

    private Button goButton, fineButton;
    private Services services = new Services();
    private DataAccessObject dataAccessObject = new DataAccessObject(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        goButton = (Button) findViewById(R.id.buttonGo);
        fineButton = (Button) findViewById(R.id.buttonOkay);

        Firebase.setAndroidContext(this);
        SugarContext.init(this);

        dataAccessObject.setDataOnSugar();

    }

    public void goClicked(View main_Screen) {
        final String ROUTETRACED = "Rota mais próxima traçada";
        Toast.makeText(MainScreenController.this, ROUTETRACED, Toast.LENGTH_SHORT).show();
        Intent routeActivity = new Intent();
        routeActivity.setClass(MainScreenController.this, RouteActivity.class);
        routeActivity.putExtra("numeroUs", -1);
        startActivity(routeActivity);
    }

    public void okayClicked(View view){
        Intent mapScreen = new Intent();
        mapScreen.setClass(getBaseContext(), MapScreenController.class);
        startActivity(mapScreen);
    }
}



