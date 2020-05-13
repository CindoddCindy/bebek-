package com.ingenicomovement.rvexpand;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlaceArrayAdapter extends RecyclerView.Adapter<PlaceArrayAdapter.ViewHolder> {

    private ArrayList<Place> places;
    private ListItemListener listItemListener;
    private boolean isExpanded = false;

    public PlaceArrayAdapter(ArrayList<Place> places) {
        this.places = places;
    }

    public void setListItemListener(ListItemListener listItemListener) {
        this.listItemListener = listItemListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_place_item, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView item = holder.item;
        item.setText(places.get(position).getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded) {
                    listItemListener.onCollapse();
                    isExpanded = false;
                } else {
                    listItemListener.onExpand();
                    isExpanded = true;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return places == null ? 0 : places.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            item = (TextView) itemView.findViewById(R.id.row_item);
        }

        @Override
        public void onClick(View v) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + item.getText());


        }
    }
}
