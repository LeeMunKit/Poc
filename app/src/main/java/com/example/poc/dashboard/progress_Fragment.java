package com.example.poc.dashboard;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.poc.R;

public class progress_Fragment extends Fragment {
    View view;
    public progress_Fragment() {
    }

    public static progress_Fragment newInstance() {
        progress_Fragment fragment = new progress_Fragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.progress_fragment,container,false);
        return view;
    }
}