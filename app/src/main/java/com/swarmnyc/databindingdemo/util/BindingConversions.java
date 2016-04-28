package com.swarmnyc.databindingdemo.util;

import android.databinding.BindingConversion;

import java.util.Date;

public class BindingConversions {
    @BindingConversion
    public static String convertToString(ObservableString string) {
        return string.get();
    }

    @BindingConversion
    public static Date convertToDate(ObservableDate date) {
        return date.get();
    }
}
