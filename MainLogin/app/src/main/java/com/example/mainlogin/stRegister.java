
package com.example.mainlogin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class stRegister extends AppCompatActivity {
TextInputLayout txtroll,name,mobno,passw,fnamee,fmobno,gmaili;
    String txt,nme,mob,pss,fnme,fmob,gmail;
    RadioGroup course,branch,year;
    String stucourse="Diploma",stubranch,stuyear;
Button btnregister;
FirebaseDatabase rootdb;
DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_st_register);
      txtroll=findViewById(R.id.rolln);
      name=findViewById(R.id.nme);
      mobno=findViewById(R.id.mobno);
      passw=findViewById(R.id.passw);
      fnamee=findViewById(R.id.fnamee);
      fmobno=findViewById(R.id.fmobno);
        gmaili=findViewById(R.id.gmail);
      course=findViewById(R.id.stucourse);
        course.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.stucourse:
                    stucourse = "Diploma";
                }
            }
        });
        branch=findViewById(R.id.stubranch);
        branch.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.cse:
                        stubranch="Computer Science And Engineering";
                        break;
                    case R.id.ee:
                        stubranch="Electrical Engineering";
                        break;
                    case R.id.eeic:
                        stubranch="Electrical Engineering With Industrial Control";
                        break;
                    case R.id.ic:
                        stubranch="Instrumental Control";
                        break;
                }
            }
        });
        year=findViewById(R.id.stuyear);
        year.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.first:
                        stuyear="First Year";
                        break;
                    case R.id.second:
                        stuyear="Second Year";
                        break;
                    case R.id.third:
                        stuyear="Third Year";
                        break;
                }
            }
        });

        btnregister=findViewById(R.id.btnregister);
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt=txtroll.getEditText().getText().toString();
                nme=name.getEditText().getText().toString();
                mob=mobno.getEditText().getText().toString();
                pss=passw.getEditText().getText().toString();
                fnme=fnamee.getEditText().getText().toString();
                fmob=fmobno.getEditText().getText().toString();
                gmail=gmaili.getEditText().getText().toString();
                rootdb = FirebaseDatabase.getInstance();
                reference = rootdb.getReference("studentinfo");
                studentinfo sdata = new studentinfo(txt, nme, stucourse, stubranch, stuyear, mob, gmail, pss, fnme, fmob);
                if (sdata.getName().isEmpty()||sdata.getRollno().isEmpty()){finish();}
                else{
                reference.child(nme).setValue(sdata);
                Toast.makeText(stRegister.this, "Data Save Succesfully", Toast.LENGTH_SHORT).show();}
            }
        });
    }
    public void stLogin(View view)
    {
        finish();
    }

}