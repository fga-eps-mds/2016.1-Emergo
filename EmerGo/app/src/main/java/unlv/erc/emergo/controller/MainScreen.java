package unlv.erc.emergo.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import unlv.erc.emergo.R;

/**
 * Created by Matheus on 21/04/2016.
 */
public class MainScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        Button buttonGo = (Button) findViewById(R.id.buttonGo);

        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainScreen.this, "Função ainda não habilitada!!", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void goClicked(View main_Screen){
        // implementar go

    }

    public void okayClicked(View main_Screen){
        Intent i = new Intent();
        i.setClass(this, MapScreen.class);
        startActivity(i);
    }
}
