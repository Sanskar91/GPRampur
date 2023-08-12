package com.example.mainlogin;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import static java.lang.Thread.sleep;

public class AdminLogin extends AppCompatActivity {
    FirebaseDatabase rootdb;
    DatabaseReference reference;
    TextInputLayout adminname, adminpass;
    String adname, adpass;
    Button adbtn;
    private ObjectAnimator progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        adminname = findViewById(R.id.adminuname);
        adminpass = findViewById(R.id.adminpass);
        adbtn = findViewById(R.id.adbtn);
        adbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adname = adminname.getEditText().getText().toString();
                adpass = adminpass.getEditText().getText().toString();
                rootdb = FirebaseDatabase.getInstance();
                reference = rootdb.getReference("admininfo");
                ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressBar1);
                progress=ObjectAnimator.ofInt(progressBar,"progress",0,100);
                progress.setDuration(8000).start();
                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            sleep(8000);

                            Query myquery = reference.orderByChild("adnamee").equalTo(adname);
                myquery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            String password = dataSnapshot.child(adname).child("adpass").getValue(String.class);
                            if (password.equals(adpass)) {
                                Intent adlogin = new Intent(AdminLogin.this, AdminDashboard.class);
                                startActivity(adlogin);
                            } else {
                                Toast.makeText(AdminLogin.this, "Password does not matched", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else {
                            Toast.makeText(AdminLogin.this, "Username does not matched", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
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
}

