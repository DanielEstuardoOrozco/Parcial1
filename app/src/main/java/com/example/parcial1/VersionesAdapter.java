package com.example.parcial1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class VersionesAdapter  extends ArrayAdapter<Versiones> {

    private List<Versiones> lista;
    private Context context;
    private int layout;

    public VersionesAdapter( Context context,  List<Versiones> objects) {
        super(context, R.layout.version_list, objects);
        this.lista = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null){
            LayoutInflater li = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.version_list, null);
        }
        if (lista.get(position) != null){
            TextView version;
            version = v.findViewById(R.id.lb_nombre_version);
            version.setText(lista.get(position).getVersion());
        }
        return v;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null){
            LayoutInflater li = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.version_list, null);
        }
        if (lista.get(position) != null){
            TextView version;
            version = v.findViewById(R.id.lb_nombre_version);
            version.setText(lista.get(position).getVersion());
        }
        return v;

    }
}
