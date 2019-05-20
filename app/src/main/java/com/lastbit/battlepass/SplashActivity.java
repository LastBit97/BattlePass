package com.lastbit.battlepass;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SplashActivity extends AppCompatActivity {

    Handler handler = new Handler();
    private TextView loading;
    String [] whatLoadString = {"We are looking for a star","Connect to the Internet"};
    Random random = new Random();
    int rand = Integer.valueOf(random.nextInt(whatLoadString.length));
    String loadTxt = whatLoadString[rand];
    int connect;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        loading = findViewById(R.id.loading);
        loading.setText(String.valueOf(loadTxt));


        startWork();

    }
    public void startWork(){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (hasConnection(SplashActivity.this)==true) {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    startWork();
                    loadingAnimate(); // поменять текст, передаётся одно и тоже
                }

            }
//        },2500);
        },1000);
    }

    public void loadingAnimate() {
        connect++;
                if(connect==3) {
                    Toast toast = Toast.makeText(this, getString(R.string.internet_error), Toast.LENGTH_SHORT);
                    toast.show();
                    connect=0;
                }
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
}

