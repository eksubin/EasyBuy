package com.e_com.subin.e_commerce;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class page_1 extends Activity {
    String num = "9567347844";
    String msg = "this is a e-commerce generated app!";
    int value;
    public static final String DEFAULT = "N/A";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_1);
        new Thread(new BarUpdate()).start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_page_1, menu);
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

    private class BarUpdate implements Runnable {

        @Override
        public void run() {

            for (int i = 0; i <= 60; i++) {
                try {
                    Thread.sleep(60);
                    value = i;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(value == 60) {

                    SharedPreferences sharedPreferences = getSharedPreferences("username", Context.MODE_PRIVATE);
                    String data = sharedPreferences.getString("name",DEFAULT);
                    if(data.equals(DEFAULT))
                    {
                        Intent myinte = new Intent(getApplicationContext(),page_2.class);
                        startActivity(myinte);
                        finish();
                    }
                    else
                    {
                        Intent j = new Intent(getApplicationContext(), page_3.class);
                        startActivity(j);
                        finish();
                    }

                    }
                }
            }

    }
}
