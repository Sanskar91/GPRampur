package com.example.mainlogin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class admin_assignment extends AppCompatActivity {
    TextInputLayout subject,description,remark;
    String sub,desc,mark;
    Button btnass;
    int maxid=0;
    RadioGroup course,branch,year;
    String stucourse="diploma",stubranch="cs",stuyear="first";
    FirebaseDatabase rootdb;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_assignment);


        subject=findViewById(R.id.stsubject);
        description=findViewById(R.id.stdescription);
        remark=findViewById(R.id.stremark);

        course=findViewById(R.id.stucourse);
        course.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.coursediploma) {
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
                    case R.id.branchcs:
                        stubranch="Computer Science And Engineering";
                        break;
                    case R.id.branchee:
                        stubranch="Electrical Engineering";
                        break;
                    case R.id.brancheeic:
                        stubranch="Electrical Engineering With I.C.";
                        break;
                    case R.id.brIC:
                        stubranch="Instrumental Control";
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

        rootdb= FirebaseDatabase.getInstance();
        reference=rootdb.getReference().child("assignment");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                maxid=(int) dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        btnass=findViewById(R.id.btnassign);
        btnass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sub=subject.getEditText().getText().toString();
                desc=description.getEditText().getText().toString();
                mark=remark.getEditText().getText().toString();
                adminaddassi aa= new adminaddassi(maxid+1,sub,desc,mark);
                reference.child((maxid+1)+"").setValue(aa);
                Toast.makeText(admin_assignment.this," Add Asssignment successfully",Toast.LENGTH_LONG).show();
            }
        });
    }
}