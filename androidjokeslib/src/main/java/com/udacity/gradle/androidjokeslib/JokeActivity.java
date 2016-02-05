package com.udacity.gradle.androidjokeslib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class JokeActivity extends AppCompatActivity {

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String sentJoke = intent.getExtras().getString("joke");

        //todo validate the joke
        //Toast.makeText(this, "HIII" + sentJoke, Toast.LENGTH_LONG).show();

        Bundle bundle = new Bundle();
        bundle.putString("joke", sentJoke);

        final FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        JokeFragment newFragment = new JokeFragment();
        newFragment.setArguments(bundle);
        t.replace(R.id.container, newFragment);
        t.commit();

    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
