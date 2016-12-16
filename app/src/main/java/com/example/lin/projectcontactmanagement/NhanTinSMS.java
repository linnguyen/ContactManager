package com.example.lin.projectcontactmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lin.model.Contact;

public class NhanTinSMS extends AppCompatActivity {
    TextView txtNguoiNhan;
    EditText txtNoiDung;
    Button btSend;

   Contact selectedContact = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_tin_sms);

        addcontrols();
        addevent();
    }

    public void addcontrols(){
        txtNguoiNhan = (TextView) findViewById(R.id.txtNguoiNhan);
        txtNoiDung = (TextView) findViewById(R.id.txtNoiDung);
        btSend = (Button) findViewById(R.id.btSend);

        Intent intent = getIntent();
        selectedContact =(Contact) intent.getSerializableExtra("CONTACT");
        txtNguoiNhan.setText();

     }
    public  void addevent(){

    }
}
