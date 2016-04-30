package unlv.erc.emergo.Controller;

import android.content.Context;
import android.location.Location;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Helper.GPSTracker;
import unlv.erc.emergo.Model.HospitalUnit;

import static java.util.Collections.sort;

/**
 * Created by victor on 29/04/16.
 */
public class HospitalUnitController {
    private static HospitalUnitController instance = null;
    private static Context context;
    private static HospitalUnit hospitalUnit;
    private static List<HospitalUnit> hospitalList = new ArrayList<HospitalUnit>();
    private static HospitalUnit hospital;

    public HospitalUnitController(Context context) {

    }

    public static HospitalUnitController getInstance() {
        return instance;
    }

    public static HospitalUnit getHospitalUnit() {
        return hospitalUnit;
    }

    public static void setHospitalUnit(HospitalUnit hospitalUnit) {
        HospitalUnitController.hospitalUnit = hospitalUnit;
    }

    public static List<HospitalUnit> getHospitalList() {
        return hospitalList;
    }

    public static void setHospitalList(List<HospitalUnit> hospitalList) {
        HospitalUnitController.hospitalList = hospitalList;
    }

    public static void setInstance(HospitalUnitController instance) {
        HospitalUnitController.instance = instance;
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        HospitalUnitController.context = context;
    }

    public static List<HospitalUnit> getAllHospitals(){
        return hospitalList;
    }

    public static HospitalUnitController getInstance(Context context) {
        if (instance == null) {
            instance = new HospitalUnitController(context);
        } else {
			/* ! Nothing To Do. */
        }
        return instance;
    }

    public static boolean setDistance(Context context, ArrayList<HospitalUnit> hospitalList) {

        GPSTracker gps = new GPSTracker(context);
        boolean canGetLocation = gps.canGetLocation();
        if(canGetLocation) {
            double userLongitude = gps.getLongitude();
            double userLatitude = gps.getLatitude();

            for (int aux = 0; aux < hospitalList.size(); aux++) {
                float resultsAdapter[] = new float[1];
                // REVIEW FUNCTION
                Location.distanceBetween(hospitalList.get(aux).getLatitude(),
                                         hospitalList.get(aux).getLongitude(),
                                         userLatitude,userLongitude,resultsAdapter);
                hospitalList.get(aux).setDistance(resultsAdapter[0]);
            }

            sort(hospitalList, new DistanceComparator());

            return true;
        }else {
            return false;
        }
    }

    public static class DistanceComparator implements Comparator<HospitalUnit>{

        /**
         * Use responseHandler created to request the requested through a URL.
         *
         * @param hospitalUnit
         *          A stablishment to be compared.
         *
         * @param hospitalUnit2
         *          A stablishment to be compared.
         *
         * @return which stablishment has the gratter distance.
         */
        public int compare(HospitalUnit hospitalUnit, HospitalUnit hospitalUnit2) {
            // Needs reduce in the complexity
            return hospitalUnit.getDistance()<(hospitalUnit2.getDistance())? -1 : 1;
        }
    }
}
