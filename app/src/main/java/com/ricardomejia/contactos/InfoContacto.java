package com.ricardomejia.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoContacto extends AppCompatActivity {


    Button btn2;
    TextView tv_nombre, tv_telefono, tv_email, tv_descripcion, tv_fecha ;
String nombre, telefono, email, descripcion, fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_contacto);

        Bundle parametros = getIntent().getExtras();
        nombre = parametros.getString(getResources().getString(R.string.nombre));
         telefono = parametros.getString(getResources().getString(R.string.telefono));
         email = parametros.getString(getResources().getString(R.string.email));
         descripcion = parametros.getString(getResources().getString(R.string.descripcion));
        String fecha1 = parametros.getString(getResources().getString(R.string.fecha));
        String fecha2 = parametros.getString(getResources().getString(R.string.fecha2));
        String fecha3 = parametros.getString(getResources().getString(R.string.fecha3));

         fecha = new StringBuilder().append(fecha1).append(fecha2).append(fecha3).toString();

        tv_nombre = findViewById(R.id.textView);
        tv_fecha = findViewById(R.id.textView2);
        tv_telefono = findViewById(R.id.textView3);
        tv_email = findViewById(R.id.textView4);
        tv_descripcion = findViewById(R.id.textView5);
        btn2 = (Button) findViewById(R.id.btn_ed);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showForm();
            }
        });



        tv_fecha.setText("Fecha de Nacimiento: "+fecha);
        tv_nombre.setText("Nombre: "+nombre);
        tv_telefono.setText("Telefono: "+telefono);
        tv_email.setText("Email: "+email);
        tv_descripcion.setText("Descripción: "+descripcion);



    }
    public void showForm(){
        Intent intent = new Intent(InfoContacto.this, MainActivity.class);
        intent.putExtra(getResources().getString(R.string.nombre), nombre);
        intent.putExtra(getResources().getString(R.string.fecha), fecha);
        intent.putExtra(getResources().getString(R.string.telefono), telefono);
        intent.putExtra(getResources().getString(R.string.email), email);
        intent.putExtra(getResources().getString(R.string.descripcion), descripcion);
        setResult(RESULT_OK, intent);
        finish();
    }

}
