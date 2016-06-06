package unlv.erc.emergo.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import unlv.erc.emergo.R;

public class ConfigController extends Activity{
    private Button emergencyContact;
    private Button medicalRecord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config);

        emergencyContact = (Button) findViewById(R.id.emergencyContact);
        medicalRecord = (Button) findViewById(R.id.medicalRecords);

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
}
