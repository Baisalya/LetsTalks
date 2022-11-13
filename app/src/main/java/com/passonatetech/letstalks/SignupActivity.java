package com.passonatetech.letstalks;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignupActivity extends AppCompatActivity {
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://letstalks-acdfe-default-rtdb.firebaseio.com/");
    private Button btn,signupbtn;
    private EditText name,mobile,email;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading.....");
        progressDialog.show();
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
                 progressDialog.show();
                 final String nameTxt=name.getText().toString();
                 final String mobileTxt=mobile.getText().toString();
                 final String emailTxt=email.getText().toString();
                 if(nameTxt.isEmpty() || mobileTxt.isEmpty()|| emailTxt.isEmpty()){
                     Toast.makeText(SignupActivity.this, "All Filed Required to Filed", Toast.LENGTH_SHORT).show();
                     progressDialog.dismiss();
                 }else {
                     databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                         @Override
                         public void onDataChange(@NonNull DataSnapshot snapshot) {
                             progressDialog.dismiss();
                             if(snapshot.child("users").hasChild(mobileTxt)){
                                 Toast.makeText(SignupActivity.this, "already exists", Toast.LENGTH_SHORT).show();
                             }else{
                                 databaseReference.child("users").child(mobileTxt).child("email").setValue(emailTxt);
                                 databaseReference.child("users").child(mobileTxt).child("name").setValue(nameTxt);
                                 Toast.makeText(getApplicationContext(), "Signup Sucess", Toast.LENGTH_SHORT).show();
                                // openSignupActivity();
                                 Intent intent=new Intent(SignupActivity.this,MainActivity.class);
                                 intent.putExtra("mobile",mobileTxt);
                                 intent.putExtra("email",emailTxt);
                                 intent.putExtra("name",nameTxt);
                                 finish();
                             }

                         }

                         @Override
                         public void onCancelled(@NonNull DatabaseError error) {
                              progressDialog.dismiss();
                         }
                     });

                 }
             }
         });
    }
    public void openSignupActivity() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
