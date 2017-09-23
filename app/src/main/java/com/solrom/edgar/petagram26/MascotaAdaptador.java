package com.solrom.edgar.petagram26;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by administrador on 08/05/17.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;
    int likes;


    // Constructor
    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    // Método que infla el layout y lo pasa al ViewHolder para que obtenga los views
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }


    // Se cargan los datos de la clase MascotaViewHolder con los datos de la lista
    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position){
        final Mascota mascota = mascotas.get(position); //Obtiene los datos de la mascota en la posición position
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());// carga el cardView con la foto del ArrayList
        mascotaViewHolder.tvNumLikes.setText(Integer.toString(mascota.getNumLikes()));// carga el Número de likes del cardView
        mascotaViewHolder.tvNombre.setText(mascota.getNombre()); // carga el nombre de la mascota sacado del Arraylist
        mascotaViewHolder.llCardView.setBackgroundResource(mascota.getColorFondo()); // carga el color del fondo aunque a todas les puse el mismo color


        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ( likes == 0 ) {

                    likes = (mascota.getNumLikes()+1);
                }else {
                    likes ++;
                }

                mascotaViewHolder.tvNumLikes.setText(Integer.toString(likes));

                Toast.makeText(activity, "Diste like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount(){
        return mascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private ImageButton btnLike;
        private TextView tvNombre;
        private TextView tvNumLikes;

        private LinearLayout llCardView;

        // Constructor
        public MascotaViewHolder(View itemView){
            super(itemView);
            // Cargo las vistas del cardview
            this.imgFoto    = (ImageView) itemView.findViewById(R.id.imgFoto);
            this.btnLike    = (ImageButton) itemView.findViewById(R.id.btnLike);
            this.tvNombre   = (TextView) itemView.findViewById(R.id.tvNombre);
            this.tvNumLikes = (TextView) itemView.findViewById(R.id.tvNumLikes);

            this.llCardView = (LinearLayout) itemView.findViewById(R.id.llCardView);
        }

    }
}
