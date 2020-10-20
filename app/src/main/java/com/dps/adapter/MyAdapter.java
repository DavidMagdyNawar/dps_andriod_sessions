package com.dps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dps.R;
import com.dps.model.SoftwareEngineer;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<SoftwareEngineer> softwareEngineerList;
    private Context context;

    //constructor
    public MyAdapter(List<SoftwareEngineer> softwareEngineerList, Context context) {
        this.softwareEngineerList = softwareEngineerList;
        this.context = context;
    }

    @NonNull
    @Override
    // Each view holder is in charge of displaying a single item with a view for our awesome recycler view
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);

        return new MyViewHolder(itemView);
    }

    // This method is used for binding the data to it's position on the recycler view - check " position " parameter passed to it
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SoftwareEngineer softwareEngineer = softwareEngineerList.get(position);
        holder.name.setText(softwareEngineer.getName());
        holder.title.setText(softwareEngineer.getTitle());
        Glide.with(context).load(softwareEngineer.getImage()).circleCrop().into(holder.image);

    }


    // This method return the counts for the while recycler view items
    @Override
    public int getItemCount() {
        return softwareEngineerList.size();
    }

    // cast views from the view holder
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, title;
        public ShapeableImageView image;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            name = (TextView) view.findViewById(R.id.name);
            image = (ShapeableImageView) view.findViewById(R.id.image);
        }
    }
}
