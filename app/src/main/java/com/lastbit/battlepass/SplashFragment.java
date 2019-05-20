package com.lastbit.battlepass;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class SplashFragment extends Fragment {
    private TextView loading;
    String [] whatLoadString = {"We are looking for a star","Connect to the Internet"};
    Random random = new Random();
    int rand = Integer.valueOf(random.nextInt(whatLoadString.length));
    String loadTxt = whatLoadString[rand];

    public SplashFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, container, false);


        loading = view.findViewById(R.id.loading);
        loading.setText(String.valueOf(loadTxt));
        return view;
    }

}