package com.hqsoft.esales.trainee.MatHang;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hqsoft.esales.trainee.Model.Model_Inventory;
import com.hqsoft.esales.trainee.R;

import java.util.ArrayList;

public class Adapter_MatHang extends RecyclerView.Adapter<Adapter_MatHang.ViewHolder>{
    private Context contextMH;
    private ArrayList<Model_Inventory> arrayListMatHang;
    public static final int type1 =1;
    public static final int type2 =2;
    public int soluong=1;

    public Adapter_MatHang(Context contextMH, ArrayList<Model_Inventory> arrayListMatHang) {
        this.contextMH = contextMH;
        this.arrayListMatHang = arrayListMatHang;
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
                itemView=layoutInflater.inflate(R.layout.item_mathang1,viewGroup,false);
                break;

            case type2:
                itemView=layoutInflater.inflate(R.layout.item_mathang2,viewGroup,false);
                break;
        }
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.sttMatHang.setText(String.valueOf(i+1));
        viewHolder.maMatHang.setText(arrayListMatHang.get(i).getInId());
        viewHolder.tenMatHang.setText(arrayListMatHang.get(i).getInName());
        viewHolder.giaMatHang.setText(arrayListMatHang.get(i).getInPrice());
        viewHolder.soLuongMatHang.setText(arrayListMatHang.get(i).getSoLuong());
    }

    @Override
    public int getItemCount() {
        return arrayListMatHang.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView sttMatHang,maMatHang,tenMatHang,giaMatHang, soLuongMatHang;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            sttMatHang=itemView.findViewById(R.id.tvSttMatHang);
            maMatHang=itemView.findViewById(R.id.tvMaMatHang);
            tenMatHang=itemView.findViewById(R.id.tvTenMatHang);
            giaMatHang=itemView.findViewById(R.id.tvGiaMatHang);
            soLuongMatHang=itemView.findViewById(R.id.tvSoLuongMatHang);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialogSoLuong(soLuongMatHang,getAdapterPosition());
                }
            });
        }
    }

    private void dialogSoLuong(final TextView soluong, final int vitri){
        final Dialog dialog=new Dialog(contextMH);
        dialog.setContentView(R.layout.dialog_soluong);
        dialog.setCancelable(false);
        final TextView sl=dialog.findViewById(R.id.dialogTvSoLuong);
        Button dongy=dialog.findViewById(R.id.dialogDongY);
        Button huy=dialog.findViewById(R.id.dialogHuy);

        dongy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayListMatHang.get(vitri).setSoLuong(sl.getText().toString());
                notifyDataSetChanged();
                dialog.dismiss();
            }
        });

        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public String trave(String sll,int vtri){
        String get=sll+":"+String.valueOf(vtri);
        return get;
    }
}
