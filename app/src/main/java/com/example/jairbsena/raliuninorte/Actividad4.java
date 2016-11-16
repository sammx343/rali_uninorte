package com.example.jairbsena.raliuninorte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Actividad4 extends AppCompatActivity {

    private String userName;
    private String group;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ArrayList<Place> places = new ArrayList<>();
    private Button goActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad4);
        goActivity = (Button) findViewById(R.id.goActivity);
        userName = getIntent().getStringExtra("userName");
        group = getIntent().getStringExtra("group");
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("places");
        /*for (int i = 0; i<5; i++){
            String key = mDatabaseReference.push().getKey();
            mDatabaseReference.child(key).setValue(new Place(
                    "hola soy descripcion - place"+i,
                    null,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque lorem nisl, eleifend a condimentum eu, vehicula nec ligula. Mauris ante odio, accumsan vel purus et, placerat rutrum sem. Maecenas vel placerat diam. Praesent vulputate libero tortor, eget sagittis erat imperdiet ac. Interdum et malesuada fames ac ante ipsum primis in faucibus. Ut vitae mattis mi. Mauris rutrum felis nec urna finibus aliquet. Ut id orci eu massa rhoncus molestie. Etiam hendrerit, velit vitae semper efficitur, turpis massa tempor diam, vel fringilla nisl diam ac orci. Nam ut nisl auctor, convallis mauris vel, dictum augue. Sed imperdiet vitae orci aliquam tristique. Nunc suscipit egestas mauris in sodales. Nunc viverra faucibus dolor nec laoreet.\n" +
                            "\n" +
                            "Suspendisse gravida id orci non fermentum. Sed pretium ultrices augue vitae volutpat. Cras ut magna condimentum, blandit elit sed, vehicula purus. Aenean efficitur orci ut mauris lobortis, eget fermentum eros lobortis. Quisque quis ipsum eget purus blandit faucibus at nec dolor. Donec eu nunc tempus, sollicitudin metus quis, ornare risus. Mauris ac erat efficitur, egestas mi non, vulputate urna. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Etiam vulputate urna eu ipsum ultricies, eget suscipit ipsum laoreet. Pellentesque in purus feugiat, vehicula nibh quis, faucibus metus. In fermentum leo a ultricies congue. Cras vel urna at quam rhoncus sollicitudin. Pellentesque massa nisi, tempus ut massa eu, luctus faucibus ex. Ut odio diam, vulputate quis massa sit amet, tincidunt facilisis nunc. Mauris elit libero, eleifend in posuere non, semper eget mauris. Sed sollicitudin velit nunc, blandit scelerisque ipsum maximus non. - place"+i,
                    "hola soy la pregunta - place" +i,
                    Arrays.asList("r1","r2","r3","r4"),
                    "r2")
            );
        }*/
        mDatabaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                places.add(dataSnapshot.getValue(Place.class));
                if (!goActivity.isEnabled())
                    goActivity.setEnabled(true);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void goActivity(View view) {
        Intent i= new Intent(Actividad4.this,Actividad5.class);
        i.putExtra("nameU",userName);
        i.putExtra("group",group);
        i.putExtra("points","0");
        i.putExtra("timeToFinish",(long) 1500000);
        i.putExtra("placeSelect", places.remove(new Random().nextInt(places.size())));
        i.putExtra("places",places);
        i.putExtra("placesFind",0);
        startActivity(i);
    }
}
