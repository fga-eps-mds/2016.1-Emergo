package unlv.erc.emergo.controller;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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

        dataAccessObject.setDataOnSugar();

        OnClickListener goListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms: 55061996941411"));
                    smsIntent.putExtra("sms_body", "ihuul, emergo decolando!");
                    startActivity(smsIntent);
                    Toast.makeText(getApplicationContext(),"Deu bom o SMS", Toast.LENGTH_LONG).show();
                }catch(Exception exception){
                    Toast.makeText(getApplicationContext(),"Nao rolou de mandar o SMS", Toast.LENGTH_LONG).show();
                }

            }
        };

        OnClickListener okayListener = new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mapScreen = new Intent();
                mapScreen.setClass(getBaseContext(), MapScreenController.class);
                startActivity(mapScreen);
                Toast.makeText(MainScreenController.this ,"Carregando USs no mapa" , Toast.LENGTH_SHORT).show();
            }
        };

        setContentView(R.layout.main_screen);
        goButton = (Button) findViewById(R.id.buttonGo);
        goButton.setOnClickListener(goListener);
        fineButton = (Button) findViewById(R.id.buttonOkay);
        fineButton.setOnClickListener(okayListener);
    }
}
