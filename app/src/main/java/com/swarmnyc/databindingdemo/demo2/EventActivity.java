package com.swarmnyc.databindingdemo.demo2;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.swarmnyc.databindingdemo.R;
import com.swarmnyc.databindingdemo.databinding.EventBinder;

public class EventActivity extends Activity {

    private EventBinder binder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binder = DataBindingUtil.setContentView(this, R.layout.activity_event);
        binder.setActivity(this);
    }

    public void changeToRed(View view){
        // change the view background
        binder.target.setBackground(new ColorDrawable(Color.RED));
    }

    public void changeToGreen(View view){
        // change the view background
        binder.target.setBackground(new ColorDrawable(Color.GREEN));
    }

    public void changeToBlue(View view){
        // change the view background
        binder.target.setBackground(new ColorDrawable(Color.BLUE));
    }
}
