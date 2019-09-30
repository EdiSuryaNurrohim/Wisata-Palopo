package com.turispalopo.android.wisatapalopo.MenuUtama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.turispalopo.android.wisatapalopo.R;

public class MainActivity extends AppCompatActivity {
    //Tampilan
    Button mRegisterBtn, mLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init tampilan
        mRegisterBtn = findViewById(R.id.register_btn);
        mLoginBtn = findViewById(R.id.login_btn);

        //handle registrasi button
        mRegisterBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //start activity
                startActivity(new Intent(MainActivity.this, RegisterActivity.class ));

            }
        });
        // handle login button
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              // start activity
              startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

    }
}
