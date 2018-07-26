package com.app.arcgis.demodraw;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.esri.android.map.GraphicsLayer;
import com.esri.android.map.MapView;
import com.esri.android.map.event.OnSingleTapListener;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.Polygon;
import com.esri.core.geometry.Polyline;
import com.esri.core.map.Graphic;
import com.esri.core.symbol.SimpleFillSymbol;
import com.esri.core.symbol.SimpleLineSymbol;
import com.esri.core.symbol.SimpleMarkerSymbol;

import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button Polyline;//划线
    private Button Polygon;//
    private MapView mapview;
    GraphicsLayer graphicsLayer;//图层，用于显示点线面要素
    SimpleLineSymbol simpleLineSymbol;//线
    SimpleMarkerSymbol simpleMarkerSymbol;//点
    SimpleFillSymbol simpleFillSymbol;//面
    List<Point> points=new ArrayList<>();//承载点击的位置点信息
    private int tag=0;//划线还是画面的标记 0划线，1画面 默认划线
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Polygon=(Button)findViewById(R.id.Polygon);//划线button
        Polyline=(Button)findViewById(R.id.Polyline);//面button
        mapview=findViewById(R.id.map);//地图
        graphicsLayer=new GraphicsLayer();//图层添加对象
        mapview.addLayer(graphicsLayer);//把该对象加载到地图上
        //点要素实例化并设置颜色和宽度
        simpleMarkerSymbol= new SimpleMarkerSymbol(Color.RED, 7, SimpleMarkerSymbol.STYLE.CIRCLE);
        simpleMarkerSymbol.setOutline(new SimpleLineSymbol(Color.BLUE, 1));
        //
        Polyline.setOnClickListener(new View.OnClickListener() {
            //选择划线监听事件
            @Override
            public void onClick(View view) {
                tag=0;
                //把之前的要素清楚
                if (points.size()>0){
                    points.clear();
                }
                if (graphicsLayer!=null){
                    graphicsLayer.removeAll();

                }
            }
        });
        Polygon.setOnClickListener(new View.OnClickListener() {
            //选择画面监听事件
            @Override
            public void onClick(View view) {
                tag=1;
                //把之前的要素清楚
                if (points.size()>0){
                    points.clear();
                }
                if (graphicsLayer!=null){
                    graphicsLayer.removeAll();

                }
            }
        });
         mapview.setOnSingleTapListener(new OnSingleTapListener() {
          //地图的点击监听事件
          @Override
          public void onSingleTap(float v, float v1) {
              if (tag==0){

                  drawline(v, v1);//画线
              }else {

                  drawgon(v,v1);//画面
              }


          }
      });//setOnSingleTapListener
    }
     private  void drawgon(float v,float v1) {
        //画面的方法
         simpleFillSymbol = new SimpleFillSymbol(Color.BLUE);//创建面要素对象
         points.add(mapview.toMapPoint(v, v1));//把点击的点坐标添加到list集合
         //显示点
         graphicsLayer.addGraphic(new Graphic(mapview.toMapPoint(v, v1), simpleMarkerSymbol));
         //生成面积
         com.esri.core.geometry.Polygon polygon = new Polygon();//arcgis 面的对象

         if (points.size() > 1) {
             //依次把点转成Polygon
             for (int i = 0; i < points.size(); i++) {
                 if (i == 0) {
                     polygon.startPath(points.get(i));
                 } else {
                     polygon.lineTo(points.get(i));
                 }
             }
             //绘制面，因为graphicsLayer在上面已经加载到地图上面了，
             // 所以这里需要把要素和点的集合加载到graphicsLayer图层对象上就可以加显示在地图上
             graphicsLayer.addGraphic(new Graphic(polygon, simpleFillSymbol));
         }
     }
    private void drawline(float v, float v1) {
        simpleLineSymbol=new SimpleLineSymbol(Color.BLUE, 3);//创建线要素对象
        points.add(mapview.toMapPoint(v,v1));//把点击的点坐标添加到list集合
        //显示点
        graphicsLayer.addGraphic(new Graphic(mapview.toMapPoint(v,v1),simpleMarkerSymbol));
        com.esri.core.geometry.Polyline polyline=new Polyline();//arcgis 线的对象
        //生成线
        if (points.size()>1) {
            //依次把点转成Polyline
            for (int i = 0; i < points.size(); i++) {
                if (i == 0) {
                    polyline.startPath(points.get(i));
                } else {
                    polyline.lineTo(points.get(i));
                }
            }
            //绘制线 因为graphicsLayer在上面已经加载到地图上面了，
            // 所以这里需要把要素和点的集合加载到graphicsLayer图层对象上就可以加显示在地图上
            graphicsLayer.addGraphic(new Graphic(polyline, simpleLineSymbol));
        }
    }
}
