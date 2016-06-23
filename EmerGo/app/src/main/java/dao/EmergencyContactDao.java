package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EmergencyContactDao extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "emerGo";
    private static final int VERSION = 42;
    private static EmergencyContactDao instance = null;

    private static final String EmergencyContact_TABLE = "EmergencyContact";
    private static final String DROP_TABLE_EmergencyContact = "DROP TABLE IF EXISTS " + EmergencyContact_TABLE;

    //EmergencyContact data
    private static final String NAMECONTACT = "[nameContact]";
    private static final String PHONECONTACT = "[phoneContact]";
    private static final String CONTACT_ID = "[IDContact]";

    private static final String CREATE_EMERGENCYCONTACT = "CREATE TABLE IF NOT EXISTS " + EmergencyContact_TABLE + " (" +
            CONTACT_ID + "INTEGER PRIMARY KEY," +
            NAMECONTACT + " VARCHAR(42), "+
            PHONECONTACT + " VARCHAR(13)); ";

    public EmergencyContactDao(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    public static EmergencyContactDao getInstance(Context context){
        if(EmergencyContactDao.instance != null){

        }else{
            EmergencyContactDao.instance = new EmergencyContactDao(context);
        }
        return EmergencyContactDao.instance;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_EMERGENCYCONTACT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL(DROP_TABLE_EmergencyContact);
        onCreate(database);
    }

    public boolean insertEmergencyContact(Integer id,String nameContact,String phone){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CONTACT_ID, id);
        contentValues.put(NAMECONTACT, nameContact);
        contentValues.put(PHONECONTACT,phone);

        long result = database.insert(EmergencyContact_TABLE,null,contentValues);
        database.close();
        if(result == -1){
            return false;
        }else {
            return true;
        }
    }
    public boolean updateEmergencyContact(Integer id,String nameContact,String phone) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAMECONTACT, nameContact);
        contentValues.put(PHONECONTACT,phone);

        database.update(EmergencyContact_TABLE, contentValues, "[IDContact] = "+id,null);
        database.close();
        return true;
    }
    public Cursor getEmergencyContact(){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + EmergencyContact_TABLE,null);

        return cursor;
    }
    public Integer deleteEmergencyContact(Integer id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete(EmergencyContact_TABLE, "[IDContact] = "+id,null);
    }
}