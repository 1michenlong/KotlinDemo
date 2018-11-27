package com.example.tecl.kotlindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tecl.kotlindemo.popupwindow.KuPayPopupWindow;
import com.example.tecl.kotlindemo.popupwindow.KuPayPopupWindows;

public class MainActivity extends AppCompatActivity {
    private LinearLayout mFatherLinear;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFatherLinear=findViewById(R.id.id_fatherLinear);
        tv=findViewById(R.id.id_text);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int str[] = {5,7,12,89,0,1,34,19,56,21,80,23,11,23,10};
                for(int i=0;i<str.length-1;i++){
                    for(int j=0;j<str.length-1-i;j++){

                        if(str[j]>str[j+1]){
                            int temp = str[j];
                            str[j]=str[j+1];
                            str[j+1]=temp;
                        }
                    }
                }

                for(int i=0;i<str.length;i++){
                    Log.i("SSSS","str=="+str[i]);
                }


                startActivity(new Intent(MainActivity.this,HomePageFragment.class));

//                KuPayPopupWindow kuPayPopupWindow = new KuPayPopupWindow(MainActivity.this,"你好");
//                kuPayPopupWindow.showAtLocation(mFatherLinear, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

            }
        });
    }
}
