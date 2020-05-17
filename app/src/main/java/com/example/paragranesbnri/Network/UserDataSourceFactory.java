package com.example.paragranesbnri.Network;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import com.example.paragranesbnri.Models.User;

public class UserDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<PageKeyedDataSource<Integer, User>> mutableLiveData = new MutableLiveData<>();

    @Override
    public DataSource create() {

        UserDataSource userDataSource = new UserDataSource();
        mutableLiveData.postValue(userDataSource);
        return userDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, User>> getMutableLiveData() {
        return mutableLiveData;
    }
}
