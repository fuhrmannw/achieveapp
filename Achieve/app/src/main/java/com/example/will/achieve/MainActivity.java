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

        Post p = new Post("Will", "Sure Dude", 10, 4);
        Post o = new Post( "Erica", "Whoops", 11, 5);
        Post s = new Post( "Melanie", "Bet", 12, 6);
        Post t = new Post("Michael", "WHAT", 13, 7);

        Global.getInstance().addToPostList(p);
        Global.getInstance().addToPostList(o);
        Global.getInstance().addToPostList(s);
        Global.getInstance().addToPostList(t);
    }


    public void gotoLogin(View view) {
        Intent toLoginIntent = new Intent(this, HomeActivity.class); // TODO should be LoginActivity instead of MainActivity
        startActivity(toLoginIntent);
    }
}