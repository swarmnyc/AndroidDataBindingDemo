package com.swarmnyc.databindingdemo.demo1;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.swarmnyc.databindingdemo.util.ObservableDate;
import com.swarmnyc.databindingdemo.R;
import com.swarmnyc.databindingdemo.databinding.OneWayBinder;

import java.util.Date;

public class OneWayBindingActivity extends Activity {

    private ObservableDate time = new ObservableDate();
    private Handler handler; //timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OneWayBinder binder = DataBindingUtil.setContentView(this, R.layout.activity_one_way_binding);

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                time.set(new Date());
                handler.sendEmptyMessageDelayed(0, 1000);
            }
        };

        handler.sendEmptyMessageDelayed(0, 0);

        binder.setTime(time);
    }
}
