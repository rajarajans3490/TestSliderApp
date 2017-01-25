package com.slider.sample.sliderapp.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.slider.sample.sliderapp.R;


public class ViewPageFragment3 extends Fragment {

    public static ViewPageFragment3 newInstance() {
        ViewPageFragment3 fragment = new ViewPageFragment3();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3, container, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplication(), R.string.fragment3, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
