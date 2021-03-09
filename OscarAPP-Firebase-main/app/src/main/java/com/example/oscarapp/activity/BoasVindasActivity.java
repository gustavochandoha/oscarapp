package com.example.oscarapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.oscarapp.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Scanner;


public class BoasVindasActivity extends AppCompatActivity {

    private  static final  String KEY_TITLE = "token";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boas_vindas);

        String uid = FirebaseAuth.getInstance().getUid();
        int valuee = Integer.parseInt(uid.replaceAll("[^0-9]", ""));

        // below, %02d says to java that I want my integer to be formatted as a 2 digit representation
        String temp = String.format("%2d", valuee);
        // and if you want to do the reverse
        int i = Integer.parseInt(temp);

        long num = i;
        int n = 2;
        long first_n = (long) (num / Math.pow(10, Math.floor(Math.log10(num)) - n + 1));


        int res = new Scanner(uid).useDelimiter("\\D+").nextInt();

        FirebaseFirestore.getInstance().collection("usuario").document(uid).get().
                addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {

            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    int value = documentSnapshot.getLong("token").intValue();

                    TextView tokentxt = findViewById(R.id.intToken);
                    tokentxt.setText(Integer.toString((int) first_n));

                }else {

                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

    }

    public void btn_votar_diretor(View view){
        Intent i = new Intent(BoasVindasActivity.this, DiretorActivity.class);
        startActivity(i);
    }

    public void btn_votar_filme(View view){
        Intent i = new Intent(BoasVindasActivity.this, ListaFilme.class);
        startActivity(i);
    }

    public void btn_confirmar_voto(View view){
        Intent i = new Intent(BoasVindasActivity.this, ConfirmarActivity.class);
        startActivity(i);
    }

    public void btn_sair(View view){
        finish();
        System.exit(0);

    }
}