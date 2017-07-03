package com.example.mind.retrofit_demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by mind on 3/7/17.
 */

class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder>{

    Context context;
    ArrayList<Model> arrayList;

    public RVAdapter(Context context, ArrayList<Model> arrayList) {

        this.context=context;
        this.arrayList=arrayList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.layout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder._id.setText("ID                       "+arrayList.get(position).getId().toString());
        holder._name.setText("First Name      "+arrayList.get(position).getFirstName().toString());
        holder._lname.setText("Last Name      "+arrayList.get(position).getLastName().toString());
        Picasso.with(context).load(arrayList.get(position).getAvatar().toString()).into(holder._image);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView _id,_name,_lname;
        ImageView _image;

        public MyViewHolder(View itemView) {
            super(itemView);
            _id=(TextView)itemView.findViewById(R.id._id);
            _name=(TextView)itemView.findViewById(R.id._name);
            _lname=(TextView)itemView.findViewById(R.id._lname);
            _image=(ImageView)itemView.findViewById(R.id._image);
        }
    }
}
