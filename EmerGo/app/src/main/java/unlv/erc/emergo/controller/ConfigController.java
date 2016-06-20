package unlv.erc.emergo.controller;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import unlv.erc.emergo.R;

public class ConfigController extends Activity{
    private Button emergencyContact , buttonGo;
    private ImageView iconList;
    private Button medicalRecord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config);
        iconList = (ImageView) findViewById(R.id.iconList);
        buttonGo = (Button) findViewById(R.id.buttonGo);
        emergencyContact = (Button) findViewById(R.id.emergencyContact);
        medicalRecord = (Button) findViewById(R.id.medicalRecords);

        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                routeScreen();
            }
        });

        iconList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listUs();
            }
        });

        medicalRecord.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                medicalRecord();
            }
        });

        emergencyContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                emergencyContact();
            }
        });
    }

    public void routeScreen(){
        Intent map = new Intent();
        map.setClass(this , RouteActivity.class);
        map.putExtra("numeroUs" , -1);
        startActivity(map);
        finish();
    }

    public void listUs(){
        Intent listUs = new Intent();
        listUs.setClass(this , ListOfHealthUnitsController.class);
        startActivity(listUs);
        finish();
    }

    public void medicalRecord(){
        Intent medicalRecord = new Intent();
        medicalRecord.setClass(this,MedicalRecordsController.class);
        startActivity(medicalRecord);
    }

    public void emergencyContact(){
        Intent emergencyContact = new Intent();
        emergencyContact.setClass(this,EmergencyContactController.class);
        startActivity(emergencyContact);
    }

    public void goClicked(View map_screen){
        Toast.makeText(this , "Função não habilitada!" , Toast.LENGTH_SHORT).show();
        Intent routeActivity = new Intent();
        routeActivity.setClass(this, RouteActivity.class);
        startActivity(routeActivity);
        finish();
    }

    public void listMapsImageClicked(View map_screen){
        Intent listOfHealth = new Intent();
        listOfHealth.setClass(this , ListOfHealthUnitsController.class);
        startActivity(listOfHealth);
        finish();
    }

    public void openConfig(View map_screen){
        Intent config = new Intent();
        config.setClass(this , ConfigController.class);
        startActivity(config);
        finish();
    }

    public void openMap(View mapScreen){
        Intent mapActivity = new Intent();
        mapActivity.setClass(this, MapScreenController.class);
        startActivity(mapActivity);
        finish();
    }
}