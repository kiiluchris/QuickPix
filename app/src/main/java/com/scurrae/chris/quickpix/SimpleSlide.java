package com.scurrae.chris.quickpix;

/**
 * Created by davidkezi on 12/03/2016.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SimpleSlide extends Fragment {
    private static  final String ARG_LAYOUT_RES_ID = "layoutResId";

    public static SimpleSlide newInstance(int layoutResId){
        SimpleSlide simpleSlide = new SimpleSlide();

        Bundle args = new Bundle();
        args.putInt(ARG_LAYOUT_RES_ID, layoutResId);
        simpleSlide.setArguments(args);

        return simpleSlide;
    }
    private int layoutResId;

    public SimpleSlide(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null && getArguments().containsKey(ARG_LAYOUT_RES_ID))
            layoutResId = getArguments().getInt(ARG_LAYOUT_RES_ID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(layoutResId, container, false);
    }
}
