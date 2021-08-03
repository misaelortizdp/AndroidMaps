package co.edu.unimagdalena.apmoviles.universidad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

public class ListadoActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    ListView listado;
    EstadioController estadioController;
    SearchView filter;
    EstadioCursorAdapter adapter;
    private BaseDatos bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        listado = findViewById(R.id.lstlistado);
        filter = findViewById(R.id.svfilter);
        estadioController = new EstadioController(this);
        Cursor c = estadioController.allEstadios2();
        adapter = new EstadioCursorAdapter(this,c,false);
        listado.setAdapter(adapter);
        listado.setTextFilterEnabled(true);

        adapter.setFilterQueryProvider(new FilterQueryProvider() {
            @Override
            public Cursor runQuery(CharSequence constraint) {
                return estadioController.filtrarHotel(constraint);
            }
        });
        filter.setOnQueryTextListener(this);

        //ocultar teclado
        //Termina de ocultar teclado
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txtid = view.findViewById(R.id.txtid);
                TextView nombre = view.findViewById(R.id.txtnombre);
                TextView departamento = view.findViewById(R.id.txtdepartamento);
                TextView ciudad = view.findViewById(R.id.txtciudad);
                TextView capacidad = view.findViewById(R.id.txtcapacidad);
                TextView direccion = view.findViewById(R.id.txtdireccion);
                TextView latitud = view.findViewById(R.id.txtlatitud);
                TextView longitud = view.findViewById(R.id.txtlongitud);

                Intent i = new Intent(getApplicationContext(), EdicionActivity.class);
                i.putExtra("id", txtid.getText().toString());
                i.putExtra("nombre", nombre.getText().toString());
                i.putExtra("departamento", departamento.getText().toString());
                i.putExtra("ciudad", ciudad.getText().toString());
                i.putExtra("capacidad", capacidad.getText().toString());
                i.putExtra("direccion", direccion.getText().toString());
                i.putExtra("latitud", latitud.getText().toString());
                i.putExtra("longitud", longitud.getText().toString());
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.i("search", newText);
        String text = newText;
        adapter.getFilter().filter(newText);
        adapter.notifyDataSetChanged();
        return false;
    }
}
