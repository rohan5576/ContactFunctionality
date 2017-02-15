package com.example.admin.contactfunctionality.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.contactfunctionality.R;
import com.example.admin.contactfunctionality.model.LogClass;

import java.util.List;

/**
 * Created by Admin on 15-02-2017.
 */



public class RecyclerViewAdapterLog extends RecyclerView.Adapter<RecyclerViewAdapterLog.MyViewHolder> {

    private List<LogClass> itemList;


    public RecyclerViewAdapterLog(List<LogClass> itemList) {
        this.itemList = itemList;

    }

    @Override
    public RecyclerViewAdapterLog.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
        MyViewHolder myViewHolder = new MyViewHolder(layoutView);
        return myViewHolder;


    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.PhoneNumber.setText(itemList.get(position).getNumber());
        holder.CallTpye.setText(itemList.get(position).getCallType());
        holder.CaLLDate.setText( itemList.get(position).getCallDate());


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView PhoneNumber;
        public TextView CallTpye;
        public TextView CaLLDate;



        //public RelativeLayout recyclerView_TextView_List_Item_anageClient;
        public MyViewHolder(View itemView) {
            super(itemView);
            PhoneNumber = (TextView) itemView.findViewById(R.id.client_name);
            CallTpye = (TextView) itemView.findViewById(R.id.CallType);
            CaLLDate = (TextView) itemView.findViewById(R.id.calldate);
            //recyclerView_TextView_List_Item_anageClient= (RelativeLayout) itemView.findViewById(R.id.recyclerView_TextView_List_Item_anageClient);

        }

    }
}