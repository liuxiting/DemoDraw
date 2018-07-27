package com.app.custom.myapplication.Custom_view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;


/**
 * Created by Administrator on 2018/7/27 0027.
 */

@SuppressLint("AppCompatCustomView")
public class TimerTextView extends TextView implements Runnable{

    public TimerTextView(Context context) {
        super(context);
    }

    public TimerTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TimerTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

   private long mday,mhour,mmin,msecond;//天，时，分，秒
    private  boolean run=false;//是否启动
    public  void setTimes(long[] times){
        mday=times[0];
        mhour=times[1];
        mhour=times[2];
        mhour=times[3];
    }
    /*
    * 倒计时计算
    * */
    private void ComputeTime(){
        msecond--;
        if (msecond<0){
            mmin--;
            msecond=59;
            if (mmin<0){
                mmin=59;
                mhour--;
                if (mhour<0){
                    mhour=59;
                    mday--;
                }
            }
        }
    }
    public boolean isRun(){
        return run;
    }
    public void beginRun(){
        this.run=true;
        run();
    }
    public void  stopRun(){
        this.run=false;
    }
    @Override
    public void run() {
        if (run){
            ComputeTime();
            String strTime=mday+"天："+mhour+"时："+mmin+"分："+msecond+"秒";
            this.setText(strTime);
            postDelayed(this,1000);
        }else {
            //如果没有启动，就重新启动view
            removeCallbacks(this);
        }
    }
}
