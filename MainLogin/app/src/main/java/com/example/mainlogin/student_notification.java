package com.example.mainlogin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class student_notification extends AppCompatActivity {
    RecyclerView recyclerView;
    notificationadapter noti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_notification);

        recyclerView =findViewById(R.id.recyclerview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<adminaddnoti> options =
                new FirebaseRecyclerOptions.Builder<adminaddnoti>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("notification"), adminaddnoti.class)
                        .build();
        noti=new notificationadapter(options);
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