package com.example.mainlogin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.se.omapi.Session;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import static java.lang.Thread.sleep;

public class login extends AppCompatActivity {
TextInputLayout stuname,stupass;
String uname,pass;
Button btn;
FirebaseDatabase rootdb;
DatabaseReference reference;
private  ObjectAnimator progress;
    public static  final String mypreference="mypref";
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        stuname = findViewById(R.id.user);
        stupass = findViewById(R.id.stupassword);
        btn=findViewById(R.id.login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uname=stuname.getEditText().getText().toString();
                pass=stupass.getEditText().getText().toString();
                rootdb= FirebaseDatabase.getInstance();
                reference=rootdb.getReference("studentinfo");

                ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressBar);
                progress=ObjectAnimator.ofInt(progressBar,"progress",0,100);
                progress.setDuration(8000).start();
                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            sleep(8000);

                            Query myquery=reference.orderByChild("name").equalTo(uname);
                myquery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            String password=dataSnapshot.child(uname).child("pass").getValue(String.class);
                            if(password.equals(pass)){

                                sharedPreferences =getSharedPreferences(mypreference, Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor=sharedPreferences.edit();

                                String rollnofromdb=dataSnapshot.child(uname).child("rollno").getValue(String.class);
                                String namefromdb=dataSnapshot.child(uname).child("name").getValue(String.class);
                                String coursefromdb=dataSnapshot.child(uname).child("course").getValue(String.class);
                                String branchfromdb=dataSnapshot.child(uname).child("branch").getValue(String.class);
                                String yearfromdb=dataSnapshot.child(uname).child("year").getValue(String.class);
                                String mobnofromdb=dataSnapshot.child(uname).child("mobno").getValue(String.class);
                                String emailfromdb=dataSnapshot.child(uname).child("email").getValue(String.class);
                                String fnamefromdb=dataSnapshot.child(uname).child("fname").getValue(String.class);
                                String fmobnofromdb=dataSnapshot.child(uname).child("fmobno").getValue(String.class);

                                editor.putString("rollno",rollnofromdb);
                                editor.putString("stname",namefromdb);
                                editor.putString("course",coursefromdb);
                                editor.putString("branch",branchfromdb);
                                editor.putString("year",yearfromdb);
                                editor.putString("mobno",mobnofromdb);
                                editor.putString("email",emailfromdb);
                                editor.putString("fname",fnamefromdb);
                                editor.putString("fmobno",fmobnofromdb);
                                editor.putString("pass",password);
                                editor.commit();
                                Intent ind=new Intent(login.this,st_dashboard.class);
                                startActivity(ind);

                            }
                            else{
                                Toast.makeText(login.this,"Password does not matched",Toast.LENGTH_SHORT).show();
                            }

                        }
                        else{
                            Toast.makeText(login.this,"Username does not matched",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(login.this,"db not available",Toast.LENGTH_SHORT).show();
                    }
                });
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        });
    }

    public void register(View view)
    {
        Intent n=new Intent(login.this, stRegister.class);
        startActivity(n);
    }
    }
