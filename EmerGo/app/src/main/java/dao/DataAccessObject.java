package dao;

import android.content.Context;
import android.util.Log;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import unlv.erc.emergo.controller.HealthUnitController;
import unlv.erc.emergo.model.HealthUnit;


public class DataAccessObject {

    private Integer id = 1;
    private Context context;
    private static final String URL_BASE_DB = "https://emergodf.firebaseio.com/";

    public DataAccessObject(Context context) {

        this.context = context;

    }

    public void setDataOnSugar(){

        Firebase.setAndroidContext(this.context);
        Firebase ref = new Firebase(URL_BASE_DB);

        if (HealthUnitController.getClosestsUs().size() == 0 ||
                HealthUnitController.getClosestsUs() == null) {
            Log.d("log123", "lista vazia");

            ref.child("EmerGo").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        double latitude = (double) child.child("lat").getValue();
                        double longitude = (double) child.child("long").getValue();
                        String nameHospital = child.child("no_fantasia").getValue().toString();
                        String unitType = child.child("ds_tipo_unidade").getValue().toString();
                        String addressNumber = child.child("co_cep").getValue().toString();
                        String district = child.child("no_bairro").getValue().toString();
                        String state = child.child("uf").getValue().toString();
                        String city = child.child("municipio").getValue().toString();

                        HealthUnit model = new HealthUnit(id,latitude,longitude,nameHospital,unitType,
                                addressNumber,district,state,city);
                        HealthUnitController.setClosestsUs(model);

                    }
                    Log.d("log123", "acabou");
                }
                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
        else{
            Log.d("log123", "preenchida offline");
        }
    }
}