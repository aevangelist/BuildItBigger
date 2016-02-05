package com.udacity.gradle.androidjokeslib;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class JokeFragment extends Fragment {

    TextView jokeTxtView;

    public JokeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.joke_fragment, container, false);

        //Set text
        jokeTxtView = (TextView) view.findViewById(R.id.joke);

        if (getArguments() != null){
            String joke = getArguments().getString("joke");
            jokeTxtView.setText(joke);
        }

        return view;

    }

}
