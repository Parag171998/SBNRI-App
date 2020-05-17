package com.example.paragranesbnri.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import com.example.paragranesbnri.Models.User;
import com.example.paragranesbnri.Network.UserDataSource;
import com.example.paragranesbnri.Network.UserDataSourceFactory;

public class MainViewModel extends ViewModel {

    LiveData<PagedList<User>> userPagedList;
    LiveData<PageKeyedDataSource<Integer, User>> liveDataSource;

    public MainViewModel()
    {
        UserDataSourceFactory userDataSourceFactory = new UserDataSourceFactory();
        liveDataSource = userDataSourceFactory.getMutableLiveData();

        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(UserDataSource.PAGE_SIZE).build();

        userPagedList = (new LivePagedListBuilder(userDataSourceFactory, pagedListConfig))
                .build();

    }



}
