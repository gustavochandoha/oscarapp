package com.example.oscarapp.ViewHolder;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oscarapp.R;

public class VHolderListaFilme extends RecyclerView.ViewHolder {

    public ImageView imagemLista;
    public TextView textoListaNome, textoListaGenero;

    public VHolderListaFilme(@NonNull View itemView) {
        super(itemView);

        imagemLista = itemView.findViewById(R.id.imagemLista);
        textoListaNome = itemView.findViewById(R.id.textoListaNome);
        textoListaGenero = itemView.findViewById(R.id.textoListaGenero);
    }

}