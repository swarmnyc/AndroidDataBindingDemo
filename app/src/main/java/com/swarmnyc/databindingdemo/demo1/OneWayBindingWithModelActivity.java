package com.swarmnyc.databindingdemo.demo1;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.swarmnyc.databindingdemo.util.ObservableDate;
import com.swarmnyc.databindingdemo.util.ObservableString;
import com.swarmnyc.databindingdemo.R;
import com.swarmnyc.databindingdemo.databinding.OneWayModelBinder;

import java.util.Date;
import java.util.Random;

public class OneWayBindingWithModelActivity extends Activity {
    public class Model {
        public ObservableDate time = new ObservableDate();
        public ObservableString weather = new ObservableString();
    }

    private Model model = new Model();
    private Handler handler; //timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Random random = new Random();
        final String[] weathers = getResources().getStringArray(R.array.weathers);

        OneWayModelBinder binder = DataBindingUtil.setContentView(this, R.layout.activity_one_way_binding_with_model);

        binder.setModel(model);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                model.time.set(new Date());
                model.weather.set(weathers[random.nextInt(weathers.length)]);
                handler.sendEmptyMessageDelayed(0, 1000);
            }
        };

        handler.sendEmptyMessageDelayed(0, 0);

    }
}
