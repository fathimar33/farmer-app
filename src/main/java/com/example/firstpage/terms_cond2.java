package com.example.firstpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class terms_cond2 extends AppCompatActivity {
    CheckBox c1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_cond);
        b1=(Button) findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c1=(CheckBox)findViewById(R.id.c1) ;
                boolean isvalid=valid();
                if (isvalid){
                    Intent view3 = new Intent(getApplicationContext(),consumer_viewrecord.class);
                    startActivity(view3);
                }
                else {
                    Toast.makeText(terms_cond2.this, "accept all terms and conditions", Toast.LENGTH_SHORT).show();
                }
            }

            private boolean valid() {
                return  c1.isChecked();

            }


        });


    }
}