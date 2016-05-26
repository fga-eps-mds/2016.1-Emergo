package helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "emerGo";
    private static final int VERSION = 42;

    private static final String USER_TABLE_USER = "[User]";
    private static final String DROP_TABLE_USER = "DROP TABLE IF EXISTS" + USER_TABLE_USER;
    private static final String HEALTHUNIT_TABLE = "[HealthUnit]";
    //User data
    private static final String NAMEUSER = "[nameUser]";
    private static final String BIRTHDAYUSER = "[birthdayUser]";
    private static final String TYPEBLOODUSER = "[typeBloodUser]";
    private static final String CARDIACUSER = "[cardiacUser]";
    private static final String DIABETICUSER = "[diabeticUser]";
    private static final String HYPERTENSIONUSER = "[hipertensionUser]";
    private static final String SEROPOSITIVEUSER = "[seropositiveUser]";
    private static final String USER_ID = "[IDUser]";

    //HealthUnit data
    private static final String LATITUDE = "[latitude]";
    private static final String LONGITUDE = "[longitude]";
    private static final String NAMEHOSPITAL = "[nameHospital]";
    private static final String UNITTYPE = "[unitType]";
    private static final String ADDRESSNUMBER = "[addressNumber]";
    private static final String DISTRICT = "[district]";
    private static final String STATE = "[state]";
    private static final String CITY = "[city]";

    private static final String CREATE_USER = "CREATE TABLE " + USER_TABLE_USER + " (" +
            NAMEUSER + " VARCHAR(42), "+
            TYPEBLOODUSER+ " VARCHAR(3)); ";

    private static final String CREATE_HEALTHUNIT = "CREATE TABLE " + HEALTHUNIT_TABLE + " (" +
            LATITUDE + "FLOAT, " +
            LONGITUDE + "FLOAT, "+
            NAMEHOSPITAL + "VARCHAR (70), " +
            UNITTYPE + "VARCHAR(42), " +
            ADDRESSNUMBER + "VARCHAR(42), "+
            DISTRICT + "VARCHAR(42), " +
            STATE + "VARCHAR(42), " +
            CITY + "VARCHAR(42)); ";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL(DROP_TABLE_USER);
        onCreate(database);
    }
}
