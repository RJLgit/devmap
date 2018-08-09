package com.example.android.devmap.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.content.Context;
import android.view.LayoutInflater;

import com.example.android.devmap.R;
import com.example.android.devmap.data.GoalsData;
import com.example.android.devmap.data.RoadMapData;
import com.example.android.devmap.data.StageData;

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
        holder.setGoalsData(stageArray.get(position));
        holder.bind(stageArray.get(position));
    }

    @Override
    public int getItemCount() {
        return stageArray.size();
    }

    // define the GoalViewHolders class
    class GoalsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView goalTextView;
        CheckBox goalCheckBox;
        GoalsData goalsData;

        public GoalsViewHolder (final View itemView){
            super(itemView);
            goalTextView = itemView.findViewById(R.id.goalNumber);
            goalCheckBox = itemView.findViewById(R.id.goalCheckBox);
            goalCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    String s = goalsData.getGoal();
                    RoadMapData.changeGoalBoolean(s, b);
                }
            });
            itemView.setOnClickListener(this);
        }

        void setGoalsData(GoalsData g) {
            goalsData = g;
        }

        void bind(GoalsData s){
            goalTextView.setText(s.getGoal());
            goalCheckBox.setChecked(s.getProgress());
        }
        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mListItemClickListener.onListItemClick(clickedPosition);
        }
    }
}
