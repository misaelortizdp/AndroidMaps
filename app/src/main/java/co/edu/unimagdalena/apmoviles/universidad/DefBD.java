package co.edu.unimagdalena.apmoviles.universidad;


    public class DefBD {
        public static final String nameDb = "Estadios";
        public static final String tabla_estadio = "estadio";
        public static final String col_id = "id";
        public static final String col_departamento = "departamento";
        public static final String col_nombre = "nombre";
        public static final String col_ciudad = "ciudad";
        public static final String col_capacidad = "capacidad";
        public static final String col_direccion = "direccion";
        public static final String col_latitud = "latitud";
        public static final String col_longitud = "longitud";

        public static final String create_tabla_est = "CREATE TABLE IF NOT EXISTS " + DefBD.tabla_estadio + " ( " +
                //DefBD.col_id + " integer primary key autoincrement," +
                DefBD.col_id + " integer," +
                DefBD.col_nombre + " text," +
                DefBD.col_departamento + " text," +
                DefBD.col_capacidad + " integer," +
                DefBD.col_ciudad + " text," +
                DefBD.col_direccion + " text," +
                DefBD.col_latitud + " real," +
                DefBD.col_longitud + " real" +
                ");";


}
