package com.swarmnyc.databindingdemo.demo3.viewmodel;

import android.databinding.BaseObservable;
import android.os.Bundle;
import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GameViewModel extends BaseViewModel {
    public String name;

    public GameViewModel(String name) {
        this.name = name;
    }

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    protected GameViewModel(Parcel in) {
        this.name = in.readString();
    }

    public static final Creator<GameViewModel> CREATOR = new Creator<GameViewModel>() {
        @Override
        public GameViewModel createFromParcel(Parcel source) {
            return new GameViewModel(source);
        }

        @Override
        public GameViewModel[] newArray(int size) {
            return new GameViewModel[size];
        }
    };

}
