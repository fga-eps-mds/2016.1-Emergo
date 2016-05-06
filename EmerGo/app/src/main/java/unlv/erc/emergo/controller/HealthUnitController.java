package unlv.erc.emergo.controller;

import android.content.Context;
import android.location.Location;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import helper.GPSTracker;
import unlv.erc.emergo.model.HospitalUnit;

import static java.util.Collections.sort;

public class HealthUnitController {
    private static HealthUnitController instance = null;
    private static Context context;
    private static HospitalUnit hospitalUnit;
    private static List<HospitalUnit> hospitalList = new ArrayList<HospitalUnit>();
    private static HospitalUnit hospital;

    public HealthUnitController(Context context) {

    }

    public static HealthUnitController getInstance() {
        return instance;
    }

    public static HospitalUnit getHospitalUnit() {
        return hospitalUnit;
    }

    public static void setHospitalUnit(HospitalUnit hospitalUnit) {

        String nameHospital = "Centro de Saúde 6 do Gama";
        Double latitude = -16.02824;
        Double longitude = -48.05841;
        Integer id = 6;
        String uf = "DF";
        HospitalUnit novoHospitalDistritoFederal = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalDistritoFederal);

        nameHospital = "Unidade de Saúde Centro de Saúde 8 do Gama";
        latitude = -16.01888;
        longitude = -48.06828;
        id = 6;
        uf = "DF";
        HospitalUnit novoHospitalDistritoFederal2 =  new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalDistritoFederal2);

        nameHospital = "Hospital Dia da Asa Sul";
        latitude = -15.82632;
        longitude = -47.92385;
        id = 6;
        uf = "DF";
        HospitalUnit novoHospitalDistritoFederal3 = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalDistritoFederal3);

        nameHospital = "Humanus Psicologia Especializada";
        latitude = -15.78014;
        longitude = -47.92916;
        id = 6;
        uf = "DF";
        HospitalUnit novoHospitalDistritoFederal4 = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalDistritoFederal4);

        nameHospital = "Centro Oftalmologico Oculistas Associados";
        latitude = -15.76404;
        longitude = -47.89142;
        id = 6;
        uf = "DF";
        HospitalUnit novoHospitalDistritoFederal5 = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalDistritoFederal5);

        nameHospital = "Posto de Saúde Emilia Lanna";
        latitude = -21.38801;
        longitude = -42.69907;
        id = 12;
        uf = "MG";
        HospitalUnit novoHospitalMinasGerais = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalMinasGerais);

        nameHospital = "Matozinhos Unidade Básica de Saúde Tonico Cota";
        latitude = -19.5453643798822;
        longitude = -44.0831565856921;
        id = 12;
        uf = "MG";
        HospitalUnit novoHospitalMinasGerais2 = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalMinasGerais2);

        nameHospital = "Posto de Saúde de Vitorinos";
        latitude = -21.0221461475547;
        longitude = -43.41887066418;
        id = 12;
        uf = "MG";
        HospitalUnit novoHospitalMinasGerais3 = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalMinasGerais3);

        nameHospital = "Centro de Saúde DR. Alpheu Gonçalves de Quadros";
        latitude = -16.74587;
        longitude = -43.84289;
        id = 12;
        uf = "MG";
        HospitalUnit novoHospitalMinasGerais4 = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalMinasGerais4);

        nameHospital = "Unidade de Saúde da Familia Avelino Dias Pimont";
        latitude = -21.47177;
        longitude = -43.11966;
        id = 12;
        uf = "MG";
        HospitalUnit novoHospitalMinasGerais5 = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalMinasGerais5);

        nameHospital = "Radiodente Radiologia Digital";
        latitude = -16.64768;
        longitude = -49.49683;
        id = 8;
        uf = "GO";
        HospitalUnit novoHospitalGoias = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalGoias);

        nameHospital = "Unidade de Saúde da Família Demolândia";
        latitude = -16.254801619746;
        longitude = -49.3611056454839;
        id = 8;
        uf = "GO";
        HospitalUnit novoHospitalGoias2 = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalGoias2);

        nameHospital = "Unidade Básica de Saúde DR.Osvaldo Cassiano de Faria IV";
        latitude = -16.8069880059216;
        longitude = -49.9227871292957;
        id = 8;
        uf = "GO";
        HospitalUnit novoHospitalGoias3 = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalGoias3);

        nameHospital = "Centro de Saúde de Paraúna";
        latitude = -16.94833;
        longitude = -50.46422;
        id = 8;
        uf = "GO";
        HospitalUnit novoHospitalGoias4 = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalGoias4);

        nameHospital = "Unidade Básica de Saúde Família Mesquita";
        latitude = -16.0778689384456;
        longitude = -47.8703713417039;
        id = 8;
        uf = "GO";
        HospitalUnit novoHospitalGoias5 = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalGoias5);

        nameHospital = "Ortopedia Sergio Barreto";
        latitude = -23.20161;
        longitude = -45.89323;
        id = 24;
        uf = "SP";
        HospitalUnit novoHospitalSaoPaulo = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalSaoPaulo);

        nameHospital = "Fundo Municipal de Saúde de Jaguariúna";
        latitude = -22.66333;
        longitude = -46.952;
        id = 24;
        uf = "SP";
        HospitalUnit novoHospitalSaoPaulo2 = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalSaoPaulo2);

        nameHospital = "Centro de Saúde I Albertino Affonso Jaboticabal" ;
        latitude = -21.25288;
        longitude = -48.32006;
        id = 24;
        uf = "SP";
        HospitalUnit novoHospitalSaoPaulo3 = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalSaoPaulo3);

        nameHospital = "Santa Casa de Guariba";
        latitude = -21.36613;
        longitude = -48.24025;
        id = 24;
        uf = "SP";
        HospitalUnit novoHospitalSaoPaulo4 = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalSaoPaulo4);

        nameHospital = "UBS José Alves de Andrade";
        latitude = -22.4727272987;
        longitude = -46.6132521629;
        id = 24;
        uf = "SP";
        HospitalUnit novoHospitalSaoPaulo5 = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalSaoPaulo5);

        nameHospital = "Hospital Municipal de Gaucha do Norte";
        latitude = -13.24743;
        longitude = -53.08731;
        id = 10;
        uf = "MT";
        HospitalUnit novoHospitalMatoGrosso = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalMatoGrosso);

        nameHospital = "Posto Saúde de Nova Aliança GN";
        latitude = -13.5442757607;
        longitude = -53.1373715401;
        id = 10;
        uf = "MT";
        HospitalUnit novoHospitalMatoGrosso2 = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalMatoGrosso2);

        nameHospital = "Hospital Municipal de Santo Antonio do Leverger";
        latitude = -15.8548;
        longitude = -56.07042;
        id = 10;
        uf = "MT";
        HospitalUnit novoHospitalMatoGrosso3 = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalMatoGrosso3);

        nameHospital = "Posto de Saúde de Engenho Velho";
        latitude = -15.7796180248;
        longitude = -56.1420893669;
        id = 10;
        uf = "MT";
        HospitalUnit novoHospitalMatoGrosso4 = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalMatoGrosso4);

        nameHospital = "Centro Municipal de Saúde Colider";
        latitude = -10.8022642136;
        longitude = -55.4563879967;
        id = 10;
        uf = "MT";
        HospitalUnit novoHospitalMatoGrosso5 = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalMatoGrosso5);

        nameHospital = "UBS José Alves de Andrade";
        latitude = -22.4727272987;
        longitude = -46.6132521629;
        id = 24;
        uf = "TO";
        HospitalUnit novoHospitalTocantins = new HospitalUnit(nameHospital,latitude,longitude,id,uf);
        hospitalList.add(novoHospitalTocantins);


        HealthUnitController.hospitalUnit = hospitalUnit;

    }

    public static List<HospitalUnit> getHospitalList() {

        return hospitalList;
    }

    public static void setHospitalList(List<HospitalUnit> hospitalList) {
        HealthUnitController.hospitalList = hospitalList;
    }

    public void initHospitalUnitController(){
        hospitalList = getHospitalList();
    }
    public static void setInstance(HealthUnitController instance) {
        HealthUnitController.instance = instance;
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        HealthUnitController.context = context;
    }

    /*public static List<HospitalUnit> getAllHospitals(){
        return hospitalList;
    }*/

    public static HealthUnitController getInstance(Context context) {
        if (instance == null) {
            instance = new HealthUnitController(context);
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
