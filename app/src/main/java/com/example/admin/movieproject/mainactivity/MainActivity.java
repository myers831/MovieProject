package com.example.admin.movieproject.mainactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.movieproject.R;
import com.example.admin.movieproject.model.Result;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListFragment listFragment;
    public static final String LIST_FRAG_TAG = "listFragTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listFragment = new ListFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.flList, listFragment, LIST_FRAG_TAG).commit();
    }

}
