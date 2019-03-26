package com.example.caddo;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nameEdit = (EditText) findViewById(R.id.name);
        final Spinner spinnerEdit = (Spinner) findViewById(R.id.spinner);
        final EditText numberEdit = (EditText) findViewById(R.id.number);
        final EditText passwordEdit = (EditText) findViewById(R.id.password);


        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                assert msg != null;
                if(msg != null && msg.obj != null && msg.obj.toString().equals("Login Success")) {
                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    Conf.username = nameEdit.getText().toString();
                    Intent intent = new Intent(MainActivity.this , chatfriend.class);
                    startActivity(intent);
                } else  {
                    Toast.makeText(MainActivity.this ,"用户登录失败，请重试" , Toast.LENGTH_SHORT).show();
                }
            }
        };

        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String result = nameEdit.getText().toString() + "=" + spinnerEdit.getSelectedItem().toString() + "=" + numberEdit.getText().toString() + "=" + passwordEdit.getText().toString();

                new Thread() {
                    @Override
                    public void run() {
                        try {

                            URL url = new URL("http://192.168.56.1:8080/HttpServlet/login");
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                            httpURLConnection.setConnectTimeout(50 * 100);
                            httpURLConnection.setReadTimeout(5 * 1000);
                            httpURLConnection.setUseCaches(true);

                            httpURLConnection.setRequestMethod("POST");
                            httpURLConnection.setRequestProperty("Charset", "UTF-8");

                            httpURLConnection.connect();

                            OutputStream outputStream = httpURLConnection.getOutputStream();
                            outputStream.write(result.getBytes());
                            outputStream.close();

                            InputStream inputStream = httpURLConnection.getInputStream();
                            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                            StringBuffer buffer = new StringBuffer();
                            String temp = "";
                            while ((temp = bufferedReader.readLine()) != null) {
                                buffer.append(temp);
                            }

                            inputStream.close();
                            inputStreamReader.close();
                            bufferedReader.close();
                            

                            Log.i("http请求结果为", buffer.toString());

                            Message msg = Message.obtain();
                            msg.obj = buffer.toString();
                            handler.sendMessage(msg);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }


                }.start();

            }
        });

    }


     public void register(View view) {
        Intent intent = new Intent(MainActivity.this  , register.class);
        startActivity(intent);
     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
