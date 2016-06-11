package unlv.erc.emergo.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
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

    private SearchView mSearchView;
    private List<String> searchUss = new ArrayList<String>();
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
        final int CORRECTINDEX = 1;
        Intent informationScreen = new Intent();
        informationScreen.putExtra("position", numberOfUsClicked + CORRECTINDEX);
        informationScreen.setClass(SearchUsController.this, InformationSearchScreenController.class);
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
        //final int MAXNUMBERUS = 50;
        Busca = mSearchView.getQuery();
        closestsUs = new ArrayList<>();
        abc = new ArrayList<>();
        int numberOfUs;
        for(numberOfUs = 1 ; numberOfUs < HealthUnitController.getSearchsUs().size() ; numberOfUs++){
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

        searchUss = getSearchsUs(HealthUnitController.getSearchsUs());

        setuSsList((ListView) findViewById(R.id.list_of_search_us));
        uSsList.setAdapter(new ArrayAdapter<>(this, R.layout.item, R.id.hospitalUnitText,
                searchUss));
        uSsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                numberOfUsClicked = parent.getPositionForView(view);
                Log.i("position" , numberOfUsClicked + "");
                openInformationUsScreen();
            }
        });
        return false;
    }
}
