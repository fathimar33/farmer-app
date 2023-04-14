package com.example.firstpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login1 extends AppCompatActivity {
    EditText et1, et2;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        et1 = (EditText) findViewById(R.id.text2);
        et2 = (EditText) findViewById(R.id.t4);
        b1 = (Button) findViewById(R.id.b1);
        b2=(Button) findViewById(R.id.b2) ;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et1.getText().toString();
                String pswd = et2.getText().toString();
                if (pswd.matches("\\d+")) {
                    Integer ps = Integer.parseInt(pswd);
                    boolean isvalid = validate(name, ps);
                    if (isvalid) {
                        Intent viewIntent = new Intent(getApplicationContext(), consumer_viewrecord.class);
                        viewIntent.putExtra("username", name);
                        startActivity(viewIntent);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Password should be numeric", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view5 = new Intent(getApplicationContext(),consumer.class);

                startActivity(view5);
            }
        });
    }

    private boolean validate(String name, Integer ps) {
        if (!name.equals("fathima")) {
            et1.setError("wrong username");
            return false;
        }
        if (!ps.equals(1234)) {
            et2.setError("wrong password");
            return false;
        }
        return true;
    }
}
