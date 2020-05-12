package com.ingenicomovement.rvexpand;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class OSViewHolder extends GroupViewHolder {

    private TextView osName;
    public OSViewHolder(View itemView) {
        super(itemView);
        osName = (TextView) itemView.findViewById(R.id.mobile_os);
    }

    @Override
    public void expand() {
        super.expand();
    }

    @Override
    public void collapse() {
        super.collapse();
    }

    public void setGroupName(ExpandableGroup group) {
        osName.setText(group.getTitle());
    }
}
