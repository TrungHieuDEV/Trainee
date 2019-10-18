package com.hqsoft.esales.trainee.MuaHang;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hqsoft.esales.trainee.Model.Model_MuaHang;
import com.hqsoft.esales.trainee.R;

import java.util.ArrayList;

public class Adapter_MuaHang extends RecyclerView.Adapter<Adapter_MuaHang.ViewHolder>{
    private Context contextMH;
    private ArrayList<Model_MuaHang> arrayListMH;
    public static final int type1 =1;
    public static final int type2 =2;

    public Adapter_MuaHang(Context contextMH, ArrayList<Model_MuaHang> arrayListMH) {
        this.contextMH = contextMH;
        this.arrayListMH = arrayListMH;
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
                itemView=layoutInflater.inflate(R.layout.item_muahang1,viewGroup,false);
                break;

            case type2:
                itemView=layoutInflater.inflate(R.layout.item_muahang2,viewGroup,false);
                break;
        }

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.sttMH.setText(String.valueOf(i+1));
        viewHolder.mathang.setText(arrayListMH.get(i).getMa());
        viewHolder.diengiai.setText(arrayListMH.get(i).getTen());
        viewHolder.giaban.setText(arrayListMH.get(i).getGia());
        viewHolder.soluong.setText(arrayListMH.get(i).getSoLuong());
        viewHolder.tongcong.setText(arrayListMH.get(i).getTongTien());
    }

    @Override
    public int getItemCount() {
        return arrayListMH.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView sttMH,mathang,diengiai,giaban,soluong,tongcong;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sttMH=itemView.findViewById(R.id.sttMuaHang);
            mathang=itemView.findViewById(R.id.matHang);
            diengiai=itemView.findViewById(R.id.dienGiai);
            giaban=itemView.findViewById(R.id.giaBan);
            soluong=itemView.findViewById(R.id.soLuong);
            tongcong=itemView.findViewById(R.id.tongCong);
        }
    }
}
