package com.swarmnyc.databindingdemo.demo3.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    public String username;

    public User(String username) {

        this.username = username;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.username);
    }

    protected User(Parcel in) {
        this.username = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
