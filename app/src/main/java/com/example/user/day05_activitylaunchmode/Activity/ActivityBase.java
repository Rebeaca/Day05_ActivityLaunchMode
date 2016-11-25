package com.example.user.day05_activitylaunchmode.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.day05_activitylaunchmode.Activity_A;
import com.example.user.day05_activitylaunchmode.Activity_B;
import com.example.user.day05_activitylaunchmode.Activity_C;
import com.example.user.day05_activitylaunchmode.Activity_D;
import com.example.user.day05_activitylaunchmode.R;

/**
 * Created by user on 2016/11/25.
 */

public abstract class ActivityBase extends AppCompatActivity {
    protected String mTitle;
    private TextView show;
    private Button bt_A,bt_B,bt_C,bt_D;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         init();
        show= (TextView) findViewById(R.id.textview);
        show.setText(mTitle);
        bt_A= (Button) findViewById(R.id.button_A);
        bt_B= (Button) findViewById(R.id.button_B);
        bt_C= (Button) findViewById(R.id.button_C);
        bt_D= (Button) findViewById(R.id.button_D);
        bt_A.setOnClickListener(new ButtonListener());
        bt_B.setOnClickListener(new ButtonListener());
        bt_C.setOnClickListener(new ButtonListener());
        bt_D.setOnClickListener(new ButtonListener());
        Log.d("SRL",mTitle+" ID:"+getTaskId());
    }
private class ButtonListener implements View.OnClickListener{

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_A:
                openNewActivity(Activity_A.class);
                break;
            case R.id.button_B:
                openNewActivity(Activity_B.class);
                break;
            case R.id.button_C:
                openNewActivity(Activity_C.class);
                break;
            case R.id.button_D:
                openNewActivity(Activity_D.class);
                break;

        }
    }
}
 private void openNewActivity(Class c){
     Intent intent =new Intent();
     intent.setClass(this,c);
     startActivity(intent);
 }
    protected abstract void init();
}
