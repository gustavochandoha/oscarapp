package com.example.oscarapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.oscarapp.Filme;
import com.example.oscarapp.R;
import com.example.oscarapp.activity.ListaFilme;
import com.example.oscarapp.adapter.ListaFilmeAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DetalheFilme extends AppCompatActivity {

    RecyclerView rView;
    ListaFilmeAdapter aAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_filme);

        rView = findViewById(R.id.rViewListaFilme);

        RecyclerView.LayoutManager lManager = new LinearLayoutManager(getApplicationContext());
        rView.setLayoutManager(lManager);
        rView.setHasFixedSize(true);
        rView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));

    }
}