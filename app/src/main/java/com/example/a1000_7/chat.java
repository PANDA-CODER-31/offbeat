package com.example.a1000_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class chat extends AppCompatActivity {

    public Button button_msg;
    public Button button_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        button_msg = (Button) findViewById(R.id.button_msg);
        button_send = (Button) findViewById(R.id.button_send);
        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button_msg.setVisibility(View.VISIBLE);
                Toast.makeText(chat.this, "Message recorded", Toast.LENGTH_SHORT).show();

            }
        });
    }
}