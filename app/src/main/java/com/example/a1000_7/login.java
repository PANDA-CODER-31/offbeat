package com.example.a1000_7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    public Button button7;
    public EditText mEmail2,mPassword2;
    public ProgressBar progressBar2;
    public FirebaseAuth fAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button7=findViewById(R.id.button7);
        mEmail2=findViewById(R.id.mEmail2);
        mPassword2=findViewById(R.id.mPassword2);
        progressBar2=findViewById(R.id.progressBar2);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String email = mEmail2.getText().toString().trim();
                    String password = mPassword2.getText().toString().trim();

                    if (TextUtils.isEmpty(email)) {
                        mEmail2.setError("User name is required");
                        return;
                    }
                    if (TextUtils.isEmpty(password)) {
                        mPassword2.setError("Password is required");
                        return;
                    }
                    if (password.length() < 8) {
                        mPassword2.setError("Password must be >=8 characters");
                        return;
                    }
                    progressBar2.setVisibility(View.VISIBLE);

                  fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                      @Override
                      public void onComplete(@NonNull Task<AuthResult> task) {
                          if(task.isSuccessful()){
                              Toast.makeText(login.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                              Intent intent = new Intent(  login.this,choices.class);
                              startActivity(intent);
                          }
                          else{
                              Toast.makeText(login.this, "Error!" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                          }
                      }
                  }) ;
            }
        });

    }
    public void register_page(View v){
        Intent intent = new Intent(  login.this,MainActivity.class);
        startActivity(intent);
    }
}