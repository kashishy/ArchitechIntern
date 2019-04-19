package com.example.architechintern;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.support.design.widget.FloatingActionButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewFlipper viewFlipper;
    private FloatingActionButton fab;
    List<DataPop> dataPop;
    List<DataPopActivity> dataActvty,dataTrending,dataklook;
    private RecyclerAdapterPop recyclerAdapterpop;
    private RecyclerAdapterPopactvty recyclerAdapterPopactvty,rvAdapterTrending,rvAdapterKlook;
    private RecyclerView recyclerViewPop,recyclerViewActvty,recyclerViewTrending,rviewKlook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewPop = findViewById(R.id.rvPopularDes_id);
        recyclerViewActvty = findViewById(R.id.rvPopActvty_id);
        recyclerViewTrending = findViewById(R.id.rvTrndng_id);
        rviewKlook = findViewById(R.id.rvKlook_id);
        rviewKlook.setHasFixedSize(true);
        rviewKlook.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerViewTrending.setHasFixedSize(true);
        recyclerViewTrending.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerViewActvty.setHasFixedSize(true);
        recyclerViewActvty.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerViewPop.setHasFixedSize(true);
        recyclerViewPop.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        dataPop = new ArrayList<>();
        dataActvty = new ArrayList<>();
        dataTrending = new ArrayList<>();
        dataklook = new ArrayList<>();

        int images[] = {R.drawable.slide4,R.drawable.slide1,R.drawable.slide5};
        viewFlipper = findViewById(R.id.flipper_id);

        for(int image: images){
            imageFliper(image);
        }

        fab = findViewById(R.id.fab);
        
        dataActivitiew();
        loadingTrending();
        laodingKlook();

        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("PopularPlaces");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()){

                    for (DataSnapshot dataSnap: dataSnapshot.getChildren()){

                        DataPop popdata = dataSnap.getValue(DataPop.class);
                        dataPop.add(popdata);
                    }
                    recyclerAdapterpop = new RecyclerAdapterPop(dataPop,MainActivity.this);
                    recyclerViewPop.setAdapter(recyclerAdapterpop);
                }
                else {
                    Toast.makeText(MainActivity.this,"No Data Found",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void imageFliper(int image){

        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.setAutoStart(true);
        //viewFlipper.setInAnimation(this,R.anim.slide_left);
        //viewFlipper.setOutAnimation(this,R.anim.slide_out);

    }

    public void dataActivitiew(){

        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("PopularActivities");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){

                    for (DataSnapshot dataSnap: dataSnapshot.getChildren()){

                        DataPopActivity dataAct = dataSnap.getValue(DataPopActivity.class);
                        dataActvty.add(dataAct);
                    }
                    recyclerAdapterPopactvty = new RecyclerAdapterPopactvty(dataActvty,MainActivity.this);
                    recyclerViewActvty.setAdapter(recyclerAdapterPopactvty);
                }
                else{
                    Toast.makeText(MainActivity.this,"Activity Data Not Exits",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this,databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void loadingTrending(){

        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("TrendingNow");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists())
                {
                    for (DataSnapshot dataSnap: dataSnapshot.getChildren())
                    {
                        DataPopActivity data = dataSnap.getValue(DataPopActivity.class);
                        dataTrending.add(data);
                    }
                    rvAdapterTrending = new RecyclerAdapterPopactvty(dataTrending,MainActivity.this);
                    recyclerViewTrending.setAdapter(rvAdapterTrending);
                }
                else {
                    Toast.makeText(MainActivity.this,"Data Not Found Trending",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this,databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void laodingKlook(){

        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("KlookRecommended");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    for (DataSnapshot dataSnap: dataSnapshot.getChildren())
                    {
                        DataPopActivity data = dataSnap.getValue(DataPopActivity.class);
                        dataklook.add(data);
                    }
                    rvAdapterKlook = new RecyclerAdapterPopactvty(dataklook,MainActivity.this);
                    rviewKlook.setAdapter(rvAdapterKlook);
                }
                else {
                    Toast.makeText(MainActivity.this,"No Data Found Klook",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this,databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
