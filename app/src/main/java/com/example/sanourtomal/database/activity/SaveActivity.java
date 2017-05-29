package com.example.sanourtomal.database.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sanourtomal.database.R;
import com.example.sanourtomal.database.database.DatabaseHelper;
import com.example.sanourtomal.database.person.Person;

/**
 * Created by Sanour Tomal on 2/12/2017.
 */

public class SaveActivity extends AppCompatActivity {

    EditText edtName;
    EditText edtPhn;
    Button save;
    DatabaseHelper databaseHelper;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.row);
        initialize();
        databaseHelper=new DatabaseHelper(this);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseHelper.insertContect(new Person(edtName.getText().toString(),edtPhn.getText().toString()));

                Toast.makeText(getApplicationContext(),"contact added successfully",Toast.LENGTH_SHORT).show();

            }
        });

    }



    private void initialize() {
        edtName=(EditText)findViewById(R.id.setName);
        edtPhn=(EditText)findViewById(R.id.setphn);
        save=(Button)findViewById(R.id.save);

    }

}
