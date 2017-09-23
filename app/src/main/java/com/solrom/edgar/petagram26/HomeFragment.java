package com.solrom.edgar.petagram26;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.solrom.edgar.petagram26.R;

import java.util.ArrayList;

/**
 * Created by administrador on 17/05/17.
 */

public class HomeFragment extends Fragment{

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public MascotaAdaptador adaptador;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //    asigna clase java al layout
        View v = inflater.inflate(R.layout.fragment_home , container, false);
        //return super.onCreateView(inflater, container, savedInstanceState);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        // Instacia el linearLayoutManager que sirve para manejar la forma en que se ve la lista
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //el RecyclerView se comportará como un LinearLayoutManager y adquirirá todas sus propiedades
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas(); // Inicializa la lista de mascotas
        inicializaAdaptador();    // Inicializa el adaptador
        return v;
    }


    // Inicializa el adaptador
    public void inicializaAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }


    // Carga las mascotas para mostrarlas
    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Hachiko", 0, R.drawable.shibainu, R.color.colorBlanco));
        mascotas.add(new Mascota("Pilón", 0, R.drawable.schnauzer_black, R.color.colorBlanco));
        mascotas.add(new Mascota("Toby", 0, R.drawable.schnauzer_blackandpepper, R.color.colorBlanco));
        mascotas.add(new Mascota("Kiby", 0, R.drawable.hamster, R.color.colorBlanco));
        mascotas.add(new Mascota("Mu", 0, R.drawable.mouse, R.color.colorBlanco));
    }
}