package com.hqsoft.esales.trainee.DonHang;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hqsoft.esales.trainee.Model.Model_SalesOrd;
import com.hqsoft.esales.trainee.R;

import java.util.ArrayList;

public class Adapter_DonHang extends RecyclerView.Adapter<Adapter_DonHang.ViewHolder>{
    private Context contextDonHang;
    private ArrayList<Model_SalesOrd> arrayListDonHang;
    public static final int type1 =1;
    public static final int type2 =2;


    public Adapter_DonHang(Context contextDonHang, ArrayList<Model_SalesOrd> arrayListDonHang) {
        this.contextDonHang = contextDonHang;
        this.arrayListDonHang = arrayListDonHang;
    }

    @Override
    public int getItemViewType(int position) {
        if(position %2==0){
            return type1;
        }else {
            return type2;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());

        View itemView=null;
        switch (i){
            case type1:
                itemView=layoutInflater.inflate(R.layout.item_donhang1,viewGroup,false);
                break;

            case type2:
                itemView=layoutInflater.inflate(R.layout.item_donhang2,viewGroup,false);
                break;
        }
        return new  ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.sttDonHang.setText(String.valueOf(i+1));
        viewHolder.orderNbr.setText(arrayListDonHang.get(i).getOrderNbr());
        viewHolder.ordAmt.setText(arrayListDonHang.get(i).getOrdAmt());

    }

    @Override
    public int getItemCount() {
        return arrayListDonHang.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView sttDonHang,orderNbr,ordAmt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sttDonHang=itemView.findViewById(R.id.sttDonHang);
            orderNbr=itemView.findViewById(R.id.OrderNbr);
            ordAmt=itemView.findViewById(R.id.OrdAmt);
        }
    }

}
