package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import helper.DatabaseHelper;

public class Dao {
    protected static DatabaseHelper database;
    protected static SQLiteDatabase sqliteDatabase;
    protected static Context context;

    //Método para inserir no banco local
    protected long insertAndClose(SQLiteDatabase sqLiteDatabase, String table, ContentValues values ) {
        sqLiteDatabase.insert(table, null, values);
        long resultInsert = 1;

        sqLiteDatabase.close();

        return resultInsert;
    }

    //Metodo para deletar o banco local
    protected long deleteAndClose(SQLiteDatabase sqLiteDatabase, String table) {
        int delete;

        delete = sqLiteDatabase.delete(table, null, null);

        sqLiteDatabase.close();

        return delete;
    }
}
