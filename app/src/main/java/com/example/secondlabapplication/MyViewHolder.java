package com.example.secondlabapplication;

import android.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder{
    public TextView myTextView;
    public EditText editText;
    private ListItemAdapter adapter;

    private final AlphaAnimation onClickAnimation = new AlphaAnimation(1F, 0.6F);

    public static void remove_item(ListItemAdapter adapter, int position){
        adapter.items.remove(position);
        adapter.notifyItemRemoved(position);
    }

    public MyViewHolder(View view) {
        super(view);
        myTextView = view.findViewById(R.id.list_item_id);
        editText = view.findViewById(R.id.edit_item_id);

        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setPositiveButton(R.string.confirm_positive, (dialog, id) -> {
            Log.d("Click", "User taps OK button.");
            remove_item(adapter, getAdapterPosition());
        });
        builder.setNegativeButton(R.string.confirm_negative, (dialog, id) -> {
            Log.d("Click", "User cancels the dialog.");
        });
        builder.setMessage(R.string.confirm_delete_msg);

        AlertDialog dialog = builder.create();

        view.findViewById(R.id.delete_button_id).setOnClickListener(_view -> {
            dialog.show();
            Log.d("Click", "Called deleteItem()");
        });

        view.findViewById(R.id.edit_button_id).setOnClickListener(_view -> {
            _view.startAnimation(onClickAnimation);
            String item = myTextView.getText().toString();
            myTextView.setVisibility(View.GONE);
            editText.setVisibility(View.VISIBLE);
            editText.setText(item);
            editText.setSelection(editText.getText().length());
            Log.d("Click", "Called editItem()");
        });

        view.findViewById(R.id.save_button_id).setOnClickListener(_view -> {

            _view.startAnimation(onClickAnimation);
            if (myTextView.getVisibility() == View.GONE){  // if "Edit button" was clicked
                int position = getAdapterPosition();
                String item = editText.getText().toString();
                myTextView.setVisibility(View.VISIBLE);
                editText.setVisibility(View.GONE);
                myTextView.setText(item);
                adapter.items.set(position, item);
                adapter.notifyItemChanged(position);
            }

            Log.d("Click", "Called saveItem()");
        });

    }

    public MyViewHolder linkAdapter(ListItemAdapter adapter){
        this.adapter = adapter;
        return this;
    }
}

