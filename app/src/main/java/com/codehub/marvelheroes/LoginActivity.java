package com.codehub.marvelheroes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    Button registernow;


    private void gotoNextScreen() {
        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
    private void gotoMainScreen() {
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

                    //buttons behavior by Anna
//        final Button register_now = findViewById(R.id.register_now);
//
//        register_now.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
//                startActivity(intent);
//            }
//
//        });
//
//        final Button login = findViewById(R.id.login_button);
//
//        login.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(LoginActivity.this, MainMenuActivity.class);
//                startActivity(intent);
//            }
//
//        });





        final TextInputLayout e1,e2;

        Button b1;
        final Database db;
        db = new Database(this);
        e1 = findViewById(R.id.username);
        e2 = findViewById(R.id.password);
        b1 = (Button)findViewById(R.id.login_button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = e1.getEditText().getText().toString().trim();
                String password = e2.getEditText().getText().toString().trim();
                Boolean chkemailpass = db.emailpassword(username,password);
                if(chkemailpass==true) {
                    Toast.makeText(getApplicationContext(),"Successfully Login",Toast.LENGTH_SHORT).show();
                    gotoMainScreen();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Wrong username or password",Toast.LENGTH_SHORT).show();
                }

            }
        });

        registernow=findViewById(R.id.register_now);
        registernow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoNextScreen();
            }
        });
    }




}
