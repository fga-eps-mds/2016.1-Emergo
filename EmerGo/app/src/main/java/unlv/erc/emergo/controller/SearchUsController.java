package unlv.erc.emergo.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import unlv.erc.emergo.R;
import unlv.erc.emergo.model.HealthUnit;

public class SearchUsController extends AppCompatActivity implements SearchView.OnQueryTextListener{

    SearchView mSearchView;
    private List<String> searchUss = new ArrayList<String>();
    private int numberOfUsClicked;
    private ListView uSsList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_screen);
    }

    public void openInformationUsScreen(){

        Intent informationScreen = new Intent();
        informationScreen.putExtra("position", numberOfUsClicked);
        informationScreen.setClass(SearchUsController.this, InformationUsScreenController.class);
        startActivity(informationScreen);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

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

    public ArrayList<String> getSearchsUs(ArrayList<HealthUnit> closest){
        final int MAXNUMBERUS = 2731;
        ArrayList<String> closestsUs = new ArrayList<String>();
        int numberOfUs;
        for(numberOfUs = 1 ; numberOfUs < MAXNUMBERUS ; numberOfUs++){
            if (closest.get(numberOfUs).getNameHospital().contains((CharSequence) mSearchView)) {
                closestsUs.add(closest.get(numberOfUs).getNameHospital());
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
        uSsList.setAdapter(new ArrayAdapter<String>(this, R.layout.item, R.id.hospitalUnitText,
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
