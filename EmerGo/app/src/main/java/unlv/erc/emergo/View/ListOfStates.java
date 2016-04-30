package unlv.erc.emergo.View;

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

import unlv.erc.emergo.Model.HospitalUnit;
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
        estadosOpcoes = (ListView) findViewById(R.id.lista_de_Estados);
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


                    case 3:
                        finish();
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
