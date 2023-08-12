package com.example.mainlogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class studentprofile extends AppCompatActivity {
String name,email,mobno,fnme,fmobno,branch,rollno, stucourse, stubranch, stuyear,password;
TextInputEditText nme,emal,contact,fname,fcontact,pss;
TextView usernm,usersub,phn,eml;
    FirebaseDatabase rootdb;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentprofile);

        SharedPreferences sharedPreferences = getSharedPreferences(login.mypreference, Context.MODE_PRIVATE);
        name = sharedPreferences.getString("stname", "");
        branch=sharedPreferences.getString("branch","");

        mobno = sharedPreferences.getString("mobno", "");
        email = sharedPreferences.getString("email", "");
        fnme = sharedPreferences.getString("fname", "");
        fmobno=sharedPreferences.getString("fmobno","");
        rollno=sharedPreferences.getString("rollno","");
        stucourse=sharedPreferences.getString("course","");
        stubranch=sharedPreferences.getString("branch","");
       stuyear=sharedPreferences.getString("year","");
       password=sharedPreferences.getString("pass","");
        nme=findViewById(R.id.sn);
        emal=findViewById(R.id.smail);
        contact=findViewById(R.id.sno);
        fname=findViewById(R.id.fn);
        fcontact=findViewById(R.id.fcno);
        pss=findViewById(R.id.newpass);

        nme.setText(name);
        emal.setText(email);
        contact.setText(mobno);
        fname.setText(fnme);
        fcontact.setText(fmobno);

        usernm=findViewById(R.id.username);
        usersub=findViewById(R.id.usersub);
        phn=findViewById(R.id.phn);
        eml=findViewById(R.id.em2);

        usernm.setText(name);
        usersub.setText(branch);
        phn.setText(mobno);
        eml.setText(email);
        Button btn=findViewById(R.id.updateprofile);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pssw = pss.getText().toString();
                String contactw = contact.getText().toString();
                String emalw = emal.getText().toString();
                String fnamew = fname.getText().toString();
                String fcontactw = fcontact.getText().toString();
                rootdb = FirebaseDatabase.getInstance();
                reference = rootdb.getReference("studentinfo");
                if (pssw.isEmpty()) {
                    studentinfo sdata = new studentinfo(rollno, name, stucourse, stubranch, stuyear, contactw, emalw,password, fnamew, fcontactw);
                    reference.child(name).setValue(sdata);
                    Toast.makeText(studentprofile.this, "Profile Updated Succesfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    studentinfo sdata = new studentinfo(rollno, name, stucourse, stubranch, stuyear, contactw, emalw,pssw, fnamew, fcontactw);
                    reference.child(name).setValue(sdata);
                    Toast.makeText(studentprofile.this, "Profile Updated Succesfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
            }
}