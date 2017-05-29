package com.example.sanourtomal.database.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sanourtomal.database.R;
import com.example.sanourtomal.database.person.Person;

import java.util.List;

/**
 * Created by Sanour Tomal on 2/11/2017.
 */

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private List<Person>persons;

    public CustomAdapter(Context context, List<Person> persons) {
        this.context = context;
        this.persons = persons;
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.customrow,parent,false);
        }
        TextView name=(TextView)convertView.findViewById(R.id.vwname);
        TextView phnnum=(TextView)convertView.findViewById(R.id.vwphn);
        name.setText(persons.get(position).getName());
        phnnum.setText(persons.get(position).getPhnNum());
        return convertView;
    }
}
