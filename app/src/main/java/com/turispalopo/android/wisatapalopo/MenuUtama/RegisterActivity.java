package com.turispalopo.android.wisatapalopo.MenuUtama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.turispalopo.android.wisatapalopo.R;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    //Tampilan
    EditText mEmailET, mPasswordET;
    Button mRegisterBtn, mLoginBtn;
    TextView mHaveAccountTv;

    //progresbar untuk menapilkan user registrasi
    ProgressDialog progressDialog;

    //Declare an instance of FirebaseAuth
    private  FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Create Account");
        //enable back button
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //init
        mEmailET = findViewById(R.id.emailEt);
        mPasswordET = findViewById(R.id.passwordEt);
        mRegisterBtn = findViewById(R.id.registerBtn);
        mHaveAccountTv = findViewById(R.id.have_accountTv);

        //firebase oncreate method
        mAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Register User...");

        //handle register btn click
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //input email, password
                String email = mEmailET.getText().toString().trim();
                String password = mPasswordET.getText().toString().trim();
                //validate
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    //set error and focus to email
                    mEmailET.setError("Invalid Email");
                    mEmailET.setFocusable(true);
                }
                else if (password.length() <6){
                    //set error and focus password
                    mPasswordET.setError("Password length at least 6 characters");
                    mPasswordET.setFocusable(true);
                }
                else {
                    registerUser(email, password); // register user
                }

            }
        });
        //handle login tv click listener
        mHaveAccountTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
             finish();
            }
        });

    }

    private void registerUser(String email, String password) {
        //email password valid show profres dialog
        progressDialog.show();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            //sign in succses, dismis dialog star register activity
                            progressDialog.dismiss();
                            FirebaseUser user = mAuth.getCurrentUser();
                            //get user email & uid from auth
                            String email = user.getEmail();
                            String uid = user.getUid();
                            //using hashmap
                            HashMap<Object, String> hashMap = new HashMap<>();
                            //put info hashmap
                            hashMap.put("email", email);
                            hashMap.put("uid", uid); // will add later edit profile
                            hashMap.put("name", "");
                            hashMap.put("phone", "");
                            hashMap.put("image", "");
                            hashMap.put("cover", "");
                            //firebase database
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            //path to store user data named "User"
                            DatabaseReference reference = database.getReference("Users");
                            //put data within hashmap in database
                            reference.child(uid).setValue(hashMap);

                            Toast.makeText(RegisterActivity.this, "Registered...\n"+user.getEmail(), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, DashboardActivity.class));
                            finish();
                        }else {
                            progressDialog.dismiss();
                            //if sign in fails display message
                            Toast.makeText(RegisterActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();

                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //error, dismis progres dialog
                progressDialog.dismiss();
                Toast.makeText(RegisterActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();//go previous activity
        return super.onSupportNavigateUp();
    }
}
