package com.example.pink24.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MyPageActivity extends AppCompatActivity {

    TextView mylogin;
    TextView mypass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        mylogin=findViewById(R.id.mylogin);
        mypass=findViewById(R.id.mypass);

        SharedPreferences sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);
        mylogin.setText(sharedPreferences.getString("Mylogin","not"));
        mypass.setText(sharedPreferences.getString(sharedPreferences.getString("Mylogin","null"),"nothing"));
    }
}
