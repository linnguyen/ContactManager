package com.example.lin.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.lin.model.Contact;
import com.example.lin.projectcontactmanagement.NhanTinSMS;
import com.example.lin.projectcontactmanagement.R;

import java.util.List;

import static android.Manifest.permission.CALL_PHONE;

/**
 * Created by lin on 14/12/2016.
 */

public class ContactApdapter extends ArrayAdapter<Contact> {
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

    public void nhanTin(Contact contact){
        Intent intent = new Intent(this.context, NhanTinSMS.class);
        intent.putExtra("CONTACT",contact);
        this.context.startActivity(intent);
    }

    private void xulyCall(Contact contact) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri uri = Uri.parse("tel:" + contact.getPhone());
        intent.setData(uri);

        if (ActivityCompat.checkSelfPermission(this.context, CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        this.context.startActivity(intent);
    }
}
