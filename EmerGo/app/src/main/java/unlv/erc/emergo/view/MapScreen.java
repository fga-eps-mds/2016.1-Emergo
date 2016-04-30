package unlv.erc.emergo.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import unlv.erc.emergo.R;
import unlv.erc.emergo.controller.RouteActivity;

/**
 * Created by Matheus on 24/04/2016.
 */
public class MapScreen extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_screen);

    }

    public void goClicked(View map_screen){
        Intent i = new Intent();
        i.setClass(this, RouteActivity.class);
        startActivity(i);

    }
}
