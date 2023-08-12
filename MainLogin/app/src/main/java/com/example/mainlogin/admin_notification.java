package com.example.mainlogin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class admin_notification extends AppCompatActivity {
    TextInputLayout notisubject,notidesc;
    Button btnnoti;
    int maxid=0;
    String sub="",desc="";
    FirebaseDatabase rootdb;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_notification);
        notisubject=findViewById(R.id.notisubject);
        notidesc=findViewById(R.id.notidesc);
        btnnoti=findViewById(R.id.btnnoti);
        rootdb= FirebaseDatabase.getInstance();
        reference=rootdb.getReference().child("notification");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                maxid=(int) dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        btnnoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sub=notisubject.getEditText().getText().toString();
                desc=notidesc.getEditText().getText().toString();
                adminaddnoti noti=new adminaddnoti(maxid+1,sub,desc);
                reference.child((maxid+1)+"").setValue(noti);
                Toast.makeText(admin_notification.this,"notification add successfully",Toast.LENGTH_LONG).show();
            }
        });
    }


}