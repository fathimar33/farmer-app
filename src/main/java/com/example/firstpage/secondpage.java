package com.example.firstpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class secondpage extends AppCompatActivity {
    Toolbar t2;
    ImageView i2;
    LinearLayout  l1,l2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondpage);
        t2=(Toolbar) findViewById(R.id.t2);
        t2.setTitle("");
        setSupportActionBar(t2);
        i2=(ImageView) findViewById(R.id.i2);
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view1 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(view1);

            }
        });
        l1=(LinearLayout) findViewById(R.id.l1);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view3 = new Intent(getApplicationContext(),thirdpage.class);

                startActivity(view3);
            }
        });
        l2=(LinearLayout) findViewById(R.id.l2);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view3 = new Intent(getApplicationContext(),consumer.class);

                startActivity(view3);
            }
        });

    }


    }

