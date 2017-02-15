package com.example.admin.contactfunctionality.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.contactfunctionality.R;
import com.example.admin.contactfunctionality.model.AllContact;
import com.example.admin.contactfunctionality.model.LogClass;

import java.util.List;

/**
 * Created by Admin on 15-02-2017.
 */



public class AllContactRecyclerViewAdapter extends RecyclerView.Adapter<AllContactRecyclerViewAdapter.MyViewHolder> {

    private List<AllContact> itemList;


    public AllContactRecyclerViewAdapter(List<AllContact> itemList) {
        this.itemList = itemList;

    }

    @Override
    public AllContactRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_allcontact, null);
        MyViewHolder myViewHolder = new MyViewHolder(layoutView);
        return myViewHolder;


    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.Name.setText(itemList.get(position).getName());
        holder.PhoneNumber.setText(itemList.get(position).getNumber());


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView PhoneNumber;
        public TextView Name;




        //public RelativeLayout recyclerView_TextView_List_Item_anageClient;
        public MyViewHolder(View itemView) {
            super(itemView);
            PhoneNumber = (TextView) itemView.findViewById(R.id.client_name);
            Name = (TextView) itemView.findViewById(R.id.name);

            //recyclerView_TextView_List_Item_anageClient= (RelativeLayout) itemView.findViewById(R.id.recyclerView_TextView_List_Item_anageClient);

        }

    }
}