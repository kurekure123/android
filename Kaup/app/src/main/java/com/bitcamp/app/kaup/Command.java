package com.bitcamp.app.kaup;

import android.widget.EditText;

/**
 * Created by 1027 on 2018-02-05.
 */

public class Command {
    public static String bmi(EditText weight, EditText height, EditText name){
        double h = Double.parseDouble(String.valueOf(height.getText()));
        double w = Double.parseDouble(String.valueOf(weight.getText()));
        double r = w/((h*h)/10000);
        String n = String.valueOf(name.getText()) + "님, ";
        String result = "";
        if (r>= 35){
            result = "당신의 BMI 지수는 " + r + " 로 당신은 고도비만 입니다" ;
        }else
        if(r >= 30 && r < 35) {
            result = "당신의 BMI 지수는 " + r + " 로 당신은 중등도비만 입니다";
        }else
        if (r >= 25 && r < 30){
            result = "당신의 BMI 지수는 " + r + " 로 당신은 경도비민 입니다";
        }else
        if (r >= 23&& r < 24.9 ){
            result = "당신의 BMI 지수는 " + r + " 로 당신은 과체중 입니다";
        }else
        if (r >= 18.5 && r < 22.9 ){
            result = "당신의 BMI 지수는 " + r + " 로 당신은 정상 입니다";
        }else{
            result = "당신의 BMI 지수는 " + r + " 로 당신은 체중미달 입니다";
        }
        return  n + result;
    }
}
