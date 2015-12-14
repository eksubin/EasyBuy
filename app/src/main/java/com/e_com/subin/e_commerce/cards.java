package com.e_com.subin.e_commerce;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


public class cards extends ActionBarActivity {

    String CheckBox_intiger= "0";
    CheckBox f5;
    CheckBox f7;
    CheckBox f10;
    String book_name;
    String Author, price;
    TextView tv,tv1,tv2,index2;
    String num = "8156807364", sms,num2 = "8129991290" ,num3= "8281937745";
    final Context context = this;
    public static final String DEFAULT = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        f5 = (CheckBox)findViewById(R.id.checkbox);
        f7 = (CheckBox)findViewById(R.id.checkBox2);
        f10 = (CheckBox)findViewById(R.id.checkBox3);
        book_name = getIntent().getExtras().getString("Book_name");
        Author = getIntent().getExtras().getString("Author");
        price = getIntent().getExtras().getString("price");
        tv= (TextView) findViewById(R.id.book);
        tv1= (TextView) findViewById(R.id.author);
        tv2= (TextView) findViewById(R.id.price);
        index2= (TextView)findViewById(R.id.index1);
        index2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog);
                dialog.setTitle("Index");

                // set the custom dialog components - text, image and button
                TextView text = (TextView) dialog.findViewById(R.id.text);
                text.setText("It shows the quality of the book\nAccording to that, price is determined");
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }

        });
        tv.setText(book_name);
        tv1.setText("Author : " +Author);
        tv2.setText("Price : " +price);}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cards, menu);
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
           Intent intent= new Intent(getApplicationContext(), About.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public void Send_data(View view) {
        SharedPreferences get_name = getSharedPreferences("username",MODE_PRIVATE);
        String data = get_name.getString("name","");
        String regnum = get_name.getString("reg","");
            sms = data + "\n" + regnum + "\n" +book_name +"\n" + Author + "\n" + price + "\n" + CheckBox_intiger;
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(num3, null, sms, null, null);
            Toast.makeText(getApplicationContext(), "Sending Data...", Toast.LENGTH_SHORT).show();
        }

        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Sending failed, please try again.", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public void f5_click(View view) {
        CheckBox_intiger = "5";
    }

    public void f7_click(View view) {
        CheckBox_intiger = "7";
    }

    public void f10_click(View view) {
        CheckBox_intiger = "10";
    }

}



