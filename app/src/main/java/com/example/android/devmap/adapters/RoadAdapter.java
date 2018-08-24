package com.example.android.devmap.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.devmap.R;
import com.example.android.devmap.database.Road;
import com.example.android.devmap.database.Stage;


import java.util.List;

public class RoadAdapter extends RecyclerView.Adapter<RoadAdapter.RoadViewHolder>{
    private List<Road> mRoadList;
    private Context mContext;


    public void setRoads(List<Road> roads){
        mRoadList = roads;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RoadAdapter.RoadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.roads_recycler_view_item, parent, false);
        RoadViewHolder rh = new RoadViewHolder(v);
        return rh;
    }

    @Override
    public void onBindViewHolder(@NonNull RoadAdapter.RoadViewHolder holder, int position) {
        //holder.mTextView.setText("test");
        holder.bind(mRoadList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        if (mRoadList != null)
            return mRoadList.size();
        else return 0;
    }

    public static class RoadViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public RoadViewHolder(TextView v) {
            super(v);
            mTextView = v.findViewById(R.id.road_name_textview);
        }

        void bind (String s) {
            mTextView.setText(s);
        }
    }
}
