package com.app.custom.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DhuaActivity extends AppCompatActivity {
    private TextView textview;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhua);
        button=(Button)findViewById(R.id.scale);
        textview=(TextView) findViewById(R.id.textview);
    }

   public void onclick(View view){
        switch (view.getId())
        {
            case R.id.translate:
                //平移
                textview.startAnimation(AnimationUtils.loadAnimation
                        (DhuaActivity.this,R.anim.translateanim));
                textview.setText("android:fromXDelta     起始点X轴坐标，可以是数值、百分数、百分数p 三种样式，比如 50、50%、50%p，具体意义已在scale标签中讲述，这里就不再重讲\n" +
                        "android:fromYDelta    起始点Y轴从标，可以是数值、百分数、百分数p 三种样式；\n" +
                        "android:toXDelta         结束点X轴坐标\n" +
                        "android:toYDelta        结束点Y轴坐标android:duration        动画持续时间，以毫秒为单位 \n" +
                        "android:fillAfter          如果设置为true，控件动画结束时，将保持动画最后时的状态\n" +
                        "android:fillBefore       如果设置为true,控件动画结束时，还原到开始动画前的状态\n" +
                        "android:fillEnabled    与android:fillBefore 效果相同，都是在动画结束时，将控件还原到初始化状态\n" +
                        "android:repeatCount 重复次数\n" +
                        "android:repeatMode\t重复类型，有reverse和restart两个值，reverse表示倒序回放，restart表示重新放一遍，必须与repeatCount一起使用才能看到效果。因为这里的意义是重复的类型，即回放时的动作。\n" +
                        "android:interpolator  设定插值器，其实就是指定的动作效果，比如弹跳效果等，不在这小节中讲解，后面会单独列出一单讲解。");
                break;
            case R.id.rotate://旋转

                textview.startAnimation(AnimationUtils.loadAnimation
                        (DhuaActivity.this,R.anim.rotateanim));
                textview.setText("android:fromDegrees     开始旋转的角度位置，正值代表顺时针方向度数，负值代码逆时针方向度数\n" +
                        "android:toDegrees         结束时旋转到的角度位置，正值代表顺时针方向度数，负值代码逆时针方向度数\n" +
                        "android:pivotX               缩放起点X轴坐标，可以是数值、百分数、百分数p 三种样式，比如 50、50%、50%p，具体意义已在scale标签中讲述，这里就不再重讲\n" +
                        "android:pivotY               缩放起点Y轴坐标，可以是数值、百分数、百分数p 三种样式，比如 50、50%、50%p" +
                        "android:duration        动画持续时间，以毫秒为单位 \n" +
                        "android:fillAfter          如果设置为true，控件动画结束时，将保持动画最后时的状态\n" +
                        "android:fillBefore       如果设置为true,控件动画结束时，还原到开始动画前的状态\n" +
                        "android:fillEnabled    与android:fillBefore 效果相同，都是在动画结束时，将控件还原到初始化状态\n" +
                        "android:repeatCount 重复次数\n" +
                        "android:repeatMode\t重复类型，有reverse和restart两个值，reverse表示倒序回放，restart表示重新放一遍，必须与repeatCount一起使用才能看到效果。因为这里的意义是重复的类型，即回放时的动作。\n" +
                        "android:interpolator  设定插值器，其实就是指定的动作效果，比如弹跳效果等，不在这小节中讲解，后面会单独列出一单讲解。");
                break;
            case R.id.alpha:
                //透明度动画
                textview.startAnimation(AnimationUtils.loadAnimation
                        (DhuaActivity.this,R.anim.alphaanim));
                 textview.setText(" android:fromAlpha   动画开始的透明度，从0.0 -1.0 ，0.0表示全透明，1.0表示完全不透明\n" +
                         "android:toAlpha       动画结束时的透明度，也是从0.0 -1.0 ，0.0表示全透明，1.0表示完全不透明\n" +
                         "\n" +
                         " android:duration        动画持续时间，以毫秒为单位\n" +
                         "android:fillAfter          如果设置为true，控件动画结束时，将保持动画最后时的状态\n" +
                         "android:fillBefore       如果设置为true,控件动画结束时，还原到开始动画前的状态\n" +
                         "android:fillEnabled    与android:fillBefore 效果相同，都是在动画结束时，将控件还原到初始化状态\n" +
                         "android:repeatCount 重复次数\n" +
                         "android:repeatMode\t重复类型，有reverse和restart两个值，reverse表示倒序回放，restart表示重新放一遍，必须与repeatCount一起使用才能看到效果。因为这里的意义是重复的类型，即回放时的动作。\n" +
                         "android:interpolator  设定插值器，其实就是指定的动作效果，比如弹跳效果等，不在这小节中讲解，后面会单独列出一单讲解。\n" +
                         "与scale标签意义一样，就不再缀述。");
                break;
            case R.id.scale://缩放动画
                textview.startAnimation(AnimationUtils.loadAnimation(DhuaActivity.this,R.anim.scaleanim));
            textview.setText("android:fromXScale    起始的X方向上相对自身的缩放比例，浮点值，比如1.0代表自身无变化，0.5代表起始时缩小一倍，2.0代表放大一倍；\n" +
                    "android:toXScale        结尾的X方向上相对自身的缩放比例，浮点值；\n" +
                    "android:fromYScale    起始的Y方向上相对自身的缩放比例，浮点值，\n" +
                    "android:toYScale        结尾的Y方向上相对自身的缩放比例，浮点值；\n" +
                    "android:pivotX            缩放起点X轴坐标，可以是数值、百分数、百分数p 三种样式，比如 50、50%、50%p，当为数值时，表示在当前View的左上角，即原点处加上50px，做为起始缩放点；如果是50%，表示在当前控件的左上角加上自己宽度的50%做为起始点；如果是50%p，那么就是表示在当前的左上角加上父控件宽度的50%做为起始点x轴坐标。（具体意义，后面会举例演示）\n" +
                    "android:pivotY           缩放起点Y轴坐标，取值及意义跟android:pivotX一样。" +
                    "android:fillAfter          如果设置为true，控件动画结束时，将保持动画最后时的状态" +
                    "android:repeatCount 重复次数" +
                    "android:repeatMode\t重复类型，有reverse和restart两个值，reverse表示倒序回放，restart表示重新放一遍，" +
                    "必须与repeatCount一起使用才能看到效果。因为这里的意义是重复的类型，即回放时的动作。");

                break;
        }

    }
}
