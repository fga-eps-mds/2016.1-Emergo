package unlv.erc.emergo.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import unlv.erc.emergo.R;
import unlv.erc.emergo.model.HealthUnit;

public class InformationUsScreenController extends Activity {

    private List <String> listOfInformations = new ArrayList<String>();
    private ListView hospInfo;
    private Intent receive;
    private final Integer CORRECTINDEX = 1; // acces the correct index
    private int numberUsSelected;
    private String padding ,titulo, nome ,gestao , uf ,municipio ,
                    bairro ,cep ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_us_screen);

        receive = getIntent();
        numberUsSelected = receive.getIntExtra("position" , 0) + CORRECTINDEX;


        hospInfo = (ListView) findViewById(R.id.hospInformation);
        setInformation(HealthUnitController.getClosestsUs().get(numberUsSelected));
        addInformationToList();

    }

    public void setInformation(HealthUnit hospital){
        padding = "\n";
        titulo = "        Informações da Unidade de Saúde";
        nome = "  Nome: " + hospital.getNameHospital();
        gestao = "  Tipo de atendimento: " + hospital.getUnitType();
        uf = "  UF: " + hospital.getState()  ;
        municipio = "  Cidade: " + hospital.getCity();
        bairro = "  Bairro: " + hospital.getDistrict();
        cep = "  Cep: " + hospital.getAddressNumber();
    }

    public void  addInformationToList(){

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
