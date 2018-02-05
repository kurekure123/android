package com.bitcamp.app.lotto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView result = findViewById(R.id.result);
        findViewById(R.id.create_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int lotto[] =  new int[6];
                String r = "";
                for (int i = 0; i < lotto.length; i++){
                    lotto[i] = (int)(Math.random()*45)+1;
                    r += lotto[i] + ", ";
                    for (int j = 0; j < i; j++){
                        if(lotto[i]==lotto[j]){
                            i--;
                        }
                    }
                }
                result.setText("로또 번호는 : " + r);
            }
        });
    }
}
