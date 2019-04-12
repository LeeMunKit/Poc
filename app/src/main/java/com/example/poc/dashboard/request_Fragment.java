package com.example.poc.dashboard;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.poc.R;
import com.example.poc.Entity.JobInfo1;
import com.example.poc.ViewHolder.MenuViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


import java.util.ArrayList;

public class request_Fragment extends Fragment {
    RecyclerView recycle_menu;
    RecyclerView.LayoutManager layoutManager;
    DatabaseReference jobinfo;
    ArrayList<JobInfo1> items = new ArrayList<>();
    int Test = 0;

    FirebaseRecyclerAdapter <JobInfo1, MenuViewHolder> adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println("Test 11111111:"+":End");
        View view = inflater.inflate(R.layout.request_fragment, container, false);

        Test = 1;
        recycle_menu = view. findViewById(R.id.recycle_menu);
        recycle_menu.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());

        recycle_menu.setLayoutManager(layoutManager);

        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
        jobinfo = FirebaseDatabase.getInstance().getReference().child("ListOfJob1");
        System.out.println("Test 555555555:"+":End");
        Query query = jobinfo.orderByKey();
        System.out.println("Test 11111166666611:"+":End");
        FirebaseRecyclerOptions firebaseRecyclerOptions = new FirebaseRecyclerOptions.Builder<JobInfo1>().setQuery(query, JobInfo1.class).build();
        adapter = new FirebaseRecyclerAdapter<JobInfo1, MenuViewHolder>(firebaseRecyclerOptions) {

            @NonNull
            @Override
            public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_list,viewGroup,false);
                return new MenuViewHolder(view);

            }

            @Override
            public void onBindViewHolder(@NonNull MenuViewHolder holder, int position, @NonNull JobInfo1 model) {
                System.out.println("Test 222:"+":End");

                holder.txtTheJobName1.setText(model.getJobName1());
                System.out.println("Test 333:"+":End");
                System.out.println("Test Name:"+model.getJobName1()+":End");
                holder.txtTheNoOfGuard1.setText(model.getNoOfGuard1());
                holder.txtTheDate1.setText(model.getDate1());
                holder.txtTheLocation1.setText(model.getLocation1());
                holder.txtTheStatus1.setText(model.getStatus1());
                holder.txtTheType1.setText(model.getType1());
                System.out.println("Test Test:"+Test+":End");

            }
        };
        recycle_menu.setAdapter(adapter);

        return view;
    }


    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}