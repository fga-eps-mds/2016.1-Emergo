package unlv.erc.emergo.controller;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.PathOverlay;


import dao.EmergencyContactDao;
import unlv.erc.emergo.R;

public class RouteActivity extends AppCompatActivity {

    EmergencyContactDao emergencyContactDao = new EmergencyContactDao(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.map_screen);

//        setRoute(map, geoLocation, new GeoPoint(HealthUnitController.getClosestsUs().get(0).getLatitude(),
//                                  HealthUnitController.getClosestsUs().get(0).getLongitude()));

    }

    public void setRoute(MapView mMapView, GeoPoint userPosition, GeoPoint unitPosition){
        mMapView.getController().setCenter(userPosition);
        PathOverlay myPath = new PathOverlay(Color.RED, this);
        myPath.addPoint(userPosition);
        myPath.addPoint(unitPosition);
        mMapView.getOverlays().add(myPath);
    }

    public void goClicked(View map_screen) {
        Cursor result = emergencyContactDao.getEmergencyContact();
        Log.i("NUM CONTATOS: ",result.getCount()+" ");

        if(result.getCount() != 0) {
            try {
                while(result.moveToNext()){
                    SmsManager.getDefault().sendTextMessage(result.getString(2), null, result.getString(1) + ", Estou precisando de ajuda urgente! teste EmerGO", null, null);
                }
                Toast.makeText(getApplicationContext(),"Ajuda a caminho", Toast.LENGTH_LONG).show();
            }catch(Exception exception){
                Toast.makeText(getApplicationContext(),"Impossível encaminhar o SMS", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getApplicationContext(),"Nenhum contato adicionado", Toast.LENGTH_LONG).show();

        }
        /*
        Intent mapRoute = new Intent();
        mapRoute.setClass(this, RouteActivity.class);
        startActivity(mapRoute);
        finish();*/
    }

    public void listMapsImageClicked(View map_screen){
        Intent listOfHealth = new Intent();
        listOfHealth.setClass(this, ListOfHealthUnitsController.class);
        startActivity(listOfHealth);
        finish();
    }

    public void openMap(View mapScreen){
        Intent mapActivity = new Intent();
        mapActivity.setClass(this, MapScreenController.class);
        startActivity(mapActivity);
        finish();
    }



}




