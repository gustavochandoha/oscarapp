package com.example.oscarapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oscarapp.Filme;
import com.example.oscarapp.R;
import com.example.oscarapp.ViewHolder.VHolderDetalheFilme;
import com.squareup.picasso.Picasso;

import java.util.List;


public class DetalheFilmeAdapter extends RecyclerView.Adapter<VHolderDetalheFilme> {

    public List<Filme> detalheFilmeAdapter;

    public DetalheFilmeAdapter(List<Filme> array) {
        this.detalheFilmeAdapter = array; System.out.println(array.size());
    }

    @NonNull
    @Override
    public VHolderDetalheFilme onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VHolderDetalheFilme(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.detalhecell, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VHolderDetalheFilme holder, int position) {
        Filme filme = detalheFilmeAdapter.get(holder.getAdapterPosition());

        holder.textoDetalheNome.setText("Nome: \n" + filme.getNome());
        holder.textoDetalheGenero.setText("Genero: \n" + filme.getGenero());
        Picasso.get().load(filme.getFoto()).resize(680, 680).into(holder.imagemDetalhe);
    }

    @Override
    public int getItemCount() {
        return detalheFilmeAdapter != null ? detalheFilmeAdapter.size() : 0;
    }

}
