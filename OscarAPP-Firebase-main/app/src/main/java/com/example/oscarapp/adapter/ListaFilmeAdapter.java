package com.example.oscarapp.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oscarapp.Filme;
import com.example.oscarapp.R;
import com.example.oscarapp.ViewHolder.VHolderDetalheFilme;
import com.example.oscarapp.ViewHolder.VHolderListaFilme;
import com.example.oscarapp.activity.DetalheFilme;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListaFilmeAdapter extends RecyclerView.Adapter<VHolderListaFilme> {

    public List<Filme> listaFilmeAdapter;

    public ListaFilmeAdapter(List<Filme> array) {
        this.listaFilmeAdapter = array; System.out.println(array.size());
    }

    @NonNull
    @Override
    public VHolderListaFilme onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VHolderListaFilme(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listacell, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VHolderListaFilme holder, int position) {
        Filme filme = listaFilmeAdapter.get(holder.getAdapterPosition());

        holder.textoListaNome.setText("Nome: \n" + filme.getNome());
        holder.textoListaGenero.setText("Genero: \n" + filme.getGenero());

        Picasso.get().load(filme.getFoto()).resize(340, 340).into(holder.imagemLista);

        /*holder.imagemLista.setOnClickListener(
                view -> abrirDetalhes(Filme filme);
        );*/
    }

    private void abrirDetalhes(Filme filme) {
        /*Intent intent = new Intent(this, DetalheFilme);
        intent.putExtra("nome", filme.getNome());
        intent.putExtra("genero", filme.getGenero());
        intent.putExtra("foto", filme.getFoto());*/
    }


    @Override
    public int getItemCount() {
        return listaFilmeAdapter != null ? listaFilmeAdapter.size() : 0;
    }


}
