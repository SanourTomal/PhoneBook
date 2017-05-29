package com.example.sanourtomal.database.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.sanourtomal.database.R;
import com.example.sanourtomal.database.adapter.CustomAdapter;
import com.example.sanourtomal.database.database.DatabaseHelper;
import com.example.sanourtomal.database.person.Person;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button add;

    CustomAdapter customAdapter;
    DatabaseHelper databaseHelper;
    Person person;
    ArrayList<Person> personlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        databaseHelper = new DatabaseHelper(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SaveActivity.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detail = new Intent(MainActivity.this, Details.class);
                detail.putExtra("name", personlist.get(position).getName());
                detail.putExtra("phnnum", personlist.get(position).getPhnNum());
                startActivity(detail);

            }
        });




    }

    @Override
    protected void onResume() {
        super.onResume();
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Modify.class);
                intent.putExtra("name", personlist.get(position).getName());
                intent.putExtra("phn", personlist.get(position).getPhnNum());
                intent.putExtra("id",personlist.get(position).getId());
                startActivity(intent);

                return true;
            }
        });

        personlist = databaseHelper.getAll();
        Log.d("size",personlist.size()+"");
        customAdapter = new CustomAdapter(this, personlist);
        listView.setAdapter(customAdapter);
        customAdapter.notifyDataSetChanged();
    }

    private void initialize() {

        add = (Button) findViewById(R.id.add);
        listView = (ListView) findViewById(R.id.list_item);

    }
}
