package com.example.jairbsena.raliuninorte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class Actividad8 extends AppCompatActivity {
    private int PlacesFind;
    private TextView timer;
    private TextView user;
    private String group;
    private EditText points;
    private EditText placesFind;
    private long timer_f;
    private static final String FORMAT = "%02d:%02d:%02d";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad8);
        timer = (TextView) findViewById(R.id.timeTotal);
        user = (TextView) findViewById(R.id.userName);
        points = (EditText) findViewById(R.id.pointsTotal);
        placesFind = (EditText) findViewById(R.id.placesFind);
        Intent b = this.getIntent();
        if (b.getExtras() != null) {
            user.setText(b.getStringExtra("nameU"));
            group = b.getStringExtra("group");
            points.setText(b.getStringExtra("points"));
            PlacesFind = b.getIntExtra("placesFind",0);
            placesFind.setText(""+PlacesFind);
            timer_f= b.getLongExtra("timeToFinish", 1500000);
            long millisUntilFinished = 1500000-timer_f;
            timer.setText(TimeUnit.MILLISECONDS.toHours(millisUntilFinished) + ":" +TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)+":"+TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished));
        }
    }

    public void saveReport(View view) {
        FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference mDatabaseReference = mFirebaseDatabase.getReference().child("reports");
        String key = mDatabaseReference.push().getKey();
        Report reporte = new Report(user.getText().toString(),group, PlacesFind, Integer.parseInt(points.getText().toString()),1500000-timer_f);
        mDatabaseReference.child(key).setValue(reporte);
        Toast.makeText(this, "Registro Guardado", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(Actividad8.this,RALI_UNINORTE.class);
        startActivity(i);
    }
}
