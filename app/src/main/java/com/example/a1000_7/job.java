package com.example.a1000_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class job extends AppCompatActivity {
    EditText empname,address,phone,salary, job_desc, experience,no_emp;
    Button savebtn;
    DatabaseReference reff;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
        address=findViewById(R.id.address);
        empname=findViewById(R.id.empname);
        job_desc=findViewById(R.id.job_desc);
        phone=findViewById(R.id.phone);
        salary=findViewById(R.id.salary);
        experience=findViewById(R.id.experience);
        no_emp=findViewById(R.id.no_empl);
        savebtn=findViewById(R.id.savebtn);
        member= new Member();
        reff= FirebaseDatabase.getInstance().getReference().child("Member");

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int noa=Integer.parseInt(no_emp.getText().toString().trim());
                Float salarya = Float.parseFloat(salary.getText().toString().trim());
                long phonea= Long.parseLong(phone.getText().toString().trim());
                int experience1 =Integer.parseInt(experience.getText().toString().trim());
                member.setName(empname.getText().toString().trim());
                member.setAddress(address.getText().toString().trim());
                member.setJob(job_desc.getText().toString().trim());
                member.setNo(noa);
                member.setPhone(phonea);
                member.setSalary(salarya);
                member.setExperience1(experience1);

                reff.push().setValue(member);
                Toast.makeText(job.this, "Form submitted successfully", Toast.LENGTH_SHORT).show();
            }
        });



    }
    public void logout(View v){
        FirebaseAuth.getInstance().signOut();
        Intent intent =new Intent(job.this,login.class);
        startActivity(intent);
        finish();
    }
}