package unlv.erc.emergo.controller;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import unlv.erc.emergo.R;
import unlv.erc.emergo.model.HealthUnit;

public class InformationSearchScreenController extends Activity{


    private List<String> listOfInformations = new ArrayList<String>();
    private ListView hospInfo;
    private Intent receive;
    //private final Integer CORRECTINDEX = 1; // acces the correct index
    private int numberUsSelected;
    private String padding ,titulo, nome ,gestao , uf ,municipio ,
            bairro ,cep ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_us_screen);

        setReceive(getIntent());
        setNumberUsSelected(receive.getIntExtra("position" , 0));

        setHospInfo((ListView) findViewById(R.id.hospInformation));
        setInformation(HealthUnitController.getSearchsUs().get(numberUsSelected));
        addInformationToList();

    }

    public void setInformation(HealthUnit hospital){
        setPadding("\n");
        setTitulo("        Informações da Unidade de Saúde");
        setNome("  Nome: " + hospital.getNameHospital());
        setGestao("  Tipo de atendimento: " + hospital.getUnitType());
        setUf("  UF: " + hospital.getState());
        setMunicipio("  Cidade: " + hospital.getCity());
        setBairro("  Bairro: " + hospital.getDistrict());
        setCep("  Cep: " + hospital.getAddressNumber());
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

    public void goClicked(View map_screen) {
        Intent mapRoute = new Intent();
        mapRoute.setClass(this, RouteActivity.class);
        startActivity(mapRoute);
        finish();
    }

    public void open_search(View mapScreen){
        Intent openSearch = new Intent();
        openSearch.setClass(this , SearchUsController.class);
        startActivity(openSearch);
    }

    public void listMapsImageClicked(View map_screen){
        Intent listOfHealth = new Intent();
        listOfHealth.setClass(this, ListOfHealthUnitsController.class);
        startActivity(listOfHealth);
        finish();
    }

    public void openMap(View mapScreen){
        Intent mapActivity = new Intent();
        mapActivity.setClass(this, MapScreenController.class);
        startActivity(mapActivity);
        finish();
    }

    public void setHospInfo(ListView hospInfo) {
        this.hospInfo = hospInfo;
    }

    public void setReceive(Intent receive) {
        this.receive = receive;
    }

    public void setNumberUsSelected(int numberUsSelected) {
        this.numberUsSelected = numberUsSelected;
    }


    public void setPadding(String padding) {
        this.padding = padding;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGestao(String gestao) {
        this.gestao = gestao;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
