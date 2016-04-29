package com.swarmnyc.databindingdemo.util;

import android.databinding.BindingAdapter;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class AnimBindingAdapters {
    @BindingAdapter({"binding:clickAnim"})
    public static void bindClickAnim(final View view, final Animation effort) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.startAnimation(effort);
            }
        });
    }
}

