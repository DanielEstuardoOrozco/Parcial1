package com.example.parcial1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText nombre;
    private RadioButton rock, pop, metal;
    private Spinner version;
    private Button guardar;
    private ListView lista;
    private List<Versiones> lista_versiones;
    private List<Canciones> lista_canciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.txt_nombre);
        rock = findViewById(R.id.rb_rock);
        pop = findViewById(R.id.rb_pop);
        metal = findViewById(R.id.rb_metal);
        version = findViewById(R.id.sn_version);
        guardar = findViewById(R.id.bt_guardar);
        lista = findViewById(R.id.lv_canciones);

        lista_canciones = new ArrayList<Canciones>();
        lista_versiones = new ArrayList<Versiones>();
        guardar.setOnClickListener(this);

        Versiones tmp = new Versiones();
        tmp.setVersion("En Vivo");
        lista_versiones.add(tmp);

        tmp = new Versiones();
        tmp.setVersion("En Especial");
        lista_versiones.add(tmp);

        tmp = new Versiones();
        tmp.setVersion("Normal");
        lista_versiones.add(tmp);

        version.setAdapter(new VersionesAdapter(this, lista_versiones));

    }
    @Override
    public void onClick(View v) {
        Canciones tmp = new Canciones();

        tmp.setNombre(nombre.getText().toString());
        if (rock.isChecked()) { tmp.setGenero("ROCK"); }
        if (pop.isChecked()) { tmp.setGenero("POP"); }
        if (metal.isChecked()) { tmp.setGenero("METAL"); }
        switch  (version.getSelectedItemPosition()){
            case 0:
                tmp.setVersion("VIVO");
                break;
            case 1:
                tmp.setVersion("ESPECIAL");
                break;
            case 2:
                tmp.setVersion("NORMAL");
                break;
        }





        lista_canciones.add(tmp);
        lista.setAdapter(new CancionesAdapter(this, lista_canciones));

    }
}
