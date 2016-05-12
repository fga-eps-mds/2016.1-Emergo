package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
public class HealthUnitDao extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "HealthUnit";
    public static final int VERSAO = 1;
    public static final String TABLE = "HealthUnit1";
    public static final String NAMEHOSPITAL = "nameHospital";
    public static final String UNITTYPE = "unitType";
    public static final String ADDRESS = "address";
    public static final String ADDRESSNUMBER = "addressNumber";
    public static final String DISTRICT = "district";
    public static final String REGION = "region";
    public static final String STATE = "state";
    public static final String CITY = "city";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String DROP_TABLE_HEALTHUNIT = "DROP TABLE IF EXISTS" + TABLE;

    public static final String CREATE_TABLE_HEALTHUNIT = "CREATE TABLE IF NOT EXISTS" + TABLE + "("
            + NAMEHOSPITAL + "TEXT NOT NULL," + UNITTYPE + "TEXT NOT NULL," + ADDRESSNUMBER + "TEXT NOT NULL,"
            + DISTRICT + "TEXT NOT NULL," + STATE + "TEXT NOT NULL," + CITY + "TEXT NOT NULL,"
            + LATITUDE + "DOUBLE NOT NULL," + LONGITUDE + "DOUBLE NOT NULL" + ")";

    private static HealthUnitDao instance;

    public HealthUnitDao(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    public static HealthUnitDao getInstance(Context context) {
        if (instance == null)
            instance = new HealthUnitDao(context);

        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_TABLE_HEALTHUNIT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL(DROP_TABLE_HEALTHUNIT);
        onCreate(database);
    }

    public boolean insertHealthUnit(Double latitude, Double longitude, String nameHospital,
                                    String unitType, String state, String city, String district,
                                    String addressNumber) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("latitude", latitude);
        contentValues.put("longitude", longitude);
        contentValues.put("nameHospital",nameHospital);
        contentValues.put("unitType",unitType);
        contentValues.put("state",state);
        contentValues.put("city",city);
        contentValues.put("district", district);
        contentValues.put("addressNumber", addressNumber);
        database.insert(TABLE, null, contentValues);
        return true;
    }

    public boolean updateTableHealthUnit(Integer id,Double latitude,Double longitude,String nameHospital,
                                         String unitType,String state,String city,String district,
                                         String addressNumber){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("latitude", latitude);
        contentValues.put("longitude",longitude);
        contentValues.put("nameHospital",nameHospital);
        contentValues.put("unitType",unitType);
        contentValues.put("state",state);
        contentValues.put("city",city);
        contentValues.put("district",district);
        contentValues.put("addressNumber",addressNumber);
        database.update(TABLE, contentValues,"id = ?",new String[]{Integer.toString(id) });
        return true;
    }

    public Integer delectTableHealthUnit(Integer id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete(TABLE,"id = ?",new String[]{Integer.toString(id) });
    }
    public ArrayList<String> selectTable(){
        ArrayList<String> healthUnitList = new ArrayList<String>();

        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM "+ TABLE,null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false){
            healthUnitList.add(cursor.getString(cursor.getColumnIndex(NAMEHOSPITAL)));
            cursor.moveToNext();
        }
        return healthUnitList;
    }
}

