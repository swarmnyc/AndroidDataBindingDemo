package com.swarmnyc.databindingdemo.demo3.viewmodel;

import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swarmnyc.databindingdemo.databinding.GameListViewBinder;
import com.swarmnyc.databindingdemo.demo3.model.User;
import com.swarmnyc.databindingdemo.util.ObservableString;

public class GameListViewModel extends BaseViewModel {
    public User user;
    public ObservableString gameName = new ObservableString();
    public ObservableArrayList<GameViewModel> games = new ObservableArrayList<>();

    public GameListViewModel(User user) {
        this.user = user;
    }

    public void addNewGame() {
        games.add(new GameViewModel(gameName.get()));
        gameName.set("");
    }

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        GameListViewBinder viewBinder = GameListViewBinder.inflate(inflater, container, false);
        viewBinder.setModel(this);
        return viewBinder.getRoot();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.user, flags);
        dest.writeParcelable(this.gameName, flags);
        dest.writeTypedList(games);
    }

    protected GameListViewModel(Parcel in) {
        this.user = in.readParcelable(User.class.getClassLoader());
        this.gameName = in.readParcelable(ObservableString.class.getClassLoader());
        in.readTypedList(this.games, GameViewModel.CREATOR);
    }

    public static final Creator<GameListViewModel> CREATOR = new Creator<GameListViewModel>() {
        @Override
        public GameListViewModel createFromParcel(Parcel source) {
            return new GameListViewModel(source);
        }

        @Override
        public GameListViewModel[] newArray(int size) {
            return new GameListViewModel[size];
        }
    };
}
