package in.com.mvvmdemo.network;


import in.com.mvvmdemo.login.datamodel.GenreListResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("genre/movie/list")
    Call<GenreListResponse> getGenerList(@Query("api_key") String apiKey);


}