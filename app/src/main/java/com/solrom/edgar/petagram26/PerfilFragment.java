package com.solrom.edgar.petagram26;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaPerfiles;
    public PerfilAdaptador adaptador;


    public PerfilFragment() {
        // esto tiene que estar en blanco
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perfil , container, false);
        //infla el layout del fragment

        listaPerfiles = (RecyclerView) v.findViewById(R.id.rvPerfil);

        // activa GridLayoutManager esto sirve para manejar la forma en que se ve la lista
        GridLayoutManager glm = new GridLayoutManager(getContext(), 3);

        // RecyclerView se comportará como un LinearLayoutManager
        listaPerfiles.setLayoutManager(glm);
        inicializarListaMascotas();
        inicializaAdaptador();

        return v;
    }

    public void inicializaAdaptador(){
        adaptador = new PerfilAdaptador(mascotas, getActivity());
        listaPerfiles.setAdapter(adaptador);
    }


    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Toby", 2, R.drawable.schnauzer_blackandpepper, R.color.colorBlanco));
        mascotas.add(new Mascota("Toby", 5, R.drawable.schnauzer_blackandpepper, R.color.colorBlanco));
        mascotas.add(new Mascota("Toby", 3, R.drawable.schnauzer_blackandpepper, R.color.colorBlanco));
        mascotas.add(new Mascota("Toby", 6, R.drawable.schnauzer_blackandpepper, R.color.colorBlanco));
        mascotas.add(new Mascota("Toby", 9, R.drawable.schnauzer_blackandpepper, R.color.colorBlanco));
        mascotas.add(new Mascota("Toby", 10, R.drawable.schnauzer_blackandpepper, R.color.colorBlanco));
        mascotas.add(new Mascota("Toby", 3, R.drawable.schnauzer_blackandpepper, R.color.colorBlanco));
        mascotas.add(new Mascota("Toby", 1, R.drawable.schnauzer_blackandpepper, R.color.colorBlanco));
        mascotas.add(new Mascota("Toby", 4, R.drawable.schnauzer_blackandpepper, R.color.colorBlanco));
    }

}
