package in.com.mvvmdemo.login;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Patterns;

import java.util.List;

import in.com.mvvmdemo.login.model.GenreListResponse;
import in.com.mvvmdemo.login.model.GenreResponse;
import in.com.mvvmdemo.login.network.ApiClient;
import in.com.mvvmdemo.login.network.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserModelInteractor {
    @NonNull
    private String mEmail;
    @NonNull
    private String mPassword;
    ApiInterface apiService;
    int statusCode=0;
    String API_KEY = "f17e9c5e6c34ad9dc2bf6aab852c0cc7";

    public UserModelInteractor(@NonNull final String email, @NonNull final String password) {
        mEmail = email;
        mPassword = password;
        apiService = ApiClient.getClient().create(ApiInterface.class);
    }

    @NonNull
    public String getEmail() {
        return mEmail;
    }

    public void setEmail(@NonNull final String email) {
        mEmail = email;
    }

    @NonNull
    public String getPassword() {
        return mPassword;
    }

    public void setPassword(@NonNull final String password) {
        mPassword = password;
    }

    public boolean isInputDataValid() {
        return !TextUtils.isEmpty(getEmail()) &&
                Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches() &&
                getPassword().length() > 5;
    }


    public int fetchMoviesList(){

        Call<GenreListResponse> call = apiService.getGenerList(API_KEY);
        call.enqueue(new Callback<GenreListResponse>() {
            @Override
            public void onResponse(Call<GenreListResponse> call, Response<GenreListResponse> response) {
                if (response.isSuccessful()) {
                    statusCode = response.code();
                    List<GenreResponse> genList = response.body().getGenres();
                }
            }

            @Override
            public void onFailure(Call<GenreListResponse> call, Throwable t) {

            }
        });
        return  statusCode;
    }



}
