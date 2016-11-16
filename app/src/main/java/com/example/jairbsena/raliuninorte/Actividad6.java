package com.example.jairbsena.raliuninorte;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Actividad6 extends AppCompatActivity {
    private int PlacesFind;
    private TextView timer;
    private TextView user;
    private String group;
    private EditText points;
    private TextView textPlace;
    private ArrayList<Place> places = new ArrayList<>();

    private long timeToFinish;
    private Place placeSelect;
    private static final String FORMAT = "%02d:%02d:%02d";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad6);
        timer = (TextView) findViewById(R.id.textView1);
        user = (TextView) findViewById(R.id.nombreusu);
        points = (EditText) findViewById(R.id.editText4);
        textPlace = (TextView) findViewById(R.id.textView5);
        textPlace.setMovementMethod(new ScrollingMovementMethod());
        Intent b = this.getIntent();
        if (b.getExtras() != null) {
            user.setText(b.getStringExtra("nameU"));
            group = b.getStringExtra("group");
            points.setText(b.getStringExtra("points"));
            placeSelect = (Place) b.getSerializableExtra("placeSelect");
            places = (ArrayList<Place>) b.getSerializableExtra("places");
            PlacesFind = b.getIntExtra("placesFind",0);
            if (!placeSelect.getTextPlace().isEmpty())
                textPlace.setText(placeSelect.getTextPlace());
            else
                Toast.makeText(this, "Error leyendo descripcion", Toast.LENGTH_SHORT).show();


            new CountDownTimer(b.getLongExtra("timeToFinish", 1500000), 1000) { // adjust the milli seconds here

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

    public void goQuestion(View view) {
        Intent i = new Intent(Actividad6.this, Actividad7.class);
        i.putExtra("nameU",user.getText().toString());
        i.putExtra("group",group);
        i.putExtra("points",points.getText().toString());
        i.putExtra("timeToFinish",timeToFinish);
        i.putExtra("placeSelect",placeSelect);
        i.putExtra("places",places);
        i.putExtra("placesFind",PlacesFind);
        startActivity(i);
    }
}
