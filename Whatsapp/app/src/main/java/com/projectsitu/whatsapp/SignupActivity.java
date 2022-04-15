package com.projectsitu.whatsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.projectsitu.whatsapp.databinding.ActivitySignupBinding;
import com.projectsitu.whatsapp.model.Users;

public class SignupActivity extends AppCompatActivity {

        ActivitySignupBinding binding;
        private FirebaseAuth auth;
        FirebaseDatabase database;
        ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        getSupportActionBar().hide();

        auth  = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        progressDialog = new ProgressDialog(SignupActivity.this);
        progressDialog.setTitle("Creating account");
        progressDialog.setMessage("We are creating your account");

        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                 auth.createUserWithEmailAndPassword(binding.etEmail.getText().toString(), binding.etPassword.getText().toString()).
                         addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                             @Override
                             public void onComplete(@NonNull Task<AuthResult> task) {
                                 progressDialog.dismiss();
                               if (task.isSuccessful()){
                                   Users user = new Users(binding.etUsername.getText().toString(), binding.etEmail.getText().toString(),
                                           binding.etPassword.getText().toString());
                                   String id = task.getResult().getUser().getUid();
                                   database.getReference().child("Users").child(id).setValue(user);
                                   Toast.makeText(SignupActivity.this, "User created succesfully", Toast.LENGTH_SHORT).show();
                               }
                               else {
                                   Toast.makeText(SignupActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                               }
                             }
                         });
            }
        });




    }
}