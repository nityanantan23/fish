package com.fish.eFish;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    String data1[], data2[], data3[];
    Context context;

    public MyAdapter(Context ct,String s1[], String s2[], String s3[]){

        context = ct;
        data1 = s1;
        data2=s2;
        data3=s3;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.blog_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text1.setText(data1[position]);
        holder.text2.setText(data2[position]);
        holder.text3.setText(data3[position]);


    }

    @Override
    public int getItemCount() {
        return data3.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView text1,text2,text3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1= itemView.findViewById(R.id.text_view_title);
            text2= itemView.findViewById(R.id.text_view_priority);

            text3= itemView.findViewById(R.id.text_view_description);

        }
    }
}
