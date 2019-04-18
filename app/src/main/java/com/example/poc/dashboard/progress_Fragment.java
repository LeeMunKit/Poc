package com.example.poc.dashboard;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.poc.accept_payment1;
import com.example.poc.Quote.quote;
import com.example.poc.R;
import com.example.poc.Entity.service_Info;
import com.example.poc.RecyclerItemClickListener;
import com.example.poc.TestingPage;
import com.example.poc.ViewHolder.MenuViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


import java.util.ArrayList;

public class progress_Fragment extends Fragment {
    RecyclerView recycle_menu;
    RecyclerView.LayoutManager layoutManager;
    DatabaseReference service_Info;
    ArrayList<service_Info> items = new ArrayList<>();
    String temp = "";
    FirebaseRecyclerAdapter <service_Info, MenuViewHolder> adapter;

    public static request_Fragment newInstance() {
        request_Fragment fragment = new request_Fragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.request_fragment, container, false);

        recycle_menu = view. findViewById(R.id.recycle_menu);
        recycle_menu.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());

        recycle_menu.setLayoutManager(layoutManager);
        final String TestCurrentUser;
        // TestCurrentUser = CUser.currentUser.getUserName();
        TestCurrentUser = "ggggjhjh";
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
        service_Info = FirebaseDatabase.getInstance().getReference().child("service_Info").child(TestCurrentUser);


        //status
        String searchBoxInput = "booked";
        Query query = service_Info.orderByChild("status").startAt((searchBoxInput)).endAt(searchBoxInput+"\uf8ff");

        FirebaseRecyclerOptions firebaseRecyclerOptions = new FirebaseRecyclerOptions.Builder<service_Info>().setQuery(query, service_Info.class).build();
        adapter = new FirebaseRecyclerAdapter<service_Info, MenuViewHolder>(firebaseRecyclerOptions) {

            @NonNull
            @Override
            public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_list,viewGroup,false);
                return new MenuViewHolder(view);

            }
            //
            @Override
            public void onBindViewHolder(@NonNull MenuViewHolder holder, int position, @NonNull service_Info model) {
                holder.txtTheJobName1.setText(model.getJobTitle());
                holder.txtTheNoOfGuard1.setText(model.getNoOfPax());
                holder.txtTheDate1.setText(model.getReqDate());
                holder.txtTheLocation1.setText(model.getAddressInfo());
                holder.txtTheStatus1.setText(model.getStatus());
                holder.txtFurtherStatus.setText(model.getFurtherStatus());
                holder.txtserviceID.setText(model.getServiceID());



                System.out.println("Test Further Status:"+model.getFurtherStatus()+":End");
                System.out.println("Test txtTheJobName1:"+model.getJobTitle()+":End");


            }
        };


        recycle_menu.addOnItemTouchListener(
                new RecyclerItemClickListener(recycle_menu ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        System.out.print("ÄAAAA");
                        // do whatever

                        //   temp = getServiceID();
                        final String SID = ((TextView)view.findViewById(R.id.serviceID)).getText().toString();
                        final String furtherStatus = ((TextView)view.findViewById(R.id.TheFurtherStatus)).getText().toString();
                        final String status = ((TextView)view.findViewById(R.id.TheStatus1)).getText().toString();
                        final String addressInfo = ((TextView)view.findViewById(R.id.TheLocation1)).getText().toString();
                        final String JobName  = ((TextView)view.findViewById(R.id.TheJobName1)).getText().toString();
                        final String NoOfGuard = ((TextView)view.findViewById(R.id.TheNoOfGuard1)).getText().toString();
                        final String theDate = ((TextView)view.findViewById(R.id.TheDate1)).getText().toString();


                            Intent myIntent = new Intent(progress_Fragment.this.getActivity(), accept_payment1.class);
                            myIntent.putExtra("ServiceID", SID);
                            myIntent.putExtra("furtherStatus", furtherStatus);
                            myIntent.putExtra("status", status);
                            myIntent.putExtra("addressInfo", addressInfo);
                            myIntent.putExtra("JobName", JobName);
                            myIntent.putExtra("NoOfGuard", NoOfGuard);
                            myIntent.putExtra("theDate", theDate);
                            System.out.println("Services ID:"+SID+":End");
                            startActivity(myIntent);






                        //     Toast.makeText(getBaseContext(),"Deleting of event id "+id,Toast.LENGTH_SHORT).show();
                        //   StorageReference storageReference = FirebaseStorage.getInstance().getReference();
                        //    storageReference.child("profileImageUrl").child(filename).delete();
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                        System.out.print("BBBBB");
                    }
                })
        );//furtherStatus


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