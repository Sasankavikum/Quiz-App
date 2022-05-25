package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.google.android.material.progressindicator.LinearProgressIndicator;

public class DashboardActivity extends AppCompatActivity {

    CountDownTimer countDownTimer;
    int timeValue = 20;
    LinearProgressIndicator progressIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        progressIndicator=findViewById(R.id.timer);

        countDownTimer = new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long l) {
                timeValue=timeValue-1;
                progressIndicator.setProgress(timeValue);
            }

            @Override
            public void onFinish() {
                Dialog dialog = new Dialog(DashboardActivity.this,R.style.Dialog);
                dialog.setContentView(R.layout.activity_time_out);
                dialog.show();
            }
        }.start();
    }
}