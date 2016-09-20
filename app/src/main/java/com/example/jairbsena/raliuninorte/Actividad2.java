package com.example.jairbsena.raliuninorte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class Actividad2 extends AppCompatActivity {

   private Button boton;
    private TextView nombreusu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        nombreusu= (TextView)findViewById(R.id.nombreusu);


        String Usuario=getIntent().getStringExtra("Usuario");
        nombreusu.setText(Usuario);


            boton = (Button) findViewById(R.id.boton);
            boton.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    Intent intento = new Intent(getApplicationContext(), Actividad3.class);
                    startActivity(intento);
                }

            });
        }
    }

