package com.trabalhomol.adans.especiesdeanimais;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Adans on 13/12/2015.
 */
public class EspecieReaderDbHelper extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ESPECIE =
            "CREATE TABLE " + EspecieContract.EspecieEntry.TABLE_NAME + " (" +
                    EspecieContract.EspecieEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    EspecieContract.EspecieEntry.COLUMN_NOME + TEXT_TYPE + COMMA_SEP +
                    EspecieContract.EspecieEntry.COLUMN_NOME_CIENTIFICO + TEXT_TYPE +
                    " )";

    private static final String SQL_DELETE_ESPECIE =
            "DROP TABLE IF EXISTS " + EspecieContract.EspecieEntry.TABLE_NAME;
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "EspecieReader.db";

    public EspecieReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ESPECIE);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ESPECIE);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
