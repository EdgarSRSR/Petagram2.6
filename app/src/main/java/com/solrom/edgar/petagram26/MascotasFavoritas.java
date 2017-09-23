package com.solrom.edgar.petagram26;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public MascotaAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascotas_favoritas);

        Toolbar toolbar = (Toolbar) findViewById(R.id.miToolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        //ajusta la forma en que se ve la lista
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //Lhace que el RecyclerView se comporte como un LinearLayoutManager con todo y propiedades
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializaAdaptador();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //infla el menu
        getMenuInflater().inflate(R.menu.menu_mascotasfavoritas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item_menu) {
        int id = item_menu.getItemId(); // obtiene el item de cada item del menu
        if (id == R.id.salir) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item_menu);
    }

    public void inicializaAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Hachiko", 0, R.drawable.shibainu, R.color.colorBlanco));
        mascotas.add(new Mascota("Pilón", 0, R.drawable.schnauzer_black, R.color.colorBlanco));
        mascotas.add(new Mascota("Toby", 0, R.drawable.schnauzer_blackandpepper, R.color.colorBlanco));
        mascotas.add(new Mascota("Kiby", 0, R.drawable.hamster, R.color.colorBlanco));
        mascotas.add(new Mascota("Mu", 0, R.drawable.mouse, R.color.colorBlanco));
    }
}