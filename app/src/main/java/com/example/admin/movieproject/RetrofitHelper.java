package com.example.admin.movieproject;

import android.util.Log;

import com.example.admin.movieproject.model.Movies;
import java.util.Map;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import static android.content.ContentValues.TAG;

/**
 * Created by Admin on 10/14/2017.
 */

public class RetrofitHelper {

    public static final String BASE_URL = "https://api.themoviedb.org";

    static public Retrofit create(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }

    static public Observable<Movies> getCall(Map<String, String> query){
        Retrofit retrofit = create();
        RequestService service = retrofit.create(RequestService.class);
        Log.d(TAG, "getCall: " + query);
        return service.responseService(/*query*/);
    }

    public interface RequestService{
        @GET("/3/search/movie?api_key=6019c2516dcc1f758e28fa9de3263013&language=en-US&query=world%20of%20warcraft&page=1&include_adult=false")
        Observable<Movies> responseService();
        //Observable<Search> responseService(@Path(value = "query", encoded=true) final String query);

        //@GET("/3/search/movie")
        //Observable<Movies> responseService(@QueryMap Map<String, String> query);
    }
}
