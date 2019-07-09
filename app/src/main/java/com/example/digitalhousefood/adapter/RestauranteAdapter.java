package com.example.digitalhousefood.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalhousefood.R;
import com.example.digitalhousefood.interfaces.RestauranteListener;
import com.example.digitalhousefood.model.Restaurante;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RestauranteAdapter extends RecyclerView.Adapter<RestauranteAdapter.ViewHolder> {

    private List<Restaurante> listaDeRestaurantes;
    private RestauranteListener restauranteListener;

    public RestauranteAdapter(List<Restaurante> listaDeRestaurantes, RestauranteListener restauranteListener) {
        this.listaDeRestaurantes = listaDeRestaurantes;
        this.restauranteListener = restauranteListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.restaurante_celula, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Restaurante restaurante = listaDeRestaurantes.get(i);
        viewHolder.setupRestaurante(restaurante);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restauranteListener.onRestauranteClicado(restaurante);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaDeRestaurantes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nomeTextView;
        private TextView enderecoTextView;
        private TextView horarioTextView;
        private ImageView fotoImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeTextView = itemView.findViewById(R.id.nome_restaurante_text_view);
            enderecoTextView = itemView.findViewById(R.id.endereco_restaurante_text_view);
            horarioTextView = itemView.findViewById(R.id.horario_restaurante_text_view);
            fotoImageView = itemView.findViewById(R.id.foto_restaurante_image_view);
        }
        public void setupRestaurante(Restaurante restaurante){
            nomeTextView.setText(restaurante.getNomeRestaurante());
            enderecoTextView.setText(restaurante.getEnderecoRestaurante());
            horarioTextView.setText(restaurante.getHorarioRestaurante());
            Picasso.get().load(restaurante.getFotoRestaurante()).into(fotoImageView);
        }
    }
}
