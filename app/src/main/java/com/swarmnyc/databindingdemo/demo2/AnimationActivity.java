package com.swarmnyc.databindingdemo.demo2;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.swarmnyc.databindingdemo.R;

public class AnimationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_animation);
    }
}
