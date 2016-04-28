package com.swarmnyc.databindingdemo.demo3.viewmodel;

import android.os.Bundle;
import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.swarmnyc.databindingdemo.databinding.LoginViewBinder;
import com.swarmnyc.databindingdemo.demo3.model.User;
import com.swarmnyc.databindingdemo.util.ObservableString;

public class LoginViewModel extends BaseViewModel {
    public ObservableString username = new ObservableString();
    public ObservableString password = new ObservableString();


    public LoginViewModel() {
    }

    public void login() {
        //valid user
        if (username.get() == null || username.get().isEmpty()) {
            Toast.makeText(getContext(), "Username or Password cannot be empty", Toast.LENGTH_LONG).show();
            return;
        }

        navTo(new GameListViewModel(new User(username.get())));
    }

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LoginViewBinder viewBinder = LoginViewBinder.inflate(inflater, container, false);
        viewBinder.setModel(this);
        return viewBinder.getRoot();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.username, flags);
        dest.writeParcelable(this.password, flags);
    }

    protected LoginViewModel(Parcel in) {
        this.username = in.readParcelable(ObservableString.class.getClassLoader());
        this.password = in.readParcelable(ObservableString.class.getClassLoader());
    }

    public static final Creator<LoginViewModel> CREATOR = new Creator<LoginViewModel>() {
        @Override
        public LoginViewModel createFromParcel(Parcel source) {
            return new LoginViewModel(source);
        }

        @Override
        public LoginViewModel[] newArray(int size) {
            return new LoginViewModel[size];
        }
    };
}
