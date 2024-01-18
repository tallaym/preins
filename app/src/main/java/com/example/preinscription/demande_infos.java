package com.example.preinscription;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


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
        String p = ((EditText) findViewById(R.id.prenom)).getText().toString();
        String nom = ((EditText) findViewById(R.id.nom)).getText().toString();
        String tel = ((EditText) findViewById(R.id.tel)).getText().toString();
        String birthValue = ((EditText) findViewById(R.id.birth)).getText().toString();
        String origine = ((Spinner) findViewById(R.id.origine)).getSelectedItem().toString();
        String fac = ((Spinner) findViewById(R.id.choix)).getSelectedItem().toString();

        if (!ValidPrenom(p) || !ValidNom(nom) || !ValidNumber(tel)
                || birthValue.isEmpty() || !ValidPays(origine) || !ValidFac(fac)) {
            Toast.makeText(this, "Veuillez comme il se doit tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent i = new Intent(getApplicationContext(), infos.class);

        i.putExtra("PRENOM", p);
        i.putExtra("NOM", nom);
        i.putExtra("TEL", tel);
        i.putExtra("BIRTH", birthValue);
        i.putExtra("ORIGINE", origine);
        i.putExtra("CHOIX", fac);

        startActivity(i);
    }

    public boolean ValidPrenom(String var)
    {
            String regexPrenom = "^[a-zA-ZÀ-ÿ]{2,}(?:[\\s-]?[a-zA-ZÀ-ÿ]{2,})*$";

            if(!var.matches(regexPrenom)){
                Toast.makeText(this, "format prénom invalide." +
                        "(Deux lettres au minimum par prénom, espace entre eux", Toast.LENGTH_LONG).show();
                return false;
            }else{
                return true;
            }

    }

    public boolean ValidNom(String var)
    {
        String regexNom = "^[a-zA-ZÀ-ÿ- ]+$";

        if(!var.matches(regexNom)){
            Toast.makeText(this, "Veuillez donner un prénom valide." +
                    "(Veuillez donner un nom valide. Lettres, espaces et tirets autorisés", Toast.LENGTH_LONG).show();
            return false;
        }else{
            return true;
        }

    }

    public boolean ValidNumber(String var)
    {
        String regexNumber = "^7[0-9]{8}$";

        if(!var.matches(regexNumber)){
            Toast.makeText(this, "Veuillez donner un numéro de télephone valide." +
                    "(Pour rappel, sont admis les numéros de téléphones du Sénégal, long de 09 chiffres ", Toast.LENGTH_LONG).show();
            return false;
        }else{
            return true;
        }

    }

    public boolean ValidPays(String var){

        Spinner spinner = findViewById(R.id.origine);
        String Liste = spinner.getSelectedItem().toString();


        if (Liste.equals(var) && !(var.equals("Sélectionner"))) {
            return true;
        } else {
            Toast.makeText(this, "La valeur n'est pas présente dans le Spinner.", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    public boolean ValidFac(String var){

        Spinner spinner = findViewById(R.id.choix);
        String Liste = spinner.getSelectedItem().toString();


        if (Liste.equals(var) && !(var.equals("Sélectionner"))) {
            return true;
        } else {
            Toast.makeText(this, "La valeur n'est pas présente dans le Spinner.", Toast.LENGTH_SHORT).show();
            return false;
        }

    }
}