package com.codehub.marvelheroes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class ForgotPass extends AppCompatActivity {

    private void gotoNextScreen() {
        Intent intent = new Intent(ForgotPass.this,LoginActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        final TextInputLayout s1,s2;

        Button b1;
        final TextInputLayout e1;
        final Database db;
        db = new Database(this);
        e1 = findViewById(R.id.email);
        s1 = findViewById(R.id.repassword);
        s2 = findViewById(R.id.confpassword);
        b1 = (Button) findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e1.getEditText().getText().toString().trim();
                String repassword = s1.getEditText().getText().toString().trim();
                String confpassword = s2.getEditText().getText().toString().trim();

                Boolean checkemail = db.chkemail(email);
                if(checkemail == true) {
                    if (s1.equals(s2)){

                    }


                    Toast.makeText(getApplicationContext(),"Correct email",Toast.LENGTH_SHORT).show();
                    gotoNextScreen();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Email does not exist",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
