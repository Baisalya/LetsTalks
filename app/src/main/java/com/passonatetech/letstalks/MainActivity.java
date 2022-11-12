package com.passonatetech.letstalks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private  Button login;
TextView tosignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       login =findViewById(R.id.btnlogin);
       tosignup=findViewById(R.id.toregd);
       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               openSignupActivity();
               Toast.makeText(getApplicationContext(),"Login Sucess",Toast.LENGTH_SHORT).show();
           }
       });
     tosignup.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              openSignupActivity();
               //Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();
           }
       });
    }

    public void openSignupActivity() {
        Intent intent=new Intent(this,SignupActivity.class);
        startActivity(intent);
    }
}