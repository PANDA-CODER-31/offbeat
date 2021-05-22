package com.example.a1000_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class stunt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stunt);
    }
    public void logout(View v){
        FirebaseAuth.getInstance().signOut();
        Intent intent =new Intent(stunt.this,login.class);
        startActivity(intent);
        finish();
    }
    public void Onchat(View v)
    {
        Intent intent =new Intent(stunt.this,chat.class);
        startActivity(intent);
    }
}