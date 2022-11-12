package com.passonatetech.letstalks;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    private Button btn,signupbtn;
    private EditText name,mobile,email;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);

       //  btn=findViewById(R.id.tosignup);
         // go to login page action
/*         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent=new Intent(SignupActivity.this,MainActivity.class);
                 startActivity(intent);

             }
         });*/
            name=findViewById(R.id.username);
            mobile=findViewById(R.id.phoneno);
            email=findViewById(R.id.email);
            signupbtn=findViewById(R.id.singupbtn);
         //signup button action
         signupbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 final String nameTxt=name.getText().toString();
                 final String mobileTxt=mobile.getText().toString();
                 final String emailTxt=email.getText().toString();
                 if(nameTxt.isEmpty() || mobileTxt.isEmpty()|| emailTxt.isEmpty()){
                     Toast.makeText(SignupActivity.this, "All Filed Required to Filed", Toast.LENGTH_SHORT).show();
                 }else {
                     Toast.makeText(getApplicationContext(), "Signup Sucess", Toast.LENGTH_SHORT).show();
                 }
             }
         });
    }
}
