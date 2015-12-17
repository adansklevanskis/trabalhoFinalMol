package com.trabalhomol.adans.especiesdeanimais;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class VerEspecieActivity extends AppCompatActivity {

    GridView gridView;


    static String[]  especiesTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_especie);

        gridView = (GridView) findViewById(R.id.gridView);

        EspecieReaderDbHelper mDbHelper = new EspecieReaderDbHelper(getApplicationContext());

        SQLiteDatabase db = mDbHelper.getReadableDatabase();


        String[] projection = {
                EspecieContract.EspecieEntry.COLUMN_NOME,
                EspecieContract.EspecieEntry.COLUMN_NOME_CIENTIFICO,
        };


        String sortOrder =
                EspecieContract.EspecieEntry.COLUMN_NOME + " ASC";

        Cursor cursor = db.query(
                EspecieContract.EspecieEntry.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                null,                                    // The columns for the WHERE clause
                null,                                    // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        cursor.moveToFirst();
        int count = 0;
        especiesTitle = new String[cursor.getCount()];
        String Nome = cursor.getString(
                cursor.getColumnIndexOrThrow(EspecieContract.EspecieEntry.COLUMN_NOME)
        );
        String NomeCientifico = cursor.getString(
                cursor.getColumnIndexOrThrow(EspecieContract.EspecieEntry.COLUMN_NOME_CIENTIFICO)
        );
        especiesTitle[count] = Nome + " - " + NomeCientifico;
        while( cursor.moveToNext()){
            count++;

            Nome = cursor.getString(
                    cursor.getColumnIndexOrThrow(EspecieContract.EspecieEntry.COLUMN_NOME)
            );
            NomeCientifico = cursor.getString(
                    cursor.getColumnIndexOrThrow(EspecieContract.EspecieEntry.COLUMN_NOME_CIENTIFICO)
            );

            especiesTitle[count] = Nome + " - " + NomeCientifico;

        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, especiesTitle);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),
                        ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
