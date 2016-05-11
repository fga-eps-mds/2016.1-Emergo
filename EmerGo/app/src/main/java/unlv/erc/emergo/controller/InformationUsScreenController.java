package unlv.erc.emergo.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import unlv.erc.emergo.R;

public class InformationUsScreenController extends Activity {


    //nome , tipo de atendimento , uf , municipio , bairro , cep
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ListView hospInfo = (ListView) findViewById(R.id.hospInformation);
        List <String> listOfInformations = new ArrayList<String>();

        String padding = "\n";
        String titulo = "        Informações da Unidade de Saúde";
        String nome = "  Nome: " + "nome";
        String gestao = "  Tipo de atendimento: " + "atende";
        String uf = "  UF: " + "uf";
        String municipio = "  Cidade: " + "cidade";
        String bairro = "  Bairro: " + "bairro";
        String cep = "  Cep: " + "cep";

        listOfInformations.add(padding);
        listOfInformations.add(titulo);
        listOfInformations.add(nome);
        listOfInformations.add(gestao);
        listOfInformations.add(uf);
        listOfInformations.add(municipio);
        listOfInformations.add(bairro);
        listOfInformations.add(cep);

        ArrayAdapter<String> adapter = new ArrayAdapter <String> (this ,
                                                            android.R.layout.simple_list_item_1,
                                                            listOfInformations );
        hospInfo.setAdapter(adapter);

    }


    public void goClicked(View v) {
        Toast.makeText(this , "Go clicked" , Toast.LENGTH_SHORT).show();
    }
}
