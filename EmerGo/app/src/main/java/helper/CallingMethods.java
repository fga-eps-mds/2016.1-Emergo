package helper;

import android.app.Service;
import android.content.Context;
import android.content.Intent;

public class CallMethods{

    public void call(View view){
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:192"));
        startActivity(callIntent);
    }

}