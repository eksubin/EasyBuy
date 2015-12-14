package com.e_com.subin.e_commerce;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.e_com.subin.e_commerce.R.id.name;


public class page_2 extends ActionBarActivity {

    private Button button;
    private EditText et, rnum;
    String name,regnum;
    boolean i=false,j=false;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_2);
        button = (Button) findViewById(R.id.enter);
        et = (EditText) findViewById(R.id.name);
        rnum = (EditText) findViewById(R.id.rnum);
       et.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

           }

           @Override
           public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

           }

           @Override
           public void afterTextChanged(Editable editable) {
                i=true;
               if(i&&j){
                    button.setClickable(true);
               }
           }
       });
        rnum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                j=true;
                if(i&&j){
                    button.setClickable(true);
                }
            }
        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_page_2, menu);
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
            Intent intent= new Intent(getApplicationContext(),About.class);
            startActivity(intent);;
        }

        return super.onOptionsItemSelected(item);
    }

    public void enter(View view) {
        name= et.getText().toString();
        regnum = rnum.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("username", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name",name);
        editor.putString("reg",regnum);
        editor.apply();
        Intent intent = new Intent(getApplicationContext(), page_3.class);
        startActivity(intent);
        finish();
    }


}
