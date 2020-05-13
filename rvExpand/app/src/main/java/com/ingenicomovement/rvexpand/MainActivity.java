package com.ingenicomovement.rvexpand;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListItemListener {

    ArrayList<Place> places;
    CardView cvContainer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        places = new ArrayList<>();
        for (int i=0; i<6; i++) {
            places.add(new Place("place " + i));
        }

        cvContainer = (CardView) findViewById(R.id.card_background);
        RecyclerView rvList = (RecyclerView) findViewById(R.id.rv_list);
        PlaceArrayAdapter placeArrayAdapter = new PlaceArrayAdapter(places);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setItemAnimator(new DefaultItemAnimator());
        rvList.setAdapter(placeArrayAdapter);

        placeArrayAdapter.setListItemListener(this);


        rvList.post(new Runnable() {
            @Override
            public void run() {
                int baseHeight =  Math.round(getResources().getDimension(R.dimen.place_item_height));
                int collapseAmount = baseHeight * (places.size() - 1);
                ExpandableUtil.collapseWithNoAnimation(cvContainer, collapseAmount);
            }
        });






    }

    @Override
    public void onExpand() {
        int from =  Math.round(getResources().getDimension(R.dimen.place_item_height));
        int to = from * places.size();
        ExpandableUtil.expand(cvContainer, from, to);


    }

    @Override
    public void onCollapse() {
        int baseHeight =  Math.round(getResources().getDimension(R.dimen.place_item_height));
        int collapseAmount = baseHeight * (places.size() - 1);
        ExpandableUtil.collapse(cvContainer, collapseAmount);

    }
}
