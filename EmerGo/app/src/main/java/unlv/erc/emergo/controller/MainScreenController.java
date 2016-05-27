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

import dao.DataAccessObject;
import helper.GPSTracker;
import helper.Services;
import unlv.erc.emergo.R;

public class MainScreenController extends Activity {

    private Button goButton , fineButton;
    private Services services = new Services();
    private DataAccessObject dataAccessObject = new DataAccessObject(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Firebase.setAndroidContext(this);
        SugarContext.init(this);

        dataAccessObject.setDataOnSugar(); //New DB Handler!

        OnClickListener goListener = new OnClickListener() {
            @Override
            public void onClick(View v) {

                //TO-DO!

            }
        };

        OnClickListener okayListener = new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mapScreen = new Intent();
                mapScreen.setClass(getBaseContext(), MapMap.class);
                startActivity(mapScreen);

            }
        };

        setContentView(R.layout.main_screen);
        goButton = (Button) findViewById(R.id.buttonGo);
        goButton.setOnClickListener(goListener);
        fineButton = (Button) findViewById(R.id.buttonOkay);
        fineButton.setOnClickListener(okayListener);
    }


}
