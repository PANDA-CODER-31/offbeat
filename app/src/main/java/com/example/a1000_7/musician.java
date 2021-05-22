package com.example.a1000_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class musician extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musician);
    }
    public void logout(View v){
        Intent intent =new Intent(musician.this,login.class);
        startActivity(intent);
        finish();
    }
    public void Onchat(View v)
    {
        Intent intent =new Intent(musician.this,chat.class);
        startActivity(intent);
    }


}