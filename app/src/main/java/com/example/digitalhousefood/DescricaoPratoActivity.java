package com.example.digitalhousefood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.digitalhousefood.model.Prato;
import com.squareup.picasso.Picasso;

public class DescricaoPratoActivity extends AppCompatActivity {

    private TextView nomePratoTextView;
    private ImageView fotoPratoImageView;
    private TextView descricaoPratoTextView;
    private ImageButton voltarImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_prato);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Prato prato = (Prato) bundle.getSerializable("PRATO");

        nomePratoTextView = findViewById(R.id.nome_prato_desc_text_view);
        fotoPratoImageView = findViewById(R.id.foto_prato_desc_image_view);
        descricaoPratoTextView = findViewById(R.id.decricao_prato_text_view);

        nomePratoTextView.setText(prato.getNomePrato());
        descricaoPratoTextView.setText(prato.getDescricaoPrato());
        Picasso.get().load(prato.getFotoPrato()).into(fotoPratoImageView);

        voltarImageButton = findViewById(R.id.desc_voltar_image_button);
        voltarImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irParaCardapio();
            }
        });

    }

    private void irParaCardapio() {
        Intent intent1 = new Intent(this, RestauranteCardapioActivity.class);
        startActivity(intent1);
    }
}
