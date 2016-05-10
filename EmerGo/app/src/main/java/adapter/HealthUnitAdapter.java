package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import unlv.erc.emergo.model.HealthUnit;
import unlv.erc.emergo.R;


public class HealthUnitAdapter extends ArrayAdapter<HealthUnit> {
    private Context context;
    private ArrayList<HealthUnit> hospitalList;
    public static final int COUNT = 20;

    public HealthUnitAdapter(Context context, ArrayList<HealthUnit> hospitalList){
        super(context, 0, hospitalList);
        setContext(context);
        setHospitalList(hospitalList);
    }

    @Override
    public int getCount() {
        return COUNT;
    }

    @Override
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<HealthUnit> getHospitalList() {
        return hospitalList;
    }

    public void setHospitalList(ArrayList<HealthUnit> hospitalList) {
        this.hospitalList = hospitalList;
    }

    @Override
    public HealthUnit getItem(int position) {

        return hospitalList.get(position);
    }


    private Float convertToKM(Float distance){

        return distance/1000;
    }

    public void setDistance(View convertView, int position) {

        if (this.hospitalList.get(position).getDistance() < 1f) {
            // Setting distance of drugstore on list item
            TextView textViewDistance = (TextView) convertView.findViewById(R.id.distanceText);
            textViewDistance.setText(this.hospitalList.get(position).getDistance() + " m");
        } else {
            // Setting distance of drugstore on list item
            TextView textViewDistance = (TextView) convertView.findViewById(R.id.distanceText);
            textViewDistance.setText(convertToKM(this.hospitalList.get(position).getDistance()).toString() + " Km");
        }
    }

    public View populateAdapter(View convertView, int position){

        HealthUnit hospitalPosition = this.hospitalList.get(position);
        convertView = LayoutInflater.from(this.context).inflate(R.layout.item, null);

        TextView textView = (TextView) convertView.findViewById(R.id.distanceText);
        textView.setText((CharSequence) hospitalPosition.getNome());

        setDistance(convertView, position);

        return convertView;
    }
}
