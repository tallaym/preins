package com.example.preinscription;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.pm.PackageManager;

public class infos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos);

        Button envoi = findViewById(R.id.send);
        Button annuler = findViewById(R.id.cancel);

        envoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = ((TextView) findViewById(R.id.nom)).getText().toString();

                // Créer un Intent pour envoyer un SMS
                Intent intent2 = new Intent(Intent.ACTION_SENDTO);
                intent2.setData(Uri.parse("smsto:" + Uri.encode("+221770661163")));

                intent2.putExtra("sms_body", "NomComplet: " + nom);
                startActivity(intent2);
              /*  if (intent2.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent2);
                } else {
                    // Gérer le cas où aucune application de messagerie n'est disponible
                    Toast.makeText(getApplicationContext(), "Aucune application de messagerie n'est disponible", Toast.LENGTH_SHORT).show();
                }*/
            }
        });

        annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            String prenomValue = intent.getStringExtra("PRENOM");
            String nomValue = intent.getStringExtra("NOM");
            String telValue = intent.getStringExtra("TEL");
            String birthValue = intent.getStringExtra("BIRTH");
            String origineValue = intent.getStringExtra("ORIGINE");
            String choixValue = intent.getStringExtra("CHOIX");

            TextView nom = findViewById(R.id.nom);
            nom.setText(prenomValue + " " + nomValue);

            TextView tel = findViewById(R.id.tel);
            tel.setText(telValue);

            TextView birth = findViewById(R.id.birth);
            birth.setText(birthValue);

            TextView origine = findViewById(R.id.origine);
            origine.setText(origineValue);

            TextView choix = findViewById(R.id.choix);
            choix.setText(choixValue);

        }




        }
    }
