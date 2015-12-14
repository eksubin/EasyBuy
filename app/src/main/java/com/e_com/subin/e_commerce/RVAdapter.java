package com.e_com.subin.e_commerce;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{




    public static class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView price;
        CardView cv;
        TextView personName;
        TextView personAge;
        ImageView personPhoto;
        Context context;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.person_name);
            personAge = (TextView)itemView.findViewById(R.id.person_age);
            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
            price = (TextView) itemView.findViewById(R.id.price);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent shruti = new Intent(v.getContext(),cards.class);
                    String name= (String) personName.getText();
                    String age= (String) personAge.getText();
                    String priceTag = price.getText().toString();
                    shruti.putExtra("Book_name",name);
                    shruti.putExtra("Author",age);
                    shruti.putExtra("price",priceTag);
                    v.getContext().startActivity(shruti);
                }
            });
        }

        @Override
        public void onClick(View v) {
            context.startActivity(new Intent(context,page_1.class));


        }
    }

    List<Person> persons;

    RVAdapter(List<Person> persons){
        this.persons = persons;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.personName.setText(persons.get(i).name);
        personViewHolder.personAge.setText(persons.get(i).age);
        personViewHolder.personPhoto.setImageResource(persons.get(i).photoId);
        personViewHolder.price.setText(persons.get(i).price);
        Log.d("open","BindViewHolder" + i);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }


}
