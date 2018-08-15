package com.app.custom.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.app.custom.myapplication.Interface.OkGoUtilsInterFace;
import com.app.custom.myapplication.tools.OkgoUtils;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Button duhua;//动画
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        duhua=findViewById(R.id.duhua);
       String str="{\"ddd\":\"dd\"}";
        Map<String,String> map=new HashMap<>();
        map.put("user2",str);
        OkgoUtils.POST(1, "http://localhost:8080/Two",map,
                "tag", new OkGoUtilsInterFace() {
            @Override
            public void onStart(Request request) {
                Log.i("测试开始","测试开始");

            }

            @Override
            public void onSuccess(Response<String> response, int requestCode) {
                Log.i("测试",response.body());
            }

            @Override
            public void onFinsh() {

            }

            @Override
            public void Error(Response<String> response) {
                Log.i("测试错误",response.message());
            }

            @Override
            public void onNetWorkError() {

            }
        });
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
