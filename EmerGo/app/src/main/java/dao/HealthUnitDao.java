package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import unlv.erc.emergo.model.HealthUnit;

public class HealthUnitDao extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "emerGo";
    private static final int VERSION = 42;
    private static final String HealthUnit_TABLE = "HealthUnit";
    private static final String DROP_TABLE_HEALTHUNIT = "DROP TABLE IF EXISTS" + HealthUnit_TABLE;
    private static final String HEALTH_UNIT_COLUMNS[] = {"latitude","longitude","nameHospital",
            "unitType","addressNumber","district","state","city"};
    //HealthUnit data
    private static final String LATITUDE = "[latitude]";
    private static final String LONGITUDE = "[longitude]";
    private static final String NAMEHOSPITAL = "[nameHospital]";
    private static final String UNITTYPE = "[unitType]";
    private static final String ADDRESSNUMBER = "[addressNumber]";
    private static final String DISTRICT = "[district]";
    private static final String STATE = "[state]";
    private static final String CITY = "[city]";

    private static final String CREATE_HEALTHUNIT = "CREATE TABLE IF NOT EXISTS " + HealthUnit_TABLE + " (" +
            LATITUDE + " DOUBLE, "+
            LONGITUDE + " DOUBLE, "+
            NAMEHOSPITAL + " VARCHAR(42), "+
            UNITTYPE + " VARCHAR(42), "+
            ADDRESSNUMBER + " VARCHAR(10), "+
            DISTRICT + "VARCHAR(42), " +
            STATE + "VARCHAR(42), "+
            CITY + "VARCHAR(42)); ";

    public HealthUnitDao(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_HEALTHUNIT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL(DROP_TABLE_HEALTHUNIT);
        onCreate(database);
    }

    public boolean insertHealthUnit(Double latitude, Double longitude, String nameHospital,
                                    String unitType, String addressNumber, String district,
                                    String state, String city){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(LATITUDE, latitude);
        contentValues.put(LONGITUDE,longitude);
        contentValues.put(NAMEHOSPITAL,nameHospital);
        contentValues.put(UNITTYPE,unitType);
        contentValues.put(ADDRESSNUMBER,addressNumber);
        contentValues.put(DISTRICT,district);
        contentValues.put(STATE,state);
        contentValues.put(CITY,city);

        long result = database.insert(HealthUnit_TABLE,null,contentValues);
        database.close();
        if(result == -1){
            return false;
        }else {
            return true;
        }
    }

    public List<HealthUnit> getHealthUnit(){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + HealthUnit_TABLE,null);
        List<HealthUnit> healthUnitList = new ArrayList<HealthUnit>();


        while (cursor.moveToNext()){
            HealthUnit healthUnit = new HealthUnit();
            System.out.println(cursor.getColumnCount());
            healthUnit.setLatitude(cursor.getDouble(cursor.getColumnIndex(HEALTH_UNIT_COLUMNS[0])));
            Log.d("LATITUDE",""+healthUnit.getLatitude());
            healthUnit.setLongitude(cursor.getDouble(cursor.getColumnIndex(HEALTH_UNIT_COLUMNS[1])));
            Log.d("LONGITUDE",""+healthUnit.getLongitude());
            healthUnit.setNameHospital(cursor.getString(cursor.getColumnIndex(HEALTH_UNIT_COLUMNS[2])));
            Log.d("NAMEHOSPITAL",""+healthUnit.getNameHospital());
            healthUnit.setUnitType(cursor.getString(cursor.getColumnIndex(HEALTH_UNIT_COLUMNS[3])));
            healthUnit.setAddressNumber(cursor.getString(cursor.getColumnIndex(HEALTH_UNIT_COLUMNS[4])));
            healthUnit.setDistrict(cursor.getString(cursor.getColumnIndex(HEALTH_UNIT_COLUMNS[5])));
            healthUnit.setState(cursor.getString(cursor.getColumnIndex(HEALTH_UNIT_COLUMNS[6])));
            healthUnit.setCity(cursor.getString(cursor.getColumnIndex(HEALTH_UNIT_COLUMNS[7])));
            healthUnitList.add(healthUnit);
        }
        return healthUnitList;
    }

    public Cursor getTableHealthUnit(){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + HealthUnit_TABLE,null);

        return cursor;
    }

    public boolean isDbEmpty(){
        SQLiteDatabase sqliteDatabase = this.getReadableDatabase();

        String query = "SELECT  1 FROM " + HealthUnit_TABLE;

        Cursor cursor = sqliteDatabase.rawQuery( query, null );

        boolean isEmpty = false;

        if( cursor != null ) {

            if( cursor.getCount() <= 0 ) {
                cursor.moveToFirst();

                isEmpty = true;

            } else {}

        } else {

            isEmpty = true;
        }

        return isEmpty;
    }
}
