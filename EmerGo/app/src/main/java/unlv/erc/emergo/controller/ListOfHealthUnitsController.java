package unlv.erc.emergo.controller;

import android.app.Activity;

public class ListOfHealthUnitsController extends Activity {

  /*  private List<String> fifthClosestsUs = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private ListView uSsList ;
    private View convertView;
    private Context context;
    private Services services = new Services();
    private InformationUsScreenController informationUsScreenController = new InformationUsScreenController();
    private int numberOfUsClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_health_unit);

       // services.setDistance(this,HealthUnitController.getClosestsUs(), services.getUserPosition());
        fifthClosestsUs = get50closestUs(HealthUnitController.getClosestsUs());

        adapter = new ArrayAdapter<String>(this, R.layout.item, R.id.hospitalUnitText, fifthClosestsUs);
        uSsList = (ListView) findViewById(R.id.list_of_hospitalUnit);
        uSsList.setAdapter(adapter);
        uSsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                numberOfUsClicked = parent.getPositionForView(view);
                openInformationScreen();
            }
        });

    }

    public void openInformationScreen(){

        Intent informationScreen = new Intent();
        informationScreen.putExtra("position", numberOfUsClicked);
        informationScreen.setClass(ListOfHealthUnitsController.this, InformationUsScreenController.class);
        startActivity(informationScreen);
    }


    public List<String> get50closestUs(ArrayList<HealthUnit> closest){
        final int MAXNUMBERUS = 50;
        List<String> closestsUs = new ArrayList<String>();
        int numberOfUs;
        for(numberOfUs = 1 ; numberOfUs < MAXNUMBERUS ; numberOfUs++){
            closestsUs.add(closest.get(numberOfUs).getNameHospital());
        }
        Log.i("distancia + proxima: ",closest.get(0).getDistance()+"");
        return closestsUs;
    }*/

}
