package unlv.erc.emergo.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import unlv.erc.emergo.model.HospitalUnit;
import unlv.erc.emergo.R;

public class ListOfStatesController extends Activity {

    HospitalUnitController hospitalListController = new HospitalUnitController(this.context);
    List<HospitalUnit> hospitalList = hospitalListController.getHospitalList();

    View convertView;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_states);

        List<String> state;
        ArrayAdapter<String> adapter;
        ListView stateOptions;
        stateOptions = (ListView) findViewById(R.id.list_of_states);
        state = new ArrayList<String>();
        state.add("Acre - AC");
        state.add("Alagoas - AL");
        state.add("Amapá - AP");
        state.add("Amazonas - AM");
        state.add("Bahia - BA");
        state.add("Ceará - CE");
        state.add("Distrito Federal - DF");
        state.add("Espírito Santo - ES");
        state.add("Goiás - GO");
        state.add("Maranhão - MA");
        state.add("Mato Grosso - MT");
        state.add("Mato Grosso do Sul - MS");
        state.add("Minhas Gerais - MG");
        state.add("Pará - PA");
        state.add("Paraíba - PB");
        state.add("Paraná - PR");
        state.add("Pernambuco - PE");
        state.add("Piauí - PI");
        state.add("Rio de Janeiro - RJ");
        state.add("Rio Grande do Norte - RN");
        state.add("Rio Grande do Sul - RS");
        state.add("Rondônia - RO");
        state.add("Roraima - RR");
        state.add("Santa Catarina - SC");
        state.add("São Paulo - SP");
        state.add("Sergipe - SE");
        state.add("Tocantins - TO");

        adapter = new ArrayAdapter<String>(this, R.layout.list_of_states, R.id.hospitalUnitText,state);
        stateOptions.setAdapter(adapter);
        stateOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "AC") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalAcre = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalAcre);
                            }
                        }
                        break;

                    case 1:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "AL") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalAlagoas = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalAlagoas);
                            }
                        }
                        break;

                    case 2:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "AP") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalAmapa = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalAmapa);
                            }
                        }
                        break;
                    case 3:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "AM") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalAmazonas = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalAmazonas);
                            }
                        }
                        break;

                    case 4:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "BA") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalBahia = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalBahia);
                            }
                        }
                        break;

                    case 5:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "CE") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalCeara = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalCeara);
                            }
                        }
                        break;

                    case 6:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "DF") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalDistritoFederal = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalDistritoFederal);
                            }
                        }
                        break;

                    case 7:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "ES") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalEspiritoSanto = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalEspiritoSanto);
                            }
                        }
                        break;

                    case 8:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "GO") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalGoias = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalGoias);
                            }
                        }
                        break;

                    case 9:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "MA") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalMaranhao = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalMaranhao);
                            }
                        }
                        break;

                    case 10:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "MT") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalMatoGrosso = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalMatoGrosso);
                            }
                        }
                        break;

                    case 11:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "MS") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalMatoGrossoDoSul = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalMatoGrossoDoSul);
                            }
                        }
                        break;

                    case 12:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "MG") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalMinasGerais = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalMinasGerais);
                            }
                        }
                        break;

                    case 13:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "PA") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalPara = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalPara);
                            }
                        }
                        break;

                    case 14:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "PB") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalParaiba = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalParaiba);
                            }
                        }
                        break;

                    case 15:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "PE") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalPernambuco = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalPernambuco);
                            }
                        }
                        break;

                    case 16:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "PE") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalPernambuco = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalPernambuco);
                            }
                        }
                        break;

                    case 17:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "PI") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalPiaui = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalPiaui);
                            }
                        }
                        break;

                    case 18:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "RJ") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalRioDeJaneiro = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalRioDeJaneiro);
                            }
                        }
                        break;

                    case 19:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "RN") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalRioGrandeDoNorte = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalRioGrandeDoNorte);
                            }
                        }
                        break;

                    case 20:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "RS") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalRioGrandeDoSul = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalRioGrandeDoSul);
                            }
                        }
                        break;

                    case 21:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "RO") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalRondonia = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalRondonia);
                            }
                        }
                        break;

                    case 22:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "RR") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalRoraima = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalRoraima);
                            }
                        }
                        break;

                    case 23:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "SC") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalSantaCatarina = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalSantaCatarina);
                            }
                        }
                        break;

                    case 24:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "SP") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalSaoPaulo = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalSaoPaulo);
                            }
                        }
                        break;

                    case 25:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "SE") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalSergipe = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalSergipe);
                            }
                        }
                        break;

                    case 26:
                        for (int aux = 0; aux < hospitalList.size(); aux++) {
                            if (hospitalList.get(aux).getUf() == "TO") {
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalTocantins = new Intent(ListOfStatesController.this, HospitalListController.class);
                                startActivity(listHospitalTocantins);
                            }
                        }
                        break;
                }
            }
        });
    }

    public void setDistance(View convertView, int position) {

        if (this.hospitalList.get(position).getDistance() < 1f) {
            // Setting distance of drugstore on list item
            TextView textViewDistance = (TextView) convertView.findViewById(R.id.distanceText);
            textViewDistance.setText(this.hospitalList.get(position).getDistance() + " m");
        } else {
            // Setting distance of drugstore on list item
            TextView textViewDistance = (TextView) convertView.findViewById(R.id.distanceText);
            textViewDistance.setText(convertToKM(this.hospitalList.get(position).getDistance()).toString() + " Km");
        }
    }

    private Float convertToKM(Float distance){

        return distance/1000;
    }
}
