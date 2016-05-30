package dao;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class HealthUnitDao extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "emerGo";
    public static final int VERSION = 42;

    public static final String HEALTHUNIT_TABLE = "HealthUnit";
    public static final String DROP_TABLE_HEALTHUNIT = "DROP TABLE IF EXISTS" + HEALTHUNIT_TABLE;
    private Activity activity;
    //HealthUnit data
    public static final String LATITUDE = "[latitude]";
    public static final String LONGITUDE = "[longitude]";
    public static final String NAMEHOSPITAL = "[nameHospital]";
    public static final String UNITTYPE = "[unitType]";
    public static final String ADDRESSNUMBER = "[addressNumber]";
    public static final String DISTRICT = "[district]";
    public static final String STATE = "[state]";
    public static final String CITY = "[city]";
    public static final String HEALTHUNIT_ID = "[IDHealthUnit]";

    public static final String CREATE_HEALTHUNIT = "CREATE TABLE " + HEALTHUNIT_TABLE + " (" +
            HEALTHUNIT_ID + "INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            LATITUDE + " FLOAT, "+
            LONGITUDE + " DOUBLE, "+
            NAMEHOSPITAL + " VARCHAR(50), "+
            UNITTYPE + " VARCHAR(42), "+
            ADDRESSNUMBER + " VARCHAR(8), "+
            DISTRICT + "VARCHAR(42)," +
            STATE + "VARCHAR(42),"+
            CITY + "VARCHAR(442)); ";

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

    public boolean insertHealthUnit(Integer id,Double latitude,Double longitude,String nameHospital,
                                    String unitType,String addressNumber,String district,String state,
                                    String city){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(HEALTHUNIT_ID, id);
        contentValues.put(LATITUDE, latitude);
        contentValues.put(LONGITUDE,longitude);
        contentValues.put(NAMEHOSPITAL,nameHospital);
        contentValues.put(UNITTYPE,unitType);
        contentValues.put(ADDRESSNUMBER,addressNumber);
        contentValues.put(DISTRICT,district);
        contentValues.put(STATE,state);
        contentValues.put(CITY,city);

        long result = database.insert(HEALTHUNIT_TABLE,null,contentValues);
        database.close();
        if(result == -1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor getHealthUnit(){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + HEALTHUNIT_TABLE,null);
        return cursor;
    }
}
