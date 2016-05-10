package unlv.erc.emergo.controller;

import android.content.Context;
import android.location.Location;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import helper.GPSTracker;
import unlv.erc.emergo.model.HealthUnit;

import static java.util.Collections.sort;

public class HealthUnitController {
    private static HealthUnitController instance = null;
    private static Context context;
    private static HealthUnit HealthUnit;
    static List<HealthUnit> healthUnitList = new ArrayList<HealthUnit>();
    private static HealthUnit hospital;

    public HealthUnitController(Context context) {

    }

    public static HealthUnitController getInstance() {
        return instance;
    }

    public static HealthUnit getHealthUnit() {
        return HealthUnit;
    }

    public static void setHealthUnit(HealthUnit HealthUnit) {

        String nameHospital = "Centro de Saúde 6 do Gama";
        Double latitude = -16.02824;
        Double longitude = -48.05841;
        Integer id = 6;
        String uf = "DF";
        HealthUnit novoHospitalDistritoFederal = new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalDistritoFederal);

        nameHospital = "Unidade de Saúde Centro de Saúde 8 do Gama";
        latitude = -16.01888;
        longitude = -48.06828;
        id = 6;
        uf = "DF";
        HealthUnit novoHospitalDistritoFederal2 =  new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalDistritoFederal2);

        nameHospital = "Hospital Dia da Asa Sul";
        latitude = -15.82632;
        longitude = -47.92385;
        id = 6;
        uf = "DF";
        HealthUnit novoHospitalDistritoFederal3 = new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalDistritoFederal3);

        nameHospital = "Humanus Psicologia Especializada";
        latitude = -15.78014;
        longitude = -47.92916;
        id = 6;
        uf = "DF";
        HealthUnit novoHospitalDistritoFederal4 = new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalDistritoFederal4);

        nameHospital = "Centro Oftalmologico Oculistas Associados";
        latitude = -15.76404;
        longitude = -47.89142;
        id = 6;
        uf = "DF";
        HealthUnit novoHospitalDistritoFederal5 = new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalDistritoFederal5);

        nameHospital = "Posto de Saúde Emilia Lanna";
        latitude = -21.38801;
        longitude = -42.69907;
        id = 12;
        uf = "MG";
        HealthUnit novoHospitalMinasGerais = new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalMinasGerais);

        nameHospital = "Matozinhos Unidade Básica de Saúde Tonico Cota";
        latitude = -19.5453643798822;
        longitude = -44.0831565856921;
        id = 12;
        uf = "MG";
        HealthUnit novoHospitalMinasGerais2 = new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalMinasGerais2);

        nameHospital = "Posto de Saúde de Vitorinos";
        latitude = -21.0221461475547;
        longitude = -43.41887066418;
        id = 12;
        uf = "MG";
        HealthUnit novoHospitalMinasGerais3 = new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalMinasGerais3);

        nameHospital = "Centro de Saúde DR. Alpheu Gonçalves de Quadros";
        latitude = -16.74587;
        longitude = -43.84289;
        id = 12;
        uf = "MG";
        HealthUnit novoHospitalMinasGerais4 = new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalMinasGerais4);

        nameHospital = "Unidade de Saúde da Familia Avelino Dias Pimont";
        latitude = -21.47177;
        longitude = -43.11966;
        id = 12;
        uf = "MG";
        HealthUnit novoHospitalMinasGerais5 = new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalMinasGerais5);

        nameHospital = "Radiodente Radiologia Digital";
        latitude = -16.64768;
        longitude = -49.49683;
        id = 8;
        uf = "GO";
        HealthUnit novoHospitalGoias = new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalGoias);

        nameHospital = "Unidade de Saúde da Família Demolândia";
        latitude = -16.254801619746;
        longitude = -49.3611056454839;
        id = 8;
        uf = "GO";
        HealthUnit novoHospitalGoias2 = new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalGoias2);

        nameHospital = "Unidade Básica de Saúde DR.Osvaldo Cassiano de Faria IV";
        latitude = -16.8069880059216;
        longitude = -49.9227871292957;
        id = 8;
        uf = "GO";
        HealthUnit novoHospitalGoias3 = new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalGoias3);

        nameHospital = "Centro de Saúde de Paraúna";
        latitude = -16.94833;
        longitude = -50.46422;
        id = 8;
        uf = "GO";
        HealthUnit novoHospitalGoias4 = new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalGoias4);

        nameHospital = "Unidade Básica de Saúde Família Mesquita";
        latitude = -16.0778689384456;
        longitude = -47.8703713417039;
        id = 8;
        uf = "GO";
        HealthUnit novoHospitalGoias5 = new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalGoias5);

        nameHospital = "Ortopedia Sergio Barreto";
        latitude = -23.20161;
        longitude = -45.89323;
        id = 24;
        uf = "SP";
        HealthUnit novoHospitalSaoPaulo = new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalSaoPaulo);

        nameHospital = "Fundo Municipal de Saúde de Jaguariúna";
        latitude = -22.66333;
        longitude = -46.952;
        id = 24;
        uf = "SP";
        HealthUnit novoHospitalSaoPaulo2 = new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalSaoPaulo2);

        nameHospital = "Centro de Saúde I Albertino Affonso Jaboticabal" ;
        latitude = -21.25288;
        longitude = -48.32006;
        id = 24;
        uf = "SP";
        HealthUnit novoHospitalSaoPaulo3 = new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalSaoPaulo3);

        nameHospital = "Santa Casa de Guariba";
        latitude = -21.36613;
        longitude = -48.24025;
        id = 24;
        uf = "SP";
        HealthUnit novoHospitalSaoPaulo4 = new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalSaoPaulo4);

        nameHospital = "UBS José Alves de Andrade";
        latitude = -22.4727272987;
        longitude = -46.6132521629;
        id = 24;
        uf = "SP";
        HealthUnit novoHospitalSaoPaulo5 = new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalSaoPaulo5);

        nameHospital = "Hospital Municipal de Gaucha do Norte";
        latitude = -13.24743;
        longitude = -53.08731;
        id = 10;
        uf = "MT";
        HealthUnit novoHospitalMatoGrosso = new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalMatoGrosso);

        nameHospital = "Posto Saúde de Nova Aliança GN";
        latitude = -13.5442757607;
        longitude = -53.1373715401;
        id = 10;
        uf = "MT";
        HealthUnit novoHospitalMatoGrosso2 = new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalMatoGrosso2);

        nameHospital = "Hospital Municipal de Santo Antonio do Leverger";
        latitude = -15.8548;
        longitude = -56.07042;
        id = 10;
        uf = "MT";
        HealthUnit novoHospitalMatoGrosso3 = new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalMatoGrosso3);

        nameHospital = "Posto de Saúde de Engenho Velho";
        latitude = -15.7796180248;
        longitude = -56.1420893669;
        id = 10;
        uf = "MT";
        HealthUnit novoHospitalMatoGrosso4 = new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalMatoGrosso4);

        nameHospital = "Centro Municipal de Saúde Colider";
        latitude = -10.8022642136;
        longitude = -55.4563879967;
        id = 10;
        uf = "MT";
        HealthUnit novoHospitalMatoGrosso5 = new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalMatoGrosso5);

        nameHospital = "UBS José Alves de Andrade";
        latitude = -22.4727272987;
        longitude = -46.6132521629;
        id = 24;
        uf = "TO";
        HealthUnit novoHospitalTocantins = new HealthUnit(nameHospital,latitude,longitude,id,uf);
        healthUnitList.add(novoHospitalTocantins);


        HealthUnitController.HealthUnit = HealthUnit;
    }

    public static List<HealthUnit> gethealthUnitList() {
        return healthUnitList;
    }

    public static void sethealthUnitList(List<HealthUnit> healthUnitList) {
        HealthUnitController.healthUnitList = healthUnitList;
    }

    public void initHealthUnitController(){
        healthUnitList = gethealthUnitList();
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

    /*public static List<HealthUnit> getAllHospitals(){
        return healthUnitList;
    }*/

    public static HealthUnitController getInstance(Context context) {
        if (instance == null) {
            instance = new HealthUnitController(context);
        } else {
			/* ! Nothing To Do. */
        }
        return instance;
    }

    public static boolean setDistance(Context context, ArrayList<HealthUnit> healthUnitList) {

        GPSTracker gps = new GPSTracker(context);
        boolean canGetLocation = gps.canGetLocation();
        if(canGetLocation) {
            double userLongitude = gps.getLongitude();
            double userLatitude = gps.getLatitude();

            for (int aux = 0; aux < healthUnitList.size(); aux++) {
                float resultsAdapter[] = new float[1];
                // REVIEW FUNCTION
                Location.distanceBetween(healthUnitList.get(aux).getLatitude(),
                                         healthUnitList.get(aux).getLongitude(),
                                         userLatitude,userLongitude,resultsAdapter);
                healthUnitList.get(aux).setDistance(resultsAdapter[0]);
            }

            sort(healthUnitList, new DistanceComparator());

            return true;
        }else {
            return false;
        }
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

}
