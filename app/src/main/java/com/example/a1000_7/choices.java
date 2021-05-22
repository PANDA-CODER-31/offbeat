package com.example.a1000_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class choices extends AppCompatActivity {

    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choices);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
    }
    public void stunt1 (View v){
        Intent intent = new Intent(  choices.this,stunt.class);
        startActivity(intent);
    }
    public void musician1 (View v){
        Intent intent = new Intent(  choices.this,musician.class);
        startActivity(intent);
    }
    public void cinema1 (View v){
        Intent intent = new Intent(  choices.this,cinema.class);
        startActivity(intent);
    }
    public void film1 (View v){
        Intent intent = new Intent(  choices.this,film.class);
        startActivity(intent);
    }
    public void wine1 (View v){
        Intent intent = new Intent(  choices.this,wine.class);
        startActivity(intent);
    }
}