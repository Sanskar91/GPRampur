package com.example.mainlogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class st_dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    String name, email, mobno, fnme, fmobno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_st_dashboard);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view1);
        toolbar = findViewById(R.id.toolbar);
        TextView up = findViewById(R.id.upnme);
        SharedPreferences sharedPreferences = getSharedPreferences(login.mypreference, Context.MODE_PRIVATE);
        name = sharedPreferences.getString("stname", "");
        up.setText(name);
        navigationView.bringToFront();
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //set onclick of navigation
        navigationView.setNavigationItemSelectedListener(this);

    }

    //set onbackpress drawerLayout should close
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemid = item.getItemId();
        switch (itemid) {
            case R.id.stu_dashboard:
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }

                break;
            case R.id.stu_notification:
                Intent in = new Intent(this, student_notification.class);
                startActivity(in);
                break;
            case R.id.stu_logout:
               finish();
                break;
            case R.id.stu_assignment:
                Intent hi=new Intent(st_dashboard.this,student_assignment.class);
                startActivity(hi);
                break;
            case R.id.stu_profile:
                Intent go = new Intent(this, studentprofile.class);
                startActivity(go);
                break;
            case R.id.developer:
                Intent deve=new Intent(st_dashboard.this,Stdeveloper.class);
                startActivity(deve);
                break;
            case R.id.faculty:
                Intent facul=new Intent(st_dashboard.this,Imageslider.class);
                startActivity(facul);
                break;
        }
        return true;
    }

    public void exit(View view) {
        finish();
    }

    public void stprofile(View view) {
        Intent go = new Intent(this, studentprofile.class);
        startActivity(go);
    }

    public void stnotification(View view) {
        Intent go = new Intent(this, student_notification.class);
        startActivity(go);
    }

    public void stassignment(View view) {
        Intent go = new Intent(this, student_assignment.class);
        startActivity(go);
    }
    public void developer(View view) {
        Intent go = new Intent(this,Stdeveloper.class);
        startActivity(go);
    }
    public void faculty(View view) {
        Intent go = new Intent(this,Imageslider.class);
        startActivity(go);
    }
}