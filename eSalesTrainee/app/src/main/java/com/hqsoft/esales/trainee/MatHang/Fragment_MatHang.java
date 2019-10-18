package com.hqsoft.esales.trainee.MatHang;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hqsoft.esales.trainee.Data.Sqlite;
import com.hqsoft.esales.trainee.Model.Model_Inventory;
import com.hqsoft.esales.trainee.R;

import java.util.ArrayList;

public class Fragment_MatHang extends DialogFragment {

    private EditText editTextTim;
    private Button btndong,btndongy;
    private RecyclerView recyclerViewMH;
    private LinearLayoutManager layoutManager;
    private Adapter_MatHang adapter_matHang;
    private ArrayList<Model_Inventory> arrayList;
    private Sqlite sqlite;
    public interface Listener{
        void sendData(String id,String name);
    }
    public Listener mListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v =inflater.inflate(R.layout.dialogfragment_mathang,container,false);
        Anhxa(v);
        sqlite=new Sqlite(v.getContext());
        arrayList=sqlite.getAllInventory();

        btndong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });

        btndongy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(v.getContext(), "Chưa làm xong^^", Toast.LENGTH_SHORT).show();
                mListener.sendData("007","dv07");
            }
        });

        //tim mat hang
        editTextTim.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String seach=charSequence.toString();
                if(seach.equals("")){
                    arrayList.clear();
                    arrayList.addAll(sqlite.getAllInventory());
                    adapter_matHang.notifyDataSetChanged();
                }else {
                    arrayList.clear();
                    arrayList.addAll(sqlite.SeachInventory(seach));
                    adapter_matHang.notifyDataSetChanged();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        AddmatHang(v);
        return v;
    }

    private void AddmatHang(View v){
        recyclerViewMH.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(v.getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerViewMH.setLayoutManager(layoutManager);

        if (adapter_matHang==null) {
            adapter_matHang = new Adapter_MatHang(v.getContext(), arrayList);
            recyclerViewMH.setAdapter(adapter_matHang);
        }else {
            adapter_matHang.notifyDataSetChanged();
        }
    }

    private void Anhxa(View v){
        editTextTim=v.findViewById(R.id.timMatHang);
        btndong=v.findViewById(R.id.btnDong);
        btndongy=v.findViewById(R.id.btnDongY);
        recyclerViewMH=v.findViewById(R.id.recyclerView_MatHang);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mListener=(Listener)getActivity();
        }catch (ClassCastException e){
            Log.d("ABC",e.getMessage()+"");
        };
    }

/*    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder dialog=new AlertDialog.Builder(getActivity());
        dialog.setTitle("adfasdf");
        dialog.setMessage("ban co mun xac nhan");
        dialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        dialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        Dialog MatHang=dialog.create();
        return MatHang;
    }
*/
}
