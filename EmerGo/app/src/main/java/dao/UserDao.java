package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDao extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MedicalRecords";
    private static final int VERSION = 42;
    private static UserDao instance = null;

    private static final String USER_TABLE = "User";
    private static final String DROP_TABLE_USER = "DROP TABLE IF EXISTS" + USER_TABLE;

    //User data
    private static final String NAMEUSER = "[nameUser]";
    private static final String BIRTHDAYUSER = "[birthdayUser]";
    private static final String TYPEBLOODUSER = "[typeBloodUser]";
    private static final String CARDIACUSER = "[cardiacUser]";
    private static final String DIABETICUSER = "[diabeticUser]";
    private static final String HYPERTENSIONUSER = "[hipertensionUser]";
    private static final String SEROPOSITIVEUSER = "[seropositiveUser]";
    private static final String OBSERVATIONS = "[observationsUser]";
    private static final String USER_ID = "[IDUser]";

    private static final String CREATE_USER = "CREATE TABLE IF NOT EXISTS " + USER_TABLE + " (" +
            USER_ID + "INTEGER PRIMARY KEY," +
            NAMEUSER + " VARCHAR(42), "+
            BIRTHDAYUSER + " VARCHAR(10), "+
            TYPEBLOODUSER+ " VARCHAR(8), "+
            CARDIACUSER + " VARCHAR(8), "+
            DIABETICUSER + " VARCHAR(8), "+
            HYPERTENSIONUSER + "VARCHAR(8)," +
            SEROPOSITIVEUSER + "VARCHAR(8),"+
            OBSERVATIONS + "VARCHAR(442)); ";

    public UserDao(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    public static UserDao getInstance(Context context){
        if(UserDao.instance != null){

        }else{
            UserDao.instance = new UserDao(context);
        }
        return UserDao.instance;
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

    public boolean insertUser(Integer id,String name,String birthday,String typeBlood,String cardiac,
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
    public boolean updateUser(Integer id,String nameUser,String birthday,String typeBlood,String cardiac,
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

        database.update(USER_TABLE, contentValues, "[IDUser] = ? ",new String[]{String.valueOf(id)});
        database.close();
        return true;
    }
    public Cursor getUser(){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + USER_TABLE,null);
        return cursor;
    }
    public Integer deleteUser(Integer id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete(USER_TABLE, "[IDUser] = ? ",new String[]{String.valueOf(id)});
    }

}
