package unlv.erc.emergo.controller;

import android.content.Context;
import android.location.Location;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import helper.GPSTracker;
import unlv.erc.emergo.model.HospitalUnit;

import static java.util.Collections.sort;

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
        String nameHospital;
        Integer id;
        Double latitude;
        Double longitude;
        String uf;

        nameHospital = "Centro de Saúde 6 do Gama";
        id = 6;
        latitude = -16.02824;
        longitude = -48.05841;
        uf = "DF";


        hospitalList.add(new HospitalUnit(nameHospital,latitude,longitude,id,uf));
        HospitalUnitController.hospitalUnit = hospitalUnit;
    }

    public static List<HospitalUnit> getHospitalList() {
        String nameHospital;
        Integer id;
        Double latitude;
        Double longitude;
        String uf;

        nameHospital = "Centro de Saúde 6 do Gama";
        id = 6;
        latitude = -16.02824;
        longitude = -48.05841;
        uf = "DF";

        String nameHospital2;
        Integer id2;
        Double latitude2;
        Double longitude2;
        String uf2;

        nameHospital2 = "Unidade de Saúde Centro de Saúde 8 do Gama";
        id2 = 6;
        latitude2 = -16.01888;
        longitude2 = -48.06828;
        uf2 = "DF";

        String nameHospital3;
        Integer id3;
        Double latitude3;
        Double longitude3;
        String uf3;

        nameHospital3 = "Hospital Dia da Asa Sul";
        id3 = 6;
        latitude3 = -15.82632;
        longitude3 = -47.92385;
        uf3 = "DF";

        String nameHospital4;
        Integer id4;
        Double latitude4;
        Double longitude4;
        String uf4;

        nameHospital4 = "Humanus Psicologia Especializada";
        id4 = 6;
        latitude4 = -15.78014;
        longitude4 = -47.92916;
        uf4 = "DF";

        String nameHospital5;
        Integer id5;
        Double latitude5;
        Double longitude5;
        String uf5;

        nameHospital5 = "Centro Oftalmologico Oculistas Associados";
        id5 = 6;
        latitude5 = -15.76404;
        longitude5 = -47.89142;
        uf5 = "DF";

        String nameHospital6;
        Integer id6;
        Double latitude6;
        Double longitude6;
        String uf6;

        nameHospital6 = "Posto de Saúde Emilia Lanna";
        id6 = 12;
        latitude6 = -21.38801;
        longitude6 = -42.69907;
        uf6 = "MG";

        String nameHospital7;
        Integer id7;
        Double latitude7;
        Double longitude7;
        String uf7;

        nameHospital7 = "Matozinhos Unidade Básica de Saúde Tonico Cota";
        id7 = 12;
        latitude7 = -19.5453643798822;
        longitude7 = -44.0831565856921;
        uf7 = "MG";

        String nameHospital8;
        Integer id8;
        Double latitude8;
        Double longitude8;
        String uf8;

        nameHospital8 = "Posto de Saúde de Vitorinos";
        id8 = 12;
        latitude8 = -21.0221461475547;
        longitude8 = -43.41887066418;
        uf8 = "MG";

        String nameHospital9;
        Integer id9;
        Double latitude9;
        Double longitude9;
        String uf9;

        nameHospital9 = "Centro de Saúde DR. Alpheu Gonçalves de Quadros";
        id9 = 12;
        latitude9 = -16.74587;
        longitude9 = -43.84289;
        uf9 = "MG";

        String nameHospital10;
        Integer id10;
        Double latitude10;
        Double longitude10;
        String uf10;

        nameHospital10 = "Unidade de Saúde da Familia Avelino Dias Pimont";
        id10 = 12;
        latitude10 = -21.47177;
        longitude10 = -43.11966;
        uf10 = "MG";

        String nameHospital11;
        Integer id11;
        Double latitude11;
        Double longitude11;
        String uf11;

        nameHospital11 = "Radiodente Radiologia Digital";
        id11 = 8;
        latitude11 = -16.64768;
        longitude11 = -49.49683;
        uf11 = "GO";

        String nameHospital12;
        Integer id12;
        Double latitude12;
        Double longitude12;
        String uf12;

        nameHospital12 = "Unidade de Saúde da Família Demolândia";
        id12 = 8;
        latitude12 = -16.254801619746;
        longitude12 = -49.3611056454839;
        uf12 = "GO";

        String nameHospital13;
        Integer id13;
        Double latitude13;
        Double longitude13;
        String uf13;

        nameHospital13 = "Unidade Básica de Saúde DR.Osvaldo Cassiano de Faria IV";
        id13 = 8;
        latitude13 = -16.8069880059216;
        longitude13 = -49.9227871292957;
        uf13 = "GO";

        String nameHospital14;
        Integer id14;
        Double latitude14;
        Double longitude14;
        String uf14;

        nameHospital14 = "Centro de Saúde de Paraúna";
        id14 = 8;
        latitude14 = -16.94833;
        longitude14 = -50.46422;
        uf14 = "GO";

        String nameHospital15;
        Integer id15;
        Double latitude15;
        Double longitude15;
        String uf15;

        nameHospital15 = "Unidade Básica de Saúde Família Mesquita";
        id15 = 8;
        latitude15 = -16.0778689384456;
        longitude15 = -47.8703713417039;
        uf15 = "GO";

        HospitalUnit novoHospitalDistritoFederal = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalDistritoFederal);
        HospitalUnit novoHospitalDistritoFederal2 =  new HospitalUnit(nameHospital2,latitude2,longitude2,id2,uf2);
        hospitalList.add(novoHospitalDistritoFederal2);
        HospitalUnit novoHospitalDistritoFederal3 = new HospitalUnit(nameHospital3,latitude3,longitude3,id3,uf3);
        hospitalList.add(novoHospitalDistritoFederal3);
        HospitalUnit novoHospitalDistritoFederal4 = new HospitalUnit(nameHospital4,latitude4,longitude4,id4,uf4);
        hospitalList.add(novoHospitalDistritoFederal4);
        HospitalUnit novoHospitalDistritoFederal5 = new HospitalUnit(nameHospital5,latitude5,longitude5,id5,uf5);
        hospitalList.add(novoHospitalDistritoFederal5);
        HospitalUnit novoHospitalMinasGerais = new HospitalUnit(nameHospital6,latitude6,longitude6,id6,uf6);
        hospitalList.add(novoHospitalMinasGerais);
        HospitalUnit novoHospitalMinasGerais2 = new HospitalUnit(nameHospital7,latitude7,longitude7,id7,uf7);
        hospitalList.add(novoHospitalMinasGerais2);
        HospitalUnit novoHospitalMinasGerais3 = new HospitalUnit(nameHospital8,latitude8,longitude8,id8,uf8);
        hospitalList.add(novoHospitalMinasGerais3);
        HospitalUnit novoHospitalMinasGerais4 = new HospitalUnit(nameHospital9,latitude9,longitude9,id9,uf9);
        hospitalList.add(novoHospitalMinasGerais4);
        HospitalUnit novoHospitalMinasGerais5 = new HospitalUnit(nameHospital10,latitude10,longitude10,id10,uf10);
        hospitalList.add(novoHospitalMinasGerais5);
        HospitalUnit novoHospitalGoias = new HospitalUnit(nameHospital11,latitude11,longitude11,id11,uf11);
        hospitalList.add(novoHospitalGoias);
        HospitalUnit novoHospitalGoias2 = new HospitalUnit(nameHospital12,latitude12,longitude12,id12,uf12);
        hospitalList.add(novoHospitalGoias2);
        HospitalUnit novoHospitalGoias3 = new HospitalUnit(nameHospital13,latitude13,longitude13,id13,uf13);
        hospitalList.add(novoHospitalGoias3);
        HospitalUnit novoHospitalGoias4 = new HospitalUnit(nameHospital14,latitude14,longitude14,id14,uf14);
        hospitalList.add(novoHospitalGoias4);
        HospitalUnit novoHospitalGoias5 = new HospitalUnit(nameHospital15,latitude15,longitude15,id15,uf15);
        hospitalList.add(novoHospitalGoias5);

        return hospitalList;
    }

    public static void setHospitalList(List<HospitalUnit> hospitalList) {
        HospitalUnitController.hospitalList = hospitalList;
    }

    public void initHospitalUnitController(){
        hospitalList = getHospitalList();
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

    /*public static List<HospitalUnit> getAllHospitals(){
        return hospitalList;
    }*/

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
