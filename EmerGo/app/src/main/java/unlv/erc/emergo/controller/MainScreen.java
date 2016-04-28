package unlv.erc.emergo.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import unlv.erc.emergo.R;

/**
 * Created by Matheus on 21/04/2016.
 */
public class MainScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

    }

    public void goClicked(View main_Screen){
        // implementar go

    }

    public void okayClicked(View main_Screen){
        //implementar okay
        Intent infoHosp = new Intent(this , InformationUsScreen.class);
        startActivity(infoHosp);

    }
}
