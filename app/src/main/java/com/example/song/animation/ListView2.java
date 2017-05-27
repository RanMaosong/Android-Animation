package com.example.song.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class ListView2 extends AppCompatActivity {
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);
        list = (ListView) findViewById(R.id.list_view1);
        String [] arr_data = {"数据1","数据2","数据3","数据4"};

        BaseAdapter arr_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr_data);
        //视图(ListView)加载适配器
        list.setAdapter(arr_adapter);
    }
}
