package com.passonatetech.letstalks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private  String mobile;
    private String email;
    private String name;
    private RecyclerView messagesRecyclerview;
    private CircleImageView userProfilePic;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://letstalks-acdfe-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userProfilePic=findViewById(R.id.userdisplaypic);
          messagesRecyclerview=findViewById(R.id.messageview);
        //gettng current session data from register
        mobile=getIntent().getStringExtra("mobile");
        email=getIntent().getStringExtra("email");
        name=getIntent().getStringExtra("name");
        messagesRecyclerview.setHasFixedSize(true);
        messagesRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        //
        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading.....");
        progressDialog.show();
        //get dp from firbse
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final String profilePicUrl=snapshot.child("users").child(mobile).child("profile_pic").getValue(String.class);
               if (! profilePicUrl.isEmpty()) {
                   //set Profile pic
                   Picasso.get().load(profilePicUrl).into(userProfilePic);
               }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
             progressDialog.dismiss();
            }
        });

    }


}