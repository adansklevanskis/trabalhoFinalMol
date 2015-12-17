package com.trabalhomol.adans.especiesdeanimais;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CadastrarEspecieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_especie);

        Button salvar = (Button) findViewById(R.id.btnSalvar);
        salvar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try {
                    TextView txtNome = (TextView) findViewById(R.id.txtNome);
                    String nome = txtNome.getText().toString();

                    TextView txtCientifico = (TextView) findViewById(R.id.txtCientifico);
                    String cientifico = txtCientifico.getText().toString();

                    EspecieReaderDbHelper mDbHelper = new EspecieReaderDbHelper(getApplicationContext());
                    // Gets the data repository in write mode
                    SQLiteDatabase db = mDbHelper.getWritableDatabase();

                    ContentValues values = new ContentValues();
                    values.put(EspecieContract.EspecieEntry.COLUMN_NOME, nome);
                    values.put(EspecieContract.EspecieEntry.COLUMN_NOME_CIENTIFICO, cientifico);

                    long newRowId;
                    newRowId = db.insert(EspecieContract.EspecieEntry.TABLE_NAME, null, values);

                    Toast.makeText(getApplicationContext(),
                            "Cadastrado Especie com sucesso.", Toast.LENGTH_SHORT).show();

                } catch (Exception ex) {
                    String message = ex.getMessage();
                }


            }
        });
    }
}
