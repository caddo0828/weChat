package com.example.android;
import com.example.caddo.Conf;

public class PushMsg {
    private String name;
    private int imageId;
    private String result;


    public PushMsg( int imageId , String result) {
        this.name = Conf.username;
        this.imageId = imageId;
        this.result = result;
    }

    public PushMsg(String name ,int imageId ,String result) {
        this.name = name;
        this.imageId = imageId;
        this.result = result;

    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getResult() {
        return result;
    }



}
