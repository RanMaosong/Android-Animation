package com.example.song.animation;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class ListView3 extends AppCompatActivity {
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);
        list = (ListView) findViewById(R.id.list_view1);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.list_view);
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(anim);
        layoutAnimationController.setOrder(LayoutAnimationController.ORDER_NORMAL);
        layoutAnimationController.setDelay(1);
        list.setLayoutAnimation(layoutAnimationController);
        String [] arr_data = {"数据1","数据2","数据3","数据4","数据5","数据6"};

        BaseAdapter arr_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr_data);
        //视图(ListView)加载适配器
        list.setAdapter(arr_adapter);


    }
}
