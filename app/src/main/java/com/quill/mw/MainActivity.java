package com.quill.mw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.quill.mw.ui.QuickIndexActivity;
import com.quill.mw.ui.SlideMenuActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView mListView;
    private List<String> activities;
    private List<Class<?>> classes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.main_list);
        getData();
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, R.layout.item_main,activities);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(this);
    }


    public void getData() {
        classes = new ArrayList<>();
        classes.add(SlideMenuActivity.class);//添加Activity
        classes.add(QuickIndexActivity.class);
        activities = new ArrayList<>();
        for (Class<?> clazz: classes) {
            activities.add(clazz+"");
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(MainActivity.this,classes.get(position));
        startActivity(intent);
    }
}
