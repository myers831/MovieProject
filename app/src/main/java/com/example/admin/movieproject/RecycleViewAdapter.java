package com.example.admin.movieproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.admin.movieproject.model.Result;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Admin on 10/14/2017.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    List<Result> resultList = new ArrayList<>();
    Context context;
    DecimalFormat df = new DecimalFormat("#.00");

    public RecycleViewAdapter(List<Result> resultList) {
        this.resultList = resultList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Result result = resultList.get(position);
        holder.result = result;
        Log.d(TAG, "onBindViewHolder: " + result.getTitle());

        holder.tvResultTitle.setText(result.getTitle());
        holder.tvResultReleaseDate.setText(String.valueOf(result.getReleaseDate()));
        holder.tvResultOverview.setText(result.getOverview());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500" + result.getBackdropPath()).into(holder.ivResultPoster);

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Result result;
        TextView tvResultTitle, tvResultReleaseDate, tvResultOverview;
        ImageView ivResultPoster;

        public ViewHolder(View itemView) {
            super(itemView);
/*
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ItemViewActivity.class);
                    intent.putExtra("result", result);
                    context.startActivity(intent);
                }
            });
    */

            ivResultPoster = itemView.findViewById(R.id.ivResultPoster);
            tvResultTitle = itemView.findViewById(R.id.tvResultTitle);
            tvResultReleaseDate = itemView.findViewById(R.id.tvResultReleaseDate);
            tvResultOverview = itemView.findViewById(R.id.tvResultOverview);
        }
    }
}
