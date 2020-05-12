package com.ingenicomovement.rvexpand;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.provider.ContactsContract;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;


@SuppressLint("ParcelCreator")
public class MobileOs extends ExpandableGroup<Phone> {
    public MobileOs(String title, List<Phone> items) {
        super(title, items);
    }

    protected MobileOs(Parcel in) {
        super(in);
    }
}
