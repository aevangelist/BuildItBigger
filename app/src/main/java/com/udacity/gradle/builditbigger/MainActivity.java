package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.udacity.gradle.androidjokeslib.JokeActivity;


public class MainActivity extends AppCompatActivity implements EndpointsAsyncResponse {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
        toolbar.setTitle("BuildItBigger");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){

        //TODO Check for network connection here
        EndpointsAsyncTask e = new EndpointsAsyncTask();
        e.delegate = this;
        e.execute(new Pair<Context, String>(this, ""));

    }


    @Override
    public void processFinish(String output) {

        //Here you will receive the result fired from async class
        Toast.makeText(this, output, Toast.LENGTH_LONG).show();

        //Launch activity
        Intent intent = new Intent(this, JokeActivity.class);
        startActivity(intent);
    }
}
