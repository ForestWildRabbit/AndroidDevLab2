package com.example.secondlabapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListItemAdapter extends RecyclerView.Adapter<MyViewHolder> {

    public ArrayList<String> items;

    @Override
    public int getItemCount() {
        return items.size();
    }
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int ViewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent, false);
        Log.d("Adapter", "OnCreateViewHolder");
        return new MyViewHolder(view).linkAdapter(this);
    }
    public void onBindViewHolder(MyViewHolder vh, int position) {
        Log.d("Adapter", "OnBindViewHolder for position: " + position);
        vh.myTextView.setText(items.get(position));
    }
    // Provide a suitable constructor (depends on the kind of dataset)
    public ListItemAdapter(ArrayList<String> dataset) {
        items = dataset;
    }

}



