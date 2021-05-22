package com.example.a1000_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class wine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine);
    }
    public void logout(View v){
        FirebaseAuth.getInstance().signOut();
        Intent intent =new Intent(wine.this,login.class);
        startActivity(intent);
        finish();
    }
    public void Onchat(View v)
    {
        Intent intent =new Intent(wine.this,chat.class);
        startActivity(intent);
    }
}