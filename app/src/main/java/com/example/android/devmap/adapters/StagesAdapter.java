package com.example.android.devmap.adapters;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.devmap.R;
import com.example.android.devmap.data.RoadMapData;
import com.example.android.devmap.data.StageData;
import com.example.android.devmap.database.Stage;
import com.example.android.devmap.database.StageRepository;

import java.util.List;

public class StagesAdapter extends RecyclerView.Adapter<StagesAdapter.StagesViewHolder> {
    final private ListItemClickListener mListItemClickListener;
    private Context c;
    private List<Stage> stageDataList;

    public StagesAdapter(Context context, ListItemClickListener listItemClickListener) {
        c = context;
        mListItemClickListener = listItemClickListener;
    }

    //Defines the interface for when an item is clicked in the recycler view.
    public interface ListItemClickListener {
        void onListItemClick(int index);
    }

    @NonNull
    @Override
    public StagesAdapter.StagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutForListItem = R.layout.stages_recycler_view_item;

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutForListItem, parent, false);
        StagesViewHolder viewHolder = new StagesViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StagesAdapter.StagesViewHolder holder, int position) {
        // bind data when it has been created in its own class.
        holder.bind(stageDataList.get(position).getName(), "ole");
    }

    public void setStages(List<Stage> stages) {
        stageDataList = stages;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        // return number of data items once class has been made with data in it.
        if (stageDataList !=null)
            return stageDataList.size();
        else return 0;
    }

    // Define the StagesViewHolder class
    class StagesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView stageTextView;
        TextView stageProgressBox;

        public StagesViewHolder(final View itemView) {
            super(itemView);
            stageTextView = (TextView) itemView.findViewById(R.id.stageNumber);
            stageProgressBox = (TextView) itemView.findViewById(R.id.stageProgressTextView);
            itemView.setOnClickListener(this);
        }

        void bind(String s, String b) {
            stageTextView.setText(s);
            stageProgressBox.setText(b);
            // find out how to set the checkbox to the boolean value of b, designating whether it is completed or not?
        }

        @Override
        public void onClick(View view) {
            int stageIdClicked = stageDataList.get(getAdapterPosition()).getId();
            mListItemClickListener.onListItemClick(stageIdClicked);
        }
    }
}
