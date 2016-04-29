package com.dashengz.goorootest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        showList((ListView) findViewById(R.id.listView), Arrays.asList("Test 1", "Test 2", "Test 3"));
        showList((ListView) findViewById(R.id.listView2), Arrays.asList("Test 4", "Test 5", "Test 6"));
        showList((ListView) findViewById(R.id.listView3), Collections.singletonList("Test 7"));
    }

    private void showList(ListView listView, List<String> list) {
        listView.setAdapter(new ListAdapter(list));
    }

    private class ListAdapter extends ArrayAdapter<String> {

        public ListAdapter(List<String> items) {
            super(MenuActivity.this, R.layout.menu_list_item, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                convertView = getLayoutInflater().inflate(R.layout.menu_list_item, parent, false);
            TextView titleView = (TextView) convertView.findViewById(R.id.textView);
            titleView.setText(getItem(position));

            return convertView;
        }
    }


}
