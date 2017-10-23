package com.example.admin.movieproject.mainactivity;

import com.example.admin.movieproject.BasePresenter;
import com.example.admin.movieproject.BaseView;
import com.example.admin.movieproject.model.Result;

import java.util.List;

/**
 * Created by Admin on 10/22/2017.
 */

public interface MainActivityContractor {

     interface View extends BaseView {
        public void adaptRecyclerView(List<Result> resultList);
    }

    interface Presenter extends BasePresenter<View> {

    }

}
