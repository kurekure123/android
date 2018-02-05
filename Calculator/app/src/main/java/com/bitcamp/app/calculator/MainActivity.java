package com.bitcamp.app.calculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText firstNum = findViewById(R.id.first_num);
        final EditText secondNum = findViewById(R.id.second_num);
        final TextView result = findViewById(R.id.result);
        Button minusBtn = findViewById(R.id.minus_btn);
        Button multi_btn = findViewById(R.id.multi_btn);
        Button devBtn = findViewById(R.id.dev_btn);
        final Context context = MainActivity.this;
        findViewById(R.id.plus_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    result.setText("계산 결과는 : " + Command.changeInt(firstNum,secondNum,"+"));
            }
        });

    }
}
