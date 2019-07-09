package com.example.digitalhousefood;

import android.content.Intent;
import android.os.Bundle;

import com.example.digitalhousefood.adapter.RestauranteAdapter;
import com.example.digitalhousefood.interfaces.RestauranteListener;
import com.example.digitalhousefood.model.Restaurante;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements RestauranteListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<Restaurante> listaDeRestaurantes = new ArrayList<>();

        Restaurante restaurante1 = new Restaurante();
        restaurante1.setNomeRestaurante("Tony Roma's");
        restaurante1.setEnderecoRestaurante("Av. Lavandisca,717 - Indianopolis, Sao Paulo");
        restaurante1.setHorarioRestaurante("Fecha as 22:30 ");
        restaurante1.setFotoRestaurante("https://cdn0.tnwcdn.com/wp-content/blogs.dir/1/files/2012/10/Food.jpg");
        listaDeRestaurantes.add(restaurante1);

        Restaurante restaurante2 = new Restaurante();
        restaurante2.setNomeRestaurante("Aoyama - Moema");
        restaurante2.setEnderecoRestaurante("Alameda dos Arapanes,532 - Moema Sao Paulo");
        restaurante2.setHorarioRestaurante("Fecha as 00:00 ");
        restaurante2.setFotoRestaurante("https://www.jornalspnorte.com.br/enviados/2018/12/141218_aoyama-2.jpg");
        listaDeRestaurantes.add(restaurante2);

        Restaurante restaurante3 = new Restaurante();
        restaurante3.setNomeRestaurante("Outback - Moema");
        restaurante3.setEnderecoRestaurante("Av. Moaci,187 - Moema, Sao Paulo");
        restaurante3.setHorarioRestaurante("Fecha as 23:30 ");
        restaurante3.setFotoRestaurante("https://www.goodfood.com.au/content/dam/images/h/0/f/a/q/i/image.related.wideLandscape.940x529.h0fa4n.png/1515456591895.jpg");
        listaDeRestaurantes.add(restaurante3);

        Restaurante restaurante4 = new Restaurante();
        restaurante4.setNomeRestaurante("Si Señor");
        restaurante4.setEnderecoRestaurante("Alameda Jauaperi,626 - Moema, Sao Paulo");
        restaurante4.setHorarioRestaurante("Fecha as 01:00 ");
        restaurante4.setFotoRestaurante("https://cdn0.tnwcdn.com/wp-content/blogs.dir/1/files/2012/10/Food.jpg");
        listaDeRestaurantes.add(restaurante4);

        RestauranteAdapter restauranteAdapter = new RestauranteAdapter(listaDeRestaurantes, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = findViewById(R.id.restaurante_recycler_view);
        recyclerView.setAdapter(restauranteAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRestauranteClicado(Restaurante restaurante) {

        Intent intent = new Intent(this, RestauranteCardapioActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("RESTAURANTE",restaurante);

        intent.putExtras(bundle);
        startActivity(intent);

    }
}
