package com.example.block05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences preferences = getSharedPreferences("Color_Pref", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();
        final ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout);

        if(preferences.contains("colorcode")) {
            layout.setBackgroundColor(preferences.getInt("colorcode",0));
        }


        RadioGroup radioGroupcolors = (RadioGroup) findViewById(R.id.radiogroup_colors);
        radioGroupcolors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int colorid=0;
                switch (checkedId) {
                    case R.id.radioButton_blue:
                        colorid = Color.BLUE;
                        break;
                    case R.id.radioButton_magenta:
                        colorid = Color.MAGENTA;
                        break;
                    case R.id.radioButton_yellow:
                        colorid = Color.YELLOW;
                        break;
                }
                layout.setBackgroundColor(colorid);
                editor.putInt("colorcode",colorid);
                editor.commit();
            }

        });
    }
}
