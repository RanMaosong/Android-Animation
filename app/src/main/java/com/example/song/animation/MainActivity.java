package com.example.song.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button viewAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        addEvent();
    }

    private void initView() {
        viewAnim = (Button) findViewById(R.id.view_anim_code);
    }

    private void addEvent() {
        viewAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewAnimation.class);
                startActivity(intent);
            }
        });

    }

    public void listView1(View view) {
        Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    public void listView2(View view) {
        Intent intent = new Intent(MainActivity.this, ListView2.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void listView3(View view) {
        Intent intent = new Intent(MainActivity.this, ListView3.class);
        startActivity(intent);
    }
}
