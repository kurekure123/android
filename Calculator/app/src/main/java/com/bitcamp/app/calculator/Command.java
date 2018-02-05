package com.bitcamp.app.calculator;

import android.widget.Button;
import android.widget.EditText;

/**
 * Created by 1027 on 2018-02-05.
 */

public class Command {
    public static int changeInt(EditText num1, EditText num2, String opcode){
        int result = 0;
        switch (opcode){
            case "+" :
                result =  Integer.valueOf(String.valueOf(num1.getText()))
                        + Integer.valueOf(String.valueOf(num2.getText()));
                break;


        }
        return  result;
    }
}
