package com.example.secondlabapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView textView;
    EditText editText;
    private final AlphaAnimation onClickAnimation = new AlphaAnimation(1F, 0.6F);
    public void saveItem (View view){
        view.startAnimation(onClickAnimation);
        textView = findViewById(R.id.list_item_id);
        editText = findViewById(R.id.edit_item_id);
        String item = editText.getText().toString();
        editText.setVisibility(View.GONE);
        textView.setVisibility(View.VISIBLE);
        textView.setText(item);

        Log.d("Click", "Called saveItem()");
    }

    public void editItem (View view){
        view.startAnimation(onClickAnimation);
        textView = findViewById(R.id.list_item_id);
        editText = findViewById(R.id.edit_item_id);
        String item = textView.getText().toString();
        textView.setVisibility(View.GONE);
        editText.setVisibility(View.VISIBLE);
        editText.setText(item);

        Log.d("Click", "Called editItem()");
    }

    public void deleteItem (View view){
        view.startAnimation(onClickAnimation);
        Log.d("Click", "Called deleteItem()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}