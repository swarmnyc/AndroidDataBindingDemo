package com.swarmnyc.databindingdemo.util;

import android.databinding.BaseObservable;
import android.os.Parcel;
import android.os.Parcelable;

public class ObservableString extends BaseObservable implements Parcelable {
    private String value;

    public ObservableString() {
    }

    public String get() {
        return value;
    }

    public void set(String value) {
        boolean noChange = ((this.value == null && value == null) || (this.value != null && this.equals(value)));
        if (!noChange) {
            this.value = value;
            notifyChange();
        }
    }

    public boolean isEmpty() {
        return value == null || value.isEmpty();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.value);
    }

    protected ObservableString(Parcel in) {
        this.value = in.readString();
    }

    public static final Creator<ObservableString> CREATOR = new Creator<ObservableString>() {
        @Override
        public ObservableString createFromParcel(Parcel source) {
            return new ObservableString(source);
        }

        @Override
        public ObservableString[] newArray(int size) {
            return new ObservableString[size];
        }
    };
}
