package osmdroid;

import android.content.Context;

import com.google.android.gms.maps.model.Polyline;

import org.osmdroid.util.GeoPoint;

import java.util.ArrayList;


public abstract class RoadManager {

    protected String mOptions;


    public abstract Road getRoad(ArrayList<GeoPoint> waypoints);


    public abstract Road[] getRoads(ArrayList<GeoPoint> waypoints);

    public RoadManager() {
        mOptions = "";
    }


    public void addRequestOption(String requestOption){
        mOptions += "&" + requestOption;
    }

    protected String geoPointAsString(GeoPoint p){
        StringBuffer result = new StringBuffer();
        double d = p.getLatitude();
        result.append(Double.toString(d));
        d = p.getLongitude();
        result.append("," + Double.toString(d));
        return result.toString();
    }


    public static Polyline buildRoadOverlay(Road road, int color, float width, Context context){
        Polyline roadOverlay = new Polyline(context);
        roadOverlay.setColor(color);
        roadOverlay.setWidth(width);
        if (road != null) {
            ArrayList<GeoPoint> polyline = road.mRouteHigh;
            roadOverlay.setPoints(polyline);
        }
        return roadOverlay;
    }


    public static Polyline buildRoadOverlay(Road road, Context context){
        return buildRoadOverlay(road, 0x800000FF, 5.0f, context);
    }

}