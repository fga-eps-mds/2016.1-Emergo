package unlv.erc.emergo.controller;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import helper.Services;
import unlv.erc.emergo.R;
import unlv.erc.emergo.model.HealthUnit;

public class MainScreenController extends Activity {

    public Button goButton;
    public Button fineButton;
    private Services services = new Services();
    //CallingMethods callingMethods = new CallingMethods();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Firebase.setAndroidContext(this);
        services.selectHealhUnitys(services.getUserPosition());

        setContentView(R.layout.main_screen);
        goButton = (Button) findViewById(R.id.buttonGo);
        fineButton = (Button) findViewById(R.id.buttonOkay);

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:33713601"));
                startActivity(callIntent);
            }
        });

    }

    public void goClicked(View main_Screen){
        Intent mapScreen = new Intent();
        mapScreen.setClass(this, MapScreenController.class);
        startActivity(mapScreen);
    }

    public void okayClicked(View main_Screen){

        Intent mapScreen = new Intent();
        mapScreen.setClass(this, MapScreenController.class);
        startActivity(mapScreen);
    }

}
