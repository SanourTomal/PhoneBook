package com.example.sanourtomal.database.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sanourtomal.database.R;
import com.example.sanourtomal.database.adapter.CustomAdapter;
import com.example.sanourtomal.database.database.DatabaseHelper;
import com.example.sanourtomal.database.person.Person;

import java.util.ArrayList;

public class Details extends AppCompatActivity {

    TextView dtName, dtPhn;
    Button call;
    Button message;
    ArrayList<Person> personlist;

    String phn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        initialize();

        phn = getIntent().getStringExtra("phnnum");
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.fromParts("tel", phn, null));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            }
        });

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address",phn);
                smsIntent.putExtra("sms_body","");
                startActivity(smsIntent);


            }
        });

    }

    private void initialize() {
        dtName = (TextView) findViewById(R.id.dtName);
        dtPhn = (TextView) findViewById(R.id.dtphn);
        call = (Button) findViewById(R.id.call);
        message=(Button)findViewById(R.id.message);
        dtName.setText(getIntent().getStringExtra("name"));
        dtPhn.setText(getIntent().getStringExtra("phnnum"));

    }
}
