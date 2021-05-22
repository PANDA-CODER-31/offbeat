package com.example.a1000_7;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText mName, mPassword, mEmail,mPassword2;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    TextView textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        mName = findViewById(R.id.Name);
        mEmail=findViewById(R.id.Email);
        mPassword=findViewById(R.id.Password);
        mPassword2=findViewById(R.id.Password2);
        textView5=findViewById(R.id.textView5);

        fAuth= FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar);



        if(fAuth.getCurrentUser()!=null){
            Intent intent = new Intent(  MainActivity.this,list.class);
            startActivity(intent);
            finish();
        }







     button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             String email = mEmail.getText().toString().trim();
             String name = mName.getText().toString().trim();
             String password = mPassword.getText().toString().trim();
             String password2 = mPassword2.getText().toString().trim();

             if (TextUtils.isEmpty(name)) {
                 mName.setError("Name is required");
                 return;
             }
             if (TextUtils.isEmpty(email)) {
                 mEmail.setError("User name is required");
                 return;
             }

             if (TextUtils.isEmpty(password)) {
                 mPassword.setError("Password is required");
                 return;
             }
             if (TextUtils.isEmpty(password2)) {
                 mPassword2.setError("Confirm password is required");
                 return;
             }
             if (password.length() < 8) {
                 mPassword.setError("Password must be >=8 characters");
                 return;
             }
             if (password.equals(password2)){
                 Toast.makeText(MainActivity.this, "Password Matches", Toast.LENGTH_SHORT).show();
             }
             else {
                 mPassword2.setError("Password Doesnt match");
                 return ;
             }
             progressBar.setVisibility(View.VISIBLE);

             fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task) {
                     if(task.isSuccessful()){
                         Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                         Intent intent = new Intent(  MainActivity.this,list.class);
                         startActivity(intent);
                     }
                     else{
                         Toast.makeText(MainActivity.this, "Error!" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                     }
                 }
             });

         }
     });

       textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(  MainActivity.this,login.class);
                startActivity(intent);
            }
        });



    }


}