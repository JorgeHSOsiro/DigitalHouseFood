package com.example.digitalhousefood.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalhousefood.R;
import com.example.digitalhousefood.model.Prato;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PratoAdapter extends RecyclerView.Adapter<PratoAdapter.ViewHolder> {

    private List<Prato> listaDePratos;

    public PratoAdapter(List<Prato> listaDePratos) {
        this.listaDePratos = listaDePratos;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.prato_celula,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Prato prato = listaDePratos.get(i);
        viewHolder.setupPrato(prato);

    }

    @Override
    public int getItemCount() {
        return listaDePratos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView fotoPratoImageView;
        private TextView nomePratoTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoPratoImageView = itemView.findViewById(R.id.foto_prato_cardapio_image_view);
            nomePratoTextView = itemView.findViewById(R.id.nome_prato_cardapio_text_view);
        }
        public void setupPrato(Prato prato){
            nomePratoTextView.setText(prato.getNomePrato());
            Picasso.get().load(prato.getFotoPrato()).into(fotoPratoImageView);
        }
    }
}
