package com.ricardomejia.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText edt, edt2, edt3, edt4;
    DatePicker dpr;
    String pnombre, ptelefono, pemail, pdescripcion, pfecha, pfecha2, pfecha3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn_siguiente);
        edt = findViewById(R.id.et_nombre);
        edt2 = findViewById(R.id.et_telefono);
        edt3 = findViewById(R.id.et_email);
        edt4 = findViewById(R.id.et_descripcion);

        dpr = findViewById(R.id.date_picker);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,InfoContacto.class);
                pnombre = edt.getText().toString();
                ptelefono = edt2.getText().toString();
                pemail = edt3.getText().toString();
                pdescripcion = edt4.getText().toString();
                pfecha = dpr.getDayOfMonth()+"/";
                pfecha2 = dpr.getMonth()+"/";
                pfecha3 = dpr.getYear()+"";

                intent.putExtra(getResources().getString(R.string.nombre),pnombre);
                intent.putExtra(getResources().getString(R.string.telefono),ptelefono);
                intent.putExtra(getResources().getString(R.string.email),pemail);
                intent.putExtra(getResources().getString(R.string.descripcion),pdescripcion);
                intent.putExtra(getResources().getString(R.string.fecha),pfecha);
                intent.putExtra(getResources().getString(R.string.fecha2),pfecha2);
                intent.putExtra(getResources().getString(R.string.fecha3),pfecha3);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
           pnombre = data.getExtras().getString(getResources().getString(R.string.nombre));
            pfecha = data.getExtras().getString(getResources().getString(R.string.fecha));
            ptelefono = data.getExtras().getString(getResources().getString(R.string.telefono));
            pemail = data.getExtras().getString(getResources().getString(R.string.email));
            pdescripcion = data.getExtras().getString(getResources().getString(R.string.descripcion));

            edt.setText(pnombre);
            edt2.setText(ptelefono);
            edt3.setText(pemail);
            edt4.setText(pdescripcion);
        }
    }


}
