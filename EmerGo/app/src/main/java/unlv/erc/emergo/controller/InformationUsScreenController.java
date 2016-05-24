package unlv.erc.emergo.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import unlv.erc.emergo.R;
import unlv.erc.emergo.model.HealthUnit;

public class InformationUsScreenController extends Activity {

    private List <String> listOfInformations = new ArrayList<String>();
    private ListView hospInfo;
    private Intent receive;
    int numberUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_us_screen);

        receive = getIntent();
        numberUs = receive.getIntExtra("position" , 0) + 1;


        hospInfo = (ListView) findViewById(R.id.hospInformation);
        addInformationToList(HealthUnitController.getClosestsUs().get(numberUs));

    }

    public void  addInformationToList(HealthUnit hospital){

        String padding = "\n";
        String titulo = "        Informações da Unidade de Saúde";
        String nome = "  Nome: " + hospital.getNameHospital();
        String gestao = "  Tipo de atendimento: " + hospital.getUnitType();
        String uf = "  UF: " + hospital.getState()  ;
        String municipio = "  Cidade: " + hospital.getCity();
        String bairro = "  Bairro: " + hospital.getDistrict();
        String cep = "  Cep: " + hospital.getAddressNumber();
        listOfInformations.add(padding);
        listOfInformations.add(titulo);
        listOfInformations.add(nome);
        listOfInformations.add(gestao);
        listOfInformations.add(uf);
        listOfInformations.add(municipio);
        listOfInformations.add(bairro);
        listOfInformations.add(cep);
        showInformationOnScreen();
    }

    public void showInformationOnScreen(){
        ArrayAdapter<String> adapter = new ArrayAdapter <String> (this ,
                android.R.layout.simple_list_item_1,
                listOfInformations );
        hospInfo.setAdapter(adapter);
    }


    public void goClicked(View v) {
        Toast.makeText(this , "Go clicked" , Toast.LENGTH_SHORT).show();
    }
}