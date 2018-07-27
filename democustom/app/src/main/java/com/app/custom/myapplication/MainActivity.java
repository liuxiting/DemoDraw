package com.app.custom.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button duhua;//动画
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        duhua=findViewById(R.id.duhua);
    }
    public void onclick(View view){
        switch (view.getId()){
            case R.id.duhua://动画
                startActivity(new Intent(MainActivity.this,DhuaActivity.class));
                break;
            case R.id.jishi:
                //倒计时自定义控件
                startActivity(new Intent(MainActivity.this,DJiShiActivity.class));


                break;
        }
    }
}
