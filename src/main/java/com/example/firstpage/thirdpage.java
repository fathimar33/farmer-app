package com.example.firstpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class thirdpage extends AppCompatActivity {
    Button b1;
    Button b2;
    EditText et1;
    EditText et2,et7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdpage);
        et1 = (EditText) findViewById(R.id.text2);
        et2 = (EditText) findViewById(R.id.t4);
        et7=(EditText) findViewById(R.id.t8);
        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = et1.getText().toString();
                String password = et2.getText().toString();
                String pswd=et7.getText().toString();
                if (password.matches("\\d+")) {
                Integer cw=Integer.parseInt(password);

                Integer cw1=Integer.parseInt(pswd);

                boolean isValid = validateinfo(name, password,cw,pswd,cw1);
                if (isValid) {
                    Intent view1 = new Intent(getApplicationContext(),terms_cond.class);
                    startActivity(view1);
                }
            } else {
                    Toast.makeText(thirdpage.this, "password must be numeric", Toast.LENGTH_SHORT).show();
                }
            }

        });
        b2=(Button) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view4 = new Intent(getApplicationContext(),login2.class);
                startActivity(view4);
            }
        });


    }

    private boolean validateinfo(String name,String password,Integer cw,String pswd,Integer cw1) {
        if (name.isEmpty()) {
            Toast.makeText(thirdpage.this, "username must not be empty", Toast.LENGTH_SHORT).show();
            et1.setError("enter the required field");
            return false;
        } else if (password.length()<8) {
            Toast.makeText(thirdpage.this, "password must be at least 8 characters", Toast.LENGTH_SHORT).show();
            et2.setError("please enter again");
            return false;
        } else if (!cw1.equals(cw)) {
            et7.setError("password mismatched");
            return  false;
        } else {
            return true;
        }
    }
}
