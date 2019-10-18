package com.hqsoft.esales.trainee.KhachHang;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hqsoft.esales.trainee.DonHang.DonHangActivity;
import com.hqsoft.esales.trainee.Model.Model_Customer;
import com.hqsoft.esales.trainee.R;

import java.util.ArrayList;

public class Adapter_KhachHang extends RecyclerView.Adapter<Adapter_KhachHang.ViewHolder>{
    private Context contextKH;
    private ArrayList<Model_Customer> arrayListKH;
    public static final int type1 =1;
    public static final int type2 =2;

    public Adapter_KhachHang(Context contextKH, ArrayList<Model_Customer> arrayListKH) {
        this.contextKH = contextKH;
        this.arrayListKH = arrayListKH;
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
                itemView=layoutInflater.inflate(R.layout.item_khachhang1,viewGroup,false);
                break;

            case type2:
                itemView=layoutInflater.inflate(R.layout.item_khachhang2,viewGroup,false);
                break;
        }

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.idKH.setText(String.valueOf(i+1));
        viewHolder.nameKH.setText(arrayListKH.get(i).getCusName());
        viewHolder.addressKH.setText(arrayListKH.get(i).getCusAddress());
        viewHolder.sdtKH.setText(arrayListKH.get(i).getCusSdt());
    }

    @Override
    public int getItemCount() {
        return arrayListKH.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView idKH,nameKH,addressKH,sdtKH;
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idKH=itemView.findViewById(R.id.CustID);
            nameKH=itemView.findViewById(R.id.CustName);
            addressKH=itemView.findViewById(R.id.CustAddress);
            sdtKH=itemView.findViewById(R.id.Custphone);
            
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int i=getAdapterPosition();
                    String OrderNbr= arrayListKH.get(i).getCusId();

                    Intent intent=new Intent(contextKH.getApplicationContext(), DonHangActivity.class);
                    intent.putExtra("CustID",OrderNbr);
                    contextKH.startActivity(intent);
                }
            });
        }
    }
}
