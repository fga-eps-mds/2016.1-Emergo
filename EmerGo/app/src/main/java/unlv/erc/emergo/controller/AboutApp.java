package unlv.erc.emergo.controller;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import unlv.erc.emergo.R;

public class AboutApp extends Activity {

    private TextView informationAboutApp;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_app);
        String message= "O aplicativo EmerGo";

        informationAboutApp = (TextView) findViewById(R.id.aboutApp);
        informationAboutApp.setText(message);

    }

}
