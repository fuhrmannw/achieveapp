package com.example.will.achieve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.FitWindowsLinearLayout;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Post p = new Post(1, "Will", "Sure Dude", 10, 4);
        Post o = new Post(2, "Erica", "Whoops", 11, 5);
        Post s = new Post(3, "Melanie", "Bet", 12, 6);
        Post t = new Post(4, "Michael", "WHAT", 13, 7);

        Global.getInstance().addToPostList(p);
        Global.getInstance().addToPostList(o);
        Global.getInstance().addToPostList(s);
        Global.getInstance().addToPostList(t);
    }


    public void gotoLogin() {
        Intent toLoginIntent = new Intent(this, HomeActivity.class); //should be LoginActivity instead of MainActivity
        startActivity(toLoginIntent);
    }
}