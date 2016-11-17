package com.example.jairbsena.raliuninorte;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Actividad5 extends AppCompatActivity {

    private int PlacesFind;
    private TextView timer;
    private TextView user;
    private String group;
    private EditText points;
    private EditText descriptionPlace;
    private ArrayList<Place> places = new ArrayList<>();
    private BeaconManager beaconManager;
    private long timeToFinish;
    private Place placeSelect;
    private Button goText;
    private Region rBeacon;

    private static final String FORMAT = "%02d:%02d:%02d";
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad5);

        beaconManager = new BeaconManager(getApplicationContext()); // init beacon manager

        timer=(TextView)findViewById(R.id.textView1);
        user = (TextView) findViewById(R.id.nombreusu);
        points= (EditText) findViewById(R.id.editText4);
        descriptionPlace = (EditText) findViewById(R.id.editText5);
        goText = (Button) findViewById(R.id.goText);
        Intent b = this.getIntent();
        if (b.getExtras() != null) {
            user.setText(b.getStringExtra("nameU"));
            group = b.getStringExtra("group");
            points.setText(b.getStringExtra("points"));
            placeSelect = (Place) b.getSerializableExtra("placeSelect");
            places = (ArrayList<Place>) b.getSerializableExtra("places");
            PlacesFind = b.getIntExtra("placesFind",0);
            if (!placeSelect.getDescriptionPlace().isEmpty())
                descriptionPlace.setText(placeSelect.getDescriptionPlace());
            else
                Toast.makeText(this, "Error leyendo descripcion", Toast.LENGTH_SHORT).show();
            rBeacon = new Region(
                    "monitored region",
                    UUID.fromString(placeSelect.getIdBeacon()),
                    62695,
                    63626);
            beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
                @Override
                public void onServiceReady() {
                    beaconManager.startMonitoring(rBeacon);
                }
            });
            beaconManager.setMonitoringListener(new BeaconManager.MonitoringListener() {
                @Override
                public void onEnteredRegion(Region region, List<Beacon> list) {
                    if (list.size()>0){
                        for (Beacon find: list) {
                            if (find.getProximityUUID().equals(UUID.fromString(placeSelect.getIdBeacon()))){
                                Toast.makeText(Actividad5.this, "Encontraste el lugar", Toast.LENGTH_SHORT).show();
                                goText.setEnabled(true);
                                beaconManager.stopMonitoring(rBeacon);
                            }
                        }
                    }
                }

                @Override
                public void onExitedRegion(Region region) {
                    //goText.setEnabled(false);
                }
            });
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
        PlacesFind +=1;
        Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(Actividad5.this, Actividad6.class);
        i.putExtra("nameU",user.getText().toString());
        i.putExtra("group",group);
        i.putExtra("points",""+(Integer.parseInt(points.getText().toString())+1));
        i.putExtra("timeToFinish",timeToFinish);
        i.putExtra("placeSelect",placeSelect);
        i.putExtra("places",places);
        i.putExtra("placesFind",PlacesFind);
        startActivity(i);
    }
}
