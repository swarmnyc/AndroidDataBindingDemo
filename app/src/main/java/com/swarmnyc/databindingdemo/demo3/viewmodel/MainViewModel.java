package com.swarmnyc.databindingdemo.demo3.viewmodel;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainViewModel extends BaseViewModel {
    public void init(Activity activity) {
        setContext(activity);

        navTo(new LoginViewModel());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public MainViewModel() {
    }

    protected MainViewModel(Parcel in) {
    }

    public static final Creator<MainViewModel> CREATOR = new Creator<MainViewModel>() {
        @Override
        public MainViewModel createFromParcel(Parcel source) {
            return new MainViewModel(source);
        }

        @Override
        public MainViewModel[] newArray(int size) {
            return new MainViewModel[size];
        }
    };

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }
}
