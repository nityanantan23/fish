package com.fish.eFish;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter  extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private ArrayList<ExampleItem> mExampleList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView mImageName;
        public TextView mTextstock;
        public TextView mTextprice;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            mImageName= itemView.findViewById(R.id.text_view_title);
            mTextstock = itemView.findViewById(R.id.text_view_description);
            mTextprice = itemView.findViewById(R.id.text_view_priority);
        }
    }

    public ExampleAdapter(ArrayList<ExampleItem> exampleList) {
        mExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.blog_row, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }



    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);

        holder.mImageName.setText(currentItem.getImageResource());
        holder.mTextstock.setText(currentItem.getText1());
        holder.mTextprice.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

}
