package com.lastbit.battlepass;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.WindowManager;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class GetRomoteConfig extends Application {
    private SharedPreferences mSettings;
    public static final String APP_PREFERENCES = "mysettings";
    public static final String WEEK1= "week1";
    public static final String WEEK2= "week2";
    public static final String WEEK3= "week3";
    public static final String WEEK4= "week4";
    public static final String WEEK5= "week5";
    public static final String WEEK6= "week6";
    public static final String WEEK7= "week7";
    public static final String WEEK8= "week8";
    public static final String WEEK9= "week9";
    public static final String WEEK10= "week10";

    public static final String WEEK1TXT= "week1txt";
    public static final String WEEK2TXT= "week2txt";
    public static final String WEEK3TXT= "week3txt";
    public static final String WEEK4TXT= "week4txt";
    public static final String WEEK5TXT= "week5txt";
    public static final String WEEK6TXT= "week6txt";
    public static final String WEEK7TXT= "week7txt";
    public static final String WEEK8TXT= "week8txt";
    public static final String WEEK9TXT= "week9txt";
    public static final String WEEK10TXT= "week10txt";

    public static final String IMAGE_COUNT_WEEK1= "image_count_week1";
    public static final String IMAGE_COUNT_WEEK2= "image_count_week2";
    public static final String IMAGE_COUNT_WEEK3= "image_count_week3";
    public static final String IMAGE_COUNT_WEEK4= "image_count_week4";
    public static final String IMAGE_COUNT_WEEK5= "image_count_week5";
    public static final String IMAGE_COUNT_WEEK6= "image_count_week6";
    public static final String IMAGE_COUNT_WEEK7= "image_count_week7";
    public static final String IMAGE_COUNT_WEEK8= "image_count_week8";
    public static final String IMAGE_COUNT_WEEK9= "image_count_week9";
    public static final String IMAGE_COUNT_WEEK10= "image_count_week0";

    public static final String SEASON_NAME= "season_name";
    public static final String SEASON_STORAGE= "storage_path";

    FirebaseRemoteConfig mFirebaseRemoteConfig;
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(this);
        mSettings = this.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        mFirebaseRemoteConfig.setDefaults(R.xml.rem_cfg);
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder().
                setDeveloperModeEnabled(BuildConfig.DEBUG).build();
        mFirebaseRemoteConfig.setConfigSettings(configSettings);

        mFirebaseRemoteConfig.fetch(0).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    mFirebaseRemoteConfig.activateFetched();

                    boolean week1,week2,week3,week4,week5,week6,week7,week8,week9,week10;
                    String week1txt,week2txt,week3txt,week4txt,week5txt,week6txt,week7txt,week8txt,week9txt,week10txt,seasonStorage,season_name;
                    long imageCountWeek1,imageCountWeek2,imageCountWeek3,imageCountWeek4,imageCountWeek5,imageCountWeek6,imageCountWeek7,imageCountWeek8,imageCountWeek9,imageCountWeek10;

                    week1 = mFirebaseRemoteConfig.getBoolean("week1");
                    week2 = mFirebaseRemoteConfig.getBoolean("week2");
                    week3 = mFirebaseRemoteConfig.getBoolean("week3");
                    week4 = mFirebaseRemoteConfig.getBoolean("week4");
                    week5 = mFirebaseRemoteConfig.getBoolean("week5");
                    week6 = mFirebaseRemoteConfig.getBoolean("week6");
                    week7 = mFirebaseRemoteConfig.getBoolean("week7");
                    week8 = mFirebaseRemoteConfig.getBoolean("week8");
                    week9 = mFirebaseRemoteConfig.getBoolean("week9");
                    week10 = mFirebaseRemoteConfig.getBoolean("week10");

                    week1txt = mFirebaseRemoteConfig.getString("week1txt");
                    week2txt = mFirebaseRemoteConfig.getString("week2txt");
                    week3txt = mFirebaseRemoteConfig.getString("week3txt");
                    week4txt = mFirebaseRemoteConfig.getString("week4txt");
                    week5txt = mFirebaseRemoteConfig.getString("week5txt");
                    week6txt = mFirebaseRemoteConfig.getString("week6txt");
                    week7txt = mFirebaseRemoteConfig.getString("week7txt");
                    week8txt = mFirebaseRemoteConfig.getString("week8txt");
                    week9txt = mFirebaseRemoteConfig.getString("week9txt");
                    week10txt = mFirebaseRemoteConfig.getString("week10txt");

                    imageCountWeek1 =  mFirebaseRemoteConfig.getLong("image_count_week1");
                    imageCountWeek2 =  mFirebaseRemoteConfig.getLong("image_count_week2");
                    imageCountWeek3 =  mFirebaseRemoteConfig.getLong("image_count_week3");
                    imageCountWeek4 =  mFirebaseRemoteConfig.getLong("image_count_week4");
                    imageCountWeek5 =  mFirebaseRemoteConfig.getLong("image_count_week5");
                    imageCountWeek6 =  mFirebaseRemoteConfig.getLong("image_count_week6");
                    imageCountWeek7 =  mFirebaseRemoteConfig.getLong("image_count_week7");
                    imageCountWeek8 =  mFirebaseRemoteConfig.getLong("image_count_week8");
                    imageCountWeek9 =  mFirebaseRemoteConfig.getLong("image_count_week9");
                    imageCountWeek10 =  mFirebaseRemoteConfig.getLong("image_count_week10");

                    seasonStorage = mFirebaseRemoteConfig.getString("storage_path");

                    season_name = mFirebaseRemoteConfig.getString("season_name");

                    SharedPreferences.Editor editor = mSettings.edit();

                    editor.putBoolean(WEEK1, week1);
                    editor.putBoolean(WEEK2, week2);
                    editor.putBoolean(WEEK3, week3);
                    editor.putBoolean(WEEK4, week4);
                    editor.putBoolean(WEEK5, week5);
                    editor.putBoolean(WEEK6, week6);
                    editor.putBoolean(WEEK7, week7);
                    editor.putBoolean(WEEK8, week8);
                    editor.putBoolean(WEEK9, week9);
                    editor.putBoolean(WEEK10, week10);

                    editor.putString(WEEK1TXT, week1txt);
                    editor.putString(WEEK2TXT, week2txt);
                    editor.putString(WEEK3TXT, week3txt);
                    editor.putString(WEEK4TXT, week4txt);
                    editor.putString(WEEK5TXT, week5txt);
                    editor.putString(WEEK6TXT, week6txt);
                    editor.putString(WEEK7TXT, week7txt);
                    editor.putString(WEEK8TXT, week8txt);
                    editor.putString(WEEK9TXT, week9txt);
                    editor.putString(WEEK10TXT, week10txt);

                    editor.putLong(IMAGE_COUNT_WEEK1, imageCountWeek1);
                    editor.putLong(IMAGE_COUNT_WEEK2, imageCountWeek2);
                    editor.putLong(IMAGE_COUNT_WEEK3, imageCountWeek3);
                    editor.putLong(IMAGE_COUNT_WEEK4, imageCountWeek4);
                    editor.putLong(IMAGE_COUNT_WEEK5, imageCountWeek5);
                    editor.putLong(IMAGE_COUNT_WEEK6, imageCountWeek6);
                    editor.putLong(IMAGE_COUNT_WEEK7, imageCountWeek7);
                    editor.putLong(IMAGE_COUNT_WEEK8, imageCountWeek8);
                    editor.putLong(IMAGE_COUNT_WEEK9, imageCountWeek9);
                    editor.putLong(IMAGE_COUNT_WEEK10, imageCountWeek10);

                    editor.putString(SEASON_STORAGE, seasonStorage);
                    editor.putString(SEASON_NAME, season_name);

                    editor.apply();
                }
            }
        });
    }
}
