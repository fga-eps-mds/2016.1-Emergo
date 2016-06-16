package unlv.erc.emergo.controller;

import android.content.Context;

import java.util.ArrayList;

import unlv.erc.emergo.model.HealthUnit;

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