package com.bitcamp.app.kaup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText cname = findViewById(R.id.name);
        final EditText cweight = findViewById(R.id.weight);
        final EditText cheight = findViewById(R.id.height);
        final TextView cresult = findViewById(R.id.result);
        findViewById(R.id.calc_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cresult.setText(Command.bmi(cweight, cheight, cname));
            }
        });
    }
}
