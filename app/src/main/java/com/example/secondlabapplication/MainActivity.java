package com.example.secondlabapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ArrayList<String> shopping_list;

    ListItemAdapter adapter;
    RecyclerView myRecyclerView;

    public void addItem (View view){
        this.shopping_list.add("New item");
        int last_position = shopping_list.size() - 1;
        adapter.notifyItemInserted(last_position);
        myRecyclerView.scrollToPosition(last_position);
        Log.d("Click", "Called addItem()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        shopping_list = new ArrayList<String>();

        adapter = new ListItemAdapter(shopping_list);
        myRecyclerView.setAdapter(adapter);

    }

}


