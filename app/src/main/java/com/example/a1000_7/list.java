package com.example.a1000_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class list extends AppCompatActivity {
    public Button button8;
    public Button button9;
    public TextView textView12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        button8=findViewById(R.id.button8);
        button9=findViewById(R.id.button9);
        textView12=findViewById(R.id.textView12);
    }

    public void job_take(View v){
        Intent intent = new Intent(  list.this,choices.class);
        startActivity(intent);
    }
    public void job_give(View v){
        Intent intent = new Intent(  list.this,job.class);
        startActivity(intent);
    }
    public void logout(View v){
        FirebaseAuth.getInstance().signOut();
        Intent intent =new Intent(list.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

}