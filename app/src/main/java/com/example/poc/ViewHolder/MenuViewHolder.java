package com.example.poc.ViewHolder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.poc.R;
//import com.squareup.picasso.Picasso;


public class MenuViewHolder extends RecyclerView.ViewHolder {
    public TextView txtTheJobName1,txtTheNoOfGuard1,txtTheDate1,txtTheLocation1,txtTheStatus1,txtTheType1, txtFurtherStatus;

    public MenuViewHolder(@NonNull View itemView) {
        super(itemView);
        // txtRegisterEventId = itemView.findViewById(R.id.RegisterEventId);
        txtTheJobName1 = itemView.findViewById(R.id.TheJobName1);
        txtTheNoOfGuard1 = itemView.findViewById(R.id.TheNoOfGuard1);
        txtTheDate1 = itemView.findViewById(R.id.TheDate1);
        txtTheLocation1 = itemView.findViewById(R.id.TheLocation1);
        txtTheStatus1 = itemView.findViewById(R.id.TheStatus1);

        txtTheType1 = itemView.findViewById(R.id.TheType1);
        txtFurtherStatus = itemView.findViewById(R.id.TheFurtherStatus);


    }
}