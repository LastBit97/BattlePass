package com.lastbit.battlepass;


import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;
import static com.lastbit.battlepass.MainActivity.APP_PREFERENCES;
import static com.lastbit.battlepass.MainActivity.SEASON_NAME;
import static com.lastbit.battlepass.MainActivity.WEEK1;
import static com.lastbit.battlepass.MainActivity.WEEK10;
import static com.lastbit.battlepass.MainActivity.WEEK10TXT;
import static com.lastbit.battlepass.MainActivity.WEEK1TXT;
import static com.lastbit.battlepass.MainActivity.WEEK2;
import static com.lastbit.battlepass.MainActivity.WEEK2TXT;
import static com.lastbit.battlepass.MainActivity.WEEK3;
import static com.lastbit.battlepass.MainActivity.WEEK3TXT;
import static com.lastbit.battlepass.MainActivity.WEEK4;
import static com.lastbit.battlepass.MainActivity.WEEK4TXT;
import static com.lastbit.battlepass.MainActivity.WEEK5;
import static com.lastbit.battlepass.MainActivity.WEEK5TXT;
import static com.lastbit.battlepass.MainActivity.WEEK6;
import static com.lastbit.battlepass.MainActivity.WEEK6TXT;
import static com.lastbit.battlepass.MainActivity.WEEK7;
import static com.lastbit.battlepass.MainActivity.WEEK7TXT;
import static com.lastbit.battlepass.MainActivity.WEEK8;
import static com.lastbit.battlepass.MainActivity.WEEK8TXT;
import static com.lastbit.battlepass.MainActivity.WEEK9;
import static com.lastbit.battlepass.MainActivity.WEEK9TXT;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment  implements AdapterMenu.OnImageClickListener {
    private RecyclerView recyclerView;
    private LinearLayoutManager verticalLinearLayoutManager;
    private AdapterMenu adapter;
    private SharedPreferences mSettings;
    private boolean week1 = true ,week2,week3,week4,week5,week6,week7,week8,week9,week10;
    private String week1txt= "Loading...",week2txt= "Loading...",week3txt= "Loading...",week4txt= "Loading...",week5txt= "Loading...",week6txt= "Loading...",week7txt= "Loading...",week8txt= "Loading...",week9txt= "Loading...",week10txt = "Loading...";
    private String season_name;
    private TextView season_name_view;
    public MainFragment() {
    }

    @Override
    public void onImageClick(ItemMainMenu item) {
        ((MainActivity) getActivity()).showAd(new Runnable() {
            @Override
            public void run() {
                if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {

                }
            }
        });
        if (hasConnection(getActivity()) == true ) {

            if (item.isLocked()) {
                Fragment fr = new ChallengesFragment();
                Bundle args = new Bundle();
                args.putInt("week_number", item.getWeekNumber());
                fr.setArguments(args);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fr)
                        .addToBackStack(null)
                        .commit();
            }else {
                Toast.makeText(getContext(),getString(R.string.week_locked)+" "+ item.getWeek_will_opened(),LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getContext(),getString(R.string.internet_error),LENGTH_SHORT).show();
        }


    }

    public void update() {
        if (mSettings.contains(WEEK1)) {
            week1 = mSettings.getBoolean(WEEK1, false);
        }
        if (mSettings.contains(WEEK2)) {
            week2 = mSettings.getBoolean(WEEK2, false);
        }
        if (mSettings.contains(WEEK3)) {
            week3 = mSettings.getBoolean(WEEK3, false);
        }
        if (mSettings.contains(WEEK4)) {
            week4 = mSettings.getBoolean(WEEK4, false);
        }
        if (mSettings.contains(WEEK5)) {
            week5 = mSettings.getBoolean(WEEK5, false);
        }
        if (mSettings.contains(WEEK6)) {
            week6 = mSettings.getBoolean(WEEK6, false);
        }
        if (mSettings.contains(WEEK7)) {
            week7 = mSettings.getBoolean(WEEK7, false);
        }
        if (mSettings.contains(WEEK8)) {
            week8 = mSettings.getBoolean(WEEK8, false);
        }
        if (mSettings.contains(WEEK9)) {
            week9 = mSettings.getBoolean(WEEK9, false);
        }
        if (mSettings.contains(WEEK10)) {
            week10 = mSettings.getBoolean(WEEK10, false);
        }
        if (mSettings.contains(WEEK1TXT)) {
            week1txt = mSettings.getString(WEEK1TXT, "");
        }
        if (mSettings.contains(WEEK2TXT)) {
            week2txt = mSettings.getString(WEEK2TXT, "");
        }
        if (mSettings.contains(WEEK3TXT)) {
            week3txt = mSettings.getString(WEEK3TXT, "");
        }
        if (mSettings.contains(WEEK4TXT)) {
            week4txt = mSettings.getString(WEEK4TXT, "");
        }
        if (mSettings.contains(WEEK5TXT)) {
            week5txt = mSettings.getString(WEEK5TXT, "");
        }
        if (mSettings.contains(WEEK6TXT)) {
            week6txt = mSettings.getString(WEEK6TXT, "");
        }
        if (mSettings.contains(WEEK7TXT)) {
            week7txt = mSettings.getString(WEEK7TXT, "");
        }
        if (mSettings.contains(WEEK8TXT)) {
            week8txt = mSettings.getString(WEEK8TXT, "");
        }
        if (mSettings.contains(WEEK9TXT)) {
            week9txt = mSettings.getString(WEEK9TXT, "");
        }
        if (mSettings.contains(WEEK10TXT)) {
            week10txt = mSettings.getString(WEEK10TXT, "");
        }
        if (mSettings.contains(WEEK10TXT)) {
            week10txt = mSettings.getString(WEEK10TXT, "");
        }

        if (mSettings.contains(SEASON_NAME)) {
            season_name = mSettings.getString(SEASON_NAME, "");
        }

        season_name_view.setText(season_name);
        List<ItemMainMenu> menuList = new ArrayList<>();

        menuList.add(new ItemMainMenu( week1txt, week1,getString(R.string.Week)+" 1",1));
        menuList.add(new ItemMainMenu( week2txt, week2,getString(R.string.Week)+" 2",2));
        menuList.add(new ItemMainMenu( week3txt, week3,getString(R.string.Week)+" 3",3));
        menuList.add(new ItemMainMenu( week4txt, week4,getString(R.string.Week)+" 4",4));
        menuList.add(new ItemMainMenu( week5txt, week5,getString(R.string.Week)+" 5",5));
        menuList.add(new ItemMainMenu( week6txt, week6,getString(R.string.Week)+" 6",6));
        menuList.add(new ItemMainMenu( week7txt, week7,getString(R.string.Week)+" 7",7));
        menuList.add(new ItemMainMenu( week8txt, week8,getString(R.string.Week)+" 8",8));
        menuList.add(new ItemMainMenu( week9txt, week9,getString(R.string.Week)+" 9",9));
        menuList.add(new ItemMainMenu( week10txt, week10,getString(R.string.Week)+" 10",10));
        adapter.setMessages(menuList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        season_name_view = view.findViewById(R.id.season_name);

        mSettings = this.getActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        recyclerView = view.findViewById(R.id.recycler);
        verticalLinearLayoutManager = new GridLayoutManager(getActivity(), 2);
        verticalLinearLayoutManager.setStackFromEnd(false);
        recyclerView.setLayoutManager(verticalLinearLayoutManager);
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x/2;

        adapter = new AdapterMenu(width);
        recyclerView.setAdapter(adapter);

        update();

        return view;
    }

    public static boolean hasConnection(final Context context)
    {
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiInfo != null && wifiInfo.isConnected())
        {
            return true;
        }
        wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifiInfo != null && wifiInfo.isConnected())
        {
            return true;
        }
        wifiInfo = cm.getActiveNetworkInfo();
        if (wifiInfo != null && wifiInfo.isConnected())
        {
            return true;
        }
        return false;
    }

    @Override
    public void onPause() {
        if (adapter != null) {
            adapter.setListener(null);
        }
        super.onPause();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adapter != null) {
            adapter.setListener(this);
        }
        if (getActivity() != null) {
            ((MainActivity) getActivity()).getConfig();
        }
    }
}