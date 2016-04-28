package com.swarmnyc.databindingdemo.demo1;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;

import com.swarmnyc.databindingdemo.R;
import com.swarmnyc.databindingdemo.databinding.OneTimeBinder;

import java.util.Date;

public class OneTimeBindingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OneTimeBinder binder = DataBindingUtil.setContentView(this, R.layout.activity_one_time_binding);

        binder.setUsername(Build.USER);
        binder.setToday(new Date());
    }
}
