package com.swarmnyc.databindingdemo.demo3;

import android.app.Activity;
import android.os.Bundle;

import com.swarmnyc.databindingdemo.R;
import com.swarmnyc.databindingdemo.demo3.viewmodel.MainViewModel;

public class ViewModelActivity extends Activity {
    public MainViewModel viewModel = new MainViewModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);
        viewModel.init(this);
    }
}
