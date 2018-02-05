package com.bitcamp.app.hellow;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText inputId = findViewById(R.id.input_id);
        final EditText inputPass = findViewById(R.id.input_pass);
        findViewById(R.id.login_btn).setOnClickListener(new View.OnClickListener() {
            Context context = MainActivity.this;
            @Override
            public void onClick(View view) {
                String id = String.valueOf(inputId.getText());
                String pass = String.valueOf(inputPass.getText());
                Log.d("들어온 ID 값", id);
                Log.d("들어온 PASS 값", pass);
                Toast.makeText(context, "들어온 ID 값 : " + id, Toast.LENGTH_LONG).show();
            }
        });
        inputId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        inputPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        }
}
