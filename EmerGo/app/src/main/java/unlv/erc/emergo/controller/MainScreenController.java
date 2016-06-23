package unlv.erc.emergo.controller;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.firebase.client.Firebase;
import com.orm.SugarContext;

import dao.DataAccessObject;
import dao.UserDao;
import helper.Services;

import unlv.erc.emergo.R;

public class MainScreenController extends Activity {

    private Button goButton, fineButton;
    private Services services = new Services();
    private DataAccessObject dataAccessObject = new DataAccessObject(this);
    private Cursor result;
    UserDao myDatabase;
    private final int MAXIMUMARRAY = 7;
    private int number = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        goButton = (Button) findViewById(R.id.buttonGo);
        fineButton = (Button) findViewById(R.id.buttonOkay);

        Firebase.setAndroidContext(this);
        SugarContext.init(this);
        myDatabase = new UserDao(this);
        dataAccessObject.setDataOnSugar();
        result = myDatabase.getUser();

        if(result.getCount() == 0){

        }else{
            medicalRecordsNotification();
        }
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


    private void medicalRecordsNotification(){
        result.moveToFirst();
        int notifyID = 1;
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this);

        notification.setContentTitle("Ficha Médica");
        notification.setContentText("Você tem uma ficha médica!");
        notification.setTicker("Alerta de Mensagem");
        notification.setSmallIcon(R.drawable.icon_emergo);

        notification.setNumber(++number);

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();


        String events[] = new String[7];

        events[0] = new String("Nome: "+result.getString(1));
        events[1] = new String("Data de Nascimento: "+result.getString(2));
        events[2] = new String("Tipo Sanguineo: "+result.getString(3));
        events[3] = new String("Cardiaco: "+result.getString(4));
        events[4] = new String("Diabetico: "+result.getString(5));
        events[5] = new String("Hipertenso: "+result.getString(6));
        events[6] = new String("Soropositivo: "+result.getString(7));
        events[6] = new String("Observações Especiais: "+result.getString(8));

        inboxStyle.setBigContentTitle("Ficha Médica");

        for(int aux=0;aux<MAXIMUMARRAY;aux++){
            inboxStyle.addLine(events[aux]);
        }
        notification.setStyle(inboxStyle);

        Intent resultIntent = new Intent(this,MedicalRecordsController.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MedicalRecordsController.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPedindIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(resultPedindIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(notifyID,notification.build());
    }
}

