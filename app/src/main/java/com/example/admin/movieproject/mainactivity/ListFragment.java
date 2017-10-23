package com.example.admin.movieproject.mainactivity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.movieproject.R;
import com.example.admin.movieproject.RecycleViewAdapter;
import com.example.admin.movieproject.mainactivity.MainActivityContractor;
import com.example.admin.movieproject.model.Result;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment implements MainActivityContractor.View{

    RecyclerView rvResults;
    RecycleViewAdapter recycleViewAdapter;
    RecyclerView.LayoutManager layoutManager;
    MainActivityPresenter presenter;


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvResults = view.findViewById(R.id.rvResults);
        layoutManager = new LinearLayoutManager(getContext());
        presenter = new MainActivityPresenter();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.addView(this);
        presenter.rxSetup();
    }

    @Override
    public void adaptRecyclerView(List<Result> resultList) {
        recycleViewAdapter = new RecycleViewAdapter(resultList);
        rvResults.setLayoutManager(layoutManager);
        rvResults.setAdapter(recycleViewAdapter);
    }
}
