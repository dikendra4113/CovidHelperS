package com.example.covidhelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity<vaccrecyclerView> extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private ArrayList<VaccineModal> vaccineModalList = new ArrayList<>();
    private RecyclerView myRcycler;
    VaccineAdapter adapter;
    private FirebaseDatabase firebaseDatabaseInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRcycler = findViewById(R.id.myRecycler);
        myRcycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//
        firebaseDatabaseInstance = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        String state = "Andaman and Nicobar Islands";
        databaseReference.child("vaccinedoses_statewise").child("16-04-2021").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

//                VaccineModal vaccineModal = new VaccineModal();
                for (DataSnapshot dsp : snapshot.getChildren()) {
                    Log.i("MShgg",dsp.getValue()+"");
                    VaccineModal vaccineModal = new VaccineModal();
                     vaccineModal = dsp.getValue(VaccineModal.class);
                    vaccineModalList.add(vaccineModal);
                }
//                    vaccineModal = snapshot.child("MP").getValue(VaccineModal.class);
//                    vaccineModalList.add(vaccineModal);

                adapter = new VaccineAdapter(MainActivity.this,vaccineModalList,state);
                myRcycler.setAdapter(adapter);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}