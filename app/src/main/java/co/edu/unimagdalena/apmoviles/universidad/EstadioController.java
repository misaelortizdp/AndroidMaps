package co.edu.unimagdalena.apmoviles.universidad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class EstadioController {
    private BaseDatos bd;
    private Context c;
    public EstadioController(Context c) {
        this.bd = new BaseDatos(c,1);
        this.c = c;
    }
    public void agregarEstadio(Estadio e){
        try {
            SQLiteDatabase sql = bd.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(DefBD.col_id, e.getId());//Nuevo
            values.put(DefBD.col_capacidad, e.getCapacidad());
            values.put(DefBD.col_nombre, e.getNombre());
            values.put(DefBD.col_departamento, e.getDepartamento());
            values.put(DefBD.col_ciudad, e.getCiudad());
            values.put(DefBD.col_direccion, e.getDireccion());//nuevo
            values.put(DefBD.col_latitud, e.getLatitud());//nuevo
            values.put(DefBD.col_longitud, e.getLongitud());//nuevo
            long id = sql.insert(DefBD.tabla_estadio, null, values);

            Toast.makeText(c, "Estadio registrado", Toast.LENGTH_LONG).show();
        }
        catch(Exception ex){
            Toast.makeText(c, "Error agregando Estadio " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public boolean buscarEstadio(Estadio e){
        String args[] = new String[] {"" + e.getId()};
        String[] columnas = {DefBD.col_id,DefBD.col_nombre};
        String col[] = new String[] {DefBD.col_id,DefBD.col_nombre};
        SQLiteDatabase sql = bd.getReadableDatabase();
      Cursor c = sql.query(DefBD.tabla_estadio,null,"id=?",args,null,null,null);
        if (c.getCount()>0){
            bd.close();
            return true;
        }
        else{
            bd.close();
            return false;
        }
    }

    public Cursor allEstadios(){
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
 Cursor c = sql.query(DefBD.tabla_estadio,null,null,null,null,null,null);
            return c;
        }
        catch (Exception ex){
            Toast.makeText(c, "Error consulta Estadio " + ex.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }
    }

    public Cursor allEstadios2(){
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
            Cursor cur = sql.rawQuery("select id as _id , nombre, departamento, ciudad, capacidad, direccion, latitud, longitud from estadio", null);
            return cur;
        }
        catch (Exception ex){
            Toast.makeText(c, "Error consulta Estadios " + ex.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }
    }

    public void eliminarEstadio(int id){
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
            String[] args = {""+id};
           sql.delete(DefBD.tabla_estadio,"id=?",args);
            Toast.makeText(c, "Estadio eliminado", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex){
            Toast.makeText(c, "Error al eliminar estadio " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void actualizarEstadio(Estadio e){
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
            String[] args = {""+e.getId()};
            ContentValues valores = new ContentValues();

            valores.put(DefBD.col_nombre, e.getNombre());
            valores.put(DefBD.col_departamento, e.getDepartamento());
            valores.put(DefBD.col_ciudad, e.getCiudad());
            valores.put(DefBD.col_capacidad, e.getCapacidad());
            valores.put(DefBD.col_direccion, e.getDireccion());//nuevo
            valores.put(DefBD.col_latitud, e.getLatitud());//nuevo
            valores.put(DefBD.col_longitud, e.getLongitud());//nuevo
            sql.update(DefBD.tabla_estadio,valores,"id=?",args);
            Toast.makeText(c, "Estadio actualizado", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex){
            Toast.makeText(c, "Error al actualizar Estadio  " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public Cursor filtrarHotel(CharSequence filtro){
        SQLiteDatabase sql = bd.getWritableDatabase();
        String query = "SELECT id as _id, nombre, departamento, ciudad, estrellas, direccion, latitud, longitud FROM hotel "
                + "where departamento like '%" + filtro + "%' or ciudad like '%" + filtro + "%' or estrellas like '%" + filtro + "%'"
                + "ORDER BY nombre ASC";

        return  sql.rawQuery(query, null);

    }
   }


