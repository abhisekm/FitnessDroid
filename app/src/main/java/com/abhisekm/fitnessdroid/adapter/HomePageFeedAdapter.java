package com.abhisekm.fitnessdroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.abhisekm.fitnessdroid.R;
import com.flaviofaria.kenburnsview.KenBurnsView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AbhisekM on 5/29/2016.
 */
public class HomePageFeedAdapter extends RecyclerView.Adapter<HomePageFeedAdapter.FeedViewHolder> {
    List<Integer> feedResId;

    public HomePageFeedAdapter() {
        feedResId = new ArrayList<>();
        feedResId.add(R.drawable.feed1);
        feedResId.add(R.drawable.feed2);
        feedResId.add(R.drawable.feed3);
        feedResId.add(R.drawable.feed4);
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.layout_feed, parent, false);
        return new FeedViewHolder(root);
    }

    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position) {
        holder.setImageView(feedResId.get(position % feedResId.size()));
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class FeedViewHolder extends RecyclerView.ViewHolder {
        private KenBurnsView imageView;
        Context context;
        /*ImageDownloader imgDownloader = new ImageDownloader();*/

        public FeedViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            imageView = (KenBurnsView) itemView.findViewById(R.id.image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Open Feed", Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void setImageView(int resId) {
            imageView.setImageResource(resId);
        }
    }
}
