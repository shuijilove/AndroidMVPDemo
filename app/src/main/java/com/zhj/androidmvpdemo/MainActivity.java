package com.zhj.androidmvpdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.zhj.androidmvpdemo.activity.BookActivity;

public class MainActivity extends AppCompatActivity {
    private EditText et_book;
    private Button bt_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        et_book = (EditText) findViewById(R.id.et_book);
        bt_search = (Button) findViewById(R.id.bt_search);
        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BookActivity.class);
                intent.putExtra("key",et_book.getText().toString());
                startActivity(intent);
            }
        });
    }
}
