package com.e_com.subin.e_commerce;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    private List<Person> persons;
    private RecyclerView rv;
    TextView tv;

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_blank, container, false);
        rv=(RecyclerView)view.findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        //rv.setHasFixedSize(true);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
               initializeData();
            initializeAdapter();
        return  view;
    }

    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Engineering Mechanics","Erwing H Shames",R.drawable.shames,"725"));
        persons.add(new Person("Concise Inorganic Chemistry","J D Lee",R.drawable.lee,"700"));
        persons.add(new Person("Concepts of Modern Physics","Arthur Beiser",R.drawable.arthur,"540"));
        persons.add(new Person("Engineering Drawing","N D Bhatt",R.drawable.bhatter,"200"));
        persons.add(new Person("Advanced Engineering Mathematics","Erwin Kreyszig",R.drawable.kreyszig,"759"));
        persons.add(new Person("Programming in ANSI C","E Balaguruswamy",R.drawable.swamy,"390"));
        persons.add(new Person("Let Us C (solutions)","Yaswant Kanetkar",R.drawable.yaswantso,"270"));
        persons.add(new Person("Let Us C","Yaswant Kanetkar",R.drawable.yaswant,"270"));
        persons.add(new Person("Enginnering Mathematics","B S Grewal",R.drawable.grewal,"625"));
        persons.add(new Person("Modern Physics for Engineers and Scientists","John R. Taylor",R.drawable.taylor,"425"));
        persons.add(new Person("Electrical Technology","S Chand",R.drawable.chand,"370"));
        persons.add(new Person("Enginnering Mathematics","N.P Bali,Ramadevi",R.drawable.rama,"1095"));
        persons.add(new Person("Textbook of Organic Chemistry","    ",R.drawable.can,"375"));
        persons.add(new Person("Vector Analysis","Murrey R",R.drawable.murrey,""));
        persons.add(new Person("Fundamentals of Physics","Haliday Resnick",R.drawable.resnik,"699"));
        persons.add(new Person("Electric Circuits","R.James & Susan",R.drawable.jame,""));
        persons.add(new Person("Electrical Devices and Circuit Theory","Robert L Boylestad",R.drawable.stad,"800"));

    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
