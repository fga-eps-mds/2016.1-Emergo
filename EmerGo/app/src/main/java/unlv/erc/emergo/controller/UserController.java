package unlv.erc.emergo.controller;

import android.app.Activity;
import android.os.Bundle;

import unlv.erc.emergo.R;

public class UserController extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user);
    }
}
