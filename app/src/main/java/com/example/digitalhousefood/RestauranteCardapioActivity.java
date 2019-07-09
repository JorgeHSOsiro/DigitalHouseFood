package com.example.digitalhousefood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.digitalhousefood.adapter.PratoAdapter;
import com.example.digitalhousefood.model.Prato;
import com.example.digitalhousefood.model.Restaurante;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RestauranteCardapioActivity extends AppCompatActivity {

    private TextView nomeRestauranteTextView;
    private ImageView fotoRestauranteImageView;
    private ImageButton botaoVoltarImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante_cardapio);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        Restaurante restaurante =(Restaurante) bundle.getSerializable("RESTAURANTE");

        nomeRestauranteTextView = findViewById(R.id.nome_restaurante_cardapio_text_view);
        fotoRestauranteImageView = findViewById(R.id.foto_restaurante_detalhes_image_view);

        nomeRestauranteTextView.setText(restaurante.getNomeRestaurante());
        Picasso.get().load(restaurante.getFotoRestaurante()).into(fotoRestauranteImageView);

        List<Prato>listaDePratos = new ArrayList<>();

        Prato prato1 = new Prato();
        prato1.setNomePrato("Salada com Molho de Gengibre");
        prato1.setFotoPrato("https://www.mundoboaforma.com.br/wp-content/uploads/2017/12/molho-para-salada-620x312.jpg");
        prato1.setDescricaoPrato(getString(R.string.loren_ipsum));
        listaDePratos.add(prato1);
        listaDePratos.add(prato1);listaDePratos.add(prato1);listaDePratos.add(prato1);listaDePratos.add(prato1);listaDePratos.add(prato1);

        PratoAdapter pratoAdapter = new PratoAdapter(listaDePratos);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        RecyclerView recyclerView = findViewById(R.id.cardapio_recycler_view);
        recyclerView.setAdapter(pratoAdapter);
        recyclerView.setLayoutManager(layoutManager);

        botaoVoltarImageButton = findViewById(R.id.cardapio_voltar_image_button);
        botaoVoltarImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltarParaHome();

            }
        });

    }

    private void voltarParaHome() {
        Intent intent1 = new Intent(this, HomeActivity.class);
        startActivity(intent1);
    }
}
