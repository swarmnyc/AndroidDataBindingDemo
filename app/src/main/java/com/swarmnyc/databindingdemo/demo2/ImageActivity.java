package com.swarmnyc.databindingdemo.demo2;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.swarmnyc.databindingdemo.R;
import com.swarmnyc.databindingdemo.databinding.ImageBinder;
import com.swarmnyc.databindingdemo.util.ObservableString;

public class ImageActivity extends Activity {
    public ObservableString imageUrl = new ObservableString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageBinder binder = DataBindingUtil.setContentView(this, R.layout.activity_image);
        binder.setActivity(this);
    }

    public void changeImage(View view) {
        String url = (String) view.getTag(R.id.imageUrl);
        imageUrl.set(url);
    }
}
