package com.example.poc.dashboard;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.poc.R;

public class complete_Fragment extends Fragment {
    View view;

    public complete_Fragment() {
    }
    public static complete_Fragment newInstance() {
        complete_Fragment fragment = new complete_Fragment();
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.complete_fragment, container, false);
        return view;
    }
}