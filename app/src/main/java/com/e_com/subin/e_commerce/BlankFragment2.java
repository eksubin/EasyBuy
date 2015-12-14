package com.e_com.subin.e_commerce;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class BlankFragment2 extends Fragment {

    private List<Person> persons;
    private RecyclerView rv;
    TextView tv;

    public BlankFragment2() {
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
        View view= inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
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
        persons.add(new Person("Sorry", "", R.drawable.juststarted,""));
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
