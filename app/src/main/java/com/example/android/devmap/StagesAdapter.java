package com.example.android.devmap;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

public class StagesAdapter extends RecyclerView.Adapter<StagesAdapter.StagesViewHolder> {
    final private ListItemClickListener mListItemClickListener;
    private Context c;

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
        holder.bind("Stage x", false);
    }

    @Override
    public int getItemCount() {
        // return number of data items once class has been made with data in it.
        return 6;
    }

    // Define the StagesViewHolder class
    class StagesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView stageTextView;
        CheckBox stageCheckBox;

        public StagesViewHolder(final View itemView) {
            super(itemView);
            stageTextView = (TextView) itemView.findViewById(R.id.stageNumber);
            stageCheckBox = (CheckBox) itemView.findViewById(R.id.stageCheckBox);
            itemView.setOnClickListener(this);
        }

        void bind(String s, boolean b) {
            stageTextView.setText(s);
            stageCheckBox.setChecked(b);
            // find out how to set the checkbox to the boolean value of b, designating whether it is completed or not?
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mListItemClickListener.onListItemClick(clickedPosition);
        }
    }
}
