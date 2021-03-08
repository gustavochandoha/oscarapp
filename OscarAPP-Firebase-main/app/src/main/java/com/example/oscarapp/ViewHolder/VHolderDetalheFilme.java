package com.example.oscarapp.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oscarapp.R;

public class VHolderDetalheFilme extends RecyclerView.ViewHolder {

    public ImageView imagemDetalhe;
    public TextView textoDetalheNome, textoDetalheGenero;

    public VHolderDetalheFilme(@NonNull View itemView) {
        super(itemView);

        imagemDetalhe = itemView.findViewById(R.id.imagemDetalhe);
        textoDetalheNome = itemView.findViewById(R.id.textoDetalheNome);
        textoDetalheGenero = itemView.findViewById(R.id.textoDetalheGenero);
    }

}
