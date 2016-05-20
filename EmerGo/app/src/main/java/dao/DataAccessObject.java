package dao;

import android.content.Context;
import android.util.Log;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import unlv.erc.emergo.model.HealthUnit;

/**
 * Created by AndreBedran on 5/18/16.
 */
public class DataAccessObject {


    private Context context;

    public DataAccessObject(Context context) {

        this.context = context;

    }

    public void setDataOnSugar(){
        //  super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_main);

        // mListView = (ListView) findViewById(R.id.listView);

        Firebase.setAndroidContext(this.context);
        Firebase ref = new Firebase(URL_BASE_DB);  //PRECISA ARRUMAR AQUI

        if (mList == null || mList.isEmpty()) { //PRECISA ARRUMAR AQUI
            Log.d("log123", "lista vazia");

            ref.child("EmerGo").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        String no_fantasia = child.child("no_fantasia").getValue().toString();
                        String no_bairro = child.child("no_bairro").getValue().toString();
                        String municipio = child.child("municipio").getValue().toString();

                        HealthUnit model = new HealthUnit(no_fantasia, no_bairro, municipio);
                        model.save();

                        Log.d("log123", no_fantasia + "  " + no_bairro + " " + municipio);
                    }

                    mList = HealthUnit.listAll(HealthUnit.class); //PRECISA ARRUMAR AQUI - mList??????

                    Log.d("log123", "acabou");

                    //  mListViewAdapter = new ListViewAdapter(MainActivity.this, mList);
                    // mListView.setAdapter(mListViewAdapter);


                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
        else
        {

            Log.d("log123", "preenchida offline");
            // mListViewAdapter = new ListViewAdapter(MainActivity.this, mList);
            //  mListView.setAdapter(mListViewAdapter);
        }



    }


}
