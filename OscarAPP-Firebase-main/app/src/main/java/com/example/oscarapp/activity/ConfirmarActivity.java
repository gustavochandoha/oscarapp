package com.example.oscarapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oscarapp.R;
import com.example.oscarapp.model.Usuario;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ConfirmarActivity extends AppCompatActivity {

    TextView Diretor, Filme;

    String email;
    public String nomediretor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);

        Diretor = (TextView) findViewById(R.id.txtDiretor);
        Filme = (TextView) findViewById(R.id.txtFilme);

        Intent intentR = getIntent();
        Bundle paramR = intentR.getExtras();

        if(paramR != null){
            String nomeDi = paramR.getString("nome");
            int idDi = paramR.getInt("id");
                nomediretor = nomeDi;
                Diretor.setText(nomeDi);
        }
    }




    public void validar_voto(View view){

        EditText text = (EditText)findViewById(R.id.token_validar);
        String token_validar = text.getText().toString();

        int token_validar_int = Integer.parseInt(token_validar);

        String uid = FirebaseAuth.getInstance().getUid();
        int valuee = Integer.parseInt(uid.replaceAll("[^0-9]", ""));

        // below, %02d says to java that I want my integer to be formatted as a 2 digit representation
        String temp = String.format("%2d", valuee);
        // and if you want to do the reverse
        int i = Integer.parseInt(temp);

        long num = i;
        int n = 2;
        long token_real = (long) (num / Math.pow(10, Math.floor(Math.log10(num)) - n + 1));

        if(token_real == token_validar_int){

            int token_int = (int) token_real;
            //GRAVAR TODOS OS DADOS NO FIREBASE

            String uidd = FirebaseAuth.getInstance().getUid();





            Usuario usuario =  new Usuario(uidd,email,token_int,nomediretor);

            FirebaseFirestore.getInstance().collection("usuario").document(uid).set(usuario);





            FirebaseFirestore.getInstance().collection("usuario").document(uidd).set(usuario);

            Toast.makeText(ConfirmarActivity.this,"ACERTOU O TOKEN! VALIDAMOS SEU VOTO" , Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(ConfirmarActivity.this,"ERROU!" + nomediretor , Toast.LENGTH_SHORT).show();
        }




    }



}