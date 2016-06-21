package unlv.erc.emergo.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import unlv.erc.emergo.R;
public class LoadingScreenController extends Activity {
    private static int SPLASH_TIME_OUT = 9000;
    private ProgressBar spinner;

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_screen);

        spinner=(ProgressBar)findViewById(R.id.progressBar);
        spinner.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent contador = new Intent(LoadingScreenController.this, MainScreenController.class);
                startActivity(contador);

                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}