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

public class InformationUsScreen extends Activity {


    //nome , tipo de atendimento , uf , municipio , bairoo , cep
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_us_screen);

        ListView hospInfo = (ListView) findViewById(R.id.hospital_information);
        List <String> listOfInformations = new ArrayList<String>();

        String nome = "Nome: ";
        String gestao = "Tipo de atendimento: ";
        String uf = "UF: ";
        String municipio = "Município: ";
        String bairro = "Bairro: ";
        String cep = "Cep: ";
        listOfInformations.add(nome);
        listOfInformations.add(gestao);
        listOfInformations.add(uf);
        listOfInformations.add(municipio);
        listOfInformations.add(bairro);
        listOfInformations.add(cep);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this ,
                                                                R.layout.information_us_screen ,
                                                                listOfInformations );
        hospInfo.setAdapter(adapter);



    }


    public void goClicked(View v) {
        Toast.makeText(this , "Go clicked" , Toast.LENGTH_SHORT).show();
    }
}
