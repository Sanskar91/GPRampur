package com.example.mainlogin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class student_assignment extends AppCompatActivity {
    RecyclerView recyclerView;
    assignmentadapter noti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_assignment);

        recyclerView =findViewById(R.id.recyclerview2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<adminaddassi> options =
                new FirebaseRecyclerOptions.Builder<adminaddassi>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("assignment"), adminaddassi.class)
                        .build();
        noti=new assignmentadapter(options);
        recyclerView.setAdapter(noti);
    }
    @Override
    protected void onStart() {
        super.onStart();
        noti.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        noti.stopListening();
    }
}