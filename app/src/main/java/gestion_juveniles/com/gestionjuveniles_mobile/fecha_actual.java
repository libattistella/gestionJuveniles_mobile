package gestion_juveniles.com.gestionjuveniles_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import gestion_juveniles.com.gestionjuveniles_mobile.Modelo.Jugador;
import gestion_juveniles.com.gestionjuveniles_mobile.Modelo.Profesor;
import gestion_juveniles.com.gestionjuveniles_mobile.Repositorio.BuscarEquipoTask;

public class Fecha_Actual extends AppCompatActivity {

    private ListView listaJugadores;
    private Profesor prof;
    private List<Jugador> formacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fecha_actual);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        formacion= new ArrayList<>();
        listaJugadores= (ListView) findViewById(R.id.listaJugadores);

}

    @Override
    protected void onStart() {
        super.onStart();
        boolean cargado = equipocargado();

        if(cargado)
            new BuscarEquipoTask(Fecha_Actual.this).execute(prof);

        }else{


        }
        adapter_equipo = new DepartamentoAdapter(ListaDepartamentosActivity.this,lista);
        listaAlojamientos.setAdapter(departamentosAdapter);
    }

    arquero = (TextView) findViewById(R.id.arquero);
    arquero.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Fecha_Actual.this);

            final CharSequence[] items = new CharSequence[3];

            items[0] = "Lucia";
            items[1] = "Nicolas";
            items[2] = "Sebastian";

            builder.setMessage("Elige solo una opción:")
                    .setItems(items,new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog,int i){
                            Log.i("Click", "click en el elemento " +i + " de mi ListView");
                        }
                    })
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }
    });

}