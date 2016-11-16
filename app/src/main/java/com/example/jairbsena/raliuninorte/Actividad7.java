package com.example.jairbsena.raliuninorte;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Actividad7 extends AppCompatActivity {
    private int PlacesFind;
    private TextView timer;
    private TextView user;
    private String group;
    private EditText points;
    private TextView questionPlace;
    private ArrayList<Place> places = new ArrayList<>();

    private long timeToFinish;
    private Place placeSelect;
    private static final String FORMAT = "%02d:%02d:%02d";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad7);
        timer = (TextView) findViewById(R.id.textView1);
        user = (TextView) findViewById(R.id.nombreusu);
        points = (EditText) findViewById(R.id.editText4);
        questionPlace = (TextView) findViewById(R.id.textView7);
        questionPlace.setMovementMethod(new ScrollingMovementMethod());
        Intent b = this.getIntent();
        if (b.getExtras() != null) {
            user.setText(b.getStringExtra("nameU"));
            group = b.getStringExtra("group");
            points.setText(b.getStringExtra("points"));
            placeSelect = (Place) b.getSerializableExtra("placeSelect");
            places = (ArrayList<Place>) b.getSerializableExtra("places");
            PlacesFind = b.getIntExtra("placesFind",0);
            if (!placeSelect.getQuestionPlace().isEmpty())
                questionPlace.setText(placeSelect.getQuestionPlace());
            else
                Toast.makeText(this, "Error leyendo descripcion", Toast.LENGTH_SHORT).show();

            ArrayList<Button> buttons = new ArrayList<>(Arrays.asList(
                    (Button) findViewById(R.id.r1),
                    (Button) findViewById(R.id.r2),
                    (Button) findViewById(R.id.r3),
                    (Button) findViewById(R.id.r4)
            ));

            while(buttons.size()>0){
                Button button = buttons.remove(new Random().nextInt(buttons.size()));
                button.setText(placeSelect.getAnswersPlace().remove(new Random().nextInt(placeSelect.getAnswersPlace().size())));
            }

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

    public void selectAnswer(View view) {
        Button button_select = (Button) view;
        if (button_select.getText().toString().equals(placeSelect.getAnswerCorrect())){
            Toast.makeText(this, "Respuesta Correcta", Toast.LENGTH_SHORT).show();
            points.setText(""+(Integer.parseInt(points.getText().toString())+1));
            if (places.size()>0){
                placeSelect = places.remove(new Random().nextInt(places.size()));
                Intent i = new Intent(Actividad7.this, Actividad5.class);
                i.putExtra("nameU",user.getText().toString());
                i.putExtra("group",group);
                i.putExtra("points",points.getText().toString());
                i.putExtra("timeToFinish",timeToFinish);
                i.putExtra("placeSelect",placeSelect);
                i.putExtra("places",places);
                i.putExtra("placesFind",PlacesFind);
                startActivity(i);
            }else{
                Intent i = new Intent(Actividad7.this, Actividad8.class);
                i.putExtra("nameU",user.getText().toString());
                i.putExtra("group",group);
                i.putExtra("points",points.getText().toString());
                i.putExtra("timeToFinish",timeToFinish);
                i.putExtra("placesFind",PlacesFind);
                startActivity(i);
            }
        }else{
            Toast.makeText(this, "Respuesta incorrecta, vuelve a intentarlo", Toast.LENGTH_SHORT).show();
            points.setText(""+(Integer.parseInt(points.getText().toString())-1));
        }
    }

    public void goBackText(View view) {
        Intent i = new Intent(Actividad7.this, Actividad6.class);
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
