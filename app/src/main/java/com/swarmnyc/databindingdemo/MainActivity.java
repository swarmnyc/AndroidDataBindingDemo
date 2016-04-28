package com.swarmnyc.databindingdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<>(this, R.layout.item_btn, R.id.btn, getResources().getStringArray(R.array.demos)));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = getResources().getStringArray(R.array.activities)[position];
                try {
                    Class cl = Class.forName(name);
                    startActivity(new Intent(MainActivity.this, cl));

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
