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
    // public TextView fileName, txtRegisterEventId, txtRegisterEventStartDate, txtRegisterEventName, txtContact_number, txtRegisterEventRadiogroup, txtRegisterEventLocation,txtPrice,txtCapacity;
    //   public ImageView imageView;
    public TextView txtTheJobName1,txtTheNoOfGuard1,txtTheDate1,txtTheLocation1,txtTheStatus1,txtTheType1;
    //TheJobName1,TheNoOfGuard1,TheDate1,TheLocation1,TheStatus1,TheType1
    public MenuViewHolder(@NonNull View itemView) {
        super(itemView);
        // txtRegisterEventId = itemView.findViewById(R.id.RegisterEventId);
        txtTheJobName1 = itemView.findViewById(R.id.TheJobName1);
        txtTheNoOfGuard1 = itemView.findViewById(R.id.TheNoOfGuard1);
        txtTheDate1 = itemView.findViewById(R.id.TheDate1);
        txtTheLocation1 = itemView.findViewById(R.id.TheLocation1);
        txtTheStatus1 = itemView.findViewById(R.id.TheStatus1);
        //imageView = itemView.findViewById(R.id.item_image);
        txtTheType1 = itemView.findViewById(R.id.TheType1);
        //  txtPrice = itemView.findViewById(R.id.Price);
        //   txtCapacity = itemView.findViewById(R.id.Capacity);


    }
}