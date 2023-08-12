package com.example.mainlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class add_subject extends AppCompatActivity {

    TextInputLayout notisubject;
    String subject;
    RadioGroup course,branch,year,selectset;
    Button btnsub;
    String stucourse="diploma",stubranch="cse",stuyear="first",set="A";
    FirebaseDatabase rootdb;
    DatabaseReference reference;
    int maxid=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);

        course=findViewById(R.id.stcourse);
        course.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.diploma) {
                    stucourse = "Diploma";
                }
            }
        });

        branch=findViewById(R.id.stubranch);
        branch.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i)
                {
                    case R.id.branchcse:
                        stubranch="Computer Science And Engineering";
                        break;
                    case R.id.brancheee:
                        stubranch="Electrical Engineering";
                        break;
                    case R.id.brancheeice:
                        stubranch="Electrical Engineering With I.C.";
                        break;
                    case R.id.branchice:
                        stubranch="Industrial Control";
                        break;
                }

            }

        });

        year=findViewById(R.id.stuyear);
        year.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i)
                {
                    case R.id.yearfirst:
                        stuyear="First year";
                        break;
                    case R.id.yearsecond:
                        stuyear="Second year";
                        break;
                    case R.id.yearthree:
                        stuyear="Third year";
                        break;

                }

            }
        });

        selectset=findViewById(R.id.set);
        selectset.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i)
                {
                    case R.id.a:
                        set="A";
                        break;
                    case R.id.b:
                        set="B";
                        break;
                    case R.id.c:
                        set="C";
                        break;
                }

            }
        });
        notisubject=findViewById(R.id.notisubject);
        rootdb= FirebaseDatabase.getInstance();
        reference=rootdb.getReference().child("subject");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                maxid=(int) dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        btnsub=findViewById(R.id.subjectbt);
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subject=notisubject.getEditText().getText().toString();
                addsubject sb= new addsubject(maxid+1,stucourse,stubranch,stuyear,subject,set);
                reference.child((maxid+1)+"").setValue(sb);
                Toast.makeText(add_subject.this,"Subject Added successfully",Toast.LENGTH_LONG).show();

            }
        });


    }
}

