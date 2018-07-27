package com.app.custom.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.app.custom.myapplication.Custom_view.TimerTextView;

//倒计时
public class DJiShiActivity extends AppCompatActivity {
   private TimerTextView timerTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dji_shi);
        timerTextView=findViewById(R.id.timer_text_view);
        long[] times={1,10,5,10};
        timerTextView.setTimes(times);

    }

    public void onclick(View view){
        switch (view.getId()){
            case R.id.main_start_btn:
                //开启
                if (!timerTextView.isRun()){
                    timerTextView.beginRun();
                }

                break;

            case R.id.main_stop_btn:
                //停止
                if (timerTextView.isRun()){
                    timerTextView.stopRun();
                }

                break;
        }
    }
}
