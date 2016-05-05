package unlv.erc.emergo.view;

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

import unlv.erc.emergo.model.HospitalUnit;
import unlv.erc.emergo.R;

public class ListOfStates extends Activity {
    static ArrayList<HospitalUnit> hospitalList = new ArrayList<HospitalUnit>();
    View convertView;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_states);


        List<String> estados;
        ArrayAdapter<String> adaptador;
        ListView estadosOpcoes;
        estadosOpcoes = (ListView) findViewById(R.id.list_of_states);
        estados = new ArrayList<String>();
        estados.add("Acre - AC");
        estados.add("Alagoas - AL");
        estados.add("Amapá - AP");
        estados.add("Amazonas - AM");
        estados.add("Bahia - BA");
        estados.add("Ceará - CE");
        estados.add("Distrito Federal - DF");
        estados.add("Espírito Santo - ES");
        estados.add("Goiás - GO");
        estados.add("Maranhão - MA");
        estados.add("Mato Grosso - MT");
        estados.add("Mato Grosso do Sul - MS");
        estados.add("Minhas Gerais - MG");
        estados.add("Pará - PA");
        estados.add("Paraíba - PB");
        estados.add("Paraná - PR");
        estados.add("Pernambuco - PE");
        estados.add("Piauí - PI");
        estados.add("Rio de Janeiro - RJ");
        estados.add("Rio Grande do Norte - RN");
        estados.add("Rio Grande do Sul - RS");
        estados.add("Rondônia - RO");
        estados.add("Roraima - RR");
        estados.add("Santa Catarina - SC");
        estados.add("São Paulo - SP");
        estados.add("Sergipe - SE");
        estados.add("Tocantins - TO");

        adaptador = new ArrayAdapter<String>(this, R.layout.list_of_states, estados);
        estadosOpcoes.setAdapter(adaptador);
        estadosOpcoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 0 && hospitalList.get(aux).getUf() == "AC"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalAcre = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalAcre);
                            }
                        }
                        break;

                    case 1:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 1 && hospitalList.get(aux).getUf() == "AL"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalAlagoas = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalAlagoas);
                            }
                        }
                        break;

                    case 2:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 2 && hospitalList.get(aux).getUf() == "AP"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalAmapa = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalAmapa);
                            }
                        }
                        break;
                    case 3:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 3 && hospitalList.get(aux).getUf() == "AM"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalAmazonas = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalAmazonas);
                            }
                        }
                        break;

                    case 4:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 4 && hospitalList.get(aux).getUf() == "BA"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalBahia = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalBahia);
                            }
                        }
                        break;

                    case 5:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 5 && hospitalList.get(aux).getUf() == "CE"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalCeara = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalCeara);
                            }
                        }
                        break;

                    case 6:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 6 && hospitalList.get(aux).getUf() == "DF"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalDistritoFederal = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalDistritoFederal);
                            }
                        }
                        break;

                    case 7:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 7 && hospitalList.get(aux).getUf() == "ES"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalEspiritoSanto = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalEspiritoSanto);
                            }
                        }
                        break;

                    case 8:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 8 && hospitalList.get(aux).getUf() == "GO"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalGoias = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalGoias);
                            }
                        }
                        break;

                    case 9:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 9 && hospitalList.get(aux).getUf() == "MA"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalMaranhao = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalMaranhao);
                            }
                        }
                        break;

                    case 10:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 10 && hospitalList.get(aux).getUf() == "MT"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalMatoGrosso = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalMatoGrosso);
                            }
                        }
                        break;

                    case 11:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 11 && hospitalList.get(aux).getUf() == "MS"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalMatoGrossoDoSul = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalMatoGrossoDoSul);
                            }
                        }
                        break;

                    case 12:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 12 && hospitalList.get(aux).getUf() == "MG"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalMinasGerais = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalMinasGerais);
                            }
                        }
                        break;

                    case 13:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 13 && hospitalList.get(aux).getUf() == "PA"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalPara = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalPara);
                            }
                        }
                        break;

                    case 14:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 14 && hospitalList.get(aux).getUf() == "PB"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalParaiba = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalParaiba);
                            }
                        }
                        break;

                    case 15:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 15 && hospitalList.get(aux).getUf() == "PE"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalPernambuco = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalPernambuco);
                            }
                        }
                        break;

                    case 16:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 16 && hospitalList.get(aux).getUf() == "PE"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalPernambuco = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalPernambuco);
                            }
                        }
                        break;

                    case 17:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 17 && hospitalList.get(aux).getUf() == "PI"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalPiaui = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalPiaui);
                            }
                        }
                        break;

                    case 18:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 18 && hospitalList.get(aux).getUf() == "RJ"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalRioDeJaneiro = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalRioDeJaneiro);
                            }
                        }
                        break;

                    case 19:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 19 && hospitalList.get(aux).getUf() == "RN"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalRioGrandeDoNorte = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalRioGrandeDoNorte);
                            }
                        }
                        break;

                    case 20:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 20 && hospitalList.get(aux).getUf() == "RS"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalRioGrandeDoSul = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalRioGrandeDoSul);
                            }
                        }
                        break;

                    case 21:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 21 && hospitalList.get(aux).getUf() == "RO"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalRondonia = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalRondonia);
                            }
                        }
                        break;

                    case 22:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 22 && hospitalList.get(aux).getUf() == "RR"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalRoraima = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalRoraima);
                            }
                        }
                        break;

                    case 23:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 23 && hospitalList.get(aux).getUf() == "SC"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalSantaCatarina = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalSantaCatarina);
                            }
                        }
                        break;

                    case 24:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 24 && hospitalList.get(aux).getUf() == "SP"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalSaoPaulo = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalSaoPaulo);
                            }
                        }
                        break;

                    case 25:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 25 && hospitalList.get(aux).getUf() == "SE"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalSergipe = new Intent(ListOfStates.this,HospitalList.class);
                                startActivity(listHospitalSergipe);
                            }
                        }
                        break;

                    case 26:
                        for(int aux=0;aux<hospitalList.size();aux++){
                            if(position == 26 && hospitalList.get(aux).getUf() == "TO"){
                                HospitalUnit hospitalPosition = hospitalList.get(position);
                                convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

                                TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
                                textView.setText((CharSequence) hospitalPosition.getNome());

                                setDistance(convertView, position);

                                Intent listHospitalTocantins = new Intent(ListOfStates.this,HospitalList.class);
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
