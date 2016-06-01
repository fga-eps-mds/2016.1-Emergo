package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import unlv.erc.emergo.model.HealthUnit;


public class HealthUnitDao extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "emerGo";
    public static final int VERSION = 42;

    public static final String HEALTHUNIT_TABLE = "HealthUnit";
    public static final String DROP_TABLE_HEALTHUNIT = "DROP TABLE IF EXISTS" + HEALTHUNIT_TABLE;

    //HealthUnit data
    public static final String LATITUDE = "[latitude]";
    public static final String LONGITUDE = "[longitude]";
    public static final String NAMEHOSPITAL = "[nameHospital]";
    public static final String UNITTYPE = "[unitType]";
    public static final String ZIPCODE = "[zipCode]";
    public static final String DISTRICT = "[district]";
    public static final String STATE = "[state]";
    public static final String CITY = "[city]";

    public static final String CREATE_HEALTHUNIT = "CREATE TABLE " + HEALTHUNIT_TABLE + " (" +
            ZIPCODE + "INTEGER PRIMARY KEY, "+
            LATITUDE + " FLOAT, "+
            LONGITUDE + " DOUBLE, "+
            NAMEHOSPITAL + " VARCHAR(50), "+
            UNITTYPE + " VARCHAR(42), "+
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

    public boolean insertHealthUnit(HealthUnit healthUnit){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(LATITUDE, healthUnit.getLatitude());
        contentValues.put(LONGITUDE,healthUnit.getLongitude());
        contentValues.put(NAMEHOSPITAL, healthUnit.getNameHospital());
        contentValues.put(UNITTYPE, healthUnit.getUnitType());
        contentValues.put(DISTRICT,healthUnit.getDistrict());
        contentValues.put(STATE, healthUnit.getState());
        contentValues.put(CITY, healthUnit.getCity());

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
