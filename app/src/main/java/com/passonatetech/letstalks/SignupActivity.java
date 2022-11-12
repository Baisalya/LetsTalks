package com.passonatetech.letstalks;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    private Button btn,signupbtn;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        signupbtn=findViewById(R.id.singupbtn);
         btn=findViewById(R.id.tosignup);
         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent=new Intent(SignupActivity.this,MainActivity.class);
                 startActivity(intent);

             }
         });
         signupbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Toast.makeText(getApplicationContext(),"Signup Sucess",Toast.LENGTH_SHORT).show();
             }
         });
    }
}
