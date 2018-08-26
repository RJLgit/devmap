package com.example.android.devmap.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.devmap.R;
import com.example.android.devmap.database.Road;
import com.example.android.devmap.database.Stage;


import java.util.List;

public class RoadAdapter extends RecyclerView.Adapter<RoadAdapter.RoadViewHolder>{
    private List<Road> mRoadList;
    final private ListItemClickListener mListItemClickListener;
    private static final String TAG = "RoadAdapter";

    public RoadAdapter(ListItemClickListener listItemClickListener) {
        mListItemClickListener= listItemClickListener;
    }

    // interface for itemclicklistener
    public interface ListItemClickListener {
        void onListItemCLick (int index);
    }

    public void setRoads(List<Road> roads){
        mRoadList = roads;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RoadAdapter.RoadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.roads_recycler_view_item, parent, false);
        RoadViewHolder rh = new RoadViewHolder(v);
        return rh;
    }

    @Override
    public void onBindViewHolder(@NonNull RoadAdapter.RoadViewHolder holder, int position) {
        holder.bind(mRoadList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        if (mRoadList != null)
        return mRoadList.size();
        else return 0;
    }

    public class RoadViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mTextView;

        public RoadViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.road_name_textview);
            v.setOnClickListener(this);
        }

        void bind (String s) {
            mTextView.setText(s);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            Log.d(TAG, "onClick: clicked position is " + clickedPosition);
            int roadIdClicked = mRoadList.get(clickedPosition).getId();
            Log.d(TAG, "onClick: road id clicked is " +roadIdClicked );
            mListItemClickListener.onListItemCLick(roadIdClicked);
        }
    }
}
