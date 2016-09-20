package com.example.jairbsena.raliuninorte;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;


public class RALI_UNINORTE extends AppCompatActivity {
    public static final int segundos = 3;
    public static final int milisegundos=segundos*1000;
    public static final int delay=2;
    private ProgressBar pbprogreso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rali__uninorte);
        pbprogreso=(ProgressBar) findViewById(R.id.pbprogreso);
        pbprogreso.setMax(maximo_progreso());
        empezaranimacion();
            }
    public void empezaranimacion() {
        new CountDownTimer(milisegundos, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            pbprogreso.setProgress(establecer_progreso(millisUntilFinished));
            }

            @Override
            public void onFinish() {
                Intent nuevofrom=new Intent(RALI_UNINORTE.this,Actividad1.class);
                startActivity(nuevofrom);
                finish();
            }
        }.start();
    }
    public int establecer_progreso(long milliseconds){
        return (int)((milisegundos-milliseconds)/1000);
    }
    public int maximo_progreso()
    {
        return segundos-delay;
    }
}






