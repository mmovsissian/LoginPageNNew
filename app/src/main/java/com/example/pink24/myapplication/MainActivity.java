package com.example.pink24.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText login;
    private EditText password;
    private Button ok;
    private Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login=findViewById(R.id.login);
        password=findViewById(R.id.password);
        ok=findViewById(R.id.ok);
        register=findViewById(R.id.register);


        register.setOnClickListener(new  View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);



            }
        });




        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                SharedPreferences sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if (sharedPreferences.getString(login.getText().toString(), "no").equals(password.getText().toString())) {
                    editor.putString("Mylogin", login.getText().toString());
                    editor.commit();

                    Intent intent = new Intent(MainActivity.this, MyPageActivity.class);

                    startActivity(intent);


                }
            }


        }    );

    }
}
