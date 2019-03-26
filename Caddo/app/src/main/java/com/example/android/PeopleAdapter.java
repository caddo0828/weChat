package com.example.android;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.caddo.R;

import java.util.List;

public class PeopleAdapter extends ArrayAdapter {
    private final int resourceId;

    public PeopleAdapter(Context context ,int textViewResourceId ,List<PushMsg> objects) {
        super(context ,textViewResourceId ,objects);
        resourceId = textViewResourceId;
    }

    public View getView(int position ,View convertView ,ViewGroup parent) {
        //获取当前实例
        PushMsg people = (PushMsg) getItem(position);

        //实例化当前对象
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);

        //获取当前布局的图片视图
        ImageView peopleImage = (ImageView)view.findViewById(R.id.people_image);

        // 获取该布局文件的文本视图
        TextView peopleName = (TextView)view.findViewById(R.id.people_name);

        //为图片视图设置图片资源
        peopleImage.setImageResource(people.getImageId());

        //为文本视图设置文本内容
        peopleName.setText(people.getName());

        //获取发表内容视图 , 并且获取盆友信息
        TextView showEd = (TextView)view.findViewById(R.id.show);

        //为内容视图添加文本内容 (或者为盆友信息界面设置内容)
        showEd.setText(people.getResult());


        return view;

    }


}
