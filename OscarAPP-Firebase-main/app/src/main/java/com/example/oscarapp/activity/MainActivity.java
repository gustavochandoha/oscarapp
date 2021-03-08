package com.example.oscarapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.oscarapp.R;

public class MainActivity extends AppCompatActivity {

    private Button btnDiretor,btnFilmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startComponent();
        eventoClickbtn();
    }

    private void alert(String s) {
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    private void startComponent() {
//        emailUser = (EditText) findViewById(R.id.emailUser);
//        senhaUser = (EditText) findViewById(R.id.senhaUser);
        btnDiretor = (Button) findViewById(R.id.btnDiretor);
        btnFilmes = (Button) findViewById(R.id.btnFilme);
//       txtResetSenha = (Button) findViewById(R.id);
    }

    private void eventoClickbtn() {
        btnDiretor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DiretorActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnFilmes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListaFilme.class);
                startActivity(i);
                finish();
            }
        });

    }


}