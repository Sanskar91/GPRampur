package com.example.mainlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class AdminDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        getIntent();
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation_view);
        toolbar=findViewById(R.id.toolbar);

        navigationView.bringToFront();
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //set onclick of navigation
        navigationView.setNavigationItemSelectedListener(this);

    }
    //set onbackpress drawerLayout should close
    public void  onBackPressed()
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemid=item.getItemId();
        switch (itemid)
        {
            case R.id.admin_dashboard:
                if(drawerLayout.isDrawerOpen(GravityCompat.START))
                {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }

                break;
            case R.id.admin_logout:
                finish();
                break;
            case R.id.admin_assignment:
                Intent go=new Intent(AdminDashboard.this,admin_assignment.class);
               startActivity(go);
                break;
            case R.id.admin_subject:
                Intent addsub=new Intent(AdminDashboard.this,add_subject.class);
                startActivity(addsub);
                break;
            case R.id.admin_notimgmt:
                Intent not=new Intent(AdminDashboard.this,student_notification.class);
                startActivity(not);
                break;
            case R.id.admin_assignmentmgmt:
                Intent asgn=new Intent(AdminDashboard.this,student_assignment.class);
                startActivity(asgn);
                break;
            case R.id.admin_noti:
                Intent in=new Intent(AdminDashboard.this, admin_notification.class);
                startActivity(in);
                break;
            case R.id.admin_developer:
                Intent deve=new Intent(AdminDashboard.this,Stdeveloper.class);
                startActivity(deve);
                break;
            case R.id.admin_studentmgmt:
                Intent repo=new Intent(AdminDashboard.this,Imageslider.class);
                startActivity(repo);
                break;
        }
        return true;
    }
    public void exit(View view)
    {
        finish();
    }
    public void adnoti(View view){
        Intent noti=new Intent(AdminDashboard.this,admin_notification.class);
        startActivity(noti);
    }
    public void adsub(View view){
        Intent sub=new Intent(AdminDashboard.this,add_subject.class);
        startActivity(sub);
    }
    public void adassi(View view){
        Intent assi=new Intent(AdminDashboard.this,admin_assignment.class);
        startActivity(assi);
    }
    public void abtclg(View view){
        Intent cllg=new Intent(AdminDashboard.this,Imageslider.class);
        startActivity(cllg);
    }
    public void addeve(View view){
        Intent deve=new Intent(AdminDashboard.this,Stdeveloper.class);
        startActivity(deve);
    }
}