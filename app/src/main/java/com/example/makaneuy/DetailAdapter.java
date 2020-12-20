package com.example.makaneuy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.MyViewHolder>{

    String data4[], data5[];
    int images2[];
    Context cont;

    public DetailAdapter(Context ctx,String s4[],String s5[], int imgs[]){
        cont = ctx;
        data4 = s4;
        data5 = s5;
        images2 = imgs;
    }
    @NonNull
    @Override
    public DetailAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(cont);
        View view = inflater.inflate(R.layout.activity_detail, parent,false);
        return new DetailAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailAdapter.MyViewHolder holder, int position) {
        holder.titleMakanan.setText(data4[position]);
        holder.descMakanan.setText(data5[position]);
        holder.imageButton.setImageResource(images2[position]);

        holder.secondLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cont, SecondActivity.class);
                intent.putExtra("data4", data4[position]);
                intent.putExtra("data5", data5[position]);
                intent.putExtra("imageButton", images2[position]);
                cont.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images2.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titleMakanan, descMakanan;
        ImageView imageButton;
        ConstraintLayout secondLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titleMakanan = itemView.findViewById(R.id.titleMakanan);
            descMakanan = itemView.findViewById(R.id.descMakanan);
            imageButton = itemView.findViewById(R.id.imageButton);
            secondLayout = itemView.findViewById(R.id.secondLayout);
        }
    }
}
