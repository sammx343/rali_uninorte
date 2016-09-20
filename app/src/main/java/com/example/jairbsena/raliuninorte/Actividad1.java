package com.example.jairbsena.raliuninorte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Actividad1 extends AppCompatActivity{

    private EditText txtusuario;
    private ImageButton btnaceptar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

        txtusuario=(EditText)findViewById(R.id.txtusuario);
       btnaceptar=(ImageButton)findViewById(R.id.btnaceptar);

        btnaceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Actividad1.this,Actividad2.class);
                i.putExtra("Usuario",txtusuario.getText()+"");
                startActivity(i);
            }
        });

    }

}
