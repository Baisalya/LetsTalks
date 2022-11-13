package com.passonatetech.letstalks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private  String mobile;
    private String email;
    private String name;
    private RecyclerView messagesRecyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          messagesRecyclerview=findViewById(R.id.messageview);
        //gettng current session data from register
        mobile=getIntent().getStringExtra("mobile");
        email=getIntent().getStringExtra("email");
        name=getIntent().getStringExtra("name");
        messagesRecyclerview.setHasFixedSize(true);
        messagesRecyclerview.setLayoutManager(new LinearLayoutManager(this));

    }


}