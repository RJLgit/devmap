package com.example.android.devmap;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.content.Context;
import android.view.LayoutInflater;

import java.util.ArrayList;


public class GoalsAdapter extends RecyclerView.Adapter<GoalsAdapter.GoalsViewHolder> {

    final private ListItemClickListener mListItemClickListener;
    private Context c;
    private StageData stage;
    private ArrayList<GoalsData> stageArray;

    public GoalsAdapter (Context context, ListItemClickListener listItemClickListener, StageData s){
        c = context;
        mListItemClickListener = listItemClickListener;
        stage = s;
        stageArray = stage.getGoals();
    }

    //defines the interface for when an item is clicked in the recycler view
    public interface ListItemClickListener{
        void onListItemClick(int index);
    }

    @NonNull
    @Override
    public GoalsAdapter.GoalsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutForListItem = R.layout.goals_recycler_view_item;

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutForListItem, parent, false);
        return new GoalsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GoalsAdapter.GoalsViewHolder holder, int position) {
        holder.bind(stageArray.get(position), false);
    }

    @Override
    public int getItemCount() {
        return stageArray.size();
    }

    // define the GoalViewHolders class
    class GoalsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView goalTextView;
        CheckBox goalCheckBox;

        public GoalsViewHolder (final View itemView){
            super(itemView);
            goalTextView = itemView.findViewById(R.id.goalNumber);
            goalCheckBox = itemView.findViewById(R.id.goalCheckBox);
            itemView.setOnClickListener(this);
        }

        void bind(GoalsData s, boolean b){
            goalTextView.setText(s.getGoal());
            goalCheckBox.setChecked(b);
        }
        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mListItemClickListener.onListItemClick(clickedPosition);
        }
    }
}
