package com.example.lin.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.lin.model.Contact;
import com.example.lin.projectcontactmanagement.R;

import java.util.List;

/**
 * Created by lin on 14/12/2016.
 */

public class ContactApdapter extends ArrayAdapter<Contact>{
    Activity context;
    int resource;
    List<Contact> objects;

    public ContactApdapter(Activity context, int resource, List<Contact> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource, null);

        TextView txtTen = (TextView) row.findViewById(R.id.Name);
        TextView txtPhone = (TextView) row.findViewById(R.id.Phone);

        Button btnCall = (Button) row.findViewById(R.id.btCall);
        Button btnSMS = (Button) row.findViewById(R.id.btSMS);
        Button btnDel = (Button) row.findViewById(R.id.btDel);

        final Contact contact = this.objects.get(position);
        
        //xử lí call
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyCall(contact);
            }
        });

        return row;
    }

    private void xulyCall(Contact contact) {
    }
}
