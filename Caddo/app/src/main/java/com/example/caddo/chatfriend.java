package com.example.caddo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.android.PeopleAdapter;
import com.example.android.PushMsg;

import java.util.ArrayList;
import java.util.List;


public class chatfriend extends ActionBarActivity {

    private List<PushMsg> msgList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatfriend);


        initPeople();
        PeopleAdapter adapter = new PeopleAdapter(chatfriend.this ,R.layout.people_item , msgList );
        ListView listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(adapter);

        ImageButton imageButton = (ImageButton)findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(chatfriend.this, talk.class);
                startActivity(intent);
            }
        });

    }


    //初始化朋友信息
    public void initPeople() {

        PushMsg caddo = new PushMsg("Lisa" , R.drawable.people1 ,"这里是朋友信息显示界面");
        msgList.add(caddo);
        PushMsg tq = new PushMsg("Mike",R.drawable.people2 ,"Aal izz well（一切都好）" );
        msgList.add(tq);
        PushMsg elina = new PushMsg("elina",R.drawable.friend2, "Where did Grandpa find Hachi?Ronnie, actually, Hachi found your grandfather." );
        msgList.add(elina);
        PushMsg sea = new PushMsg("sea",R.drawable.friend3 ,"如果我再也见不到你，我祝你早上好，中午好，晚上好");
        msgList.add(sea);
        PushMsg quene = new PushMsg("Caddo",R.drawable.friend1,"Mathilda： Is life always this hard, or is it just when you're a kid? LOEN： Always like this." );
        msgList.add(quene);
        PushMsg solar = new PushMsg("solar",R.drawable.friend3 ,"生活就像一盒巧克力,你无法预知会吃到什么口味");
        msgList.add(solar);
        PushMsg jenny = new PushMsg("jenny",R.drawable.friend1,"我曾听人说过，当你不能够再拥有，你唯一可以做的，就是令自己不要忘记" );
        msgList.add(jenny);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chatfriend, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
