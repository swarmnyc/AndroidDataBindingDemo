package com.swarmnyc.databindingdemo.util;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.swarmnyc.databindingdemo.BR;
import com.swarmnyc.databindingdemo.R;

import java.util.Date;

public class BindingAdapters {
    public interface OnClickListener {
        void onClick();
    }

    @BindingAdapter({"binding:text", "binding:textFormat"})
    public static void bindDateWithFormat(TextView view, Date date, String format) {
        view.setText(String.format(format, date));
    }

    @BindingAdapter({"binding:text"})
    public static void bindText(EditText view, final ObservableString string) {
        if (view.getTag(R.id.dataBinding) == null) {
            view.setTag(R.id.dataBinding, Boolean.TRUE);

            view.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    string.set(s.toString());
                }
            });
        }

        String newValue = string.get();
        if (!view.getText().toString().equals(newValue) && newValue != null) {
            view.setText(newValue);
            view.setSelection(newValue.length());
        }
    }

    @BindingAdapter({"binding:toastMe"})
    public static void toastMe(final View view, CharSequence string) {
        if (view.getTag(R.id.dataBinding) == null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), view.getTag(R.id.dataBinding).toString(), Toast.LENGTH_LONG).show();
                }
            });
        }

        view.setTag(R.id.dataBinding, string);
    }

    @BindingAdapter({"binding:src"})
    public static void bindImage(final ImageView view, String imageUrl) {
        view.setTag(R.id.imageUrl, imageUrl);
        if (imageUrl != null && !imageUrl.isEmpty()) {
            Glide.with(view.getContext()).load(imageUrl).centerCrop().into(view);
        }
    }

    @BindingAdapter({"binding:model", "binding:itemLayout"})
    public static void bindModel(final ListView view, final ObservableArrayList model, final int layoutId) {
        if (view.getAdapter() == null) {
            view.setAdapter(new BaseAdapter() {
                @Override
                public int getCount() {
                    return model.size();
                }

                @Override
                public Object getItem(int position) {
                    return model.get(position);
                }

                @Override
                public long getItemId(int position) {
                    return position;
                }

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    if (convertView == null) {
                        convertView = DataBindingUtil.inflate(LayoutInflater.from(view.getContext()), layoutId, parent, false).getRoot();
                    }

                    ViewDataBinding binder = (ViewDataBinding) convertView.getTag(R.id.dataBinding);
                    binder.setVariable(BR.model, model.get(position));

                    return convertView;
                }
            });
        } else {
            ((BaseAdapter) view.getAdapter()).notifyDataSetChanged();
        }

    }

    @BindingAdapter({"binding:click"})
    public static void bindClick(final View view, final OnClickListener clickListener) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClick();
            }
        });
    }
}

