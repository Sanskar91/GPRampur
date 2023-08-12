package com.example.mainlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Stdeveloper extends AppCompatActivity {
    ImageView fb,gm,yt,ig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stdeveloper);
        fb= findViewById(R.id.fb);
        gm= findViewById(R.id.gaamil);
        yt=findViewById(R.id.youtube);
        ig= findViewById(R.id.insta);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openfb("https://www.facebook.com/sanskar.saxena.589");
            }
        });
        gm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                String[] recipients={"saxena.sanskar92@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT,"");
                intent.putExtra(Intent.EXTRA_TEXT,"");
                intent.putExtra(Intent.EXTRA_CC,"mailcc@gmail.com");
                intent.setType("text/html");
                intent.setPackage("com.google.android.gm");
                startActivity(Intent.createChooser(intent, "Send mail"));
            }
        });
        yt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openyt("https://www.youtube.com/channel/UCP__TRYUbOQqX5rDVI29E8w");
            }
        });
        ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openig("https://www.instagram.com/devilking8281/");
            }
        });
    }
    public void openfb(String url)
    {
        Uri uri=Uri.parse(url);
        Intent fburl=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(fburl);
    }
    public void openyt(String url)
    {
        Uri uri=Uri.parse(url);
        Intent yturl=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(yturl);
    }
    public void openig(String url)
    {
        Uri uri=Uri.parse(url);
        Intent igurl=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(igurl);
    }
}