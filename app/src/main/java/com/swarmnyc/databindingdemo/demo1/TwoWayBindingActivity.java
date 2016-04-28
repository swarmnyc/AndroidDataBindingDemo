package com.swarmnyc.databindingdemo.demo1;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.swarmnyc.databindingdemo.util.ObservableString;
import com.swarmnyc.databindingdemo.R;
import com.swarmnyc.databindingdemo.databinding.TwoWayBinder;

public class TwoWayBindingActivity extends Activity {

    private ObservableString username = new ObservableString();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwoWayBinder binder = DataBindingUtil.setContentView(this, R.layout.activity_two_way_binding);

        binder.setUsername(username);
    }
}
