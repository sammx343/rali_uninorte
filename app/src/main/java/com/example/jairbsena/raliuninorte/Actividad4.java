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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad4);

        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){




            @Override
            public void onClick(View v){
                Intent intento= new Intent(getApplicationContext(),Actividad5.class);
                startActivity(intento);
            }

        });



    }

}
