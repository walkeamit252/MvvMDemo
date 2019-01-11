package in.com.mvvmdemo.login.datamodel;

import com.google.gson.annotations.Expose;

import java.util.List;

public class GenreListResponse
{

    List<GenrelResponse> genres;

    public List<GenrelResponse> getGenres() {
        return genres;
    }

    public void setGenres(List<GenrelResponse> genres) {
        this.genres = genres;
    }
}