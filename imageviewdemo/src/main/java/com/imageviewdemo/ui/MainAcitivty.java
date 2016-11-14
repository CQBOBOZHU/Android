package com.imageviewdemo.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.Movie;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import com.imageviewdemo.R;
import com.imageviewdemo.ui.adapter.RecyclerAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/10/25.
 */
public class MainAcitivty extends Activity {
    ListView mlistview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.main_activity);
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        initData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerAdapter(mData,this,R.layout.list_item));

        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.gifView);
        View header= LayoutInflater.from(this).inflate(R.layout.listview_header,null);
        mlistview = (ListView) findViewById(R.id.listview);
        mlistview.addHeaderView(header,null,false);

        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setAutoPlayAnimations(true)//自动播放动画
//                .setUri(Uri.parse("asset://com.imageviewdemo/de.gif"))//路径
                .setUri(Uri.parse("http://images.17173.com/2014/news/2014/12/29/2014cpb1229gif01.gif"))
                .build();
        simpleDraweeView.setController(draweeController);
        int a=3;
        int b=(++a>2)?(a++):(a=3);
        Log.v("this",b+"");

        mlistview.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return mData.size();
            }

            @Override
            public Object getItem(int position) {
                return mData.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view=LayoutInflater.from(MainAcitivty.this).inflate(R.layout.list_item,null);
                TextView t_view= (TextView) view.findViewById(R.id.item_textview);
                t_view.setText(mData.get(position));
                return view;
            }
        });
    }
    List<String> mData=new ArrayList<String>();
    private void initData() {
        for (int i=0;i<50;i++){
            mData.add("adada"+i);
        }
    }


}
