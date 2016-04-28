package com.swarmnyc.databindingdemo.demo3;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swarmnyc.databindingdemo.demo3.viewmodel.BaseViewModel;

public class ViewModelFragment extends Fragment {

    public static final String KEY = "ViewModel";

    private BaseViewModel viewModel;

    public static ViewModelFragment create(BaseViewModel viewModel) {
        ViewModelFragment fragment = new ViewModelFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY, viewModel);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            viewModel = getArguments().getParcelable(KEY);
        } else {
            viewModel = savedInstanceState.getParcelable(KEY);
        }

        if (viewModel == null) {
            throw new RuntimeException("View Model Cannot Be Null");
        } else {
            viewModel.setContext(this);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return viewModel.createView(inflater,container, savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(KEY, viewModel);
    }
}
