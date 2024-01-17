package com.example.preinscription;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class demande_infos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demande_infos);

        Button envoi = findViewById(R.id.send);
        Button annuler = findViewById(R.id.cancel);


        envoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Envoi(v);
            }
        });

        annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void Envoi(View v)
    {
        String prenomValue = ((EditText) findViewById(R.id.prenom)).getText().toString();
        String nomValue = ((EditText) findViewById(R.id.nom)).getText().toString();
        String telValue = ((EditText) findViewById(R.id.tel)).getText().toString();
        String birthValue = ((EditText) findViewById(R.id.birth)).getText().toString();
        String origineValue = ((Spinner) findViewById(R.id.origine)).getSelectedItem().toString();
        String choixValue = ((Spinner) findViewById(R.id.choix)).getSelectedItem().toString();

        Intent i = new Intent(getApplicationContext(), infos.class);

        i.putExtra("PRENOM", prenomValue);
        i.putExtra("NOM", nomValue);
        i.putExtra("TEL", telValue);
        i.putExtra("BIRTH", birthValue);
        i.putExtra("ORIGINE", origineValue);
        i.putExtra("CHOIX", choixValue);

        startActivity(i);
    }
}