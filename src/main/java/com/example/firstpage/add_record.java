package com.example.firstpage;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class add_record extends Activity implements OnClickListener {

    private EditText subjectEditText;
    private EditText descEditText;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        //defining ids
        subjectEditText = (EditText) findViewById(R.id.subject_edittext);
        descEditText = (EditText) findViewById(R.id.description_edittext);
        Button addTodoBtn = (Button) findViewById(R.id.add_record);

        //opening database
        dbManager = new DBManager(this);
        dbManager.open();

        //button onclick
        addTodoBtn.setOnClickListener(this);
    }

    //button onclick value operations
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_record:

                final String name = subjectEditText.getText().toString();
                final String desc = descEditText.getText().toString();

                //   if (TextUtils.isEmpty(subjectEditText.getText()))
                //       subjectEditText.setError("required");
                //   else {}

                dbManager.insert(name, desc);

                Intent main = new Intent(this, ViewFarmersList.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);
                break;
        }
    }

}