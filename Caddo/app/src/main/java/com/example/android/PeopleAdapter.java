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
        //��ȡ��ǰʵ��
        PushMsg people = (PushMsg) getItem(position);

        //ʵ������ǰ����
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);

        //��ȡ��ǰ���ֵ�ͼƬ��ͼ
        ImageView peopleImage = (ImageView)view.findViewById(R.id.people_image);

        // ��ȡ�ò����ļ����ı���ͼ
        TextView peopleName = (TextView)view.findViewById(R.id.people_name);

        //ΪͼƬ��ͼ����ͼƬ��Դ
        peopleImage.setImageResource(people.getImageId());

        //Ϊ�ı���ͼ�����ı�����
        peopleName.setText(people.getName());

        //��ȡ����������ͼ , ���һ�ȡ������Ϣ
        TextView showEd = (TextView)view.findViewById(R.id.show);

        //Ϊ������ͼ����ı����� (����Ϊ������Ϣ������������)
        showEd.setText(people.getResult());


        return view;

    }


}
