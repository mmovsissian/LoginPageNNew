package com.example.pink24.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {


    private Button reg_ok;
    private EditText reg_login;
    private EditText reg_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
      reg_login=findViewById(R.id.reg_login);
       reg_ok=findViewById(R.id.reg_ok);
         reg_pass=findViewById(R.id.reg_pass);


            reg_ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    if (TextUtils.isEmpty(reg_login.getText().toString())==true && TextUtils.isEmpty(reg_pass.getText().toString())==true
                            && reg_login.getText().toString().equals("Mylogin")==false) {

                        Toast.makeText(RegistrationActivity.this, "Login or Password empty", Toast.LENGTH_LONG).show();

                    }

                    if (TextUtils.isEmpty(reg_login.getText().toString())==false && TextUtils.isEmpty(reg_pass.getText().toString())==false) {

                        SharedPreferences sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(reg_login.getText().toString(), reg_pass.getText().toString());
                        editor.commit();
                        finish();


                    }
                } });

    }
}
