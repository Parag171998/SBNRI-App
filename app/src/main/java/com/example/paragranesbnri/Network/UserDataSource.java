package com.example.paragranesbnri.Network;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.example.paragranesbnri.Models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDataSource extends PageKeyedDataSource<Integer, User> {

    public static final int PAGE_SIZE = 10;

    //we will start from the first page which is 1
    private static final int FIRST_PAGE = 1;

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, User> callback) {

        ApiClient.getInstance().getApi()
                .getUsersList(String.valueOf(FIRST_PAGE))
                .enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        if(response.body() != null)
                        {
                            callback.onResult(response.body(),null,FIRST_PAGE+1);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, User> callback) {

        ApiClient.getInstance().getApi()
                .getUsersList(params.key.toString())
                .enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                        Integer key = (params.key > 1) ? params.key - 1 : null;
                        if(response.body() != null)
                        {
                            callback.onResult(response.body(),key);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, User> callback) {

       ApiClient.getInstance().getApi()
               .getUsersList(params.key.toString())
               .enqueue(new Callback<List<User>>() {
                   @Override
                   public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                       Integer key = (response.body().size() <= params.key) ? params.key + 1 : null;
                       callback.onResult(response.body(), key);
                   }

                   @Override
                   public void onFailure(Call<List<User>> call, Throwable t) {

                   }
               });
    }
}
