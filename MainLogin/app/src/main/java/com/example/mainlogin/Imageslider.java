package com.example.mainlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;

public class Imageslider extends AppCompatActivity {
    ViewFlipper flipper;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageslider);

        //slider
        int imgarray[]={R.drawable.coll,R.drawable.lab,R.drawable.coll,R.drawable.campus,R.drawable.suryapp};
        flipper=(ViewFlipper)findViewById(R.id.flipper);
        for(int i=0;i<imgarray.length;i++)
        {
            showimage(imgarray[i]);
        }
    }

    public  void showimage(int img)
    {
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(img);
        flipper.addView(imageView);
        flipper.setFlipInterval(3000);
        flipper.setAutoStart(true);
        flipper.setInAnimation(this,android.R.anim.fade_in);
        flipper.setOutAnimation(this,android.R.anim.fade_out);
    }


}