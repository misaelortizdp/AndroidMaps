package co.edu.unimagdalena.apmoviles.universidad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EdicionActivity extends AppCompatActivity {

    EditText txtid, nombre, departamento, ciudad, capacidad, direccion, latitud, longitud;
    TextView mensajeError;
    Button actualizar, eliminar, regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicion);
        Intent i = getIntent();

        String id = i.getStringExtra("id");
        String nom = i.getStringExtra("nombre");
        String dep = i.getStringExtra("departamento");
        final String ciud = i.getStringExtra("ciudad");
        String cap = i.getStringExtra("capacidad");
        String direc = i.getStringExtra("direccion");
        String lati = i.getStringExtra("latitud");
        String longi = i.getStringExtra("longitud");


        txtid = findViewById(R.id.edtid);
        nombre = findViewById(R.id.edtnombre);
        departamento = findViewById(R.id.edtdepartamento);
        ciudad = findViewById(R.id.edtciudad);
        capacidad = findViewById(R.id.edtcapacidad);
        direccion = findViewById(R.id.edtdireccion2);
        latitud = findViewById(R.id.edtlatitud2);
        longitud = findViewById(R.id.edtlongitud2);

        actualizar = findViewById(R.id.btnactualizar);
        eliminar = findViewById(R.id.btneliminar);
        regresar = findViewById(R.id.btnregresar);


        txtid.setText(id);

        txtid.setEnabled(false);
        nombre.setText(nom);
        departamento.setText(dep);
        ciudad.setText(ciud);
        capacidad.setText(cap);
        direccion.setText(direc);
        latitud.setText(lati);
        longitud.setText(longi);


        mensajeError = findViewById(R.id.textViewMensajeError);

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EstadioController ec = new EstadioController(getApplication());
                ec.eliminarEstadio(Integer.parseInt(txtid.getText().toString()));
                Intent i = new Intent(getApplicationContext(),ListadoActivity.class);
                startActivity(i);
                finish();
            }
        });
        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mensajeError.setText("");
                if(TextUtils.isEmpty(txtid.getText().toString()) || TextUtils.isEmpty(ciudad.getText().toString()) || TextUtils.isEmpty(nombre.getText().toString()) ||
                        TextUtils.isEmpty(departamento.getText().toString()) || TextUtils.isEmpty(capacidad.getText().toString()) ||
                        TextUtils.isEmpty(direccion.getText().toString()) || TextUtils.isEmpty(latitud.getText().toString()) || TextUtils.isEmpty(longitud.getText().toString()) ){


                    mensajeError.setText("No pueden haber casillas vacias");

                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

                }else {
                    Estadio estadio = new Estadio(Integer.parseInt(txtid.getText().toString()), nombre.getText().toString(), departamento.getText().toString(),
                            ciudad.getText().toString(), Integer.parseInt(capacidad.getText().toString()),
                            direccion.getText().toString(), latitud.getText().toString(), longitud.getText().toString());

                    EstadioController estadioController = new EstadioController(getApplication());
                    estadioController.actualizarEstadio(estadio);
                    Intent i = new Intent(getApplicationContext(), ListadoActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ListadoActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}