package unlv.erc.emergo.controller;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.orm.SugarContext;

import helper.Services;
import unlv.erc.emergo.R;

public class MainScreenController extends Activity {

    private Button goButton , fineButton;
    private Services services = new Services();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Firebase.setAndroidContext(this);

        SugarContext.init(this);
       // services.selectHealhUnitys(services.getUserPosition());


        Log.i("log", "testeeeeeeeeeeeeeeeeeeee");
        services.setDataOnSugar();

        Log.i("log", "FIIM ALELUIA ALELIA KAKAKAK");


        OnClickListener goListener = new OnClickListener() {
            @Override
            public void onClick(View v) {

                //TO-DO!

            }
        };

        OnClickListener okayListener = new OnClickListener() {
            @Override
            public void onClick(View v) {

                Services services = new Services();

                services.selectHealhUnitys(services.getUserPosition());

                Intent mapScreen = new Intent();
                mapScreen.setClass(getBaseContext(), MapScreenController.class);
                startActivity(mapScreen);

            }
        };

        setContentView(R.layout.main_screen);
        goButton = (Button) findViewById(R.id.buttonGo);
        goButton.setOnClickListener(goListener);
        fineButton = (Button) findViewById(R.id.buttonOkay);
        fineButton.setOnClickListener(okayListener);
    }

    public void goClicked(View main_Screen){


    }

    public void okayClicked(View main_Screen){


    }

}
