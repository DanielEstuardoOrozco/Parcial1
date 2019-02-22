package com.example.parcial1;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class CancionesAdapter extends ArrayAdapter<Canciones> {

    private List<Canciones> lista;
    private Context context;
    private int layout;

    public CancionesAdapter(@NonNull Context context, @NonNull List<Canciones> objects) {
        super(context, R.layout.item_list, objects);
        this.lista = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null){
            LayoutInflater li = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.item_list, null);
        }
        if (lista.get(position) != null){
            TextView version, nombre;
            ImageView imagen;
            LinearLayout fondo;

            nombre = v.findViewById(R.id.lb_nombre);
            version = v.findViewById(R.id.lb_version);
            imagen = v.findViewById(R.id.iv_imagen);
            fondo = v.findViewById(R.id.ll_fondo);
            nombre.setText(lista.get(position).getNombre());
            version.setText(lista.get(position).getVersion());

            switch (lista.get(position).getGenero()){
                case "ROCK":
                    imagen.setImageResource(R.drawable.rock);
                    break;
                case "METAL":
                    imagen.setImageResource(R.drawable.metal);
                    break;
                case "POP":
                    imagen.setImageResource(R.drawable.pop);
                    break;
            }
            switch (lista.get(position).getVersion()){
                case "VIVO":
                    fondo.setBackgroundColor(Color.parseColor("#1967E5"));
                    break;
                case "ESPECIAL":
                    imagen.setImageResource(R.drawable.metal);
                    fondo.setBackgroundColor(Color.parseColor("#74E518"));
                    break;
                case "NORMAL":
                    imagen.setImageResource(R.drawable.pop);
                    fondo.setBackgroundColor(Color.parseColor("#A118E5"));
                    break;
            }
        }
        return v;
    }

}
