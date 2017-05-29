package com.example.sanourtomal.database.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.sanourtomal.database.R;
import com.example.sanourtomal.database.database.DatabaseHelper;

public class Update extends AppCompatActivity {

    EditText name,phn;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        initialize();
    }

    private void initialize() {
        name=(EditText)findViewById(R.id.udname);
        phn=(EditText)findViewById(R.id.udphn);
        db=new DatabaseHelper(this);
        name.setText(getIntent().getStringExtra("name"));
        phn.setText(getIntent().getStringExtra("phn"));
    }
}
