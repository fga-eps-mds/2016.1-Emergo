package unlv.erc.emergo.controller;

import android.content.Context;
import android.location.Location;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import helper.GPSTracker;
import unlv.erc.emergo.model.HealthUnit;

import static java.util.Collections.sort;

public class HealthUnitController {
    private static HealthUnitController instance = null;
    static ArrayList<HealthUnit> closestsUs = new ArrayList<HealthUnit>();

    public static HealthUnit createHealthUnit(Double latitude , Double longitude , String nameHospital,
                                              String unityType , String state , String city ,
                                              String district , String adressNumber) {
        HealthUnit healthUnit = new HealthUnit(latitude, longitude, nameHospital, unityType, adressNumber,
                district, state, city );
        return healthUnit;
    }

    public HealthUnitController(Context context) {

    }


    public static class DistanceComparator implements Comparator<HealthUnit>{

        /**
         * Use responseHandler created to request the requested through a URL.
         *
         * @param HealthUnit
         *          A stablishment to be compared.
         *
         * @param HealthUnit2
         *          A stablishment to be compared.
         *
         * @return which stablishment has the gratter distance.
         */
        public int compare(HealthUnit HealthUnit, HealthUnit HealthUnit2) {
            // Needs reduce in the complexity
            return HealthUnit.getDistance()<(HealthUnit2.getDistance())? -1 : 1;
        }
    }

    public static ArrayList<HealthUnit> getClosestsUs() {
        return closestsUs;
    }

    public static void setClosestsUs(HealthUnit healthUnit) {
        closestsUs.add(healthUnit);
    }

}


