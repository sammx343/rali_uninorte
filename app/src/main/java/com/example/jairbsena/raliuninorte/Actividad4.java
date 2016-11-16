package com.example.jairbsena.raliuninorte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Actividad4 extends AppCompatActivity {

    private  Button button;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad4);
        userName = getIntent().getStringExtra("userName");
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){




            @Override
            public void onClick(View v){
                Intent i= new Intent(Actividad4.this,Actividad5.class);
                i.putExtra("nameU",userName);
                i.putExtra("points","0");
                i.putExtra("timeToFinish",(long) 1500000);
                i.putExtra("placeSelect", new Place("hola soy descripcion",null,"hola soy el texto","hola soy la pregunta",new String[]{"r1","r2","r3","r4"},"r2"));
                startActivity(i);
            }

        });



    }

}
