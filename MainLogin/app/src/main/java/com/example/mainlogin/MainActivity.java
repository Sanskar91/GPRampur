package com.example.mainlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void stlogin(View view)
    {
        Intent it =new Intent(MainActivity.this, login.class);
        startActivity(it);

    }

    public void AdminLogin(View view)
    {
        Intent it =new Intent(MainActivity.this, AdminLogin.class);
        startActivity(it);

    }
}