package com.example.admin.movieproject.mainactivity;

import android.support.v4.util.ArrayMap;
import android.util.Log;

import com.example.admin.movieproject.RetrofitHelper;
import com.example.admin.movieproject.mainactivity.MainActivityContractor.View;
import com.example.admin.movieproject.model.Movies;
import com.example.admin.movieproject.model.Result;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

import static android.content.ContentValues.TAG;

/**
 * Created by Admin on 10/22/2017.
 */

public class MainActivityPresenter implements MainActivityContractor.Presenter {

    MainActivityContractor.View view;
    Map<String, String> query = new ArrayMap<>();
    List<Result> resultList = new ArrayList<>();



    @Override
    public void addView(View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    public void rxSetup(){

        query.put("apiKey", "6019c2516dcc1f758e28fa9de3263013");
        query.put("query", "world of warcraft");

        RetrofitHelper.getCall(query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Movies>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.d(TAG, "onSubscribe: " + d.toString());
                    }

                    @Override
                    public void onNext(@NonNull Movies movies) {
                        for(Result r: movies.getResults()){
                            resultList.add(r);
                            Log.d(TAG, "onNext: " + r.getTitle());
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "onError: " + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        view.adaptRecyclerView(resultList);
                        Log.d(TAG, "onComplete: ");
                    }
                });
    }
}
