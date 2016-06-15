package unlv.erc.emergo.controller;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.orm.SugarContext;

import dao.DataAccessObject;
import dao.UserDao;
import helper.Services;
import unlv.erc.emergo.R;

public class MainScreenController extends Activity {

    private Button goButton , fineButton;
    private Services services = new Services();
    private DataAccessObject dataAccessObject = new DataAccessObject(this);
    private Cursor result;
    UserDao myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Firebase.setAndroidContext(this);
        SugarContext.init(this);
        myDatabase = new UserDao(this);
        dataAccessObject.setDataOnSugar();
        result = myDatabase.getUser();

        if(result.getCount() == 0){

        }else{
            medicalRecordsNotification();
        }
        OnClickListener goListener = new OnClickListener() {
            @Override
            public void onClick(View v) {

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

    private void medicalRecordsNotification(){
        result.moveToFirst();
        Intent intent = new Intent(this,MainScreenController.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);

        Notification notification = new Notification.Builder(this)
                .setTicker("Ficha Médica")
                .setContentTitle("Ficha Médica")
                .setContentText("Nome: "+result.getString(1))
                .setSmallIcon(R.drawable.button_go)
                .setContentIntent(pendingIntent).getNotification();
        notification.flags = Notification.FLAG_AUTO_CANCEL;

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(0,notification);
    }
}
