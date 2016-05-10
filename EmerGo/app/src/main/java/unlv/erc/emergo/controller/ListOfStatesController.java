package unlv.erc.emergo.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import unlv.erc.emergo.model.HealthUnit;
import unlv.erc.emergo.R;

public class ListOfStatesController extends Activity {

    HealthUnitController healthUnitController= new HealthUnitController(this.context);
    //List<HealthUnit> HealthUnitController.healthUnitList = healthUnitController.getHealthUnitController.healthUnitList();

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
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "AC") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalAcre = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalAcre);
                            }
                        }
                        break;

                    case 1:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "AL") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalAlagoas = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalAlagoas);
                            }
                        }
                        break;

                    case 2:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "AP") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalAmapa = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalAmapa);
                            }
                        }
                        break;
                    case 3:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "AM") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalAmazonas = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalAmazonas);
                            }
                        }
                        break;

                    case 4:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "BA") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalBahia = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalBahia);
                            }
                        }
                        break;

                    case 5:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "CE") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalCeara = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalCeara);
                            }
                        }
                        break;

                    case 6:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "DF") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalDistritoFederal = new Intent(ListOfStatesController.this, HealthUnitListController.class);
                                startActivity(listHospitalDistritoFederal);
                            }
                        }
                        break;

                    case 7:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "ES") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalEspiritoSanto = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalEspiritoSanto);
                            }
                        }
                        break;

                    case 8:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "GO") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalGoias = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalGoias);
                            }
                        }
                        break;

                    case 9:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "MA") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalMaranhao = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalMaranhao);
                            }
                        }
                        break;

                    case 10:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "MT") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalMatoGrosso = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalMatoGrosso);
                            }
                        }
                        break;

                    case 11:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "MS") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalMatoGrossoDoSul = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalMatoGrossoDoSul);
                            }
                        }
                        break;

                    case 12:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "MG") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalMinasGerais = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalMinasGerais);
                            }
                        }
                        break;

                    case 13:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "PA") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalPara = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalPara);
                            }
                        }
                        break;

                    case 14:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "PB") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalParaiba = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalParaiba);
                            }
                        }
                        break;

                    case 15:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "PE") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalPernambuco = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalPernambuco);
                            }
                        }
                        break;

                    case 16:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "PE") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalPernambuco = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalPernambuco);
                            }
                        }
                        break;

                    case 17:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "PI") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalPiaui = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalPiaui);
                            }
                        }
                        break;

                    case 18:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "RJ") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalRioDeJaneiro = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalRioDeJaneiro);
                            }
                        }
                        break;

                    case 19:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "RN") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalRioGrandeDoNorte = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalRioGrandeDoNorte);
                            }
                        }
                        break;

                    case 20:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "RS") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalRioGrandeDoSul = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalRioGrandeDoSul);
                            }
                        }
                        break;

                    case 21:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "RO") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalRondonia = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalRondonia);
                            }
                        }
                        break;

                    case 22:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "RR") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalRoraima = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalRoraima);
                            }
                        }
                        break;

                    case 23:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "SC") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalSantaCatarina = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalSantaCatarina);
                            }
                        }
                        break;

                    case 24:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "SP") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalSaoPaulo = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalSaoPaulo);
                            }
                        }
                        break;

                    case 25:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "SE") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalSergipe = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalSergipe);
                            }
                        }
                        break;

                    case 26:
                        for (int aux = 0; aux < HealthUnitController.healthUnitList.size(); aux++) {
                            if (HealthUnitController.healthUnitList.get(aux).getUf() == "TO") {
                                HealthUnit hospitalPosition = HealthUnitController.healthUnitList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalTocantins = new Intent(ListOfStatesController.this, HealthUnitController.class);
                                startActivity(listHospitalTocantins);
                            }
                        }
                        break;
                }
            }
        });
    }

    public void setDistance(View convertView, int position) {

        if (HealthUnitController.healthUnitList.get(position).getDistance() < 1f) {
            // Setting distance of drugstore on list item
            TextView textViewDistance = (TextView) convertView.findViewById(R.id.distanceText);
            textViewDistance.setText(HealthUnitController.healthUnitList.get(position).getDistance() + " m");
        } else {
            // Setting distance of drugstore on list item
            TextView textViewDistance = (TextView) convertView.findViewById(R.id.distanceText);
            textViewDistance.setText(convertToKM(HealthUnitController.healthUnitList.get(position).getDistance()).toString() + " Km");
        }
    }

    private Float convertToKM(Float distance){

        return distance/1000;
    }
}
