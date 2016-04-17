package unlv.erc.emergo.controller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import unlv.erc.emergo.R;

/**
 * Created by mrvictor on 17/04/16.
 */
public class lista_de_estados_activity extends Activity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_de_estados);


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

        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, estados);
        estadosOpcoes.setAdapter(adaptador);
        estadosOpcoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Context contexto = getApplicationContext();
                        String texto = "ACRE CARAI";
                        int duracao = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(contexto, texto, duracao);
                        toast.show();
                        break;


                    case 3:
                        finish();
                        break;
                }
            }
        });
    }
}
