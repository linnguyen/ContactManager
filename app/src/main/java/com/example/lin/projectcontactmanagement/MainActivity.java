package com.example.lin.projectcontactmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.lin.adapter.ContactApdapter;
import com.example.lin.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     EditText txtName;
     EditText txtPhone;
     Button btnSave;

    ListView lvDanhBa;
    ArrayList<Contact> arrDanhBa;
    ContactApdapter adContactApdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvent();
    }

    private void addEvent() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyLuuDanhBa();
            }
        });
    }

    private void xulyLuuDanhBa(){
        Contact contact = new Contact(txtName.getText().toString(),txtPhone.getText().toString());
        arrDanhBa.add(contact);
        adContactApdapter.notifyDataSetChanged();

    }
    private void addControls(){
        txtName = (EditText) findViewById(R.id.edName);
        txtPhone = (EditText) findViewById(R.id.edPhone);
        btnSave = (Button) findViewById(R.id.btAdd);


        lvDanhBa = (ListView) findViewById(R.id.lvDanhBa);
        arrDanhBa = new ArrayList<>();
        adContactApdapter = new ContactApdapter(MainActivity.this,R.layout.item,arrDanhBa);
        lvDanhBa.setAdapter(adContactApdapter);

    }
}
