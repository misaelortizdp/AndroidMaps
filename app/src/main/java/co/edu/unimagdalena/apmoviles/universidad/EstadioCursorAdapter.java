package co.edu.unimagdalena.apmoviles.universidad;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class EstadioCursorAdapter extends CursorAdapter {
    public EstadioCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.fila_estadio,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtid = view.findViewById(R.id.txtid);
        TextView txtnombre = view.findViewById(R.id.txtnombre);
        TextView txtdepartamento = view.findViewById(R.id.txtdepartamento);
        TextView txtciudad = view.findViewById(R.id.txtciudad);
        TextView txtcapacidad = view.findViewById(R.id.txtcapacidad);
        TextView txtdireccion = view.findViewById(R.id.txtdireccion);
        TextView txtlatitud = view.findViewById(R.id.txtlatitud);
        TextView txtlongitud = view.findViewById(R.id.txtlongitud);

        String id = cursor.getString(0);
        String nombre = cursor.getString(1);
        String departamento = cursor.getString(2);
        String ciudad = cursor.getString(3);
        String capacidad = cursor.getString(4);
        String direccion = cursor.getString(5);
        String latitud = cursor.getString(6);
        String longitud = cursor.getString(7);

        txtid.setText(id);
        txtnombre.setText(nombre);
        txtdepartamento.setText(departamento);
        txtciudad.setText(ciudad);
        txtcapacidad.setText(capacidad);
        txtdireccion.setText(direccion);
        txtlatitud.setText(latitud);
        txtlongitud.setText(longitud);

    }
}
