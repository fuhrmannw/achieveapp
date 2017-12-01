package com.example.will.achieve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.FitWindowsLinearLayout;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void gotoLogin(View view) {
        Intent toLoginIntent = new Intent(this, GoogleSignin.class); // TODO should be LoginActivity instead of MainActivity
        startActivity(toLoginIntent);
    }
}