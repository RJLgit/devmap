package com.example.android.devmap.adapters;

import android.os.AsyncTask;
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
import com.example.android.devmap.database.Goal;
import com.example.android.devmap.database.UpdateDbClass;

import java.util.List;


public class GoalsAdapter extends RecyclerView.Adapter<GoalsAdapter.GoalsViewHolder> {

    final private ListItemClickListener mListItemClickListener;
    private final Context c;
    private List<Goal> stageArray;


    public GoalsAdapter (Context context, ListItemClickListener listItemClickListener){
        c = context;
        mListItemClickListener = listItemClickListener;
    }

    public void setGoals(List<Goal> goals) {
        stageArray = goals;
        notifyDataSetChanged();
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
        holder.setGoal(stageArray.get(position));
        holder.bind(stageArray.get(position));
    }

    @Override
    public int getItemCount() {
        if (stageArray !=null)
            return stageArray.size();
        else return 0;
    }

    // define the GoalViewHolders class
    class GoalsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView goalTextView;
        final CheckBox goalCheckBox;
        Goal goal;
        private AsyncTask backgroundTask;

        GoalsViewHolder(final View itemView){
            super(itemView);
            goalTextView = itemView.findViewById(R.id.goalNumber);
            goalCheckBox = itemView.findViewById(R.id.goalCheckBox);

            goalCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    goal.setProgress(b);
                    new UpdateDbClass(c).execute(goal);

                }
            });
            itemView.setOnClickListener(this);
        }





        void setGoal(Goal g) {
            goal = g;
        }

        void bind(Goal s){
            goalTextView.setText(s.getName());
            goalCheckBox.setChecked(s.getProgress());
        }
        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mListItemClickListener.onListItemClick(clickedPosition);
        }
    }
}
