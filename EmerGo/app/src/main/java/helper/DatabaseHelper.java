package helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "emerGo";
    public static final int VERSION = 42;

    public static final String USER_TABLE = "User";
    public static final String DROP_TABLE_USER = "DROP TABLE IF EXISTS" + USER_TABLE;
    private static final String HEALTHUNIT_TABLE = "[HealthUnit]";

    //User data
    public static final String NAMEUSER = "[nameUser]";
    public static final String BIRTHDAYUSER = "[birthdayUser]";
    public static final String TYPEBLOODUSER = "[typeBloodUser]";
    public static final String CARDIACUSER = "[cardiacUser]";
    public static final String DIABETICUSER = "[diabeticUser]";
    public static final String HYPERTENSIONUSER = "[hipertensionUser]";
    public static final String SEROPOSITIVEUSER = "[seropositiveUser]";
    public static final String OBSERVATIONS = "[observationsUser]";
    public static final String USER_ID = "[IDUser]";

    //HealthUnit data
    private static final String LATITUDE = "[latitude]";
    private static final String LONGITUDE = "[longitude]";
    private static final String NAMEHOSPITAL = "[nameHospital]";
    private static final String UNITTYPE = "[unitType]";
    private static final String ADDRESSNUMBER = "[addressNumber]";
    private static final String DISTRICT = "[district]";
    private static final String STATE = "[state]";
    private static final String CITY = "[city]";

    public static final String CREATE_USER = "CREATE TABLE " + USER_TABLE + " (" +
            USER_ID + "INTEGER PRIMARY KEY," +
            NAMEUSER + " VARCHAR(42), "+
            BIRTHDAYUSER + " VARCHAR(10), "+
            TYPEBLOODUSER+ " VARCHAR(8), "+
            CARDIACUSER + " VARCHAR(8), "+
            DIABETICUSER + " VARCHAR(8), "+
            HYPERTENSIONUSER + "VARCHAR(8)," +
            SEROPOSITIVEUSER + "VARCHAR(8),"+
            OBSERVATIONS + "VARCHAR(4242)); ";

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

    public boolean insertUser(String id,String name,String birthday,String typeBlood,String cardiac,
                              String diabetic,String hypertension,String seropositive,
                              String observations){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_ID, id);
        contentValues.put(NAMEUSER, name);
        contentValues.put(BIRTHDAYUSER,birthday);
        contentValues.put(TYPEBLOODUSER,typeBlood);
        contentValues.put(CARDIACUSER,cardiac);
        contentValues.put(DIABETICUSER,diabetic);
        contentValues.put(HYPERTENSIONUSER,hypertension);
        contentValues.put(SEROPOSITIVEUSER,seropositive);
        contentValues.put(OBSERVATIONS,observations);

        long result = database.insert(USER_TABLE,null,contentValues);
        database.close();
        if(result == -1){
            return false;
        }else {
            return true;
        }
    }
    public boolean updateUser(String id,String nameUser,String birthday,String typeBlood,String cardiac,
                              String diabetic,String hypertension,String seropositive,String observation) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAMEUSER, nameUser);
        contentValues.put(BIRTHDAYUSER,birthday);
        contentValues.put(TYPEBLOODUSER,typeBlood);
        contentValues.put(CARDIACUSER,cardiac);
        contentValues.put(DIABETICUSER,diabetic);
        contentValues.put(HYPERTENSIONUSER,hypertension);
        contentValues.put(SEROPOSITIVEUSER,seropositive);
        contentValues.put(OBSERVATIONS,observation);

        database.update(USER_TABLE, contentValues, "[IDUser] = ? ",new String[]{id});
        database.close();
        return true;
    }
    public Cursor getUser(){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + USER_TABLE,null);
        return cursor;
    }
    public Integer deleteUser(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete(USER_TABLE, "[IDUser] = ? ",new String[]{id});
    }
}
