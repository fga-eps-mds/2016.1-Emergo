package unlv.erc.emergo.controller;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import unlv.erc.emergo.R;
import unlv.erc.emergo.model.HealthUnit;

public class InformationSearchScreenController extends Activity{


    private List<String> listOfInformations = new ArrayList<String>();
    private ListView hospInfo;
    private Intent receive;
    private Button route;
    private ImageView buttonGo;
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
        route = (Button) findViewById(R.id.botaoRota);
        route.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                buttonRoute();
            }
        });
        buttonGo = (ImageView) findViewById(R.id.buttonGo);
        buttonGo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                buttonClickGo();
            }
        });

        setHospInfo((ListView) findViewById(R.id.hospInformation));
        setInformation(HealthUnitController.getClosestsUs().get(numberUsSelected));
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

    public void buttonRoute(){
        Intent route = new Intent();
        route.setClass(this , RouteActivity.class);
        route.putExtra("numeroUs" , receive.getIntExtra("position" , 0));
        startActivity(route);
        finish();
    }

    public void buttonClickGo(){
        final String ROUTETRACED = "Rota mais próxima traçada";
        Toast.makeText(this, ROUTETRACED , Toast.LENGTH_SHORT).show();
        Intent routeActivity = new Intent();
        routeActivity.setClass(this , RouteActivity.class);
        routeActivity.putExtra("numeroUs" , -1);
        startActivity(routeActivity);
        finish();
    }

    public void open_search(View mapScreen){
        Intent openSearch = new Intent();
        openSearch.setClass(this , SearchUsController.class);
        startActivity(openSearch);
    }

    public void openConfig(View map_screen){
        Intent config = new Intent();
        config.setClass(this , ConfigController.class);
        startActivity(config);
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
    public String getPadding() { return  padding;}

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo() { return titulo; }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome(){ return nome; }

    public void setGestao(String gestao) {
        this.gestao = gestao;
    }
    public String getGestao(){ return gestao; }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getUf(){return uf;}

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getMunicipio(){return municipio;}

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getBairro(){
        return bairro;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String  getCep(){
        return cep;
    }
}
