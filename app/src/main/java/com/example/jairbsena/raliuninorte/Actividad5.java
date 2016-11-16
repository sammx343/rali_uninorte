package com.example.jairbsena.raliuninorte;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class Actividad5 extends AppCompatActivity {


    private TextView timer;
    private TextView user;
    private EditText points;
    private EditText descriptionPlace;
    private long timeToFinish;
    private Place placeSelect;

    private static final String FORMAT = "%02d:%02d:%02d";
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad5);


        timer=(TextView)findViewById(R.id.textView1);
        user = (TextView) findViewById(R.id.nombreusu);
        points= (EditText) findViewById(R.id.editText4);
        descriptionPlace = (EditText) findViewById(R.id.editText5);

        Intent b = this.getIntent();
        if (b.getExtras() != null) {
            user.setText(b.getStringExtra("nameU"));
            points.setText(b.getStringExtra("points"));
            placeSelect = (Place) b.getSerializableExtra("placeSelect");
            if (!placeSelect.getDescriptionPlace().isEmpty())
                descriptionPlace.setText(placeSelect.getDescriptionPlace());
            else
                Toast.makeText(this, "Error leyendo descripcion", Toast.LENGTH_SHORT).show();


            new CountDownTimer(b.getLongExtra("timeToFinish",1500000), 1000) { // adjust the milli seconds here

                public void onTick(long millisUntilFinished) {
                    timeToFinish = millisUntilFinished;
                    timer.setText(String.format(FORMAT,
                            TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                            TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                    TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                            TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                }

                public void onFinish() {
                    timer.setText("Tiempo agotado!");
                }
            }.start();

        }

    }

    public void goText(View view) {
        Intent i = new Intent(Actividad5.this, Actividad6.class);
        i.putExtra("nameU",user.getText().toString());
        i.putExtra("points",points.getText().toString());
        i.putExtra("timeToFinish",timeToFinish);
        i.putExtra("placeSelect",placeSelect);
        startActivity(i);
    }
}
