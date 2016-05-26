package helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import unlv.erc.emergo.model.User;

public class DatabaseHelper extends SQLiteOpenHelper{
    private static DatabaseHelper database;
    private static SQLiteDatabase sqliteDatabase;
    private static final String DATABASE_NAME = "emerGo";
    private static final int VERSION = 42;

    private static final String USER_TABLE = "[User]";
    private static final String DROP_TABLE_USER = "DROP TABLE IF EXISTS" + USER_TABLE;
    private static final String HEALTHUNIT_TABLE = "[HealthUnit]";
    //User data
    public static final String NAMEUSER = "[nameUser]";
    public static final String BIRTHDAYUSER = "[birthdayUser]";
    public static final String TYPEBLOODUSER = "[typeBloodUser]";
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

    private static final String CREATE_USER = "CREATE TABLE " + USER_TABLE + " (" +
            NAMEUSER + " VARCHAR(42), "+
            BIRTHDAYUSER + " VARCHAR(10), "+
            TYPEBLOODUSER+ " VARCHAR(3), "+
            CARDIACUSER + " VARCHAR(4), "+
            DIABETICUSER + " VARCHAR(4), "+
            HYPERTENSIONUSER + "VARCHAR(4), "+
            SEROPOSITIVEUSER + "VARCHAR(4), "+
            USER_ID + "INTEGER PRIMARY KEY); ";

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

    public boolean insertUser(User user){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nameUser", user.getName());
        contentValues.put("birthdayUser",user.getBirthday());
        contentValues.put("typeBloodUser",user.getTypeBlood());
        contentValues.put("cardiacUser",user.getCardiac());
        contentValues.put("diabeticUser",user.getDiabetic());
        contentValues.put("hypertensionUser",user.getHypertension());
        contentValues.put("seropositiveUser",user.getSeropositive());
        contentValues.put("IDUser",user.getID());
        database.insert(USER_TABLE,null,contentValues);
        database.close();
        return true;
    }
    public boolean updateUser (Integer id,User user) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nameUser", user.getName());
        contentValues.put("birthdayUser",user.getBirthday());
        contentValues.put("typeBloodUser",user.getTypeBlood());
        contentValues.put("cardiacUser",user.getCardiac());
        contentValues.put("diabeticUser",user.getDiabetic());
        contentValues.put("hypertensionUser",user.getHypertension());
        contentValues.put("seropositiveUser",user.getSeropositive());
        contentValues.put("IDUser",user.getID());
        database.update(USER_TABLE, contentValues, "id = ? "+id,null);
        database.close();
        return true;
    }

    public boolean isDatabaseEmpty() {
        sqliteDatabase = database.getReadableDatabase();

        String query = "SELECT * FROM " + USER_TABLE;

        Cursor cursor = sqliteDatabase.rawQuery(query, null);

        boolean isEmpty = false;

        if (cursor != null) {

            if (cursor.getCount() <= 0) {
                cursor.moveToFirst();

                isEmpty = true;

            } else {

            }

        } else {

            isEmpty = true;
        }
        return isEmpty;
    }

    public long deleteUser(SQLiteDatabase sqLiteDatabase, String table) {
        int delete;

        delete = sqLiteDatabase.delete(table, null, null);

        sqLiteDatabase.close();

        return delete;
    }

    public List<User> getAllHospitals() {

        sqliteDatabase = database.getReadableDatabase();

        String query = "SELECT * FROM " + USER_TABLE;

        Cursor cursor = sqliteDatabase.rawQuery( query, null );

        List<User> listHospitals = new ArrayList<User>();

        while( cursor.moveToNext() ) {

            Hospital hospital = new Hospital();

            hospital.setLatitude(cursor.getString(cursor
                    .getColumnIndex(tableColumns[0])));

            hospital.setLongitude(cursor.getString(cursor
                    .getColumnIndex(tableColumns[1])));


            hospital.setCity(cursor.getString(cursor
                    .getColumnIndex(tableColumns[2])));


            hospital.setAddress(cursor.getString(cursor
                    .getColumnIndex(tableColumns[3])));


            hospital.setState(cursor.getString(cursor
                    .getColumnIndex(tableColumns[4])));


            hospital.setRate(cursor.getFloat(cursor
                    .getColumnIndex(tableColumns[5])));


            hospital.setDistrict(cursor.getString(cursor
                    .getColumnIndex(tableColumns[6])));


            hospital.setTelephone(cursor.getString(cursor
                    .getColumnIndex(tableColumns[7])));


            hospital.setName(cursor.getString(cursor
                    .getColumnIndex(tableColumns[8])));


            hospital.setType(cursor.getString(cursor
                    .getColumnIndex(tableColumns[9])));

            hospital.setNumber(cursor.getString(cursor
                    .getColumnIndex(tableColumns[10])));

            hospital.setId(cursor.getString(cursor
                    .getColumnIndex(tableColumns[11])));

            listHospitals.add(hospital);
        }

        //sqliteDatabase.close();

        return listHospitals;
    }
}
