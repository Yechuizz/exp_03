package com.example.exp_03;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ActionModeView extends AppCompatActivity{

    private ListView listview;
    private String[] names = {"One", "Two", "Three", "Four", "Five"};
    private int image = R.drawable.android_icon;
    private List<Map<String,Object>> list = new ArrayList<>();
    private SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_mode);
        listview = findViewById(R.id.list_view);

        for (int i = 0; i < names.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("names", names[i]);
            item.put("images", image);
            list.add(item);
        }

        simpleAdapter = new SimpleAdapter(ActionModeView.this, list, R.layout.menu_unit,
                new String[]{"names", "images"},
                new int[]{R.id.list_name, R.id.android_icon});
        listview.setAdapter(simpleAdapter);
        listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listview.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                //获取选中的列表项的个数
                int count = listview.getCheckedItemCount();
                //在actionbar的顶部显示选择项的个数
                mode.setTitle(String.format("%d Selected", count));
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.action_mode_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                ArrayList del = new ArrayList<>();
                switch (item.getItemId()) {
                    case R.id.dustbin:
                        for( int i=0; i<list.size(); i++){
                            if(listview.getCheckedItemPositions().get(i) == true){
                                del.add(list.get(i));
                            }
                        }
                        list.removeAll(del);
                        mode.finish();
                        return true;
                    case R.id.right:
                        mode.finish();
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
            }
        });

    }

}
