package com.example.jairbsena.raliuninorte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Actividad3 extends AppCompatActivity {

    Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3);

        button3=(Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v){
              //  EditText editText = (EditText) findViewById(R.id.editText);
                EditText editText2 = (EditText) findViewById(R.id.editText2);

                if (editText2.getText().toString().isEmpty() ) {
                    if (editText2.getText().toString().isEmpty())
                        editText2.setError("Campo nombre está vacio");

                    //if (editText.getText().toString().isEmpty())
                     //   editText.setError("No puede estar vacio");
                }
                else {
                    Intent intento = new Intent(getApplicationContext(), Actividad4.class);
                    intento.putExtra("userName",editText2.getText().toString());
                    startActivity(intento);
                }
            }

        });
    }
}