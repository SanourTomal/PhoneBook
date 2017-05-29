package com.example.sanourtomal.database.activity;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sanourtomal.database.R;
import com.example.sanourtomal.database.adapter.CustomAdapter;
import com.example.sanourtomal.database.database.DatabaseHelper;
import com.example.sanourtomal.database.person.Person;

import java.util.ArrayList;

public class Modify extends AppCompatActivity {

    Button delete,update;
    DatabaseHelper db;
    String id;
    String name,phn;
    ArrayList<Person>personlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_modify);
        initilize();
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.Delete(id);


                Toast.makeText(getApplicationContext(),"Delete",Toast.LENGTH_SHORT).show();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Modify.this,Update.class);
                intent.putExtra("id",id);
                intent.putExtra("name",name);
                intent.putExtra("id",phn);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initilize() {
        delete=(Button)findViewById(R.id.delete);
        update=(Button)findViewById(R.id.update);
        db=new DatabaseHelper(this);
        personlist=db.getAll();
        name=getIntent().getStringExtra("name");
        id=getIntent().getStringExtra("id");
        phn=getIntent().getStringExtra("phn");
    }
}
