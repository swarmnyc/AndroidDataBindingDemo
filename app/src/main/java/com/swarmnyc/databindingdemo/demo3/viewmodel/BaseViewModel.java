package com.swarmnyc.databindingdemo.demo3.viewmodel;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swarmnyc.databindingdemo.R;
import com.swarmnyc.databindingdemo.demo3.ViewModelFragment;

public abstract class BaseViewModel implements Parcelable {
    private Activity activity;

    public void setContext(Activity activity) {

        this.activity = activity;
    }

    public void setContext(Fragment fragment) {
        this.activity = fragment.getActivity();
    }

    public Context getContext() {
        return activity;
    }

    public void navTo(BaseViewModel viewModel) {
        FragmentManager manager = activity.getFragmentManager();
        if (manager.getBackStackEntryCount() == 0) {
            activity.getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, ViewModelFragment.create(viewModel))
                    .commit();
        } else {
            activity.getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, ViewModelFragment.create(viewModel))
                    .addToBackStack(viewModel.toString())
                    .commit();
        }
    }

    public abstract View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
}
