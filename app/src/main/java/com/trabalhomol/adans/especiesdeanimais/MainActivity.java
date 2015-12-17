package com.trabalhomol.adans.especiesdeanimais;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = (Button) findViewById(R.id.btnAddEspecie);
        Button btnVer = (Button) findViewById(R.id.btnVerEspecies);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), CadastrarEspecieActivity.class);
                startActivity(it);
            }
        });

        btnVer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), VerEspecieActivity.class);
                startActivity(it);

            }
        });
    }
}
