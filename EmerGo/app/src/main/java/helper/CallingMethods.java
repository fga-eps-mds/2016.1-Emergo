package helper;

import android.app.Service;
import android.content.Context;
import android.content.Intent;

public class CallingMethods{

    public void call(View view){
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:192"));
        startActivity(callIntent);
    }

    public TelephonyManager listeningCallState(){
        CallListener phoneListener = new CallListener();
        TelephonyManager telephonyManager = (TelephonyManager) this
                .getSystemService(Context.TELEPHONY_SERVICE);
        telephonyManager.listen(phoneListener,PhoneStateListener.LISTEN_CALL_STATE);
        return telephonyManager;
    }

}