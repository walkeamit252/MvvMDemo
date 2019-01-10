package in.com.mvvmdemo.login.network;


import in.com.mvvmdemo.login.model.GenreListResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("genre/movie/list")
    Call<GenreListResponse> getGenerList(@Query("api_key") String apiKey);


}