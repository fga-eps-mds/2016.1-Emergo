package unlv.erc.emergo.controller;

import android.content.Context;
import android.location.Location;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import helper.GPSTracker;
import unlv.erc.emergo.model.HealthUnit;

import static java.util.Collections.sort;

public class HealthUnitController {
    private static HealthUnitController instance = null;
    static ArrayList<HealthUnit> closestsUs = new ArrayList<HealthUnit>();

    public static HealthUnit createHealthUnit(Double latitude , Double longitude , String nameHospital,
                                              String unityType , String addressNumber , String district ,
                                              String state, String city) {
        HealthUnit healthUnit = new HealthUnit(latitude, longitude, nameHospital, unityType, addressNumber,
                district, state, city );
        return healthUnit;
    }

    public HealthUnitController(Context context) {

    }

    public static ArrayList<HealthUnit> getClosestsUs() {
        return closestsUs;
    }

    public static void setClosestsUs(HealthUnit healthUnit) {
        closestsUs.add(healthUnit);
    }


}


