package co.edu.unimagdalena.apmoviles.universidad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Estadio estadio;
    EstadioController estadioController;
    EditText ciudad, nombre, departamento, capacidad, txtid, direccion, latitud, longitud;
    Button agregar, mostrar, mapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregar = findViewById(R.id.btnguardar);
        mostrar = findViewById(R.id.btnlistado);
        mapa = findViewById(R.id.btnvermapa);

        txtid = findViewById(R.id.edtcodigo);
        ciudad = findViewById(R.id.edtciudad);
        nombre = findViewById(R.id.edtnombre);
        capacidad = findViewById(R.id.edtcapacidad);
        departamento = findViewById(R.id.edtdepartamento);
        direccion = findViewById(R.id.edtdireccion);
        latitud = findViewById(R.id.edtlatitud);
        longitud = findViewById(R.id.edtlongitud);

        agregar.setOnClickListener(this);
        mostrar.setOnClickListener(this);
        mapa.setOnClickListener(this);

        estadioController = new EstadioController(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnguardar:
               if(TextUtils.isEmpty(txtid.getText().toString()) || TextUtils.isEmpty(ciudad.getText().toString()) || TextUtils.isEmpty(nombre.getText().toString()) ||
                  TextUtils.isEmpty(departamento.getText().toString()) || TextUtils.isEmpty(capacidad.getText().toString()) ||
                  TextUtils.isEmpty(direccion.getText().toString()) || TextUtils.isEmpty(latitud.getText().toString()) || TextUtils.isEmpty(longitud.getText().toString()) ){

                    Toast.makeText(this,"No pueden haber casillas vacias", Toast.LENGTH_LONG).show();

               }else{
                    estadio = new Estadio(Integer.parseInt(txtid.getText().toString()), nombre.getText().toString(), departamento.getText().toString(), ciudad.getText().toString(),
                            Integer.parseInt(capacidad.getText().toString()),
                            direccion.getText().toString(), latitud.getText().toString(), longitud.getText().toString());

                    if (estadioController.buscarEstadio(estadio)){
                        Toast.makeText(this,"Código ya existe", Toast.LENGTH_LONG).show();
                    }
                    else{
                        estadioController.agregarEstadio(estadio);

                        txtid.setText("");
                        nombre.setText("");
                        departamento.setText("");
                        ciudad.setText("");
                        capacidad.setText("");
                        direccion.setText("");
                        latitud.setText("");
                        longitud.setText("");
                    }
               }
                break;
            case R.id.btnlistado:
                Intent i = new Intent(this, ListadoActivity.class);
                startActivity(i);
                break;
            case R.id.btnvermapa:
                Intent j = new Intent(this, MapsActivity.class);
                startActivity(j);
                break;
        }
    }


}
