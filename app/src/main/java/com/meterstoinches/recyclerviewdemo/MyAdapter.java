package com.meterstoinches.recyclerviewdemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String s1_name[], s2_desc[];
    int img[];
    Context context;

    public MyAdapter(Context ctx, String arr_name[], String arr_desc[], int pictures[]) {

        this.s1_name = arr_name;
        this.s2_desc = arr_desc;
        this.img = pictures;
        this.context = ctx;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.name.setText(s1_name[position]);
        holder.desc.setText(s2_desc[position]);
        holder.img.setImageResource(img[position]);

        holder.my_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Main2Activity.class);
                intent.putExtra("name", s1_name[position]);
                intent.putExtra("desc", s2_desc[position]);
                intent.putExtra("image", img[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return img.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name, desc;
        ImageView img;

        LinearLayout my_row;//

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.seriesTitleID);
            desc = itemView.findViewById(R.id.seriesDescriptionID);
            img = itemView.findViewById(R.id.seriesImageID);

            my_row = itemView.findViewById(R.id.my_rowID);//


        }
    }
}
