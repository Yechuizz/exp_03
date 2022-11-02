package com.example.exp_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView listview;
    private TextView textview;
    private ImageView imageview;
    private String[] names = {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
    private int []images = {R.drawable.lion, R.drawable.tiger, R.drawable.monkey, R.drawable.dog, R.drawable.cat, R.drawable.elephant};
    private List<Map<String,Object>> list1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = findViewById(R.id.list_view);

        for (int i=0; i<names.length; i++){
            Map<String, Object> item = new HashMap<>();
            item.put("names", names[i]);
            item.put("images", images[i]);
            list1.add(item);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this, list1, R.layout.logic,
                new String[]{"names", "images"},
                new int[]{R.id.text_view, R.id.image_view});
        listview.setAdapter(simpleAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Map<String, Object> temp = list1.get(i);
                Toast.makeText(MainActivity.this, temp.get("names").toString(), Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btn1).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, AlertDialogDemo.class);
        startActivity(intent);
    }
}