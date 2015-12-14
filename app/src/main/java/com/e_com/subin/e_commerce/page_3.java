package com.e_com.subin.e_commerce;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class page_3 extends ActionBarActivity {
private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout dl;
    ListView lv;
    private FragmentTransaction fragmentTransaction;
    private FragmentTransaction fragmentTransaction1;
    private FragmentManager fragmentManager;

    String msg = "this is a e-commerce generated app!";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_3);


       dl = (DrawerLayout) findViewById(R.id.main_activity_drawer_layout);
        lv= (ListView) findViewById(R.id.list);
        lv.setFocusable(false);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,dl,R.string.open_drawer,R.string.close_drawer);
        dl.setDrawerListener(actionBarDrawerToggle);
        //to get the icon of action bar
        android.support.v7.app.ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        //creating theString array
        ArrayList<String> fragments=new ArrayList<>();
        fragments.add("Year 1");
        fragments.add("Year 2");
        fragments.add("Year 3 & 4");
        fragments.add("Extras");
        ArrayAdapter arrayAdapter= new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_activated_1,fragments);
        lv.setAdapter(arrayAdapter);

        //setting the fragment
        fragmentManager = getSupportFragmentManager();


        //set onclick -list view
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               loadSelection(i);

                dl.closeDrawer(lv);
            }

        });
        loadSelection(0);//setting the first selection as 0
        //to get the telephone num

    }
 public void loadSelection(int i)
 {
     lv.setItemChecked(i,true);
     switch (i)
     {
         case 0:
            BlankFragment fragment1= new BlankFragment();
             fragmentTransaction= fragmentManager.beginTransaction();
             fragmentTransaction.replace(R.id.fragmentHolder, fragment1);
             fragmentTransaction.commit();
             break;
         case 1:
            BlankFragment2 fragment2= new BlankFragment2();
             fragmentTransaction= fragmentManager.beginTransaction();

             fragmentTransaction.replace(R.id.fragmentHolder, fragment2);
             fragmentTransaction.commit();
             break;
         case 2:
             BlankFragment2 fragment4= new BlankFragment2();
             fragmentTransaction= fragmentManager.beginTransaction();

             fragmentTransaction.replace(R.id.fragmentHolder, fragment4);
             fragmentTransaction.commit();
             break;
         case 3:
             BlankFragment3 fragment3= new BlankFragment3();
             fragmentTransaction= fragmentManager.beginTransaction();
             fragmentTransaction.replace(R.id.fragmentHolder, fragment3);
             fragmentTransaction.commit();
             break;
     }


 }
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_page_3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            Intent call_about = new Intent(getApplicationContext(),About.class);
            startActivity(call_about);
            return true;
        }

        //enabling the icon to control the drawer
        else if (id == android.R.id.home)
        {
            if (dl.isDrawerOpen(lv))
            {
                dl.closeDrawer(lv);
            }
            else
            {
                dl.openDrawer(lv);
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
