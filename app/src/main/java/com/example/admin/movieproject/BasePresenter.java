package com.example.admin.movieproject;

/**
 * Created by Admin on 10/22/2017.
 */

public interface BasePresenter<V extends BaseView> {

    void addView(V View);
    void removeView();

}
