package unlv.erc.emergo.controller;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import unlv.erc.emergo.R;
import unlv.erc.emergo.model.HealthUnit;

public class SearchUsController extends AppCompatActivity implements SearchView.OnQueryTextListener , View.OnClickListener{

    private SearchView mSearchView;
    private ImageView map , usList;
    private ImageView goButton;
    private List<String> searchUss = new ArrayList<>();
    private int numberOfUsClicked;
    private ListView uSsList;
    private CharSequence Busca;
    ArrayList<String> closestsUs;
    ArrayList<HealthUnit> abc;

    public ListView getuSsList() {
        return uSsList;
    }

    public SearchView getmSearchView() {
        return mSearchView;
    }

    public void setmSearchView(SearchView mSearchView) {
        this.mSearchView = mSearchView;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_screen);
    }

    public void openInformationUsScreen(){

        Intent informationScreen = new Intent();
        informationScreen.putExtra("position", numberOfUsClicked );
        informationScreen.setClass(SearchUsController.this, InformationSearchScreenController.class);
        startActivity(informationScreen);
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        goButton = (ImageView) findViewById(R.id.buttonGo);
        goButton.setOnClickListener(this);
        usList = (ImageView) findViewById(R.id.iconList);
        usList.setOnClickListener(this);
        map = (ImageView) findViewById(R.id.iconMap);
        map.setOnClickListener(this);

        //Carrega o arquivo de menu.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);

        //Pega o Componente.
        mSearchView = (SearchView) menu.findItem(R.id.search)
                .getActionView();
        //Define um texto de ajuda:
        mSearchView.setQueryHint("Busca");

        // exemplos de utilização:
        mSearchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonGo){
            Intent route = new Intent();
            route.setClass(SearchUsController.this, RouteActivity.class);
            startActivity(route);
            finish();
        }
        if(v.getId() == R.id.iconMap){
            Intent map = new Intent();
            map.setClass(SearchUsController.this, MapScreenController.class);
            map.putExtra("numeroUs" , -1);
            startActivity(map);
            finish();
        }
        if(v.getId() == R.id.iconList){
            Intent list = new Intent();
            list.setClass(SearchUsController.this, ListOfHealthUnitsController.class);
            startActivity(list);
            finish();
        }
    }

    public ArrayList<String> getSearchsUs(ArrayList<HealthUnit> closest){

        Busca = mSearchView.getQuery();
        closestsUs = new ArrayList<>();
        abc = new ArrayList<>();
        int numberOfUs;
        for(numberOfUs = 0 ; numberOfUs < HealthUnitController.getClosestsUs().size() ; numberOfUs++){
            if (closest.get(numberOfUs).getNameHospital().toLowerCase().contains(Busca)) {
                closestsUs.add(closest.get(numberOfUs ).getNameHospital());
                abc.add(HealthUnitController.getClosestsUs().get(numberOfUs));
            }
        }
        return closestsUs;
    }

    public void setuSsList(ListView uSsList) {
        this.uSsList = uSsList;
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        searchUss = getSearchsUs(HealthUnitController.getClosestsUs());

        setuSsList((ListView) findViewById(R.id.list_of_search_us));
        uSsList.setAdapter(new ArrayAdapter<>(this, R.layout.item, R.id.hospitalUnitText,
                searchUss));
        uSsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                numberOfUsClicked = parent.getPositionForView(view);
                openInformationUsScreen();
            }
        });
        return false;
    }
}
