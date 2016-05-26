package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import helper.DatabaseHelper;
import unlv.erc.emergo.model.User;

/**
 * Created by victor on 25/05/16.
 */
public class UserDao extends Dao {
    private static UserDao instance;
    private static String tableColumns[]={"nameUser,typeBloodUser"};
    private static String nameTable = "User";

    private UserDao(Context context ) {
        UserDao.database = new DatabaseHelper( context );
    }

    public static UserDao getInstance( Context context ) {
        if( UserDao.instance != null ) {

        } else {
            UserDao.instance = new UserDao( context );
        }

        return UserDao.instance;
    }

    public boolean isDatabaseEmpty(){
        sqliteDatabase = database.getReadableDatabase();

        String query = "SELECT * FROM " + nameTable;

        Cursor cursor = sqliteDatabase.rawQuery( query, null );

        boolean isEmpty = false;

        if( cursor != null ) {

            if( cursor.getCount() <= 0 ) {
                cursor.moveToFirst();

                isEmpty = true;

            } else {

            }

        } else {

            isEmpty = true;
        }

        return isEmpty;
    }

    public boolean insertUserOnDatabase(User user) {
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(tableColumns[0], user.getName());
        values.put(tableColumns[1], user.getTypeBlood());

        boolean result = insertAndClose(sqLiteDatabase,nameTable, values)>0;
        return result;
    }

    public List<User> getUser() {

        sqliteDatabase = database.getReadableDatabase();

        String query = "SELECT * FROM " + nameTable;

        Cursor cursor = sqliteDatabase.rawQuery( query, null );

        List<User> users = new ArrayList<User>();

        while( cursor.moveToNext() ) {

            User user = new User();

            user.setName(cursor.getString(cursor.getColumnIndex(tableColumns[0])));
            user.setTypeBlood(cursor.getString(cursor.getColumnIndex(tableColumns[1])));
            user.setId(cursor.getString(cursor.getColumnIndex(tableColumns[2])));

            users.add(user);
        }

        //sqliteDatabase.close();

        return users;
    }

    public boolean insertUser( List<User> users ) {
        Iterator<User> index = users.iterator();

        boolean result = true;

        while( index.hasNext() ) {
            result = insertUserOnDatabase( index.next() );
        }

        return result;
    }

    public long deleteUser() {
        long result;

        result = deleteAndClose(sqliteDatabase, nameTable);

        return result;
    }
}
