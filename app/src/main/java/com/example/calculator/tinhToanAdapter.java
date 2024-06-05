package com.example.calculator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class tinhToanAdapter extends RecyclerView.Adapter<tinhToanAdapter.tinhToanViewHolder> {
    OnClickItem onClickItem;
    ArrayList<String> listItem;


    public tinhToanAdapter(OnClickItem onClickItem, ArrayList<String> listItem) {
        this.onClickItem = onClickItem;
        this.listItem = listItem;
    }

    @NonNull
    @Override
    public tinhToanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemtinhtoan,parent,false);
        return new tinhToanViewHolder(view,onClickItem);
    }

    @Override
    public void onBindViewHolder(@NonNull tinhToanViewHolder holder, int position) {
        holder.tinhtoan.setText(listItem.get(position));
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    class tinhToanViewHolder extends RecyclerView.ViewHolder  {
        TextView tinhtoan;

        public tinhToanViewHolder(@NonNull View itemView,OnClickItem onClickItem) {
            super(itemView);
            tinhtoan = itemView.findViewById(R.id.itemtinhtoan);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onClickItem!=null){
                        int pos = getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            onClickItem.onClicked(pos);
                        }
                    }
                }
            });
        }

    }
}
